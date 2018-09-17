public class Permute {
  public static long numtries;

  public static void swap(int [] keys, int x, int y) {
    int temp = keys[x];
    keys[x] = keys[y];
    keys[y] = temp;
  }

  public static void permute(int [] keys, int l, int r) {
     int i;
     if (l == r) {
        if ((numtries < 100) || (numtries % 100000 == 0)) {
          System.out.print("try[" + numtries + "]:");
          for (int x = 0; x < keys.length; x++) { System.out.print(" " + keys[x]); }
          System.out.println();
        }
        numtries++;
     } else {
        for (i = l; i <= r; i++) {
          swap(keys,l, i);
          permute(keys, l+1, r);
          swap(keys, l, i); 
        }
    }
  }

  public static void main(String [] args) {
    if (args.length == 0) {
      System.out.println("Permute num");
      return;
    }

    int len = Integer.parseInt(args[0]);
    int [] keys = new int[len];
    for (int i = 0; i < len; i++) { keys[i] = i+1; }
    permute(keys, 0, len-1);
    System.err.println("There are " + numtries + " permutations of " + len + " items.");
  }
}
