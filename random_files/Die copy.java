import edu.princeton.cs.algs4.StdOut;
import java.util.Random;
import java.util.Arrays;
// A data type representing a six-sided die.
public class Die implements Comparable<Die> {
 private int value; // face value

    // Rolls the die.
    public void roll() {
        Random n = new Random();
        int face = n.nextInt(7 - 1) + 1;
        this.value = face;
    }

    // Returns the face value of the die.
    public int value() {
        return this.value;
    }

    public int compareTo(Die that)
    {
    if(this.value > that.value) {return +1;}
    if(this.value < that.value){return -1;}
    return 0;
    
    }// Returns true if this and that die have the same face value, and
    // false otherwise.
    public boolean equals(Die that) {
        return this.compareTo(that) == 0;
    }

    // Returns a string representation of the die giving the current
    // face value.
    public String toString() {
        String s = "";
        if (this.value == 1) {
         s += "     " + "\n  *  " + "\n     ";
        }
        
        if (this.value == 2) {
         s += "*    " + "\n     " + "\n    *";
        }
        
        if (this.value == 3) {
         s += "*    " + "\n  *  " + "\n    *";
        }
        
        if (this.value == 4) {
         s += "*   *" + "\n     " + "\n*   *";
        }
        
        if (this.value == 5) {
         s += "*   *" + "\n  *  " + "\n*   *";
        }
        
        if (this.value == 6) {
         s += "* * *" + "\n     " + "\n* * *";
        }
        return s;
    }

    // Test client. [DO NOT EDIT]
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        Die[] dice = new Die[n];
        for (int i = 0; i < n; i++) {
            dice[i] = new Die();
            dice[i].roll();
        }
        Arrays.sort(dice);
        for (Die die : dice) {
            StdOut.println(die.value());
        }
    }
}
