import com.github.phf.jb.Bench;
import com.github.phf.jb.Bee;

import java.util.Random;

/**
 * Compare performance of ArraySet and ListSet.
 */
public final class BasicSetsBench {
    private static final int SIZE = 100;
    private static final Random RAND = new Random();

    // First some basic "compound operations" to benchmark. Note that each
    // of these is carefully dimensioned (regarding the range of elements)
    // to allow combining them.

    // Insert a number of "consecutive" strings into the given set.
    private static void insertLinear(Set<String> s) {
        for (int i = 0; i < SIZE; i++) {
            s.insert(Integer.toString(i));
        }
    }

    // Insert a number of "random" strings into the given set.
    private static void insertRandom(Set<String> s) {
        for (int i = 0; i < SIZE; i++) {
            s.insert(Integer.toString(RAND.nextInt(SIZE * 4)));
        }
    }

    // Remove a number of "random" strings from the given set.
    private static void removeRandom(Set<String> s) {
        for (int i = 0; i < SIZE; i++) {
            s.remove(Integer.toString(RAND.nextInt(SIZE * 2)));
        }
    }

    // Lookup a number of "consecutive" strings in the given set.
    private static void lookupLinear(Set<String> s) {
        for (int i = 0; i < SIZE; i++) {
            boolean x = s.has(Integer.toString(i));
        }
    }

    // Lookup a number of "random" strings in the given set.
    private static void lookupRandom(Set<String> s) {
        for (int i = 0; i < SIZE; i++) {
            boolean x = s.has(Integer.toString(RAND.nextInt(SIZE)));
        }
    }

    // Now the benchmarks we actually want to run.

    @Bench
    public void insertLinearArraySet(Bee b) {
        for (int n = 0; n < b.reps(); n++) {
            b.stop();
            Set<String> s = new ArraySet<>();
            b.start();
            insertLinear(s);
        }
    }

    @Bench
    public void insertLinearListSet(Bee b) {
        for (int n = 0; n < b.reps(); n++) {
            b.stop();
            Set<String> s = new ListSet<>();
            b.start();
            insertLinear(s);
        }
    }

    @Bench
    public void insertRandomArraySet(Bee b) {
        for (int n = 0; n < b.reps(); n++) {
            b.stop();
            Set<String> s = new ArraySet<>();
            b.start();
            insertRandom(s);
        }
    }

    @Bench
    public void insertRandomListSet(Bee b) {
        for (int n = 0; n < b.reps(); n++) {
            b.stop();
            Set<String> s = new ListSet<>();
            b.start();
            insertRandom(s);
        }
    }

    @Bench
    public void removeRandomArraySet(Bee b) {
        for (int n = 0; n < b.reps(); n++) {
            b.stop();
            Set<String> s = new ArraySet<>();
            insertRandom(s);
            b.start();
            removeRandom(s);
        }
    }

    @Bench
    public void removeRandomListSet(Bee b) {
        for (int n = 0; n < b.reps(); n++) {
            b.stop();
            Set<String> s = new ListSet<>();
            insertRandom(s);
            b.start();
            removeRandom(s);
        }
    }

    @Bench
    public void lookupLinearArraySet(Bee b) {
        for (int n = 0; n < b.reps(); n++) {
            b.stop();
            Set<String> s = new ArraySet<>();
            insertLinear(s);
            b.start();
            lookupLinear(s);
        }
    }

    @Bench
    public void lookupLinearListSet(Bee b) {
        for (int n = 0; n < b.reps(); n++) {
            b.stop();
            Set<String> s = new ListSet<>();
            insertLinear(s);
            b.start();
            lookupLinear(s);
        }
    }

    @Bench
    public void lookupRandomArraySet(Bee b) {
        for (int n = 0; n < b.reps(); n++) {
            b.stop();
            Set<String> s = new ArraySet<>();
            insertLinear(s);
            b.start();
            lookupRandom(s);
        }
    }

    @Bench
    public void lookupRandomListSet(Bee b) {
        for (int n = 0; n < b.reps(); n++) {
            b.stop();
            Set<String> s = new ListSet<>();
            insertLinear(s);
            b.start();
            lookupRandom(s);
        }
    }
}
