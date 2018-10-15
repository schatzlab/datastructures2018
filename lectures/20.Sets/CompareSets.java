import com.github.phf.jb.Bench;
import com.github.phf.jb.Bee;

import java.util.Random;


public final class CompareSets {
    private static final Random r = new Random();
    private static final int SPREAD = 100000;
    private static final int SIZE   = 1000;

    @Bench
    public void randomArraySet(Bee b) {
      for (int i = 0; i < b.reps(); i++)
      {
        ArraySet<Integer> set = new ArraySet<Integer>();
        for (int j = 0; j < SIZE; j++)
        {
          set.insert(r.nextInt(SPREAD));
        }
        b.bytes(SIZE * 4);
      }
    }

    @Bench
    public void randomListSet(Bee b) {
      for (int i = 0; i < b.reps(); i++)
      {
        ListSet<Integer> set = new ListSet<Integer>();
        for (int j = 0; j < SIZE; j++)
        {
          set.insert(r.nextInt(SPREAD));
        }
        b.bytes(SIZE * 4);
      }
    }
}

