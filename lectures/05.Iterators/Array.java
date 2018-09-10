/**
    Arrays with integer positions.

    The constructor should take a length &gt; 0 as well as a default value to
    "plaster" all over the new array. The constructor should throw
    LengthException if length &le; 0.

        Array(int length, T default) throws LengthException

    The intuition behind an Array "a" with length "n" and default value "t" is
    best summarized by the following figure:

    <pre>
             0   1   2   3  ... n-2 n-1
           +---+---+---+---+---+---+---+
        a: | t | t | t | t |...| t | t |
           +---+-|-+---+---+---+-^-+---+
           \_____|______ n ______|_____/
                 | get       put |
                 v               |
    </pre>

    Arrays have a fixed length that determines the valid index range. Arrays
    hold values of arbitrary type; get() reads the value at a given index,
    put() writes the value at a given index.

    @param <T> Element type.
*/
public interface Array<T> extends Iterable<T> {
    /**
        Change value at index.

        @param i Index to write value at.
        @param t Value to write at index.
        @throws IndexException if i &lt; 0 or i &gt; length-1.
    */
    void put(int i, T t) throws IndexException;

    /**
        Value at index.

        @param i Index to read value at.
        @return Value read at index.
        @throws IndexException if i &lt; 0 or i &gt; length-1.
    */
    T get(int i) throws IndexException;

    /**
        Length of array.

        @return Length of array, always &gt; 0.
    */
    int length();
}
