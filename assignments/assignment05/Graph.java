/**
 * Directed graphs.
 *
 * A general interface for directed graphs. If you need an undirected
 * graph, simply insert two directed edges (presumably with the same
 * data), one in each direction.
 *
 * We assume that vertices and edges each carry *one* uniform type of
 * data. If you need, say, a bipartite graph, you can use inheritance
 * to model vertices/edges of two or more different kinds.
 *
 * Instead of our customary Position interface we use Vertex and Edge
 * interfaces as positions. We can therefore overload method names to
 * keep down interface complexity and (more importantly) we get some
 * degree of static type safety: clients who confuse vertex and edge
 * positions will notice at compile-time (unless they try really hard
 * not to anyway).
 *
 * Important: A number of methods return Iterable to allow clients to
 * explore certain aspects of a graph. The problem with this is that
 * Java mandates a remove() method on Iterator and if we're not careful
 * that remove() could "ruin" your internal data structures. If you're
 * using an Iterable for which the Iterator supports remove(), you will
 * need to return a *copy* to be on the safe side. If you're using an
 * Iterable for which the Iterator doesn't support remove(), it should
 * be fine to return the actual implementation without making a copy.
 * Use your judgement! Under no circumstances should a client be able
 * to use remove() on an iterator to "mess up" your data structure.
 *
 * @param <V> Vertex element type.
 * @param <E> Edge element type.
 */
public interface Graph<V, E> {
    /**
     * Insert new vertex.
     * @param v Element to insert.
     * @return Vertex position created to hold element.
     */
    Vertex<V> insert(V v);

    /**
     * Insert new edge.
     * @param from Vertex position where edge starts.
     * @param to Vertex position where edge ends.
     * @param e Element to insert.
     * @return Edge position created to hold element.
     * @throws PositionException If either vertex position is invalid.
     * @throws InsertionException If insertion would create a self-loop or
     *     duplicate edge.
     */
    Edge<E> insert(Vertex<V> from, Vertex<V> to, E e)
        throws PositionException, InsertionException;

    /**
     * Remove a vertex.
     * @param v Vertex position to remove.
     * @return Element from removed vertex position.
     * @throws PositionException If vertex position is invalid.
     * @throws RemovalException If vertex still has incident edges.
     */
    V remove(Vertex<V> v) throws PositionException, RemovalException;

    /**
     * Remove an edge.
     * @param e Edge position to remove.
     * @return Element from removed edge position.
     * @throws PositionException If edge position is invalid.
     */
    E remove(Edge<E> e) throws PositionException;

    /**
     * Vertices of graph.
     * @return Iterable over all vertices of the graph (in no specific order).
     */
    Iterable<Vertex<V>> vertices();

    /**
     * Edges of graph.
     * @return Iterable over all edges of the graph (in no specific order).
     */
    Iterable<Edge<E>> edges();

    /**
     * Outgoing edges of vertex.
     * @param v Vertex position to explore.
     * @return Iterable over all outgoing edges of the given vertex
     *     (in no specific order).
     * @throws PositionException If vertex position is invalid.
     */
    Iterable<Edge<E>> outgoing(Vertex<V> v) throws PositionException;

    /**
     * Incoming edges of vertex.
     * @param v Vertex position to explore.
     * @return Iterable over all incoming edges of the given vertex
     *     (in no specific order).
     * @throws PositionException If vertex position is invalid.
     */
    Iterable<Edge<E>> incoming(Vertex<V> v) throws PositionException;

    /**
     * Start vertex of edge.
     * @param e Edge position to explore.
     * @return Vertex position edge starts from.
     * @throws PositionException If edge position is invalid.
     */
    Vertex<V> from(Edge<E> e) throws PositionException;

    /**
     * End vertex of edge.
     * @param e Edge position to explore.
     * @return Vertex position edge leads to.
     * @throws PositionException If edge position is invalid.
     */
    Vertex<V> to(Edge<E> e) throws PositionException;

    /**
     * Label vertex with object.
     * @param v Vertex position to label.
     * @param l Label object.
     * @throws PositionException If vertex position is invalid.
     */
    void label(Vertex<V> v, Object l) throws PositionException;

    /**
     * Label edge with object.
     * @param e Edge position to label.
     * @param l Label object.
     * @throws PositionException If edge position is invalid.
     */
    void label(Edge<E> e, Object l) throws PositionException;

    /**
     * Vertex label.
     * @param v Vertex position to query.
     * @return Label object (or null if none).
     * @throws PositionException If vertex position is invalid.
     */
    Object label(Vertex<V> v) throws PositionException;

    /**
     * Edge label.
     * @param e Edge position to query.
     * @return Label object (or null if none).
     * @throws PositionException If edge position is invalid.
     */
    Object label(Edge<E> e) throws PositionException;

    /**
     * Clear all labels.
     * All labels are null after this.
     */
    void clearLabels();
}
