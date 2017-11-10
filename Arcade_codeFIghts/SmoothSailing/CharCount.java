/*

Given two strings, find the number of common characters between them.

Example

For s1 = "aabcc" and s2 = "adcaa", the output should be
commonCharacterCount(s1, s2) = 3.

Strings have 3 common characters - 2 "a"s and 1 "c".

Input/Output

[time limit] 3000ms (java)
[input] string s1

A string consisting of lowercase latin letters a-z.

Guaranteed constraints:
1 ≤ s1.length ≤ 15.

[input] string s2

A string consisting of lowercase latin letters a-z.

Guaranteed constraints:
1 ≤ s2.length ≤ 15.

[output] integer

*/
import java.util.*;


public class CharCount {
  static LinkedHashMap<Character, Valor> unoMapa = new LinkedHashMap<Character, Valor>();
  static LinkedHashMap<Character, Valor> dosMapa = new LinkedHashMap<Character, Valor>();

  static void addinMapa(LinkedHashMap<Character, Valor> mapa, String s){

    for (int i = 0; i < s.length(); i++) {
      if(mapa.containsKey(s.charAt(i))){
        //mapa.put(s.charAt(i), mapa.get(s.charAt(i)) + 1);
        mapa.put(s.charAt(i),new Valor(mapa.get(s.charAt(i)).val + 1, true));

      }else{
        mapa.put(s.charAt(i), new Valor(1, true));
      }
    }

  }

  static int contarSuma(String c){
    int sum = 0;

    for (int i = 0; i < c.length(); i++) {
      if(unoMapa.containsKey(c.charAt(i)) && dosMapa.containsKey(c.charAt(i))){
        if(unoMapa.get(c.charAt(i)).val < dosMapa.get(c.charAt(i)).val ){
          sum = sum + unoMapa.get(c.charAt(i)).val;
        }else{
          sum = sum + dosMapa.get(c.charAt(i)).val;
        }
      }
    }

    return sum;
  }

  /////
///////
/////// Add an array
/////
////

  static int commonCharacterCount(String s1, String s2) {

    int suma = 0;
    int longitud = 0;
    String cuerda ;

    addinMapa(unoMapa, s1);
    addinMapa(dosMapa, s2);

    cuerda = s1.length() < s2.length() ? s1 : s2;
    suma = contarSuma(cuerda);



    return suma;

  }

  public static void main(String[] args){
    String s1 = "aabcc";
    String s2 = "adcaa";
    System.out.println(commonCharacterCount(s1, s2));

  }

  public static class Valor{
    public Valor(int x,boolean t){
      val = x;
      status = t;
    }

    int val;
    boolean status;

  }



}
