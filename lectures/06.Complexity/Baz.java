import java.text.NumberFormat;

public class Baz {

  public static int baz(int n) {
    if (n <= 0) {
      return 0;
    }

    int sum = 0;
    for (int i = 0; i < n; i++) {
      sum = sum + i;
    }

    return sum + baz(n/2) + baz(n/2-1);
  }

  public static void main(String[] args) {
    if (args.length == 0) {
      System.out.println("USAGE: baz <array size>");
      return;
    }

    int arraysize = Integer.parseInt(args[0]);
    System.out.println("Scanning the array of size: " + NumberFormat.getInstance().format(arraysize));

    long startTime = System.nanoTime(); 
    int val = baz(arraysize);
    long endTime = System.nanoTime();
    long duration = endTime - startTime;

    System.out.println("The value is: " + val);
    System.out.println("Search took: " + NumberFormat.getInstance().format(duration) + " nanoseconds");
  }
}
