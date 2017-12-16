/*

Given an array of integers, find the maximal absolute difference between any
two of its adjacent elements.

Example

For inputArray = [2, 4, 1, 0], the output should be
arrayMaximalAdjacentDifference(inputArray) = 3.

Input/Output

[time limit] 3000ms (java)

[input] array.integer inputArray

Guaranteed constraints:
3 ≤ inputArray.length ≤ 10,
-15 ≤ inputArray[i] ≤ 15.

[output] integer

The maximal absolute difference.
*/

public class AbsoluteDiff  {

  static int arrayMaximalAdjacentDifference(int[] inputArray) {
    int maximoDiferencia = 0;

    for (int i = 1; i < inputArray.length; i++) {
      if(Math.abs(inputArray[i] - inputArray[i-1]) > maximoDiferencia){
        maximoDiferencia = Math.abs(inputArray[i] - inputArray[i-1]);
      }
    }

    return maximoDiferencia;
  }

  public static void main(String[] args) {
    int[] inputArray = {2,4,1,0};

    System.out.println(arrayMaximalAdjacentDifference(inputArray));
  }
}
