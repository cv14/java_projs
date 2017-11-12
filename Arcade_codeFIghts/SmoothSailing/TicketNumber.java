/*

Ticket numbers usually consist of an even number of digits. A ticket number is
considered lucky if the sum of the first half of the digits is equal to the sum
of the second half.

Given a ticket number n, determine if it's lucky or not.

Example

For n = 1230, the output should be
isLucky(n) = true;
For n = 239017, the output should be
isLucky(n) = false.

*/
import java.util.*;

public class TicketNumber {

  static boolean isLucky(int n) {
    int suma1 = 0;
    int suma2 = 0;

    String temporal = Integer.toString(n);
    String primera_mitad = temporal.substring(0, (temporal.length()/2));

    for(int i = 0,j = temporal.length()/2;i < temporal.length()/2 && j < temporal.length();i++,j++){
       suma1 = suma1 + (temporal.charAt(i) - '0');
       suma2 = suma2 + (temporal.charAt(j) - '0');
    }

    if(suma1 == suma2){
      return true;
    }

    return false;

  }

  public static void main(String[] args) {
    int n = 1230;
    System.out.println(isLucky(n));
  }
}
