/**
 * Sets of arbitrary values.
 * @param <T> Element type.
 */
public interface Set<T> extends Iterable<T> {
    /**
     * Insert a value.
     * Set doesn't change if we insert a value we already have.
     * @param t Value to insert.
     */
    void insert(T t);

    /**
     * Remove a value.
     * Set doesn't change if we remove a value we don't have.
     * @param t Value to remove.
     */
    void remove(T t);

    /**
     *  Test membership of a value.
     *  @param t Value to test.
     *  @return True if t is in the set, false otherwise.
     */
    boolean has(T t);
}
