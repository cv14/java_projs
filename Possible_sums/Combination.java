/******************************************************************************
 *  Compilation:  javac Combinations.java
 *  Execution:    java Combinations n
 *
 *  Enumerates all subsets of n elements using recursion.
 *  Uses some String library functions.
 *
 *  Both functions (comb1 and comb2) print them in alphabetical
 *  order; comb2 does not include the empty subset.
 *
 *  % java Combinations 3
 *
 *  a
 *  ab
 *  abc
 *  ac
 *  b
 *  bc
 *  c
 *
 *  a
 *  ab
 *  abc
 *  ac
 *  b
 *  bc
 *  c
 *
 *  Remark: this is, perhaps, easier by counting from 0 to 2^N - 1 by 1
 *  and looking at the bit representation of the counter. However, this
 *  recursive approach generalizes easily, e.g., if you want to print
 *  out all combinations of size k.
 *
 ******************************************************************************/
import java.util.*;
public class Combination {

  static LinkedHashMap<ArrayList<Integer>, Integer> mapa = new LinkedHashMap<ArrayList<Integer>, Integer>();
  static ArrayList<Integer> combinacion = new ArrayList<Integer>();
    // print all subsets of the characters in s
    public static void comb1(String s) { comb1("", s); }

    // print all subsets of the remaining elements, with given prefix
    private static void comb1(String prefix, String s) {
        if (s.length() > 0) {
            System.out.println(prefix + s.charAt(0));
            comb1(prefix + s.charAt(0), s.substring(1));
            comb1(prefix,               s.substring(1));
        }
    }

    // alternate implementation
    public static void comb2(String s) { comb2("", s); }
    private static void comb2(String prefix, String s) {

        System.out.println(prefix);
        for (int i = 0; i < s.length(); i++){
            //System.out.println(prefix);
            comb2(prefix + s.charAt(i), s.substring(i + 1));
          }
    }

    public static void comb3(int[] numbs){
      comb3(combinacion, numbs);
    }

    private static void comb3(ArrayList<Integer> combinacion, int[] numbs){
        mapa.put(combinacion,0);
        //System.out.println(mapa);
        for(int i = 0; i < numbs.length; i++){
          combinacion.add(numbs[i]);
          System.out.println(combinacion);
          //System.out.println(Arrays.toString(numbs));
          comb3(combinacion, Arrays.copyOfRange(numbs, i+1, numbs.length));
        }


    }




    // read in N from command line, and print all subsets among N elements
    public static void main(String[] args) {

        int[] c = {10, 50};
        System.out.println(mapa.size());
        comb3(c);
        System.out.println(mapa.size());
        System.out.println(mapa);



        int n = Integer.parseInt(args[0]);
        String alphabet = "abbcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";


        String elements = alphabet.substring(0, n);

        // using first implementation
        comb1(elements);
        System.out.println();

        // using second implementation
        comb2(elements);
        System.out.println();
    }

}
