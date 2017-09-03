/*
There are a number of different formats for representing color.
RGB format specifies the level of red (R), green (G), and blue (B) on an integer
scale from 0 to 255: It is the primary format for LCD displays, digital cameras,
and web pages. CMYK format specifies the level of cyan (C), magenta (M), yellow
(Y), and black (K) on a real scale of 0.0 to 1.0: It is the primary format for
publishing books and magazines. Write a program RGBtoCMYK.java that reads in
three integers red, green, and blue from the command line and prints out
equivalent CMYK parameters.


*/
import java.lang.Math;

public class RGBtoCMYK {
  public static void main(String[] args) {

    double r, g , b, white;

    r = Double.parseDouble(args[0]); g = Double.parseDouble(args[1]);
    b = Double.parseDouble(args[2]);

    white = Math.max(Math.max(r/255.0, g/255.0), Math.max(g/255.0,b/255.0));

    System.out.println("cyan  =  " + (white - (r/255))/white);
    System.out.println("magenta  =  " + (white - (g/255))/white);
    System.out.println("yellow  =  " + (white - (b/255))/white);
    System.out.println("black  =  " + (1-white));
    }

  }
