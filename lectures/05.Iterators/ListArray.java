import java.util.Iterator;

/**
    Array implementation using a linked list.

    The sole purpose of this (otherwise useless) implementation is to show
    that we can implement a given interface in many different ways. Also,
    to a lesser degree, it's a stepping stone for the SparseArray homework...

    @param <T> Element type.
*/
public class ListArray<T> implements Array<T> {
    // A nested Node<T> class to build our linked list out of. We use a
    // nested class (instead of an inner class) here since we don't need
    // access to the ListArray object we're part of.
    private static class Node<T> {
        T data;
        Node<T> next;
    }

    // The not-so-obvious representation of our abstract Array: A linked
    // list with "length" nodes instead of an array of "length" slots.
    // We also keep an explicit length so we don't have to re-compute it
    // every time.
    private Node<T> list;
    private int length;

    // An iterator to traverse the array from front to back.
    private class ArrayIterator implements Iterator<T> {
        // Current position in the linked list.
        Node<T> current;

        ArrayIterator() {
            this.current = ListArray.this.list;
        }

        @Override
        public T next() {
            T t = this.current.data;
            this.current = this.current.next;
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

    /**
        Constructs a new ListArray.

        @param n Length of array, must be n &gt; 0.
        @param t Default value to store in each slot.
        @throws LengthException if n &le; 0.
    */
    public ListArray(int n, T t) throws LengthException {
        if (n <= 0) {
            throw new LengthException();
        }

        // Initialize all positions as we promise in the specification.
        // Unlike in SimpleArray we cannot avoid the initialization even
        // if t == null since the nodes still have to be created. On the
        // upside we don't need a cast anywhere.
        for (int i = 0; i < n; i++) {
            this.prepend(t);
        }

        // Remember the length!
        this.length = n;
    }

    // Insert a node at the beginning of the linked list.
    private void prepend(T t) {
        Node<T> n = new Node<T>();
        n.data = t;
        n.next = this.list;
        this.list = n;
    }

    // Find the node for a given index. Assumes valid index.
    private Node<T> find(int index) {
        Node<T> n = this.list;
        int i = 0;
        while (n != null && i < index) {
            n = n.next;
            i = i + 1;
        }
        return n;
    }

    // Unlike in SimpleArray, we have to check the preconditions explicitly
    // in get() and put().

    @Override
    public T get(int i) throws IndexException {
        if (i < 0 || i >= this.length) {
            throw new IndexException();
        }

        Node<T> n = this.find(i);
        return n.data;
    }

    @Override
    public void put(int i, T t) throws IndexException {
        if (i < 0 || i >= this.length) {
            throw new IndexException();
        }

        Node<T> n = this.find(i);
        n.data = t;
    }

    @Override
    public int length() {
        return this.length;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator();
    }

    public static void main(String[] args) {
        ListArray<String> mylist = new ListArray(5, "Mike");

        System.out.println("Created array of length: " + mylist.length());
        for (int i = 0; i < mylist.length(); i++)
        {
            String val = mylist.get(i);
            System.out.println("mylist[" + i + "]: " + val);
        }

        mylist.put(3, "Peter");

        System.out.println("Printing Array after setting mylist[3]=Peter");

        for (int i = 0; i < mylist.length(); i++)
        {
            String val = mylist.get(i);
            System.out.println("mylist[" + i + "]: " + val);
        }

        System.out.println("Printing Array with Iterator");

        for (String val : mylist) 
        {
            System.out.println(val);
        }
    }

}
