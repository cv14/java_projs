/*
You have a string s that consists of English letters, punctuation marks,
whitespace characters, and brackets. It is guaranteed that the parentheses in s
form a regular bracket sequence.

Your task is to reverse the strings contained in each pair of matching
parentheses, starting from the innermost pair. The results string should not
contain any parentheses.

Example

For string s = "a(bc)de", the output should be
reverseParentheses(s) = "acbde".

Input/Output

[time limit] 3000ms (java)
[input] string s

A string consisting of English letters, punctuation marks, whitespace characters
and brackets. It is guaranteed that parentheses form a regular bracket sequence.

Constraints:
5 ≤ s.length ≤ 55.

[output] string

input:
s: "a(bcdefghijkl(mno)p)q"
Output:"apmnolkjihgfedcbq"
Empty
Expected Output:
"apmnolkjihgfedcbq"


*/
import java.util.*;


public class Parenthesis {

  static Stack<Character> stack = new Stack<Character>();

  static String reverseParentheses(String s) {
    boolean stackSwitch = false;
    StringBuilder str = new StringBuilder();

    for (int i = 0; i < s.length(); i++) {
      if(stackSwitch == false){
        str.append(s.charAt(i));
      }
      if(s.charAt(i) == '(' ){
        stackSwitch = true;
      }

      if(stackSwitch == true && s.charAt(i) != '('){
          stack.push(s.charAt(i));
      }

      if(s.charAt(i) != ')') {

      }
    }

    return s;
  }

  public static void main(String[] args) {
    String s = "a(bc)de";

    System.out.println(reverseParentheses(s));

     s = "a(bcdefghijkl(mno)p)q";

  }
}
