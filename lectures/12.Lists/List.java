import java.util.Iterator;

/**
 * Generic unbounded list abstraction.
 *
 * We have used linked lists in the past, for example inside of ListArray
 * and ListStack, but there they were just an implementation detail hiding
 * behind another interface. Now we're modelling the "idea" of a list instead!
 *
 * Sure, when you read through the interface the "obvious" implementation
 * will be a linked list (a doubly-linked list at that) but just like we
 * implemented an Array in terms of lists before, we can implement List in
 * terms of arrays if there is a good reason to.
 *
 * It's exactly because we want to keep our implementation options open that
 * we introduce the Position interface. Yes, if it's really a linked list,
 * then Position will be exactly the same as a node object. However, nobody
 * using a List implementation can use that fact to do anything that would
 * not also work with a List implemented in terms of an array.
 *
 * Note that despite the fact that most methods can throw PositionException,
 * there is no valid() method to check whether a given position is valid for
 * a given list. This contradicts the "ADT rule" that we should be able to
 * confirm, ahead of time, whether a partial function might fail. However,
 * if we had provided valid() each user of List would have to sprinkle it
 * *all* *over* their code. And for what? Most of the time a programmer will
 * know which positions they obtained from which lists. So we broke the "ADT
 * rule" quite consciously: Any implementation of List is still expected to
 * check positions it receives and to throw an exception if something is
 * amiss, but at least the poor programmers using our List interface can
 * save themselves some (almost always useless anyway) keystrokes...
 *
 * @param <T> Element type.
 */
public interface List<T> extends Iterable<T> {
    /**
     * Number of elements in list.
     * @return Number of elements.
     */
    int length();

    /**
     * List empty?
     * @return True if empty, false otherwise.
     */
    boolean empty();

    /**
     * Insert at front of list.
     * @param t Element to insert.
     * @return Position created to hold element.
     */
    Position<T> insertFront(T t);

    /**
     * Insert at back of list.
     * @param t Element to insert.
     * @return Position created to hold element.
     */
    Position<T> insertBack(T t);

    /**
     * Insert before a position.
     *
     * @param p Position to insert before.
     * @param t Element to insert.
     * @return Position created to hold element.
     * @throws PositionException If p is invalid for this list.
     */
    Position<T> insertBefore(Position<T> p, T t) throws PositionException;

    /**
     * Insert after a position.
     * @param p Position to insert after.
     * @param t Element to insert.
     * @return Position created to hold element.
     * @throws PositionException If p is invalid for this list.
     */
    Position<T> insertAfter(Position<T> p, T t) throws PositionException;

    /**
     * Remove a position.
     * @param p Position to remove.
     * @throws PositionException If p is invalid for this list.
     */
    void remove(Position<T> p) throws PositionException;

    /**
     * Remove from front of list.
     * @throws EmptyException If list is empty.
     */
    void removeFront() throws EmptyException;

    /**
     * Remove from back of list.
     * @throws EmptyException If list is empty.
     */
    void removeBack() throws EmptyException;

    /**
     * First position.
     * @return First position.
     * @throws EmptyException If list is empty.
     */
    Position<T> front() throws EmptyException;

    /**
     * Last position.
     * @return Last position.
     * @throws EmptyException If list is empty.
     */
    Position<T> back() throws EmptyException;

    /**
     * Is this the first position?
     * @param p Position to examine.
     * @throws PositionException If p is invalid for this list.
     * @return True if p is the first position, false otherwise.
     */
    boolean first(Position<T> p) throws PositionException;

    /**
     * Is this the last position?
     * @param p Position to examine.
     * @throws PositionException If p is invalid for this list.
     * @return True if p is the last position, false otherwise.
     */
    boolean last(Position<T> p) throws PositionException;

    /**
     * Next position.
     * @param p Position to examine.
     * @throws PositionException If p is invalid or the last position.
     * @return Position after p.
     */
    Position<T> next(Position<T> p) throws PositionException;

    /**
     * Previous position.
     * @param p Position to examine.
     * @throws PositionException If p is invalid or the first position.
     * @return Position before p.
     */
    Position<T> previous(Position<T> p) throws PositionException;

    /**
     * Returns an iterator going forward over list elements of type T.
     * The standard iterator() method creates one of these.
     * @return Iterator going from front to back.
     */
    Iterator<T> forward();

    /**
     * Returns an iterator going backward over list elements of type T.
     * @return Iterator going from back to front.
     */
    Iterator<T> backward();
}
