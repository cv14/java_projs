/*
A cryptarithm is a mathematical puzzle for which the goal is to find the
correspondence between letters and digits, such that the given arithmetic
equation consisting of letters holds true when the letters are converted to
digits.

You have an array of strings crypt, the cryptarithm, and an an array containing
the mapping of letters and digits, solution. The array crypt will contain three
non-empty strings that follow the structure: [word1, word2, word3], which should
be interpreted as the word1 + word2 = word3 cryptarithm.

If crypt, when it is decoded by replacing all of the letters in the cryptarithm
with digits using the mapping in solution, becomes a valid arithmetic equation
containing no numbers with leading zeroes, the answer is true. If it does not
become a valid arithmetic solution, the answer is false.
*/
import java.util.*;

public class CryptSolution{
  public static boolean isCryptSolution(String[] crypt, char[][] solution) {

      int num1, num2, num3;
     LinkedHashMap<Character, Character> solMap = new LinkedHashMap<Character, Character>();

      for(int i = 0; i < solution.length; i++){
        solMap.put(solution[i][0],solution[i][1]);
      }
      System.out.println(solMap);

      for (int i = 0; i < crypt[0].length(); i++) {
          System.out.println(crypt[0]);
          crypt[0] = crypt[0].replace(crypt[0].charAt(i),solMap.get(crypt[0].charAt(i)));
          System.out.println(crypt[0]);
      }
      //System.out.println(crypt[0]);

      for (int i = 0; i < crypt[1].length(); i++) {
          crypt[1] = crypt[1].replace(crypt[1].charAt(i),solMap.get(crypt[1].charAt(i)));
      }
      //System.out.println(crypt[1]);


      for (int i = 0; i < crypt[2].length(); i++) {
          crypt[2] = crypt[2].replace(crypt[2].charAt(i),solMap.get(crypt[2].charAt(i)));
      }
      //System.out.println(crypt[2]);
      if(crypt[0].length() > 1 && crypt[0].charAt(0) == '0'){
        System.out.println("lado1");
          return false;
      }
      if(crypt[1].length() > 1 && crypt[1].charAt(0) == '0'){
        System.out.println("lado2");
          return false;
      }



      num1 = Integer.parseInt(crypt[0]);
      num2 = Integer.parseInt(crypt[1]);
      num3 = Integer.parseInt(crypt[2]);

      if((num1 + num2) == num3){
        return true;
      }else{
        System.out.println("lado3");
        return false;
      }
  }

  public static void main(String[] args) {
      String[] crypt = {"SEND", "MORE", "MONEY"};
      char[][] solution =
            {{'O', '0'},{'M', '1'},{'Y', '2'},{'E', '5'},{'N', '6'},
            {'D', '7'},{'R', '8'},{'S', '9'}};
      System.out.println(isCryptSolution(crypt, solution));

      String[] crypt1 = {"ABAB", "ABAB", "AA"};
      char[][] solution1 = {{'A','0'}};
      System.out.println(isCryptSolution(crypt1, solution1));


  }
}
