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

//using for loop check if the value from first to end is greater than next to it.
//if it is then take it out and see if the sequence is increasing
//if it is return true else false.

//Or using a stack

public class IncreasingSequence {

  public static boolean almostIncreasingSequence(int[] sequence) {
      

    // for (int i = 0; i < sequence.length-2; i++) {
    //   if(sequence.)
    //   if(sequence[i] >= sequence[i+1]){
    //     if(sequence[i] >= sequence[i+2]){
    //       return false;
    //     }
    //   }
    //
    // }

    return true;
  }

  public static void main(String[] args) {
    int[] seq = {10, 1, 2, 3, 4, 5};
    System.out.println(almostIncreasingSequence(seq));

    //seq = { 1, 3, 2};

  }
}
