/*
A drunkard's walk. A drunkard begins walking aimlessly, starting at a lamp post.
 At each time step, the drunkard forgets where he or she is, and takes one step
 at random, either north, east, south, or west, with probability 25%. How far
 will the drunkard be from the lamp post after N steps?

Write a program RandomWalker.java that takes an integer command-line argument
N and simulates the motion of a random walker for N steps. After each step,
print the location of the random walker, treating the lamp post as the origin
(0, 0). Also, print the square of the final distance from the origin.

To generate a number from 10 to 20 :

(int)(Math.random() * 11 + 10);
In the general case:

(int)(Math.random() * ((upperbound - lowerbound) + 1) + lowerbound);
(where lowerbound is inclusive and upperbound exclusive).
              ||
              ||
https://stackoverflow.com/a/16624834/7838588

*/
import java.lang.Math;

public class RandomWalker {
  public static int r, x = 0, y = 0;
  
  public static void main(String[] args) {

    if(args.length == 0){
        System.out.println("lado lado");
        System.exit(0);
    }

    int N = Integer.parseInt(args[0]);


    for(int i = 0; i < N; i++){
          r = (int)(Math.random() * 100 + 1);
          //System.out.println(r);
          if(r >= 1 && r <= 25){
              y += 1;
              System.out.println(x + ", " + y);
          }else if(r >= 26 && r <= 50){
              x += 1;
              System.out.println(x + ", " + y);
          }else if(r >= 51 && r <= 75 ){
              x -= 1;
              System.out.println(x + ", " + y);
          }else{
            y -= 1;
            System.out.println(x + ", " + y);
          }
     }

     System.out.println("Squared Distance = " + (x*x + y*y));

  }//end main
}//end class
