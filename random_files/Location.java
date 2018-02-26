import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

// An immutable type representing a location on Earth.
public class Location implements Comparable<Location> {
    private final String loc; // location name
    private final double lat; // latitude
    private final double lon; // longitude

    // Constructs a new location given its name, latitude, and longitude values.
    public Location(String loc, double lat, double lon) {
        this.loc = loc;
        this.lat = lat;
        this.lon = lon;
    }

    // Returns the great-circle distance between this location and that.
    public double distanceTo(Location that) {
        double x1 = this.lat;
        double y1 = this.lon;
        double x2 = that.lat;
        double y2 = that.lon;
        x1 = Math.toRadians(x1);
        y1 = Math.toRadians(y1);
        x2 = Math.toRadians(x2);
        y2 = Math.toRadians(y2);
        double s = Math.sin(x1) * Math.sin(x2);
        double c = Math.cos(x1) * Math.cos(x2) * Math.cos(y1 - y2);
        double t = Math.acos(s + c);
        double deg = Math.toDegrees(t);
        double d = 111 * deg;
        return d;
    }

    // Returns true if this and that location are the same, and false otherwise.
    public boolean equals(Location that) {
        return (this.lat == that.lat && this.lon == that.lon);
    }

    // Returns -1, 0, or 1 depending on whether the distance of this 
    // location to the origin is less than, equal to, or greater than the 
    // distance of that location to the origin, where the origin is 
    // the center of the Universe, ie, UMass Boston (42.3134, -71.0384).
    public int compareTo(Location that) {
        int z = 0;
        Location umb = new Location("UMass Boston", 42.3134, -71.0384);
        
       if (this.distanceTo(umb) < that.distanceTo(umb)) { return -1; }
        if (this.distanceTo(umb) > that.distanceTo(umb)) { return 1; }
       return z;
    }

    // Returns a string representation of the location, in 
    // "loc (lat, lon)" format.
    public String toString() {
       String str = this.loc + " (" + this.lat + ", " + this.lon + ")";
        return str;
    }

    // Test client. [DO NOT EDIT]
    public static void main(String[] args) {
        Location[] wonders = new Location[7];
        wonders[0] = new Location("The Great Wall of China (China)", 
                                  40.6769, 117.2319);
        wonders[1] = new Location("Petra (Jordan)", 30.3286, 35.4419);
        wonders[2] = new Location("The Colosseum (Italy)", 41.8902, 12.4923);
        wonders[3] = new Location("Chichen Itza (Mexico)", 20.6829, -88.5686);
        wonders[4] = new Location("Machu Picchu (Peru)", -13.1633, -72.5456);
        wonders[5] = new Location("Taj Mahal (India)", 27.1750, 78.0419);
        wonders[6] = new Location("Christ the Redeemer (Brazil)", 
                                  22.9519, -43.2106);
        Arrays.sort(wonders);
        for (Location wonder : wonders) {
            StdOut.println(wonder);
        }
    }
}
