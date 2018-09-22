/**
    The essence of a sorting algorithm.

    Note that in order to sort, some random type T would not be good enough.
    Things to be sorted need an *order*, and we need a way to compare things,
    not just for equality (there's an equals() method on all objects) but
    for less-than and greater-than as well.

    This is why we need a *bounded* type parameter: Not just *any* T will do,
    only those that are at least of type Comparable. That, in turn, ensures
    that we have a method compareTo() that we can use to establish order. See
    https://docs.oracle.com/javase/8/docs/api/java/lang/Comparable.html for
    more.

    @param <T> Element type.
*/
public interface SortingAlgorithm<T extends Comparable<T>> {
    /**
        Sort an array.

        @param array Array to sort.
    */
    void sort(Array<T> array);

    /**
        Name of algorithm.

        @return Name of algorithm.
    */
    String name();
}
