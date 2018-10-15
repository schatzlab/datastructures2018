import java.util.Scanner;

public final class Unique {
	private static Set<Integer> data;
	private Unique() { }
	public static void main(String[] args) {
		data = new ArraySet<Integer>();
		Scanner scanner = new Scanner(System.in);

        //long before = System.nanoTime();

		while (scanner.hasNextInt()) { 
			int i = scanner.nextInt();
			data.insert(i);
		}

		for (Integer i : data) {
			System.out.println(i);
		}

        //long duration = System.nanoTime() - before;
        //System.err.println(duration / 1e9);
	}
}
