public class BitTwiddleC {
  public static void main(String[] args) {
    int x = Integer.parseInt(args[0]);
    System.out.println("x: " +  x);
    int c = 0;
    while (x != 0) {
       c++;
       x = x & (x - 1);
    }
    System.out.println("x: " +  x + " c: " + c);
  }
}
