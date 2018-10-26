/**
 * Queue of ordered values.
 *
 * Note that the interface does not include methods to obtain the minimum
 * or maximum explicitly, but of course we want to be able to create PQs
 * of either sort.
 *
 * Your implementations *must* provide two constructors, one that uses
 * the "natural" ordering of java.util.Comparable, and another that
 * accepts an explicit java.util.Comparator argument.
 *
 * It's a *very* good idea to take the time and *read* the documentation
 * for those interfaces *before* you start hacking!
 *
 * @param <T> Element type.
 */
public interface PriorityQueue<T extends Comparable<? super T>> {
    /**
     * Insert a value.
     *
     * A queue is not a set, so duplicate values <b>are</b> possible:
     * Inserting X three times means it has to be removed three times
     * before it's gone again.
     *
     * @param t Value to insert.
     */
    void insert(T t);

    /**
     * Remove top value.
     *
     * The top value is the largest value in the queue as determined
     * by the queue's comparator.
     *
     * @throws EmptyException If queue is empty.
     */
    void remove() throws EmptyException;

    /**
     * Return top value.
     *
     * The top value is the largest value in the queue as determined
     * by the queue's comparator.
     *
     * @return Top value in the queue.
     * @throws EmptyException If queue is empty.
     */
    T top() throws EmptyException;

    /**
     * No elements?
     * @return True if queue is empty, false otherwise.
     */
    boolean empty();
}
