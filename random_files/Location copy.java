import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

// An immutable type representing a location on Earth.
public class Location implements Comparable<Location>{
    private final String loc1; // location name
    private final double lat1; // latitude
    private final double lon1; // longitude

    // Constructs a new location given its name, latitude, and longitude values.
    public Location(String loc, double lat, double lon) {
        loc1 = loc;
        lat1 = lat;
        lon1 = lon;
    }

    // Returns the great-circle distance between this location and that.
    public double distanceTo(Location that) {
        double a = Math.sin(Math.toRadians(this.lat1)) * Math.sin(Math.toRadians(that.lat1));
        double b = Math.cos(Math.toRadians(this.lat1)) * Math.cos(Math.toRadians(that.lat1)) * Math.cos(Math.toRadians(this.lon1 - that.lon1));
        double d = Math.toDegrees(111 * Math.acos(a + b));
        return d;
    }
    

    public int compareTo(Location that) {
        int i = 0;
        Location a = new Location("UMass Boston", 42.3134, -71.0384);
        if (this.distanceTo(a) == that.distanceTo(a)) {
            i = 0;
        }
        
        if(this.distanceTo(a) > that.distanceTo(a)) {
            i = 1;
        }
        
        if(this.distanceTo(a) < that.distanceTo(a)){
            i = -1;
        }
        return i;
    }
    
    // Returns true if this and that location are the same, and false otherwise.
    public boolean equals(Location that) {
        return this.compareTo(that) == 0;
    }

    // Returns a string representation of the location, in 
    // "loc (lat, lon)" format.
    public String toString() {
        String s = this.loc1;
        s += " (" + this.lat1 + ", " + this.lon1 + ")";
        return s;
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
