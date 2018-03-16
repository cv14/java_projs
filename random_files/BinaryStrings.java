import edu.princeton.cs.algs4.StdOut;
import java.util.Iterator;

// An immutable data type to systematically iterate over length-n binary
// strings.
public class BinaryStrings implements Iterable<String> {
    private final int n; // need all binary strings of length n

    // Constructs an iterable BinaryStrings object given the length of binary 
    // strings needed.
    public BinaryStrings(int n1) {
        n = n1;
    }

    // Returns a BinaryStringsIterator object.
    public Iterator<String> iterator() { return new BinaryStringsIterator();}
    
    // Binary strings iterator.
    private class BinaryStringsIterator implements Iterator<String> {
        private int count = 0; // number of binary strings returned
        private int p = 0;     // current number

        // Are there anymore length-n binary strings left to be iterated?
        public boolean hasNext() { 
            return count != Math.pow(2, n);
        }

        // Returns the next length-n binary string.
        public String next() {
            String a = "";
            a += binary(p);
            p += 1;
            count += 1;
            return a;
        }
        
        // Remove is not supported.
        public void remove() {
            // nothing to do
        }

        // Returns the n-bit representation of x.
        private String binary(int x) {
            String s = Integer.toBinaryString(x);
            int padding = n - s.length();
            for (int i = 1; i <= padding; i++) {
                s = "0" + s;
            }
            return s;
        }
    }

    // Test client. [DO NOt EDIT]
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        for (String s : new BinaryStrings(n)) {
            StdOut.println(s);
        }
    }
}