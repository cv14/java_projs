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
Expected Output:
"apmnolkjihgfedcbq"

Input:
s: "Code(Cha(lle)nge)"

Expected Output:
"CodeegnlleahC"


*/
import java.util.*;


public class Parenthesis {



  static String reverseParentheses(String s) {
    Stack<Character> stack = new Stack<Character>();
    Queue<Character> tempQ = new LinkedList<Character>();
    boolean stackSwitch = false;
    StringBuilder str = new StringBuilder();
    char temp ;
    int level = 0;

    for (int i = 0; i < s.length(); i++) {
      //System.out.println(stack);
      if(s.charAt(i) == '(' ){
        stackSwitch = true;
        level++;
      }
      if(stackSwitch == true && s.charAt(i) != ')'){
          stack.push(s.charAt(i));
      }
      //System.out.println(str.toString());
      if(s.charAt(i) == ')' && level == 1) {
        temp = stack.pop();
        while (temp != '(') {
          str.append(temp);
          System.out.println(temp);
          temp = stack.pop();
        }
       stackSwitch = false;
       level--;
     }else if(s.charAt(i) == ')' && level > 1) {
       tempQ = new LinkedList<Character>();
       temp = stack.pop();
       while (temp != '(') {
         tempQ.add(temp);
         temp = stack.pop();
       }
       level--;
       stack.addAll(tempQ);
      stackSwitch = false;
     }

      if(stackSwitch == false && s.charAt(i) != ')'){
        str.append(s.charAt(i));
      }
     }

     s = str.toString();

    return s;
  }

  public static void main(String[] args) {
    String s = "a(bc)de";

    System.out.println(reverseParentheses(s));

     s = "a(bcdefghijkl(mno)p)q";
     System.out.println(reverseParentheses(s));

     s = "Code(Cha(lle)nge)";
     System.out.println(reverseParentheses(s));

  }
}
