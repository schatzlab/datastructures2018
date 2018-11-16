import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
  Computes a Run Length Encoding of a string.
**/
public final class RLEEncoder {

    /** Make checkstyle happy. */
    private RLEEncoder() { }

    /** Run Length Encode the String.

        @param input The input String
        @return The run length encoded version of the input string
        @throws IOException On invalid input
    */
    public static String runLengthEncode(String input) throws IOException {
        StringBuilder out = new StringBuilder();

        // Your code here :)

        return out.toString();
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

        try {
            System.out.println(runLengthEncode(text));
        } catch (IOException e) {
            System.err.println("Invalid Input");
            System.exit(1);
        }
    }
}
