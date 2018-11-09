import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.regex.Pattern;

/**
 * A simple spell-checker.
 *
 * Load dictionary file given as command line argument, check text from
 * standard input, print misspelled words to standard output. Dictionary
 * files should have one lower-case word per line, nothing else. The
 * definiton of "word" in the input text is rather arbitrary and won't
 * make the linguists among you very happy.
 */
public final class Spell {
    private static Map<String, Integer> dictionary;
    private static Pattern pattern = Pattern.compile("[\\s[^a-zA-Z]]+");

    // Make checkstyle happy.
    private Spell() {}

    // Load dictionary file with given name.
    private static void load(String name) throws IOException {
        FileReader file = new FileReader(name);
        BufferedReader reader = new BufferedReader(file);

        dictionary = new SimpleMap<String, Integer>();

        String line;
        while ((line = reader.readLine()) != null) {
            String word = line.trim();
            dictionary.insert(word, 1); // we really want a set...
        }

        reader.close();
        file.close();
    }

    // Check standard input against dictionary, print misspelled
    // words to standard output.
    private static void check() throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input);

        String line;
        while ((line = reader.readLine()) != null) {
            String[] words = pattern.split(line, 0);
            for (String word: words) {
                if (word.length() == 0) {
                    continue;
                }
                if (!dictionary.has(word.toLowerCase())) {
                    System.out.println(word);
                }
            }
        }

        reader.close();
        input.close();
    }

    /**
     * Main method.
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.printf("Error: Need path to dictionary file!\n");
            System.exit(1);
        }
        if (args.length > 1) {
            System.err.printf("Warning: Extra command line arguments!\n");
        }

        try {
            load(args[0]);
        } catch (IOException e) {
            System.err.printf("Error: Cannot load dictionary %s!\n", args[0]);
            System.exit(1);
        }

        try {
            check();
        } catch (IOException e) {
            System.err.printf("Error: Cannot process input!\n");
            System.exit(1);
        }
    }
}
