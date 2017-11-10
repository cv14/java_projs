/*
Given an array of strings, return another array containing all of its
longest strings.

Example

For inputArray = ["aba", "aa", "ad", "vcd", "aba"], the output should be
allLongestStrings(inputArray) = ["aba", "vcd", "aba"].

Input/Output

[time limit] 3000ms (java)
[input] array.string inputArray

A non-empty array.

Guaranteed constraints:
1 ≤ inputArray.length ≤ 10,
1 ≤ inputArray[i].length ≤ 10.

[output] array.string

Array of the longest strings, stored in the same order as in the inputArray.
*/

//Using Arraylist
import java.util.*;

public class LongestString {

  static String[] allLongestStrings(String[] inputArray) {
    ArrayList<String> retArr = new ArrayList<String>();
    int longitud = 0;

    retArr.add(inputArray[0]);
    longitud = inputArray[0].length();

    for (int i = 1; i < inputArray.length; i++) {
      if(inputArray[i].length() > longitud){
        retArr.clear();
        retArr.add(inputArray[i]);
        longitud = inputArray[i].length();
      }else if(inputArray[i].length() == longitud){
        retArr.add(inputArray[i]);
      }
    }

    String[] reterno_matriz = new String[retArr.size()];
    reterno_matriz = retArr.toArray(reterno_matriz);

    return reterno_matriz;
  }

  public static void main(String[] args) {
    String[] inputArray = {"abc","eeee","abcd","dcd"} ;
    inputArray = allLongestStrings(inputArray);
    System.out.println(Arrays.toString(inputArray));
  }
}
