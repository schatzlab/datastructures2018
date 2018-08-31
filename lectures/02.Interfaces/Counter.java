/**
    The essence of any counter.

    A (somewhat useless) abstraction of an integer. Imagine, if you will, a
    little black box with an integer display (glowing in red of course) and two
    buttons labeled "up" and "down" and you have a pretty good idea.
*/
public interface Counter {
    /**
        Current value of this counter.

        @return Current value.
    */
    int value();

    /** Increment this counter. */
    void up();

    /** Decrement this counter. */
    void down();
}
