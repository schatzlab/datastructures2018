import java.util.Iterator;

/**
 * A generic position-based linked list.
 *
 * Here we use the "standard" representation of a doubly-linked list with
 * head (front, first) and tail (back, last) pointers. The empty list and
 * the ends of the list are marked with null pointers. As such there are
 * a *lot* of special cases to take care of in the code.
 *
 * Actually, the code below is a *lot* more convoluted than it needs to be.
 * Do *not* make the mistake of copying it and then trying to "fix it" in
 * just a few places for your homework assignment. You need to *rethink*
 * how all of this should work from the ground up. Using private helper
 * methods, you can simplify everything *significantly* and we expect you
 * to do so!
 *
 * @param <T> Type for elements.
 */
public class NodeList<T> implements List<T> {

    private static final class Node<T> implements Position<T> {
        // The usual doubly-linked list stuff.
        Node<T> next;
        Node<T> prev;
        T data;

        // List that created this node, used to validate positions.
        List<T> owner;

        @Override
        public T get() {
            return this.data;
        }

        @Override
        public void put(T t) {
            this.data = t;
        }
    }

    private final class ListIterator implements Iterator<T> {
        Node<T> current;
        boolean forward;

        ListIterator(boolean f) {
            this.forward = f;
            if (this.forward) {
                this.current = NodeList.this.head;
            } else {
                this.current = NodeList.this.tail;
            }
        }

        @Override
        public T next() {
            T t = this.current.get();
            if (this.forward) {
                this.current = this.current.next;
            } else {
                this.current = this.current.prev;
            }
            return t;
        }

        @Override
        public boolean hasNext() {
            return this.current != null;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int length;

    /**
     * Create an empty list.
     */
    public NodeList() {
        // nothing to do
    }

    // Convert a position back into a node. Guards against null positions,
    // positions from other data structures, and positions that belong to
    // other NodeList objects. That about covers it?
    private Node<T> convert(Position<T> p) throws PositionException {
        try {
            Node<T> n = (Node<T>) p;
            if (n.owner != this) {
                throw new PositionException();
            }
            return n;
        } catch (NullPointerException | ClassCastException e) {
            throw new PositionException();
        }
    }

    @Override
    public boolean empty() {
        return this.length == 0;
    }

    @Override
    public int length() {
        return this.length;
    }

    @Override
    public boolean first(Position<T> p) {
        return this.head == p;
    }

    @Override
    public boolean last(Position<T> p) {
        return this.tail == p;
    }

    @Override
    public Position<T> front() throws EmptyException {
        if (this.empty()) {
            throw new EmptyException();
        }
        return this.head;
    }

    @Override
    public Position<T> back() throws EmptyException {
        if (this.empty()) {
            throw new EmptyException();
        }
        return this.tail;
    }

    @Override
    public Position<T> insertFront(T t) {
        Node<T> n = new Node<T>();
        n.data = t;
        n.owner = this;
        n.next = this.head;
        if (this.head != null) {
            this.head.prev = n;
        }
        this.head = n;
        if (this.tail == null) {
            this.tail = n;
        }
        this.length += 1;
        return n;
    }

    @Override
    public Position<T> insertBack(T t) {
        Node<T> n = new Node<T>();
        n.data = t;
        n.owner = this;
        n.prev = this.tail;
        if (this.tail != null) {
            this.tail.next = n;
        }
        this.tail = n;
        if (this.head == null) {
            this.head = n;
        }
        this.length += 1;
        return n;
    }

    @Override
    public void removeFront() throws EmptyException {
        if (this.empty()) {
            throw new EmptyException();
        }
        Node<T> n = this.head;
        assert (n.prev == null);
        if (n.next != null) {
            n.next.prev = null;
        }
        this.head = n.next;
        if (this.tail == n) {
            this.tail = null;
        }
        this.length -= 1;
        n.owner = null; // invalidate position
    }

    @Override
    public void removeBack() throws EmptyException {
        if (this.empty()) {
            throw new EmptyException();
        }
        Node<T> n = this.tail;
        assert (n.next == null);
        if (n.prev != null) {
            n.prev.next = null;
        }
        this.tail = n.prev;
        if (this.head == n) {
            this.head = null;
        }
        this.length -= 1;
        n.owner = null; // invalidate position
    }

    @Override
    public Position<T> next(Position<T> p) throws PositionException {
        if (this.last(p)) {
            throw new PositionException();
        }
        return this.convert(p).next;
    }

    @Override
    public Position<T> previous(Position<T> p) throws PositionException {
        if (this.first(p)) {
            throw new PositionException();
        }
        return this.convert(p).prev;
    }

    @Override
    public Position<T> insertBefore(Position<T> p, T t)
    throws PositionException {
        Node<T> current = this.convert(p);
        Node<T> n = new Node<T>();
        n.data = t;
        n.owner = this;
        n.prev = current.prev;
        n.next = current;
        if (current.prev != null) {
            current.prev.next = n;
        } else {
            this.head = n;
        }
        current.prev = n;
        this.length += 1;
        return n;
    }

    @Override
    public Position<T> insertAfter(Position<T> p, T t)
    throws PositionException {
        Node<T> current = this.convert(p);
        Node<T> n = new Node<T>();
        n.data = t;
        n.owner = this;
        n.prev = current;
        n.next = current.next;
        if (current.next != null) {
            current.next.prev = n;
        } else {
            this.tail = n;
        }
        current.next = n;
        this.length += 1;
        return n;
    }

    @Override
    public void remove(Position<T> p) throws PositionException {
        Node<T> n = this.convert(p);
        if (n.prev != null) {
            n.prev.next = n.next;
        } else {
            this.head = n.next;
        }
        if (n.next != null) {
            n.next.prev = n.prev;
        } else {
            this.tail = n.prev;
        }
        this.length -= 1;
    }

    @Override
    public Iterator<T> forward() {
        return new ListIterator(true);
    }

    @Override
    public Iterator<T> backward() {
        return new ListIterator(false);
    }

    @Override
    public Iterator<T> iterator() {
        return this.forward();
    }

    @Override
    public String toString() {
        String s = "[";
        for (Node<T> p = this.head; p != null; p = p.next) {
            s += p.data;
            if (p.next != null) {
                s += ", ";
            }
        }
        s += "]";
        return s;
    }
}
