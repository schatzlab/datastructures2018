public class BitTwiddleM {
  public static void main(String[] args) {
    int x = (int) Integer.parseInt(args[0]);
    int y = (int) Integer.parseInt(args[1]);
    int m = y ^ ((x ^ y) & -(x < y));
    System.out.println("x: ", x, " y: ", y, " m:", m);
  }
}
