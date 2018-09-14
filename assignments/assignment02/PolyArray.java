import java.util.ArrayList; // see note in main() below

/**
    Simple polymorphic test framework for arrays.

    See last week's PolyCount. You need to add more test cases (meaning more
    methods like testNewLength and testNewWrongLength below) to make sure all
    preconditions and axioms are indeed as expected from the specification.
*/
public final class PolyArray {
    private static final int LENGTH = 113;
    private static final int INITIAL = 7;

    private PolyArray() {}

    // methods for testing axioms go here

    private static void testNewLength(Array<Integer> a) {
        assert a.length() == LENGTH;
    }

    private static void testNewGet(Array<Integer> a) {
        for (int i = 0; i < LENGTH; i++) {
            assert a.get(i) == INITIAL;
        }
    }

    // TODO more test cases for axioms

    // methods for testing preconditions go here

    private static void testNewWrongLength() {
        try {
            Array<Integer> a = new SimpleArray<>(0, INITIAL);
            assert false;
        } catch (LengthException e) {
            // passed the test, nothing to do
        }
        // TODO the same for ListArray and SparseArray here
    }

    // TODO more test cases for preconditions

    /**
        Run (mostly polymorphic) tests on various array implementations.

        Make sure you run this with -enableassertions! We'll learn a much
        better approach to unit testing later.

        @param args Command line arguments (ignored).
    */
    public static void main(String[] args) {
        // For various technical reasons, we cannot use a plain Java array here
        // like we did in PolyCount. Sorry.
        ArrayList<Array<Integer>> arrays = new ArrayList<>();
        arrays.add(new SimpleArray<Integer>(LENGTH, INITIAL));
        // TODO add ListArray and SparseArray instances here

        // Test all the axioms. We can do that nicely in a loop. In the test
        // methods, keep in mind that you are handed the same object over and
        // over again!
        for (Array<Integer> a: arrays) {
            testNewLength(a);
            testNewGet(a);
            // TODO call more test cases (hint: order matters)
        }

        // Test all the preconditions. Sadly we have to code each one of these
        // out manually, not even Java's reflection API would help...
        testNewWrongLength();
        // TODO call more test cases
    }
}
