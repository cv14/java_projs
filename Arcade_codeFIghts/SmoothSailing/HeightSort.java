/*
Some people are standing in a row in a park. There are trees between them which
cannot be moved. Your task is to rearrange the people by their heights in a
non-descending order without moving the trees.

Example

For a = [-1, 150, 190, 170, -1, -1, 160, 180], the output should be
sortByHeight(a) = [-1, 150, 160, 170, -1, -1, 180, 190].

Input/Output

[time limit] 3000ms (java)
[input] array.integer a

If a[i] = -1, then the ith position is occupied by a tree. Otherwise a[i] is the height of a person standing in the ith position.

Guaranteed constraints:
5 ≤ a.length ≤ 15,
-1 ≤ a[i] ≤ 200.

[output] array.integer

Sorted array a with all the trees untouched.


*/
import java.util.Arrays;
import java.util.ArrayList;

public class HeightSort {
  static ArrayList<Integer> al = new ArrayList<Integer>();

  static void addToAL(ArrayList<Integer> al,int[] a ){

    for (int i = 0; i < a.length; i++) {
      al.add(a[i]);
    }

  }

  static int[] sortByHeight(int[] a) {

    boolean[] temporal = new boolean[a.length];

    for (int i = 0; i < a.length; i++) {
      temporal[i] = a[i] == -1 ? false : true;
    }

    System.out.println(Arrays.toString(temporal));

    Arrays.sort(a);
    addToAL(al, a);






    return a;
  }

  public static void main(String[] args) {
    int[] a = {-1, 150, 190, 170, -1, -1, 160, 180};
    System.out.println(Arrays.toString(sortByHeight(a)));
  }

}
