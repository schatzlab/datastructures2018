
// package com.cs226.hw1.count;

/**
 * Simple polymorphic test framework for counters.
 * Really just an example for subtype polymorphism: Note how most of the code
 * is written in terms of interfaces, not classes! The only time classes are
 * mentioned is when we have to create actual objects...
 */
public final class PolyCount {

    // Appeasing checkstyle.
    private PolyCount() {}

    private static void testAnyCounter(Counter c) {
        // Note how this test case tries to capture the axioms of the Counter
        // ADT we discussed in lecture. (It needs a "fresh" counter though to
        // check the first axiom.) We need to "capture" previous values in an
        // awkward way because in Java we modify the counter object; in math
        // land (the ADT) we just keep creating more and more, but that would
        // hardly be efficient in computer land.
        int v1 = c.value();
        assert v1 >= 0;
        c.up();
        int v2 = c.value();
        assert v2 > v1;
        c.up();
        int v3 = c.value();
        assert v3 > v2;
        c.down();
        int v4 = c.value();
        assert v4 <= v3;
        c.down();
        int v5 = c.value();
        assert v5 <= v4;
        // This last assertion is not strictly speaking implied by the ADT.
        assert v5 == v1;
    }

    /**
        Run polymorphic test on various counters.

        Make sure you run this with -enableassertions! We'll learn a much
        better approach to unit testing later.

        @param args Command line arguments (ignored).
    */
    public static void main(String[] args) {
        // When you start out, you won't have all the counters yet; work on
        // BasicCounter first (comment out the other two); once that works,
        // put SquareCounter back in, finally FlexibleCounter. Easy. (Please
        // don't modify PolyCount in any other way, you're risking that it'll
        // fail with our version used for grading.)
        Counter[] counters = {
            new BasicCounter(),
            new TenCounter(),
            new FlexibleCounter(5, 7),
            new EvenCounter(),
        };

        for (Counter c: counters) {
            testAnyCounter(c);
        }
    }
}
