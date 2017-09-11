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

      long num1, num2, num3;
     LinkedHashMap<Character, Character> solMap = new LinkedHashMap<Character, Character>();

      for(int i = 0; i < solution.length; i++){
        solMap.put(solution[i][0],solution[i][1]);
      }

      char[] myNameChars = crypt[0].toCharArray();

      for (int i = 0; i < crypt[0].length(); i++) {
        myNameChars[i] = solMap.get(crypt[0].charAt(i));
        crypt[0] = String.valueOf(myNameChars);
      }

      myNameChars = crypt[1].toCharArray();
      for (int i = 0; i < crypt[1].length(); i++) {
        myNameChars[i] = solMap.get(crypt[1].charAt(i));
        crypt[1] = String.valueOf(myNameChars);
      }

      myNameChars = crypt[2].toCharArray();
      for (int i = 0; i < crypt[2].length(); i++) {
        myNameChars[i] = solMap.get(crypt[2].charAt(i));
        crypt[2] = String.valueOf(myNameChars);
      }

      if(crypt[0].length() > 1 && crypt[0].charAt(0) == '0' ||
         crypt[1].length() > 1 && crypt[1].charAt(0) == '0' ||
         crypt[2].length() > 1 && crypt[2].charAt(0) == '0'){
          return false;
      }

      num1 = Long.parseLong(crypt[0]);
      num2 = Long.parseLong(crypt[1]);
      num3 = Long.parseLong(crypt[2]);

      //checking if word1 + word2 = word3
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

      String[] crypt1 = {"AA", "BAA", "AA"};
      char[][] solution1 = {{'A','1'}, {'B', '0'}};
      System.out.println(isCryptSolution(crypt1, solution1));

      String[] crypt3 = {"AAAAAAAAAAAAAA","BBBBBBBBBBBBBB","CCCCCCCCCCCCCC"};
      char[][] solution2 = {{'A','1'},{'B','2'},{'C','3'}};
      System.out.println(isCryptSolution(crypt3, solution2));

      String[] crypt4 =  {"WASD","IJKL","AOPAS"};
      char[][] solution3 = {{'W','2'}, {'A','0'}, {'S','4'},{'D','1'},{'I','5'},
              {'J','8'},{'K','6'},{'L','3'},{'O','7'},{'P','9'}};
      System.out.println(isCryptSolution(crypt4, solution3));
  }
}
