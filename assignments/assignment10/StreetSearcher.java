import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class StreetSearcher {
    // graph to search
	StreetGraph graph;

    // useful for marking distance to nodes
    private static double INFINITY = 1e18;

    // helper class to manage the priority queue with endpoints and distances
    static class State implements Comparable<State> {
       // DO ME
    }

    // find the path from start to end!
    public void findPath(String startname, String endname) throws IOException {
      // DO ME
    }

    // parse the arguments and call the find method
    public static void main(String[] args) throws IOException {
        if (args.length != 3) {
            System.err.println("USAGE: StreetSearcher mapname.txt startname endname");
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
