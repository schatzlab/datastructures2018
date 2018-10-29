public class PrintBits {
  public static void main(String[] args) {
    Integer i = Integer.parseInt(args[0]);
    System.out.println("Integer: " + i + " Bits: " + Integer.toBinaryString(i));
  }
}
