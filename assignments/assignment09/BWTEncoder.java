import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;


/**
  Builds the BWT of a string.

  Builds the BWT by sorting all of the cyclic permutations.
**/
public class BWTEncoder {

    // You may want to use this ;-)
    private final class CyclicPermutation
        implements Comparable<CyclicPermutation> {
    }

    String text;

    /** Silence checkstyle. */
    public BWTEncoder() { }

    /** Construct the BWT of a string.

        Derives the list of possible permutations, sorts them, and then
        extracts the last colunm

        @param input The input String
        @return The BWT of the input string
        @throws IOException On invalid input
    */
    public String createBWT(String input) throws IOException {
        this.text = input + "$";

        StringBuilder bwt = new StringBuilder();

        // Your code here :)

        return bwt.toString();
    }

    /** Reads the input from standard in.
        @return Returns a string with the input data without newlines
        @throws IOException if the file cannot be read
    */
    public static String readInput() throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input);
        StringBuilder sb = new StringBuilder();

        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        reader.close();
        input.close();

        return sb.toString();
    }

    /** Main method, load file into string, compute BWT.
        @param args Input arguments, ingorned
    */
    public static void main(String[] args) {
        String text = "";

        try {
            text = readInput();
        } catch (IOException e) {
            System.err.println("Cant read input");
            System.exit(1);
        }

        BWTEncoder bwt = new BWTEncoder();
        try {
            System.out.println(bwt.createBWT(text));
        } catch (IOException e) {
            System.err.println("Invalid Input");
            System.exit(1);
        }
    }
}
