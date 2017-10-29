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

  public static boolean isListPalindrome(ListNode<Integer> l){

    int size = size(l);
    int tillMid = 0;
    ListNode<Integer> headNode = l;
    ListNode<Integer> cur­rN­ode = l;
    ListNode<Integer> pre­vN­ode = null;
    ListNode<Integer> nextNode = null;
    ListNode<Integer> firstHalf = null;
    ListNode<Integer> secondHalf = null;

    if(size == 1){
      return true;
    }


    if(size % 2 == 0){
      //if even number check the first half and last half
      for(ListNode<Integer> n = l; n != null && tillMid != size/2; n = n.next){
        //System.out.println(n.value);
        headNode = n;
        tillMid++;
      }
      cur­rN­ode = headNode.next;
    }else{
      for(ListNode<Integer> n = l; n != null && tillMid != size/2 + 1; n = n.next){
        headNode = n;
        tillMid++;
      }

      cur­rN­ode = headNode.next;
    }

    while(currNode!=null){
        nextNode = currNode.next;
        currNode.next = prevNode;
        prevNode = currNode;
        currNode = nextNode;
    }
    headNode.next = prevNode;

    firstHalf = l;
    secondHalf = prevNode;

    for (int i = 0; i < size/2; i++,firstHalf = firstHalf.next, secondHalf = secondHalf.next){
      if((firstHalf.value).equals(secondHalf.value) != true){
        return false;
      }
    }
    return true;
  }

  public static int size(ListNode<Integer> l) {

      int size = 1;
      for(ListNode<Integer> n = l; n.next != null; n = n.next){
        size++;
      }

     return size;
  }

  public static void main(String[] args) {

      ListNode<Integer> temp = new ListNode(null);

      System.out.println(isListPalindrome(temp));

      ListNode<Integer> temp1 = new ListNode(10);
      System.out.println(isListPalindrome(temp1));


      ListNode<Integer> ll3 = new ListNode(1);
      ListNode<Integer> ll1 = new ListNode(1000000000);
      ListNode<Integer> ll2 = new ListNode(-1000000000);
      ListNode<Integer> ll31 = new ListNode(-1000000000);
      ListNode<Integer> ll4 = new ListNode(1000000000);
      ListNode<Integer> ll69 = new ListNode(1);

      ll3.next = ll1;
      ll1.next = ll2;
      ll2.next = ll31;
      ll31.next = ll4;
      ll4.next = ll69;

      System.out.println(isListPalindrome(ll3));

  }

  public static class ListNode<T> {
    public ListNode(T x) {
      value = x;
    }
    T value;
    ListNode<T> next;
  }


}
