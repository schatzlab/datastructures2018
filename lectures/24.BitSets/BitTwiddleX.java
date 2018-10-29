public class BitTwiddleX {
  public static void main(String[] args) {
    int x = (int) Integer.parseInt(args[0]);
    int y = (int) Integer.parseInt(args[1]);
    System.out.println("x: " +  x + " y: " + y);
    x = x ^ y;
    y = x ^ y;
    x = x ^ y;
    System.out.println("x: " +  x + " y: " + y);
  }
}
