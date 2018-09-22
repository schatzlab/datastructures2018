/**
    A statable object can provide statistics about itself.

    We count operations that read from or write to the object in question. A
    read operation doesn't modify the object itself, a write operation does.
    For example, if we make an Array statable, get() and length() would be
    read operations whereas put() would be a write operation.

    (In C++ terms we are concerned with "logical const-ness" for reads, not
    with "physical const-ness"; but for this assignment, the distinction is
    mostly academic. In any case, the counters maintained for statistics do
    *not* influence whether an operation is read or write. Think Heisenberg.)

    Note that "Statable" should be read "stat-able" as in "able to produce
    statistics" and not "state-able" as in "able to be clearly stated".
*/
public interface Statable {
    /**
        Reset the statistics collected so far. After this is called, all
        counts are 0 again.
    */
    void resetStatistics();

    /**
        Read operations so far.
        @return Number of read operations so far, always &ge; 0.
    */
    int numberOfReads();

    /**
        Write operations so far.
        @return Number of write operations so far, always &ge; 0.
    */
    int numberOfWrites();
}
