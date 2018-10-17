/**
 * Exception for bad insertions.
 *
 * Some data structures don't like certain insertions. For example, the Tree
 * interface doesn't allow insertRoot() if there's already a root, the Graph
 * interface doesn't allow insertEdge() if the edge would create a self-loop,
 * etc.
 */
public class InsertionException extends RuntimeException {
    private static final long serialVersionUID = 0L;
}
