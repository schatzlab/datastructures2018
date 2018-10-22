import java.util.Scanner;

public final class UniqueOrderedArrayListSet {
	private static OrderedSet<Integer> data;
	private UniqueOrderedArrayListSet() { }
	public static void main(String[] args) {
		data = new OrderedArrayListSet<Integer>();
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
