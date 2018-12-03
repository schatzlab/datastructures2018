import java.io.IOException;
import java.util.HashMap;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

/**
  Represents a street network with Roads and Endpoints.
**/
public class StreetGraph {
    // Store the endpoints of the graph
    private HashMap<String, Endpoint> endpoints;

    // record the number of roads seen
    private int numroads;

    /** constructor initializes the graph. */
    public StreetGraph() {
        endpoints = new HashMap<>();
    }

    /**
      Check to see if an endpoint exists.
      @param name Name of Endpoint (gps coordinates)
      @return True if endpoint are known
    **/
    public Boolean hasEndpoint(String name) {
       // DO ME
    }

    /**
      Get the endpoint object by name.

      @param name Name of Endpoint (GPS coordinates)
      @return reference to associated Endpoint
      @throws IOException if the Endpoint is not known
    **/
    public Endpoint getEndpoint(String name) throws IOException {
       // DO ME
    }


    /**
      helper to get the number of known endroads.
      @return Number of Road in Graph
    **/
    public int numRoads() {
        return this.numroads;
    }

    /**
      helper to report the number of known endpoints.
      @return Number of known Endpoints
    **/
    public int numEndpoints() {
        return this.endpoints.size();
    }


    /**
      get ArrayList of all endpoints in the graph.
      @return ArrayList of all of the Endpoints
    **/
    public ArrayList<Endpoint> getAllEndpoints() {
       // DO ME
    }

    /**
      add a road to the graph.
      @param end1name Name of first endpoint
      @param end2name Name of second endpoint
      @param roaddist Distance of Road
      @param roadname Name of Road
    **/
    public void addRoad(String end1name, String end2name,
                        double roaddist, String roadname) {
        numroads++;

        // DO ME
    }

    /**
      load the graph of roads from a file.
      @param filename filename of the graph
      @throws FileNotFoundException if file cant be loaded
    **/
    public void loadFromFile(String filename) throws FileNotFoundException {
        System.out.println("Loading network from: " + filename);
        Scanner input = new Scanner(new FileInputStream(new File(filename)));
        while (input.hasNext()) {
            String[] tokens = input.nextLine().split(" ");
            String end1name = tokens[0];
            String end2name = tokens[1];
            double roaddist = Double.parseDouble(tokens[2]);
            String roadname = tokens[3];

            addRoad(end1name, end2name, roaddist, roadname);
        }
        System.out.println("Loaded " + numRoads() + " roads");
        System.out.println("Loaded " + numEndpoints() + " endpoints");
    }
}
