import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;
import java.util.Comparator;

// An immutable data type representing a 3D point.
public class Point3D implements Comparable<Point3D> {
    private final double x; // x coordinate
    private final double y; // y coordinate
    private final double z; // z coordinate

    // Constructs a point in 3D given its coordinates.
    public Point3D(double x1, double y1, double z1) {
       x = x1;
       y = y1;
       z = z1;
    }

    // Returns the Euclidean distance between this point and that.
    public double distance(Point3D that) {
        x1 = this.x - that.x;
        y1 = this.y - that.y;
        z1 = this.z - that.z;
        
        double d = x1*x1 + y1*Y1 + z1*z1 ;
        return Math.sqrt(d);
    }

    // Returns the squared Euclidean distance between this point and that.
    public double distanceSquared(Point3D that) {
        double e = this.distance(that);
        return Math.pow(e, 2);
    }

    // Returns the L1 distance between this point and that.
    public double distanceL1(Point3D that) {
        double a = Math.abs(this.x - that.x);
        double b = Math.abs(this.y - that.y);
        double c = Math.abs(this.z - that.z);
        return a + b + c;
    }

    // Returns true if this and that point have the same coordinates, and 
    // false otherwise.
    public int compareTo(Point3D that) {
        Point3D a = new Point3D(0.0, 0.0, 0.0);
        int i = 0;
        if (this.distance(a) < that.distance(a)) {
            i = -1;
        }
        
        if (this.distance(a) == that.distance(a)) {
            i = 0;
        }
        
        if (this.distance(a) > that.distance(a)) {
            i = 1;
        }
        return i;
    }
    
    public int helper(Point3D that) {
        if (this.x == that.x && this.y == that.y && this.z == that.z) {
            return 0;
        }
        else {
            return 1;
        }
    }
    
    public boolean equals(Point3D that) {
       return this.helper(that) == 0;
    }

    // Returns a string representation of the point, in "(x, y, z)" format.
    public String toString() {
        String s = "(";
        s += this.x + ", " + this.y + ", " + this.z + ")";
        return s;
    }


    // Compares points based on their x-coordinates.
    public static class XOrder implements Comparator<Point3D> {
        // Returns -1, 0, or 1 depending on whether p1's x-coordinate
        // is less than, equal to, or greater than p2's x-coordinate.
        public int compare(Point3D p1, Point3D p2) {
            int a = 0;
            if (p1.x < p2.x) {
                a = -1;
            }
            
            if (p1.x == p2.x) {
                a = 0;
            }
            
            if (p1.x > p2.x) {
                a = 1;
            }
            return a;
        }
    }

    // Compares points based on their y-coordinates.
    public static class YOrder implements Comparator<Point3D> {
        // Returns -1, 0, or 1 depending on whether p1's y-coordinate
        // is less than, equal to, or greater than p2's y-coordinate.
        public int compare(Point3D p1, Point3D p2) {
            int b = 0;
             if (p1.y < p2.y) {
                b = -1;
            }
            
            if (p1.y == p2.y) {
                b = 0;
            }
            
            if (p1.y > p2.y) {
                b = 1;
            }
            return b;
        }
    }

    // Compares points based on their z-coordinates.
    public static class ZOrder implements Comparator<Point3D> {
        // Returns -1, 0, or 1 depending on whether p1's z-coordinate
        // is less than, equal to, or greater than p2's z-coordinate.
        public int compare(Point3D p1, Point3D p2) {
            int c = 0;
             if (p1.z < p2.z) {
                c = -1;
            }
            
            if (p1.z == p2.z) {
                c = 0;
            }
            
            if (p1.z > p2.z) {
                c = 1;
            }
            return c;
        }
    }
    
    //Test client. [DO NOT EDIT]
    public static void main(String[] args) {
        int n = StdIn.readInt();
        Point3D[] points = new Point3D[n];
        for (int i = 0; i < n; i++) {
            double x = StdIn.readDouble();
            double y = StdIn.readDouble();
            double z = StdIn.readDouble();
            points[i] = new Point3D(x, y, z);
        }
        for (Point3D point : points) {
            StdOut.println(point);
        }
        Arrays.sort(points);
        for (Point3D point : points) {
            StdOut.println(point);
        }
        Arrays.sort(points, new Point3D.XOrder());
        for (Point3D point : points) {
            StdOut.println(point);
        }
        Arrays.sort(points, new Point3D.YOrder());
        for (Point3D point : points) {
            StdOut.println(point);
        }
        Arrays.sort(points, new Point3D.ZOrder());
        for (Point3D point : points) {
            StdOut.println(point);
        }
    }
}
