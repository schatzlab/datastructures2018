/**
    Stack implemented using a linked list.

    All operations take O(1) time in the worst case; however
    each push() results in a new object being allocated which
    may be inappropriate for some applications.

    @param <T> Element type.
*/
public class ListStack<T> implements Stack<T> {
    private static final class Node<T> {
        Node<T> next;
        T data;
    }

    private Node<T> first;

    /**
        Create an empty stack.
    */
    public ListStack() {
    }

    @Override
    public T top() throws EmptyException {
        try {
            return this.first.data;
        } catch (NullPointerException e) {
            throw new EmptyException();
        }
    }

    @Override
    public void pop() throws EmptyException {
        try {
            this.first = this.first.next;
        } catch (NullPointerException e) {
            throw new EmptyException();
        }
    }

    @Override
    public void push(T t) {
        Node<T> n = new Node<T>();
        n.data = t;
        n.next = this.first;
        this.first = n;
    }

    @Override
    public boolean empty() {
        return this.first == null;
    }

    @Override
    public String toString() {
        String s = "[";
        for (Node<T> n = this.first; n != null; n = n.next) {
            s += n.data.toString();
            if (n.next != null) {
                s += ", ";
            }
        }
        s += "]";
        return s;
    }
}
