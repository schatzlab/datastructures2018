/**
 * Exception for invalid positions.
 *
 * Data structures that accept positions throw PositionException
 * for a variety of reasons: when a position is null, when it
 * refers to a different data structure entirely (passing a Graph
 * position to a List), when it refers to a different, unrelated
 * instance (passing a position from List A into List B), etc.
 */
public class PositionException extends RuntimeException {
    private static final long serialVersionUID = 0L;
}
