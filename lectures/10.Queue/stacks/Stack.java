/**
    The classic last-in-first-out (LIFO) data structure.

    We model unbounded stacks here, stacks that (in theory) never get full.
    As a result, the constructor of any implementation has no arguments:

        Stack()

    If we wanted to accomodate bounded stacks as well, a more complicated
    interface design would be required. The intuition for a stack of, say,
    three elements is best summarized by the following figure:

    <pre>
                push   pop
                 |      ^
                 v      |
                +--------+
        top --- | 3      |
                +--------+
                | 2      |
                +--------+
                | 1      |
                +--------+
    </pre>

    The formal specification for stacks has the details, but in brief: top()
    does not modify the stack, it simply returns the top-most value; push()
    extends the stack with a new "box" for the pushed value at the top-end;
    pop() removes the top-most "box" exposing whatever is "underneath".

    Unlike arrays, stacks have only one "position" where anything happens: the
    top. Hence iterators make no sense either.

    @param <T> Element type.
*/
public interface Stack<T> {
    /**
        Test if stack is empty.

        @return True if the stack is empty, false otherwise.
    */
    boolean empty();

    /**
        Access top element of stack.

        @return Top element of the stack.
        @throws EmptyException for empty stack.
    */
    T top() throws EmptyException;

    /**
        Remove element at top of stack.

        @throws EmptyException for empty stack.
    */
    void pop() throws EmptyException;

    /**
        Insert new element at top of stack.

        @param t Element to push.
    */
    void push(T t);
}
