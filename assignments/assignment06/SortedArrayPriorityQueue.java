import java.util.ArrayList;
import java.util.Comparator;

/**
 * Priority queue implemented as a sorted ArrayList.
 *
 * We use binary search to find the insertion point in O(log n) time, but
 * we need to spend O(n) time to "make room" for the insertion. We don't
 * treat the array as cyclic, so remove() also takes O(n) time...
 *
 * We use slot 0 of the ArrayList as a "sentinel" of sorts for internal
 * find() calls.
 *
 * @param <T> Element type.
 */
public class SortedArrayPriorityQueue<T extends Comparable<? super T>>
    implements PriorityQueue<T> {

    // The default comparator uses the "natural" ordering.
    private static class DefaultComparator<T extends Comparable<? super T>>
        implements Comparator<T> {
        public int compare(T t1, T t2) {
            return t1.compareTo(t2);
        }
    }

    private ArrayList<T> data;
    private Comparator<T> cmp;

    /**
     * A sorted array using the "natural" ordering of T.
     */
    public SortedArrayPriorityQueue() {
        this(new DefaultComparator<>());
    }

    /**
     * A sorted array using the given comparator for T.
     * @param cmp Comparator to use.
     */
    public SortedArrayPriorityQueue(Comparator<T> cmp) {
        this.data = new ArrayList<T>();
        this.data.add(null);
        this.cmp = cmp;
    }

    // Value in slot i "less" than value in slot j? Note that the
    // comparator determines what we consider "less" here.
    private boolean less(int i, int j) {
        return this.cmp.compare(this.data.get(i), this.data.get(j)) < 0;
    }

    // Find position in data[] where t should live.
    private int find(T t) {
        this.data.set(0, t); // set sentinel
        int l = 1;
        int u = this.data.size() - 1;
        while (l <= u) {
            int m = (l + u) / 2;
            if (this.less(0, m)) {
                u = m - 1;
            } else if (this.less(m, 0)) {
                l = m + 1;
            } else {
                return m;
            }
        }
        return l;
    }

    @Override
    public void insert(T t) {
        int p = this.find(t);
        this.data.add(p, t);
    }

    @Override
    public void remove() throws EmptyException {
        if (this.empty()) {
            throw new EmptyException();
        }
        T t = this.data.remove(1);
    }

    @Override
    public T top() throws EmptyException {
        if (this.empty()) {
            throw new EmptyException();
        }
        return this.data.get(1);
    }

    @Override
    public boolean empty() {
        return this.data.size() == 1;
    }
}
