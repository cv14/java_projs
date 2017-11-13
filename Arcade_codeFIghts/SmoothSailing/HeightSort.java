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
import java.util.LinkedList;

public class HeightSort {
  static LinkedList<Integer> al = new LinkedList<Integer>();

  static void addToAL(LinkedList<Integer> al,int[] a ){

    for (int i = 0; i < a.length; i++) {
      if(a[i] != -1){ al.add(a[i]); }
    }

  }

  static void addTrees(LinkedList<Integer> al,boolean[] temporal ){

    for (int i = 0; i < temporal.length; i++) {
      if(!temporal[i]) {
        al.add(i, -1);
      }
    }
  }

  static int[] sortByHeight(int[] a) {

    boolean[] temporal = new boolean[a.length];

    for (int i = 0; i < a.length; i++) {
      temporal[i] = a[i] == -1 ? false : true;
    }

    Arrays.sort(a);
    addToAL(al, a);

    addTrees(al, temporal);

    for(int num = 0; num < al.size(); num++)
      {
    	  a[num] = al.get(num);
      }

    return a;
  }

  public static void main(String[] args) {
    int[] a = {-1, -1, -1, -1, -1};
    System.out.println(Arrays.toString(sortByHeight(a)));
  }

}
