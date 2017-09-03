/*
A drunkard's walk. A drunkard begins walking aimlessly, starting at a lamp post.
 At each time step, the drunkard forgets where he or she is, and takes one step
 at random, either north, east, south, or west, with probability 25%. How far
 will the drunkard be from the lamp post after N steps?

Write a program RandomWalkers.java that takes two integer command-line arguments
N and T. In each of T independent experiments, simulate a random walk of N steps
and compute the squared distance. Output the mean squared distance (the average
of the T squared distances).

As N increases, we expect the random walker to end up further and further
away from the origin. But how much further? Use RandomWalkers to formulate a
hypothesis as to how the mean squared distance grows as a function of N. Use
T = 100,000 trials to get a sufficiently accurate estimate.

Remark: this process is a discrete version of a natural phenomenon known as
Brownian motion. It serves as a scientific model for an astonishing range of
physical processes from the dispersion of ink flowing in water, to the formation
of polymer chains in chemistry, to cascades of neurons firing in the brain.


-- So the RandomWalker will end up N step further hypothetically. 
*/

import java.lang.Math;

public class RandomWalkers {
  public static void main(String[] args) {

    if(args.length < 2){
        System.out.println("\nMissing argument T : # independent experiments\n");
        System.exit(0);
    }

    int T = Integer.parseInt(args[1]);
    double meanDis = 0;

    RandomWalker w = new RandomWalker();

    for(int i = 0; i < T; i++){
      w = new RandomWalker();
      w.main(args);
      System.out.print("\033[H\033[2J"); //for clearing the output
      meanDis = meanDis + (w.x * w.x + w.y * w.y);
      //System.out.println(meanDis);
    }

    meanDis = meanDis/T;
    System.out.println("mean squared distance = " + meanDis);

  }//end main
}//end class
