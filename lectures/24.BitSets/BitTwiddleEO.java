public class BitTwiddleEO {
  public static void main(String[] args) {
    int x = (int) Integer.parseInt(args[0]);
    int r = (x & 1);
    Boolean b = (r == 1);
    System.out.println("x: " +  x + " r: " + r + " b: " + b);
  }
}
