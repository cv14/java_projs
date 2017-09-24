/*

Note: Try to solve this task in O(n) time using O(1) additional space, where n
is the number of elements in l, since this is what you'll be asked to do during
an interview.

Given a singly linked list of integers, determine whether or not it's a
palindrome.

Example

For l = [0, 1, 0], the output should be
isListPalindrome(l) = true;
For l = [1, 2, 2, 3], the output should be
isListPalindrome(l) = false.
Input/Output

[time limit] 3000ms (java)
[input] linkedlist.integer l

A singly linked list of integers.

Guaranteed constraints:
0 ≤ list size ≤ 5 · 105,
-109 ≤ element value ≤ 109.

[output] boolean

Return true if l is a palindrome, otherwise return false.


*/
import java.util.*;

public class Palindrome {

  public static ListNode<Integer> boolean isListPalindrome(ListNode<Integer> l){

    //get the length;
    //break the list in half
    //if odd number of element take the mid point and compare left and right
    //if even number check the first half and last half

    System.out.println(size(l));

    return true;
  }

  public int size(ListNode<Integer> l) {

      int size = 0;
      for(ListNode<Integer> n = l; n.next != null; n = n.next){
        size++;
      }

     return size;
  }

  public static void main(String[] args) {

      ListNode<Integer> ll3 = new ListNode(0);
      ListNode<Integer> ll1 = new ListNode(1);
      ListNode<Integer> ll2 = new ListNode(0);
      ListNode<Integer> ll31 = new ListNode(1);
      ListNode<Integer> ll4 = new ListNode(0);

      ll3.next = ll1;
      ll1.next = ll2;
      ll2.next = ll31;
      ll31.next = ll4;

      System.out.println(isListPalindrome(ll3, 3));

  }

  public static class ListNode<T> {
    public ListNode(T x) {
      value = x;
    }
    T value;
    ListNode<T> next;
  }


}
