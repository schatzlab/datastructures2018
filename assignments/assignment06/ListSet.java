import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 * Set implemented using plain Java list.
 *
 * Since the implementation of this is pretty boring, we decided to add an
 * example for a "fail-fast" iterator, just to spice things up. If you want
 * to understand these beasts in detail, you need to read up on (and think
 * through) the issues yourself.
 *
 * To make an iterator "fail-fast" we need to be able to tell that the data
 * structure has been modified since the iteration started. We use a version
 * number in the ListSet class to achieve this. The number starts at 0 and
 * is incremented whenever a Set operation modifies the internal list. Each
 * iterator also "remembers" the version number it was created for. We can
 * then check for modifications by comparing version numbers in the Iterator
 * operations: If we notice a mismatch, we raise an exception.
 *
 * (If you read up on this, you know that we should not *test* for the
 * ConcurrentModificationException being thrown. If you don't understand
 * this, you need to read/think some more.)
 *
 * @param <T> Element type.
 */
public class ListSet<T> implements Set<T> {
    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;
    }

    private Node<T> head;
    private int version;

    private class SetIterator implements Iterator<T> {
        private Node<T> current;
        private int version;

        SetIterator() {
            this.current = ListSet.this.head;
            this.version = ListSet.this.version;
        }

        private void checkVersion() throws ConcurrentModificationException {
            if (this.version != ListSet.this.version) {
                throw new ConcurrentModificationException();
            }
        }

        @Override
        public boolean hasNext() {
            this.checkVersion();
            return this.current != null;
        }

        @Override
        public T next() {
            this.checkVersion();
            T t = this.current.data;
            this.current = this.current.next;
            return t;
        }

        @Override
        public void remove() {
            this.checkVersion();
            throw new UnsupportedOperationException();
        }
    }

    private Node<T> find(T t) {
        for (Node<T> n = this.head; n != null; n = n.next) {
            if (n.data.equals(t)) {
                return n;
            }
        }
        return null;
    }

    @Override
    public void insert(T t) {
        if (this.has(t)) {
            return;
        }
        Node<T> n = new Node<T>();
        n.data = t;
        n.next = this.head;
        n.prev = null;
        if (this.head != null) {
            this.head.prev = n;
        }
        this.head = n;
        this.version++;
    }

    @Override
    public void remove(T t) {
        Node<T> position = this.find(t);
        if (position == null) {
            return;
        }
        if (position.next != null) {
            position.next.prev = position.prev;
        }
        if (position.prev != null) {
            position.prev.next = position.next;
        } else {
            this.head = position.next;
        }
        this.version++;
    }

    @Override
    public boolean has(T t) {
        return this.find(t) != null;
    }

    @Override
    public Iterator<T> iterator() {
        return new SetIterator();
    }
}
