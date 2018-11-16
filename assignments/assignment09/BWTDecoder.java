import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

/** Class to decode a BWT back to the original string. */
public final class BWTDecoder {

    /** Make checkstyle happy. */
    private BWTDecoder() { }

    /** Decode the BWT of a string.
        @param bwt the input bwt string
        @return The original string (before BWT)
        @throws IOException On invalid input
    */
    public static String decodeBWT(String bwt) throws IOException {
        StringBuilder text = new StringBuilder();

        // Your code here :)

        return text.reverse().toString();
    }

    /** Reads the input data into a string.
        @return A string with the input data wiht newlines removed
        @throws IOException On error reading input
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

    /** Reads a BWT string from standard in and returns the original string.
        @param args ignored
    */
    public static void main(String[] args) {
        String bwt = "";

        try {
            bwt = readInput();
        } catch (IOException e) {
            System.err.println("Cant read input");
            System.exit(1);
        }

        try {
            System.out.println(BWTDecoder.decodeBWT(bwt));
        } catch (IOException e) {
            System.err.println("Invalid input");
            System.exit(1);
        }
    }
}
