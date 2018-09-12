import java.text.NumberFormat;

public class FastBuz {

  public static int fastbuz(int n) {
    int [] s = new int[n+1];
    s[0] = 1; s[1] = 1;

    for (int i = 2; i <= n; i++) {
      s[i] = s[i-1] + s[i-2];
    }

    return s[n];
  }

  public static void main(String[] args) {
    if (args.length == 0) {
      System.out.println("USAGE: ArrayFind <array size>");
      return;
    }

    int arraysize = Integer.parseInt(args[0]);
    System.out.println("Scanning the array of size: " + NumberFormat.getInstance().format(arraysize));

    long startTime = System.nanoTime(); 
    int val = fastbuz(arraysize);
    long endTime = System.nanoTime();
    long duration = endTime - startTime;

    System.out.println("The value is: " + val);
    System.out.println("Search took: " + NumberFormat.getInstance().format(duration) + " nanoseconds");
  }
}
