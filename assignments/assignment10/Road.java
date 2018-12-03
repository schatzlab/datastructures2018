/**
  Encodes a directed road from one endpoint to the next.

  Note there is no way to change the destination or distance
  once the road has been constructed.
**/
public class Road {
    // name of this road
    private String name;

    // Reference to the endpoint at the other end of this road segment
    private Endpoint dest;

    // Distance to travel along this endpoint
    private double dist;

    /**
      Constructor.

      @param name name of road
      @param dest reference to destination endpoint
      @param dist Distance to destination endpoint
    **/
    public Road(String name, Endpoint dest, double dist) {
        this.name = name;
        this.dest = dest;
        this.dist = dist;
    }

    /**
      get the road name.
      @return name of road.
    **/
    public String getName() {
        return this.name;
    }

    /**
      get the destination endpoint.
      @return destination
    **/
    public Endpoint getDest() {
        return this.dest;
    }

    /**
      get the distance to next endpoint.
      @return distance
    **/
    public double getDist() {
        return this.dist;
    }
}
