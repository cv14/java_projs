/*
Two arrays are called similar if one can be obtained from another by swapping
at most one pair of elements in one of the arrays.

Given two arrays a and b, check whether they are similar.

Example

For a = [1, 2, 3] and b = [1, 2, 3], the output should be
areSimilar(a, b) = true.

The arrays are equal, no need to swap any elements.

For a = [1, 2, 3] and b = [2, 1, 3], the output should be
areSimilar(a, b) = true.

We can obtain b from a by swapping 2 and 1 in b.

For a = [1, 2, 2] and b = [2, 1, 1], the output should be
areSimilar(a, b) = false.

Any swap of any two elements either in a or in b won't make a and b equal.
*/

//check order of both the arrays and if two swipes return false else true.
import java.util.Arrays;

public class Similar {

  static int findInd(int[] arr, int val, int start){

    for (int i = start; i < arr.length; i++) {
      if(arr[i] == val){
        return i;
      }
    }
    return -1;

  }

  static boolean areSimilar(int[] a, int[] b) {
    int indA = 0, indB = 0 ;
    int skipInd = -1;

    if(Arrays.equals(a,b)){ return true;}

    int intercambiars = 0;

    for (int i = 0; i < a.length; i++) {
      System.out.println(i);
      if(a[i] != b[i] && intercambiars < 1){
        if(skipInd == i){
          break;
        }
        indA = findInd(b, a[i], i + 1);
        indB = findInd(a, b[i], i + 1);
        System.out.println(indA + "  " + indB);
        if(indA != indB || indA == -1 || indB == -1){
          return false;
        }
        skipInd = indA;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    int a[] = {4, 6, 3};
    int b[] =  {3, 4, 6};


    //System.out.println(areSimilar(a,b));

    int aa[] = {1,2,2};
    int bb[] = {2, 1, 1};
    System.out.println(areSimilar(aa,bb));
  }
}
