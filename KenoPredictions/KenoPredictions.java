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

//        for (String key : lhm.keySet()) {
//            System.out.print(key + ":" + lhm.get(key));
//            System.out.print("  ");
//        }
//        System.out.println();
        //System.out.println("\n" + Arrays.toString(sKeno));

        //System.out.println(Arrays.toString(keno));

    }

    public static void main(String[] args) {

       lhm = new LinkedHashMap<String, Integer>();
       bonus = new LinkedHashMap<String, Integer>();


        try{
            PDDocument document = PDDocument.load(new File("test1.pdf"));

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
                    //System.out.println("Line no " +i  + ": " + lines[i]);
                    calculate(lines[i]);
                }
            }
        }catch (Exception e) {
           e.printStackTrace();
        }

        for (String key : lhm.keySet()) {
            System.out.print(key + ":" + lhm.get(key));
            System.out.print("  ");
        }
        System.out.println();

        for (String key : bonus.keySet()) {
            System.out.print(key + ":" + bonus.get(key));
            System.out.print("  ");
        }
        System.out.println();




//        try {
//            PDDocument document = null;
//            document = PDDocument.load(new File("test.pdf"));
//            document.getClass();
//            if (!document.isEncrypted()) {
//                PDFTextStripperByArea stripper = new PDFTextStripperByArea();
//                stripper.setSortByPosition(true);
//                PDFTextStripper Tstripper = new PDFTextStripper();
//                String st = Tstripper.getText(document);
//                while(st.charAt(i) != '\n'){
//                    System.out.println("Text:" + st);
//
//                }
//
//                //System.out.println("Text:" + st);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }

}
