import java.util.*;

public class RotateImage{

  public static int[][] rotateImage(int[][] a) {

    int[][] tempArr = new int[a.length][a.length];


     int r , c;
     r= 0; c = 0;


     for(int i = 0; i < a.length; i++){
       for(int j = a.length - 1 ; j >= 0; j--){

         System.out.println(a[j][i]);
         System.out.println(r + "    " + c);
          tempArr[r][c++] = a[j][i];

          if(c == a.length){
            r++;
            c = 0;
          }
       }
     }

     return tempArr;


  }

  public static void main(String[] args) {
    int[][] myArray = {{10,9,6,3,7},
                        {6,10,2,9,7},
                         {7,6,3,8,2},
                         {8,9,7,9,9},
                         {6,8,6,8,2}};


    System.out.println(Arrays.deepToString(rotateImage(myArray)));

  }
}


// [[7,4,1],
//  [8,5,2],
//  [9,6,3]]
