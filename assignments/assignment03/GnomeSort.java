/**
    One messed-up sorting algorithm...

    See https://en.wikipedia.org/wiki/Gnome_sort for more.

    @param <T> Element type.
*/
public final class GnomeSort<T extends Comparable<T>>
    implements SortingAlgorithm<T> {

    // Helper to make code more readable.
    private boolean less(T a, T b) {
        return a.compareTo(b) < 0;
    }

    // Helper to make code more readable.
    private void swap(Array<T> a, int i, int j) {
        T t = a.get(i);
        a.put(i, a.get(j));
        a.put(j, t);
    }

    @Override
    public void sort(Array<T> a) {
        int i = 0;
        while (i < a.length()) {
            if (i == 0 || !this.less(a.get(i), a.get(i - 1))) {
                i++;
            } else {
                this.swap(a, i, i - 1);
                i--;
            }
        }
    }

    @Override
    public String name() {
        return "Gnome Sort";
    }
}
