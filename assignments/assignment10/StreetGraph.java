import java.io.IOException;
import java.util.HashMap;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

public class StreetGraph {
    // Store the endpoints of the graph
    private HashMap<String, Endpoint> endpoints;

    // check to see if an endpoint exists
    public Boolean hasEndpoint(String name) {
      // DO ME
    }

    // get the endpoint object by name
    public Endpoint getEndpoint(String name) throws IOException {
      // DO ME
    }

    // record the number of roads seen
    private int numroads;

    // helper to get the number of known endroads
    public int numRoads() {
        return this.numroads;
    }

    // helper to report the number of known endpoints
    public int numEndpoints() {
        return this.endpoints.size();
    }

    // constructor initializes the graph
    public StreetGraph() { 
        endpoints = new HashMap<>();
    }

    // get list of all endpoints in the graph
    public ArrayList<Endpoint> getAllEndpoints() {
       // DO ME
    }


    // add a road to the graph
    // make sure to add both the road from end1 to end2 as well as end2 to end1
    public void addRoad(String end1name, String end2name, double roaddist, String roadname) {
        numroads++;

       // DO ME
    }

    // load the graph of roads from a file
    public void loadFromFile(String filename) throws FileNotFoundException {
        System.out.println("Loading network from: " + filename);
        Scanner input = new Scanner(new FileInputStream(new File(filename)));
		while(input.hasNext()) {
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
