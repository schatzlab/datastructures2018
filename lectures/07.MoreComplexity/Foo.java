import java.text.NumberFormat;

public class Foo {

    public static int foo(int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + i;
        }

        return sum;
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("USAGE: foo <array size>");
            return;
        }

        int arraysize = Integer.parseInt(args[0]);
        System.out.println("Scanning the array of size: "
                           + NumberFormat.getInstance().format(arraysize));

        long startTime = System.nanoTime();
        int val = foo(arraysize);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        System.out.println("The value is: " + val);
        System.out.println("Search took: "
                           + NumberFormat.getInstance().format(duration)
                           + " nanoseconds");
    }
}
