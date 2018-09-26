/**
 * Generic position abstraction.
 *
 * An abstract position that serves the same role as integers did for array
 * positions. All position-oriented data structures (lists, trees, graphs)
 * can utilize this interface because it makes absolutely no assumptions as
 * to how several positions interrelate. Value-oriented data structures, on
 * the other hand, should never use positions in their interfaces.
 *
 * Note that, strictly speaking, we could also define this interface without
 * any methods in it. However, it's convenient to be able to access the data
 * we care about directly, without going through another abstraction.
 *
 * @param <T> Element type.
 */
public interface Position<T> {
    /**
     * Read element.
     * @return Element at this position.
     */
    T get();

    /**
     * Write element.
     * @param t Element to store at this position.
     */
    void put(T t);
}
