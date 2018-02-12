/*
You are given an array of integers representing coordinates of obstacles situated
 on a straight line.

Assume that you are jumping from the point with coordinate 0 to the right.
You are allowed only to make jumps of the same length represented by some integer.

Find the minimal length of the jump enough to avoid all the obstacles.

Example

For inputArray = [5, 3, 6, 7, 9], the output should be
avoidObstacles(inputArray) = 4.

Input/Output

[time limit] 3000ms (java)

[input] array.integer inputArray

Non-empty array of positive integers.

Guaranteed constraints:
2 ≤ inputArray.length ≤ 10,
1 ≤ inputArray[i] ≤ 40.

[output] integer

The desired length.
*/
import java.util.*;

public class Obstacles {

  static int avoidObstacles(int[] inputArray) {
    int max = 0;
    int jump = 0;
    int pos = 0 ;
    boolean[] postions = new boolean[40];

    Arrays.sort(inputArray);
    System.out.println(Arrays.toString(postions));

    for (int i = 0; i < inputArray.length; i++) {
      postions[inputArray[i]] = true;
    }

    System.out.println(Arrays.toString(postions));

    jump = inputArray[0] + 1;

    while(pos < inputArray[inputArray.length - 1] ){
      pos = pos + jump;
      if(postions[pos] == true){
        pos = 0;
        jump = jump + 1;
      }

    }

    return jump;
  }

  public static void main(String[] args) {
    int[] inputArray = {5, 3, 6, 7, 9};
    System.out.println(avoidObstacles(inputArray));

  }
}
