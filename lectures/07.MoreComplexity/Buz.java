import java.text.NumberFormat;

public class Buz {

  public static int buz(int n) {
    if (n <= 1) {
      return 1;
    }

    return buz(n-1) + buz(n-2);
  }

  public static void main(String[] args) {
    if (args.length == 0) {
      System.out.println("USAGE: buz <array size>");
      return;
    }

    int arraysize = Integer.parseInt(args[0]);
    System.out.println("Scanning the array of size: " + NumberFormat.getInstance().format(arraysize));

    long startTime = System.nanoTime(); 
    int val = buz(arraysize);
    long endTime = System.nanoTime();
    long duration = endTime - startTime;

    System.out.println("The value is: " + val);
    System.out.println("Search took: " + NumberFormat.getInstance().format(duration) + " nanoseconds");
  }
}
