import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.logging.*;
import java.io.*;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Comparator;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;


public class KenoPredictions {

    private static LinkedHashMap<String, Integer> lhm;
    private static LinkedHashMap<String, Integer> bonus;
    private static LinkedHashMap<String, Integer> combosHm;
    private static PDDocument document;

//    public static String[] nGrams(String s, int len) {
//        //System.out.println(s);
//        if (s.endsWith(" No Bonus")) {
//            s = s.substring(0, s.length() - 9);
//        }else if (s.endsWith(" 3x")) {
//            s = s.substring(0, s.length() - 3);
//        }else if (s.endsWith(" 4x")) {
//            s = s.substring(0, s.length() - 3);
//        } else if (s.endsWith(" 5x")) {
//            s = s.substring(0, s.length() - 3);
//        }else if (s.endsWith(" 10x")) {
//            s = s.substring(0, s.length() - 4);
//        }
//
//        //System.out.println(s);
//
//        String[] parts = s.split("\u00AD");
//        String[] result = new String[parts.length - len + 1];
//
//        for(int i = 0; i < parts.length - len + 1; i++) {
//            StringBuilder sb = new StringBuilder();
//            for(int k = 0; k < len; k++) {
//                if(k > 0) sb.append(' ');
//                sb.append(parts[i+k]);
//            }
//            result[i] = sb.toString();
//        }
//        //System.out.println("length " + result.length);
//        return result;
//
//    }

    private static String[] cleanBack(String s){

        if (s.endsWith(" No Bonus")) {
            s = s.substring(0, s.length() - 9);
        }else if (s.endsWith(" 3x")) {
            s = s.substring(0, s.length() - 3);
        }else if (s.endsWith(" 4x")) {
            s = s.substring(0, s.length() - 3);
        } else if (s.endsWith(" 5x")) {
            s = s.substring(0, s.length() - 3);
        }else if (s.endsWith(" 10x")) {
            s = s.substring(0, s.length() - 4);
        }

        String[] numbs = s.split("\u00AD");

        return numbs;

    }

    private static int countLines(String str) {
        if(str == null || str.isEmpty())
        {
            return 0;
        }
        int lines = 1;
        int pos = 0;
        while ((pos = str.indexOf("\n", pos) + 1) != 0) {
            lines++;
        }
        return lines;
    }

    private static void calculate(String keno){

        String[] sKeno = keno.split("\u00AD",0);

        for(int i = 0; i < 20; i++){
            if(i == 19){
                String[] t = sKeno[i].split(" ", 2);
                if(lhm.containsKey(t[0])){
                    lhm.put(t[0],lhm.get(t[0]) + 1);
                }else{
                    lhm.put(t[0], 1);
                }

                if(bonus.containsKey(t[1])){
                    bonus.put(t[1],bonus.get(t[1]) + 1);
                }else{
                    bonus.put(t[1], 1);
                }
            }else if(lhm.containsKey(sKeno[i])){
                lhm.put(sKeno[i],lhm.get(sKeno[i]) + 1);
            }else{
                lhm.put(sKeno[i], 1);
            }
        }

    }

    private static void printHM(LinkedHashMap<String, Integer> mapa){
        for (String key : mapa.keySet()) {
            System.out.print(key + ":" + mapa.get(key));
            System.out.print("  ");
        }
        System.out.println();
    }

    private static void printTopN(LinkedHashMap<String, Integer> mapa, int n){
        int i = 1;
        for (String key : mapa.keySet()) {
            System.out.println(i + ". " + key + ":" + mapa.get(key));
            i++;
            if(i == n+1){
                break;
            }
        }
        System.out.println();
    }

    private static void combosChecker(String[] temp){
        if(combosHm.containsKey(Arrays.toString(temp))){
            combosHm.put(Arrays.toString(temp),combosHm.get(Arrays.toString(temp)) + 1);
        }else{
            combosHm.put(Arrays.toString(temp), 1);
        }
    }

    private static void combinations2(String[] arr, int len, int startPosition, String[] result){
        if (len == 0){
            combosChecker(result);
            return;
        }
        for (int i = startPosition; i <= arr.length-len; i++){
            result[result.length - len] = arr[i];
            combinations2(arr, len-1, i+1, result);
        }
    }

    private static void calculateNgrams(String resultGrams, int n){
        String[] resultingCombs = new String[n];
        String[] r = cleanBack(resultGrams);
        combinations2(r,n, 0, resultingCombs);
    }

    private static LinkedHashMap sortByValues(LinkedHashMap<String, Integer> mapa){

        List list = new LinkedList(mapa.entrySet());
        // Defined Custom Comparator here
        Collections.sort(list, new Comparator() {
            public int compare(Object o1, Object o2) {
                return ((Comparable) ((Map.Entry) (o2)).getValue())
                        .compareTo(((Map.Entry) (o1)).getValue());
            }
        });

        LinkedHashMap sortedHashMap = new LinkedHashMap();
        for (Iterator it = list.iterator(); it.hasNext();) {
            Map.Entry entry = (Map.Entry) it.next();
            sortedHashMap.put(entry.getKey(), entry.getValue());
        }
        return sortedHashMap;

    }

    public static void main(String[] args) throws IOException {

        lhm = new LinkedHashMap<String, Integer>();
        bonus = new LinkedHashMap<String, Integer>();
        combosHm = new LinkedHashMap<String, Integer>();

        StringBuilder f = new StringBuilder();
        int c = 0;
        //  f.append((char)(c + '0') + ".pdf" );

        while (c != 1) {
            f = new StringBuilder("test");
            f.append((char) (c + '0') + ".pdf");
            c++;

            try {
                document = PDDocument.load(new File(f.toString()));

                Splitter splitter = new Splitter();

                //splitting the pages of a PDF document
                List<PDDocument> Pages = splitter.split(document);

                //Creating an iterator
                Iterator<PDDocument> iterator = Pages.listIterator();

                //Saving each page as an individual document
                while (iterator.hasNext()) {
                    PDDocument pd = iterator.next();
                    PDFTextStripper pdfStripper = new PDFTextStripper();
                    String text = pdfStripper.getText(pd);
                    String[] lines = text.split("\r\n|\r|\n");
                    for (int i = 4; i < countLines(text) - 2; i++) {
                        for (int j = 0; j < 19; j++) {
                            char[] myNameChars = lines[i].toCharArray();
                            myNameChars[j] = ' ';
                            lines[i] = String.valueOf(myNameChars);
                        }
                        lines[i] = lines[i].trim();
                        calculate(lines[i]);
                        calculateNgrams(lines[i], 12);

                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (document != null) {
                    document.close();
                }
            }
        }

            //System.out.println(lhm.size());
            //System.out.println(combosHm.size());
            //printHM(lhm);
            //printHM(bonus);

            //System.out.println(lhm.get("44"));
            //System.out.println(combosHm.get("[01, 08, 09, 11]"));
            printHM(sortByValues(lhm));
            //printHM(sortByValues(bonus));
            //printHM(sortByValues(combosHm));
            System.out.println(combosHm.size());
            printTopN(sortByValues(combosHm), 5);


            //Make A METHOD to see how many times certain combination showed up in the past. 
            //Sort by values
            //Display top 5
            //Download more data
            //predict using AI analysis like  based on last 5 games what will be the possible numbers in next game
            //if 2 is followed by 22 then what is expected to follow it again.
            //Write a good analysis
    }

}
