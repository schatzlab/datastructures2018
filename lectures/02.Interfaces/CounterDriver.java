public class CounterDriver {
    public static void main(String[] args)
    {
        Counter c = null;
        if ((args.length > 0) && (args[0].equals("Weird"))) {
          c = new WeirdCounter();
        }
        else { 
          c = new MyCounter();
        }

        System.out.println("Counter is " + c.value());

        c.up();

        System.out.println("Counter is " + c.value());

        c.down();

        System.out.println("Counter is " + c.value());
    }
}


