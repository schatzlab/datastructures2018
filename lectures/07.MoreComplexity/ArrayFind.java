import java.text.NumberFormat;

/**
  Demonstrates time to scan an array of different sizes.
**/
public final class ArrayFind {
    // Maximum range for integer values
    static final int MAXINT = 100000000;

    private ArrayFind() { }

    /**
      * do a linear scan to find the max element.
      * @param myarray array of integers to scan
      * @return max element in myarray
     **/
    public static int findMaximum(int[] myarray) {
        int max = myarray[0];
        for (int i = 1; i < myarray.length; i++) {
            if (myarray[i] > max) {
                max = myarray[i];
            }
        }

        return max;
    }

    /**
      * Parse command line to report max value.
      * @param args args[0] is the length of array
     **/
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("USAGE: ArrayFind <array size>");
            return;
        }

        int arraysize = Integer.parseInt(args[0]);

        System.out.println("Scanning the array of size: "
                           + NumberFormat.getInstance().format(arraysize));

        int[] myarray = new int[arraysize];

        // initialize with random valuas
        for (int i = 0; i < myarray.length; i++) {
            int random = (int) (Math.random() * MAXINT);
            myarray[i] = random;
        }

        long startTime = System.nanoTime();
        int max = findMaximum(myarray);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        System.out.println("The max is: " + max);
        System.out.println("Search took: "
                           + NumberFormat.getInstance().format(duration)
                           + " nanoseconds");
    }
}
