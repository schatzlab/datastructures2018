import java.util.ArrayList;

public class Endpoint {
    // Name of this endpoint (GPS coordinates)
    private String name;

    // List of roads that connect at this endpoint
    private ArrayList<Road> roads;

    // distance to this endpoint during search
    private double dist;

    // path taken to get to this endpint during search
    private Road incoming;

    // Construct a new endpoint
    public Endpoint(String name) {
      this.roads = new ArrayList<Road>();
      this.name = name;
    }

    // get name of this endpoint
    public String getName() {
      return this.name;
    }

    // Add a road that connects to this endpoint
    public void addRoad(Road r) {
      this.roads.add(r);
    }

    // set distance to this endpoint
    public void setDist(double dist) {
      this.dist = dist;
    }

    // get distance to this endpoint
    public double getDist() {
      return this.dist;
    }

    // set incoming road traveled during search
    public void setIncoming(Road incoming) {
      this.incoming = incoming;
    }

    // get incoming road during search
    public Road getIncoming() {
      return this.incoming;
    }

    // get list of road that connect at this endpoint
    public ArrayList<Road> getRoads() {
        return roads;
    }
}
