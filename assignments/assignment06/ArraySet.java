import java.util.Iterator;

/**
 * Set implemented using plain Java arrays.
 * @param <T> Element type.
 */
public class ArraySet<T> implements Set<T> {
    private int used;
    private T[] data;

    private class SetIterator implements Iterator<T> {
        private int current;

        @Override
        public boolean hasNext() {
            return this.current < ArraySet.this.used;
        }

        @Override
        public T next() {
            T t = ArraySet.this.data[this.current];
            this.current += 1;
            return t;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /**
     * Make a set.
     */
    public ArraySet() {
        this.data = (T[]) new Object[1];
    }

    private boolean full() {
        return this.used >= this.data.length;
    }

    private void grow() {
        T[] bigger = (T[]) new Object[2 * this.used];
        for (int i = 0; i < this.used; i++) {
            bigger[i] = this.data[i];
        }
        this.data = bigger;
    }

    private int find(T t) {
        for (int i = 0; i < this.used; i++) {
            if (this.data[i].equals(t)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void insert(T t) {
        if (this.has(t)) {
            return;
        }
        if (this.full()) {
            this.grow();
        }
        this.data[this.used] = t;
        this.used += 1;
    }

    @Override
    public void remove(T t) {
        int p = this.find(t);
        if (p == -1) {
            return;
        }
        for (int i = p; i < this.used - 1; i++) {
            this.data[i] = this.data[i + 1];
        }
        this.used -= 1;
    }

    @Override
    public boolean has(T t) {
        return this.find(t) != -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new SetIterator();
    }
}
