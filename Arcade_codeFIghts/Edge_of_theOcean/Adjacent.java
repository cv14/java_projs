/*

Given an array of integers, find the pair of adjacent elements that has the
largest product and return that product.

Example

For inputArray = [3, 6, -2, -5, 7, 3], the output should be
adjacentElementsProduct(inputArray) = 21.

7 and 3 produce the largest product.

Input/Output

[time limit] 3000ms (java)
[input] array.integer inputArray

An array of integers containing at least two elements.

Guaranteed constraints:
2 ≤ inputArray.length ≤ 10,
-1000 ≤ inputArray[i] ≤ 1000.

[output] integer

The largest product of adjacent elements.

*/
import java.util.*;

public class Adjacent {

  public static int adjacentElementsProduct(int[] inputArray){
    int currLrg = 0;
    int prevLrg = Integer.MIN_VALUE;;
    for(int i = 0; i < inputArray.length-1; i++){
      currLrg = inputArray[i] * inputArray[i+1];
      if(currLrg > prevLrg){
        prevLrg = currLrg;
      }

    }

    return prevLrg;
  }


  public static void main(String[] args) {
    int[] a = {-23, 4, -3, 8, -12};

    System.out.println(adjacentElementsProduct(a));

  }
}
