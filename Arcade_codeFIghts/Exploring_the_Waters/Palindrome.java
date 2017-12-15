/*
Given a string, find out if its characters can be rearranged to form a
palindrome.

Example

For inputString = "aabb", the output should be
palindromeRearranging(inputString) = true.

We can rearrange "aabb" to make "abba", which is a palindrome.

Input/Output

[time limit] 3000ms (java)

[input] string inputString

A string consisting of lowercase English letters.

Guaranteed constraints:
1 ≤ inputString.length ≤ 50.

[output] boolean

true if the characters of the inputString can be rearranged to form a
palindrome, false otherwise.

*/

import java.util.* ;

public class Palindrome {

  static boolean palindromeRearranging(String inputString) {

    if(inputString.length() == 1){ return true;}

    int[] alphas = new int[26];
    boolean impars = true;

    for (int i = 0; i < inputString.length(); i++) {
      alphas[inputString.charAt(i) - 97] += 1;
    }

    //System.out.println(Arrays.toString(alphas));



    if(inputString.length() % 2 == 0){
      for (int i = 0; i < alphas.length; i++) {
        if(alphas[i] % 2 == 1){ return false; }
      }
    }else {
      for (int i = 0; i < alphas.length; i++) {
        if(alphas[i] % 2 == 1 && impars == false){return false;}

        if(alphas[i] % 2 == 1){ impars = false; }
      }
    }

    return true;
  }

  public static void main(String[] args) {
    String inStr = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbc";

    System.out.println(inStr.length());

    System.out.println(palindromeRearranging(inStr));


  }
}
