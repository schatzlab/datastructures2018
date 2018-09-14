import java.text.NumberFormat;

public class Bar {
  final static int MAXINT = 100000000;

  public static int bar(int n) {
    int sum = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < i; j++) {
        for (int k = 0; k < j; k++) {
          sum = sum + i + k + k;
        }
      }
    }

    return sum;
  }

  public static void main(String[] args) {
    if (args.length == 0) {
      System.out.println("USAGE: bar <array size>");
      return;
    }

    int arraysize = Integer.parseInt(args[0]);

    System.out.println("Scanning the array of size: " + NumberFormat.getInstance().format(arraysize));

    long startTime = System.nanoTime(); 
    int val = bar(arraysize);
    long endTime = System.nanoTime();
    long duration = endTime - startTime;

    System.out.println("The value is: " + val);
    System.out.println("Search took: " + NumberFormat.getInstance().format(duration) + " nanoseconds");
  }
}
