public class ShowMod {
  public static void main(String[] args){
    System.out.println("i\ti%2\ti%5\ti%10\ti%16");
    for (int i = 0; i < 20; i++) {
      System.out.println(i + "\t" + i % 2 + "\t" + i % 5 + "\t" + i % 10 + "\t" + i % 16);
    }
  }
}
