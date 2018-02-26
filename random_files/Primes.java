import edu.princeton.cs.algs4.StdOut;
import java.util.Iterator;

// An immutable data type to systematically iterate over the first n primes.
public class Primes implements Iterable<Integer> {
    private final int n; // need first n primes

    // Constructs an iterable Primes object given the number of primes needed.
    public Primes(int n) {
        this.n = n;
    }

    // Returns a PrimesIterator object.
    public Iterator<Integer> iterator() { return new PrimesIterator(); }
    
    // Primes iterator.
    private class PrimesIterator implements Iterator<Integer> {
        private int count = 0; // number of primes returned
        private int p = 2;     // current prime

        // Are there anymore primes left to be iterated?
        public boolean hasNext() { 
            return (count < n);
        }

        // Returns the next prime.
        public Integer next() {
            while (!isPrime(p)) {
                p++;
            }
            count++;
            return p++;
        }
        
        // Remove is not supported.
        public void remove() {
            // nothing to do
        }

        // Returns true if x (>= 2) is prime and false otherwise.
        private boolean isPrime(int x) {
            for (int i = 2; i <= x / i; i++) {
                if (x % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    // Test client. [DO NOt EDIT]
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        for (int i : new Primes(n)) {
            StdOut.println(i);
        }
    }
}
