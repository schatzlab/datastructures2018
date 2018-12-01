import java.util.ArrayList;

// This is a directed road from one endpoint to the next
public class Road {
    // name of this road
    private String name;

    // Reference to the endpoint at the other end of this road segment
    private Endpoint dest;

    // Distance to travel along this endpoint
    private double dist;

    // constructor
    public Road(String name, Endpoint dest, double dist) {
        this.name = name;
        this.dest = dest;
        this.dist = dist;
    }

    // get the name
    public String getName() {
        return this.name;
    }

    // get the destination endpoint
    public Endpoint getDest() {
        return this.dest;
    }

    // get the distnace to the next endpoint
    public double getDist() {
        return this.dist;
    }

    // note no way to reset the dest or dist
}
