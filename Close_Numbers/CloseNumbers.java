/*
Given an array of integers nums and an integer k, determine whether there are
two distinct indices i and j in the array where nums[i] = nums[j] and the
absolute difference between i and j is less than or equal to k.

Example

For nums = [0, 1, 2, 3, 5, 2] and k = 3, the output should be
containsCloseNums(nums, k) = true.

There are two 2s in nums, and the absolute difference between their positions
is exactly 3.

For nums = [0, 1, 2, 3, 5, 2] and k = 2, the output should be

containsCloseNums(nums, k) = false.

The absolute difference between the positions of the two 2s is 3, which is more
than k.


*/


import java.util.*;

 public class CloseNumbers {

   public static boolean containsCloseNums(int[] nums, int k) {
     HashMap<Integer, Integer> mapa = new HashMap<Integer, Integer>();
     boolean cambiar = true;

     if(nums.length == 0 || nums.length == 1){
       cambiar = false;
     }

     for(int i = 0; i < nums.length; i++){
       if(mapa.containsKey(nums[i])){
         if(i - mapa.get(nums[i])> k){
           cambiar = false;
           mapa.put(nums[i], i);
         }else{
           cambiar = true;
           return cambiar;
         }
       }else{
         mapa.put(nums[i], i);
       }
     }

     if(mapa.size() == nums.length){
       cambiar = false;
     }

     return cambiar;
   }


   public static void main(String[] args) {
     int[] nums = {1, 0 ,1 ,1 };
     int k = 1;
     System.out.println(containsCloseNums(nums,k));
   }

 }
