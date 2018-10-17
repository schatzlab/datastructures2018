/**
 * Exception for bad removals.
 *
 * Some data structures don't like certain removals. For example, the Tree
 * interface doesn't allow remove() on a position with children, the Graph
 * interface doesn't allow remove() on a vertex with incident edges, etc.
 */
public class RemovalException extends RuntimeException {
    private static final long serialVersionUID = 0L;
}
