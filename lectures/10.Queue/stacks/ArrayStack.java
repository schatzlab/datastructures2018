/**
    Stack implemented using a growing array.

    All operations except push() take O(1) time in the worst
    case; push() takes O(1) amortized time because the array
    may need to be resized; however, compared to ListStack,
    fewer push() operations result in objects being allocated.

    @param <T> Element type.
*/
public class ArrayStack<T> implements Stack<T> {
    private T[] data;
    private int used;

    /**
        Create an empty stack.
    */
    public ArrayStack() {
        this.data = (T[]) new Object[1];
    }

    @Override
    public T top() throws EmptyException {
        if (this.empty()) {
            throw new EmptyException();
        }
        return this.data[this.used - 1];
    }

    @Override
    public void pop() throws EmptyException {
        if (this.empty()) {
            throw new EmptyException();
        }
        this.used -= 1;
    }

    private boolean full() {
        return this.data.length == this.used;
    }

    private void grow() {
        T[] bigger = (T[]) new Object[this.data.length * 2];
        for (int i = 0; i < this.used; i++) {
            bigger[i] = this.data[i];
        }
        this.data = bigger;
    }

    @Override
    public void push(T t) {
        if (this.full()) {
            this.grow();
        }
        this.data[this.used] = t;
        this.used += 1;
    }

    @Override
    public boolean empty() {
        return this.used == 0;
    }

    @Override
    public String toString() {
        String s = "[";
        for (int i = this.used - 1; i >= 0; i--) {
            s += this.data[i].toString();
            if (i > 0) {
                s += ", ";
            }
        }
        s += "]";
        return s;
    }
}
