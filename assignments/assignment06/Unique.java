import java.util.Scanner;

/**
 * Filter unique integers from standard input to standard output.
 *
 * If you're benchmarking this program, you may want to suppress
 * the output by redirecting it to /dev/null.
 */
public final class Unique {
    private static Set<Integer> data;

    // Make checkstyle happy.
    private Unique() {}

    /**
     *  Main method.
     *  @param args Command line arguments (ignored).
     */
    public static void main(String[] args) {
        data = new ArraySet<Integer>();
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextInt()) {
            int i = scanner.nextInt();
            data.insert(i);
        }

        for (Integer i: data) {
            System.out.println(i);
        }
    }
}
