import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;

/**
  Search for the shortest path between two endpoints in a StreetGraph.
**/
public class StreetSearcher {
    // useful for marking distance to nodes
    private static double maxDistance = 1e18;

    // graph to search
    StreetGraph graph;

    // helper class to manage the priority queue with endpoints and distances
    static class State implements Comparable<State> {
        // Do Me
    }

    /**
      find and print the path from start to end.
      @param startname Starting endpoint (GPS Coordinates)
      @param endname Ending endpoint (GPS Coordinates)
      @throws IOException if either endpoint is unknown
    **/
    public void findPath(String startname, String endname) throws IOException {
        // DO ME
    }

    /**
      main method: parse the arguments and call the find method.
      @param args Command line arguments
      @throws IOException if there are any errors
    **/
    public static void main(String[] args) throws IOException {
        if (args.length != 3) {
            System.err.println("USAGE: StreetSearcher mapname.txt start end");
            System.exit(0);
        }

        String filename  = args[0];
        String startname = args[1];
        String endname   = args[2];

        StreetSearcher searcher = new StreetSearcher();
        searcher.graph = new StreetGraph();
        searcher.graph.loadFromFile(filename);

        if (!searcher.graph.hasEndpoint(startname)) {
            throw new IOException("Invalid endpoint: " + startname);
        }

        if (!searcher.graph.hasEndpoint(endname)) {
            throw new IOException("Invalid endpoint: " + endname);
        }

        searcher.findPath(startname, endname);
    }
}
