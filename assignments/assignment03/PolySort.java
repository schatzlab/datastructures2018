import java.util.ArrayList;
import java.util.Scanner;

/**
    A simple framework for evaluating sorting algorithms.

    The program reads at most the given number of lines from standard input.
    (Input is treated as strings, not integers as in Unique.) It then runs a
    variety of sorting algorithms on the data, collects statistics about each
    algorithm, and prints those statistics to standard output.

    Hints: You should run each of your experiments at least three times and
    ignore outliers to compensate for variations in load. Ideally you run them
    on your own machine (not a shared lab machine or server) and with as few
    other programs active as possible. That said, only the wallclock time will
    be affected by these concerns, and that's a bad critereon to begin with...
*/

public final class PolySort {
    // Default capacity if none on the command line.
    private static final int DEFAULT_CAPACITY = 1000;

    // How many nanoseconds in a second.
    private static final double NANOS = 1e9;

    // We read the strings to be sorted into the following array; only entries
    // 0 to size-1 are actually used.
    private static int capacity = DEFAULT_CAPACITY;
    private static int size;
    private static Array<String> buffer;

    // The list of sorting algorithms we wish to compare. See setup() below
    // for how this list is initialized.
    private static ArrayList<SortingAlgorithm<String>> algorithms =
        new ArrayList<>();

    // Make checkstyle happy.
    private PolySort() {}

    // Print an error message to standard error.
    private static void errorln(String message) {
        System.err.println("error: " + message);
    }

    // Parse arguments.
    private static void arguments(String[] args) {
        if (args.length <= 0) {
            return; // nothing to do, default capacity
        }

        try {
            int value = Integer.parseInt(args[0]);
            if (value <= 0) {
                errorln("Capacity \"" + args[0] + "\" must be > 0.");
            } else {
                capacity = value;
            }
        } catch (NumberFormatException e) {
            errorln("\"" + args[0] + "\" is not an integer (too large?).");
        }
    }

    // Set up buffer and algorithms.
    private static void setup() {
        // Create a buffer of appropriate size.
        buffer = new SimpleArray<String>(capacity, null);
        // Add the algorithms we want to compare. This is where you should add
        // your algorithms once you have implemented them.
        algorithms.add(new NullSort<String>());
        algorithms.add(new GnomeSort<String>());
        algorithms.add(new SelectionSort<String>());
    }

    // Read input into buffer array.
    private static void input() {
        Scanner in = new Scanner(System.in);
        while (size < capacity && in.hasNextLine()) {
            String str = in.nextLine();
            buffer.put(size, str);
            size += 1;
        }
    }

    // Check whether the given array is sorted in ascending order.
    private static boolean sorted(Array<String> a) {
        for (int i = 0; i < a.length() - 1; i++) {
            if (a.get(i).compareTo(a.get(i + 1)) > 0) {
                return false;
            }
        }
        return true;
    }

    // Run the benchmark for all sorting algorithms.
    private static void benchmark() {
        if (size <= 0) {
            errorln("No input?");
            return;
        }

        System.out.printf(
            "%-20s %-8s %-12s %-12s %-12s %-12s\n\n",
            "Algorithm", "Sorted?", "Size", "Reads", "Writes", "Seconds"
        );

        StatableArray<String> temp = new StatableArray<String>(size, null);

        for (SortingAlgorithm<String> algo: algorithms) {
            // copy value into statable array and reset it
            for (int j = 0; j < size; j++) {
                temp.put(j, buffer.get(j));
            }
            temp.resetStatistics();

            // run the next sorting algorithm
            long before = System.nanoTime();
            algo.sort(temp);
            long after = System.nanoTime();

            double seconds = (after - before) / NANOS;
            int reads = temp.numberOfReads();
            int writes = temp.numberOfWrites();
            boolean success = sorted(temp); // last since it changes statistics

            // print the statistics for this algorithm
            System.out.printf(
                "%-20s %-8b %,-12d %,-12d %,-12d %,-12f\n",
                algo.name(), success, size, reads, writes, seconds
            );
        }
    }

    /**
        Compare sorting algorithms.

        $ java PolySort [capacity] [&lt; file]

        @param args Command line arguments.
    */
    public static void main(String[] args) {
        arguments(args);
        setup();
        input();
        benchmark();
    }
}
