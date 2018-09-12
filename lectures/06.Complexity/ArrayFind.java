import java.text.NumberFormat;

public class ArrayFind {
  // Maximum range for integer values
  final static int MAXINT = 100000000;

  // linear scan to find the max
  public static int findMaximum(int [] myarray) {
    int max = myarray[0];
    for (int i = 1; i < myarray.length; i++) {
      if (myarray[i] > max) {
        max = myarray[i];
      }
    }

    return max;
  }

  // simple program to create an array of length N filled with random numbers, reports max
  public static void main(String[] args) {
    if (args.length == 0) {
      System.out.println("USAGE: ArrayFind <array size>");
      return;
    }

    int arraysize = Integer.parseInt(args[0]);

    System.out.println("Scanning the array of size: " + NumberFormat.getInstance().format(arraysize));

    int [] myarray = new int[arraysize];

    // initialize with random valuas
    for (int i = 0; i < myarray.length; i++) {
      int random = (int)(Math.random() * MAXINT);
      myarray[i] = random;
    }

    long startTime = System.nanoTime(); 
    int max = findMaximum(myarray);
    long endTime = System.nanoTime();
    long duration = endTime - startTime;

    System.out.println("The max is: " + max);
    System.out.println("Search took: " + NumberFormat.getInstance().format(duration) + " nanoseconds");
  }
}
