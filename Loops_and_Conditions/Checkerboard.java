/*
Write a program Checkerboard.java that takes an integer command-line argument N,
and uses two nested for loops to print an N-by-N "checkerboard" pattern like the
one below: a total of N2 asterisks, where each row has 2N characters
(alternating between asterisks and spaces).
*/


public class Checkerboard {
  public static void main(String[] args) {

    if(args.length == 0){
        System.out.println("lado lado");
        System.exit(0);
    }

    int N = Integer.parseInt(args[0]);
    boolean sl = true;
    boolean s = true;

    for(int i = 0; i < N; i++){
      for(int j = 0; j < N+N; j++){
        if(s){
          System.out.print("*");
          s = false;
        }else{
          System.out.print(" ");
          s = true;
        }
      }
      System.out.println();
      if(sl){
        s = false;
        sl = false;
      }else{
        s = true;
        sl = true;
      }
    }

  }//end main
}//end class
