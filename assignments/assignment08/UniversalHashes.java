import java.util.Random;
import java.math.BigInteger;

/**
 * Generate (or approximate in any case) universal hash functions.
 */
public final class UniversalHashes {
    private static final Random RAND = new Random();

    // Make checkstyle happy.
    private UniversalHashes() {}

    /**
     * The classic Carter/Wegman construction. Works for any m &gt; 0
     * but uses expensive modulo operations internally.
     *
     * @param m Size of the hash table.
     * @return Random hash function that yields 0..m-1.
     */
    public static HashFunction prime(int m) {
        BigInteger bigM = BigInteger.valueOf(m);
        BigInteger bigP = bigM.nextProbablePrime(); // so that's a maybe
        int p = bigP.intValue();
        int b = RAND.nextInt(p);
        int a = RAND.nextInt(p);
        while (a == 0) {
            a = RAND.nextInt(p);
        }
        return prime(a, b, p, m);
    }

    // Separate method because of anonymous class restrictions.
    private static HashFunction prime(int a, int b, int p, int m) {
        return new HashFunction() {
            public int hash(int i) {
                int u = i & ~(1 << 31); // clear high bit
                return ((((a * u) % p) + b) % p) % m;
            }

            public String toString() {
                return "((" + a + " * x + " + b + ") % " + p + ") % " + m;
            }
        };
    }

    /**
     * The newer Dietzfelbinger construction. Works only for m = 2^M
     * but should be a lot faster to compute. (But note that 0 hashes
     * to 0 which is sad.)
     *
     * @param m Size of the hash table, m = 2^M, 1 &lt; M &lt; 32.
     * @return Random hash function that yields 0..m-1.
     */
    public static HashFunction power(int m) {
        int bit = Integer.highestOneBit(m);
        if ((m & bit) != m || m <= 0) {
            throw new IllegalArgumentException("m not a positive power of 2!");
        }
        int bigM = Integer.numberOfTrailingZeros(bit);
        int w = 32;
        int b = RAND.nextInt(1 << (w - bigM));
        int a = RAND.nextInt();
        while (a <= 0 || (a & 1) == 0) {
            a = RAND.nextInt();
        }
        return power(a, b, w, bigM);
    }

    // Separate method because of anonymous class restrictions.
    private static HashFunction power(int a, int b, int w, int bigM) {
        return new HashFunction() {
            public int hash(int i) {
                return (a * i + b) >>> (w - bigM); // ever clear high?
            }

            public String toString() {
                return "(" + a + " * x + " + b + ") >>> " + (w - bigM);
            }
        };
    }

    // Hash a few integers through given hash function.
    private static void hashSome(HashFunction h) {
        for (int i = 42; i < 47; i++) {
            System.out.printf("\t[%d => %d]", i, h.hash(i));
        }
        System.out.println();
    }

    /**
     * Main method demonstrates how to make and use hash functions.
     *
     * @param args Command line arguments (ignored).
     */
    public static void main(String[] args) {
        for (int i = 4; i < 13; i += 2) {
            int size = 1 << i;

            HashFunction pr = prime(size);
            System.out.printf("prime: %s\n", pr);
            hashSome(pr);

            HashFunction po = power(size);
            System.out.printf("power: %s\n", po);
            hashSome(po);

            System.out.println();
        }
    }
}
