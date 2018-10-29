public class BitTwiddleA {
  public static void main(String[] args) {
    int x = (int) Integer.parseInt(args[0]);
    int y = x >> 31;
    int z = (x + y) ^ y;
    System.out.println("x: " +  x + " z: " + z);
  }
}
