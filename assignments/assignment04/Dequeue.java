/**
 * Generic unbounded double-ended queue abstraction.
 *
 * Starting with this interface, we're becoming a little less conservative.
 * The length() operation, for example, is not strictly necessary; however
 * it can be useful in certain applications. Similarly, instead of sticking
 * to "queue-style terminology" we go with more neutral yet symmetric names
 * such as insertBack() instead of "enqueue" and removeFront() instead of
 * "dequeue".
 *
 * Note that any implementation of Dequeue could in principle be used as a
 * Stack or Queue as well; it's just the changed operation names and Java's
 * rigid notion of interface subtyping that keeps us from doing so. We could,
 * however, write explicit adapter classes...
 *
 * @param <T> Element type.
 */
public interface Dequeue<T> {
    /**
     *  No elements?
     *  @return True if no elements, false otherwise.
     */
    boolean empty();

    /**
     *  How many elements?
     *  @return Number of elements in the queue.
     */
    int length();

    /**
     *  Front element?
     *  @throws EmptyException If queue is empty.
     *  @return First element in the queue.
     */
    T front() throws EmptyException;

    /**
     *  Back element?
     *  @throws EmptyException If queue is empty.
     *  @return Last element in the queue.
     */
    T back() throws EmptyException;

    /**
     *  Insert a new front element.
     *  @param t Element to insert.
     */
    void insertFront(T t);

    /**
     *  Insert a new back element.
     *  @param t Element to insert.
     */
    void insertBack(T t);

    /**
     *  Remove front element.
     *  @throws EmptyException If queue is empty.
     */
    void removeFront() throws EmptyException;

    /**
     *  Remove back element.
     *  @throws EmptyException If queue is empty.
     */
    void removeBack() throws EmptyException;
}
