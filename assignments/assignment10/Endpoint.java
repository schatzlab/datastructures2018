import java.util.ArrayList;

/**
  Encodes an endpoint for a road.

  Stores a list of roads (outgoing edges) that leave from this endpoint
**/
public class Endpoint {
    // Name of this endpoint (GPS coordinates)
    private String name;

    // List of roads that connect at this endpoint
    private ArrayList<Road> roads;

    // distance to this endpoint during search
    private double dist;

    // previous road to get to this endpoint during search
    private Road incomingRoad;

    // previous endpoint to get to this endpoint during search
    private Endpoint incomingEndpoint;

    /**
      Construct a new endpoint.
      @param name Name of Endpoint (GPS coordinates)
    **/
    public Endpoint(String name) {
        this.roads = new ArrayList<Road>();
        this.name = name;
    }

    /**
      get name of this endpoint.
      @return name of endpoint
    **/
    public String getName() {
        return this.name;
    }

    /**
      Add a road that connects to this endpoint.
      @param r reference to road connecting this endpoint
    **/
    public void addRoad(Road r) {
        this.roads.add(r);
    }

    /**
      set distance to this endpoint (during search).
      @param d distance
    **/
    public void setDist(double d) {
        this.dist = d;
    }

    /**
      get distance to this endpoint (during search).
      @return current distance to endpoint
    **/
    public double getDist() {
        return this.dist;
    }

    /**
      set incoming road traveled during search.
      @param in Reference to incoming Road
    **/
    public void setIncomingRoad(Road in) {
        this.incomingRoad = in;
    }

    /**
      get incoming road during search.
      @return Reference to incoming road
    **/
    public Road getIncomingRoad() {
        return this.incomingRoad;
    }

    /**
      set incoming endpoint traveled during search.
      @param in Reference to incoming Road
    **/
    public void setIncomingEndpoint(Endpoint in) {
        this.incomingEndpoint = in;
    }

    /**
      get incoming endpoint during search.
      @return Reference to incoming endpoint
    **/
    public Endpoint getIncomingEndpoint() {
        return this.incomingEndpoint;
    }

    /**
      get list of roads that leave from this endpoint.
      @return ArrayList of roads that connect
    **/
    public ArrayList<Road> getRoads() {
        return roads;
    }
}
