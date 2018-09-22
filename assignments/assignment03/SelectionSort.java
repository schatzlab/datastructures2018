/**
    The basic Selection Sort algorithm.

    @param <T> Element type.
*/
public final class SelectionSort<T extends Comparable<T>>
    implements SortingAlgorithm<T> {

    // Helper to make code more readable.
    private boolean less(T a, T b) {
        return a.compareTo(b) < 0;
    }

    @Override
    public void sort(Array<T> array) {
        // We try to put "correct" values into a[0], a[1], ... a[n-2];
        // once a "correct" value is in a[n-2], the very last value
        // has to be the largest one anyway; thus it's also "correct".
        for (int i = 0; i < array.length() - 1; i++) {
            // We're trying to put the "correct" element in a[i].
            // We need to find the smallest element in a[i..n-1].
            // We start by assuming a[i] is the smallest one.
            int min = i;
            // Now we try to find a smaller one in a[i+1..n-1].
            for (int j = i + 1; j < array.length(); j++) {
                if (this.less(array.get(j), array.get(min))) {
                    min = j;
                }
            }
            // Now we have the "true" minimum at a[min], and we
            // swap it with a[i], unless i == min of course.
            if (min != i) {
                T t = array.get(i);
                array.put(i, array.get(min));
                array.put(min, t);
            }
        }
    }

    @Override
    public String name() {
        return "Selection Sort";
    }
}
