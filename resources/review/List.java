import java.util.Iterator;

public interface List<T> extends Iterable<T> {
    int length();
    boolean empty();

    void insertFront(T t);
    T front();

    // TODO - insertBefore();

}


















// Take 2
public interface List<T> extends Iterable<T> {
    int length();
    boolean empty();

    // Requires Node to be declared publicly!
    Node<T> insertFront(T t);
    Node<T> front();

    // Now we can insert before
    Node<T> insertBefore(Node<T> n, T t);
}




// Take 3
public interface Position<T> {

    T get();
    void put(T t);
}

public interface List<T> extends Iterable<T> {

    int length();

    boolean empty();

    Position<T> insertFront(T t);

    Position<T> insertBack(T t);

    Position<T> insertBefore(Position<T> p, T t) throws PositionException;

    Position<T> insertAfter(Position<T> p, T t) throws PositionException;

    void remove(Position<T> p) throws PositionException;

    void removeFront() throws EmptyException;

    void removeBack() throws EmptyException;

    Position<T> front() throws EmptyException;

    Position<T> back() throws EmptyException;

    boolean first(Position<T> p) throws PositionException;

    boolean last(Position<T> p) throws PositionException;

    Position<T> next(Position<T> p) throws PositionException;

    Position<T> previous(Position<T> p) throws PositionException;

    Iterator<T> forward();

    Iterator<T> backward();
}
