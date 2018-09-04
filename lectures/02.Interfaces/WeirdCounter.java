/** My counter implementation. */
public class WeirdCounter implements Counter {
    private int myvalue;

    @Override
    public int value() {
        return this.myvalue;
    }

    @Override
    public void up() {
        this.myvalue += 42;
    }

    @Override
    public void down() {
        this.myvalue -= 1;
    }

    /** Main method.
    * @param args The arguments
    */
    public static void main(String[] args) {
        System.out.println("In main");
        Counter c = new WeirdCounter();

        assert c.value() == 0;
        System.out.println("Counter is: " + c.value());

        c.up();
        assert c.value() == 1;
        System.out.println("Counter is: " + c.value());

        c.down();
        assert c.value() == 0;
        assert c.value() == 1;
        System.out.println("Counter is: " + c.value());
    }
}
