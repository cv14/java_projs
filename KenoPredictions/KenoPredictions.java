import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;

public class KenoPredictions {
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

    public static void main(String[] args) {
        
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
                    System.out.println("Line no " +i  + ": " + lines[i]);
                    //System.out.println(lines[i]);
                }
            }
        }catch (Exception e) {
           e.printStackTrace();
        }




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
