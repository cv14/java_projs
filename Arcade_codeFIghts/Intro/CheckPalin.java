import java.util.*;

public class CheckPalin {

  public static boolean checkPalindrome1(String inputString) {

    if(inputString.length() == 1 || inputString.length() == 0){
      return true;
    }

    if(inputString.length() == 2){
      if(inputString.charAt(0) != inputString.charAt(1)){
        return false;
      }
    }

    for(int i = 0, j = inputString.length() - 1; i <= (inputString.length()/2)  && j >= (inputString.length()/2); i++, j-- ){
      System.out.println(inputString.charAt(i) + " " + inputString.charAt(j) );
      System.out.println(i + "  " + j);
      if( inputString.charAt(i) != inputString.charAt(j)){
        return false;
      }
    }

    return true;
  }

  public static boolean checkPalindrome(String inputString) {
    String reverse = new StringBuffer(inputString).reverse().toString();
    System.out.println(reverse);
    if(!inputString.equals(reverse)){
      return false;
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(checkPalindrome("aabaa"));

  }


}
