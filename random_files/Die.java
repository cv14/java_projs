import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

// A data type representing a six-sided die.
public class Die implements Comparable<Die> {
    private int value; // face value

    // Rolls the die.
    public void roll() {
        value = (int) (Math.random() * 6) + 1;
    }

    // Returns the face value of the die.
    public int value() {
        return this.value;
    }

    // Returns true if this and that die have the same face value, and
    // false otherwise.
    public boolean equals(Die that) {
         return (this.value == that.value);
    }

    // Returns negative, zero, or positive integer depending on whether this
    // die's value is less than, equal to, or greater than the that die's value.
    public int compareTo(Die that) {
        
        int z = 0;
        if (this.value < that.value) { return -1; }
        if (this.value > that.value) { return 1; }
        return z;
    }

    // Returns a string representation of the die giving the current
    // face value.
    public String toString() {
        String dieFace = "null";
        if (value == 1) {
            dieFace = "     \n  *  \n     ";
        }
        if (value == 2) {
            dieFace = "*    \n     \n    *";
        }
        if (value == 3) {
               dieFace = "*    \n  *  \n    *";
        }
        if (value == 4) {
               dieFace = "*   *\n     \n*   *";
        }
        if (value == 5) {
               dieFace = "*   *\n  *  \n*   *";
        }
        if (value == 6) {
               dieFace = "* * *\n     \n* * *";
            }      
        
        return dieFace;

        
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
