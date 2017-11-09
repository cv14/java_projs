/*
Given a sequence of integers as an array, determine whether it is possible to
obtain a strictly increasing sequence by removing no more than one element from
the array.

Example

For sequence = [1, 3, 2, 1], the output should be
almostIncreasingSequence(sequence) = false;

There is no one element in this array that can be removed in order to get a
strictly increasing sequence.

For sequence = [1, 3, 2], the output should be
almostIncreasingSequence(sequence) = true.

You can remove 3 from the array to get the strictly increasing sequence [1, 2].
Alternately, you can remove 2 to get the strictly increasing sequence [1, 3].

Input/Output

[time limit] 3000ms (java)
[input] array.integer sequence

Guaranteed constraints:
2 ≤ sequence.length ≤ 105,
-105 ≤ sequence[i] ≤ 105.

[output] boolean

Return true if it is possible to remove one element from the array in order to
get a strictly increasing sequence, otherwise return false.


*/
//optimize the code

import java.util.*;

public class IncreasingSequence {

  public static boolean check_seq(ArrayList<Integer> seqNumbs){

    for (int i = 0; i < seqNumbs.size()-1; i++) {
      if(seqNumbs.get(i) >= seqNumbs.get(i+1)){
        return false;
      }
    }
    return true;
  }

  public static boolean almostIncreasingSequence(int[] sequence) {
      ArrayList<Integer> seqNumbs = new ArrayList<Integer>();
      int temporal = 0;
      boolean retBool = true;

      for (int i = 0; i < sequence.length; i++){
        seqNumbs.add(sequence[i]);
      }

      for (int i = 0; i < seqNumbs.size()-2; i++) {
        if(seqNumbs.get(i) >= seqNumbs.get(i+1)){
          temporal = seqNumbs.get(i);
          seqNumbs.remove(i);
          retBool = check_seq(seqNumbs);
          seqNumbs.add(i, temporal);

        }
        if(i > 0 && retBool == false && seqNumbs.get(i-1) >= seqNumbs.get(i+1)){
          temporal = seqNumbs.get(i+1);
          seqNumbs.remove(i+1);
          retBool = check_seq(seqNumbs);
          seqNumbs.add(i+1, temporal);
        }

      }
    return retBool;
  }

  public static void main(String[] args) {
    int[] seq = {1, 1, 1, 2, 3};
    System.out.println(almostIncreasingSequence(seq));

  }
}
