/**
    Sets of integers.

    The constructor should probably set lower and upper bounds if
    you want to provide O(1) implementations without wasting tons
    of memory.
*/
public interface IntegerSet extends Iterable<Integer> {
    /**
        Insert a value. Set doesn't change if we insert
        a value we already have.

        @param i Value to insert.
    */
    void insert(int i);

    /**
        Remove a value. Set doesn't change if we remove
        a value we don't have.

        @param i Value to remove.
    */
    void remove(int i);

    /**
        Test membership of a value.

        @param i Value to test.
        @return True if i is in the set, false otherwise.
    */
    boolean has(int i);
}
