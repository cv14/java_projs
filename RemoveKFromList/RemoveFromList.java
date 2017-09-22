/*

Note: Try to solve this task in O(n) time using O(1) additional space, where n
is the number of elements in the list, since this is what you'll be asked to do
during an interview.

Given a singly linked list of integers l and an integer k, remove all elements
from list l that have a value equal to k.

Example

For l = [3, 1, 2, 3, 4, 5] and k = 3, the output should be
removeKFromList(l, k) = [1, 2, 4, 5];
For l = [1, 2, 3, 4, 5, 6, 7] and k = 10, the output should be
removeKFromList(l, k) = [1, 2, 3, 4, 5, 6, 7].
Input/Output

[time limit] 3000ms (java)
[input] linkedlist.integer l

A singly linked list of integers.

Guaranteed constraints:
0 ≤ list size ≤ 105,
-1000 ≤ element value ≤ 1000.

[input] integer k

An integer.

Guaranteed constraints:
-1000 ≤ k ≤ 1000.

[output] linkedlist.integer

Return l with all the values equal to k removed.


*/
import java.util.*;

public class RemoveFromList {

  public static ListNode<Integer> removeKFromList(ListNode<Integer> l, int k) {

    if(l == null){return null;}

    ListNode<Integer> current = l;

    if(current.value == k){
            if (current.next == null) {
                return null;
            }

            /* Copy the data of next node to head */
            current.value = current.next.value;

            // Remove the link of next node
            current.next = current.next.next;
        }

    while(current.next != null){
      if(current.next.value == k){
        current.next = current.next.next;
      }else{
        current = current.next;
      }
    }
    return l.value == k ? l.next : l;
  }

  public static void main(String[] args) {

      ListNode<Integer> ll3 = new ListNode(3);
      ListNode<Integer> ll1 = new ListNode(1);
      ListNode<Integer> ll2 = new ListNode(2);
      ListNode<Integer> ll31 = new ListNode(3);
      ListNode<Integer> ll4 = new ListNode(4);
      ListNode<Integer> ll5 = new ListNode(5);

      ll3.next = ll1;
      ll1.next = ll2;
      ll2.next = ll31;
      ll31.next = ll4;
      ll4.next = ll5;

      //removeKFromList(ll3, 3);
      System.out.println(removeKFromList(ll3, 3));

      while(ll3 != null){
        System.out.println(ll3.value);
        ll3 = ll3.next;
      }

  }

  public static class ListNode<T> {
    public ListNode(T x) {
      value = x;
    }
    T value;
    ListNode<T> next;
  }


}
