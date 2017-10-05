import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;


public class KenoPredictions {

    private static LinkedHashMap<String, Integer> lhm;
    private static LinkedHashMap<String, Integer> bonus;
    private static LinkedHashMap<String[], Integer> combosHm;

    public static String[] nGrams(String s, int len) {
        //System.out.println(s);
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

        //System.out.println(s);

        String[] parts = s.split("\u00AD");
        String[] result = new String[parts.length - len + 1];

        for(int i = 0; i < parts.length - len + 1; i++) {
            StringBuilder sb = new StringBuilder();
            for(int k = 0; k < len; k++) {
                if(k > 0) sb.append(' ');
                sb.append(parts[i+k]);
            }
            result[i] = sb.toString();
        }
        //System.out.println("length " + result.length);
        return result;

    }

    public static String[] cleanBack(String s){

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

        System.out.println(s);

        return numbs;

    }

    public static int countLines(String str) {
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

    public static void calculate(String keno){
        //System.out.println(keno);


        String[] sKeno = keno.split("\u00AD",0);

        for(int i = 0; i < 20; i++){
            //System.out.print(sKeno[i]+ " ");
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
                    //System.out.println(t[1]);
                    bonus.put(t[1], 1);
                }



            }else if(lhm.containsKey(sKeno[i])){
                lhm.put(sKeno[i],lhm.get(sKeno[i]) + 1);
            }else{
                lhm.put(sKeno[i], 1);
            }
        }

    }

    public static void printHM(LinkedHashMap<String, Integer> mapa){
        for (String key : mapa.keySet()) {
            System.out.print(key + ":" + mapa.get(key));
            System.out.print("  ");
        }
        System.out.println();
    }

    public static void combosChecker(String[] temp){

        System.out.println("result at : " + Arrays.toString(temp));

        if(combosHm.containsKey(temp)){
            combosHm.put(temp,combosHm.get(temp) + 1);
        }else{
            combosHm.put(temp, 1);
        }




    }

    public static void combinations2(String[] arr, int len, int startPosition, String[] result){
        if (len == 0){
            combosChecker(result);
            return;
        }
        for (int i = startPosition; i <= arr.length-len; i++){
            result[result.length - len] = arr[i];
            combinations2(arr, len-1, i+1, result);
        }
    }

    public static void calculateNgrams(String resultGrams, int n ){
        String[] resultingCombs = new String[n];
        //System.out.println(Arrays.toString(ngrams(resultGrams, n)));
        System.out.println(resultGrams);
        String[] r = cleanBack(resultGrams);
        System.out.println(Arrays.toString(r));

        combinations2(r,n, 0, resultingCombs);




        //String[] result = nGrams(resultGrams, n);
        //System.out.println(Arrays.toString(result));

    }

    public static void main(String[] args) {

       lhm = new LinkedHashMap<String, Integer>();
       bonus = new LinkedHashMap<String, Integer>();
       combosHm = new LinkedHashMap<String[], Integer>();


        try{
            PDDocument document = PDDocument.load(new File("test2.pdf"));

            Splitter splitter = new Splitter();

            //splitting the pages of a PDF document
            List<PDDocument> Pages = splitter.split(document);

            //Creating an iterator
            Iterator<PDDocument> iterator = Pages.listIterator();

            //Saving each page as an individual document
            while(iterator.hasNext()) {
                PDDocument pd = iterator.next();
                PDFTextStripper pdfStripper = new PDFTextStripper();
                String text = pdfStripper.getText(pd);
                String[] lines = text.split("\r\n|\r|\n");
                for (int i = 4; i < countLines(text) - 2; i++) {
                    for(int j = 0; j < 19;j++){
                        char[] myNameChars = lines[i].toCharArray();
                        myNameChars[j] = ' ';
                        lines[i] = String.valueOf(myNameChars);
                    }
                    lines[i] = lines[i].trim();
                    calculate(lines[i]);
                    //System.out.println(Arrays.toString(lines[i]));
                    calculateNgrams(lines[i], 3);

                }
            }
        }catch (Exception e) {
           e.printStackTrace();
        }

        printHM(lhm);
        printHM(bonus);

    }

}
