/**
 * Hash functions from int to int.
 *
 * These are really "secondary" hash functions. We assume that you obtain
 * a (good!) initial hash using, for example, the hashCode() method. That
 * int is then further transformed by this hash function.
 */
public interface HashFunction {
    /**
     * Compute the hash.
     * @param i Integer to hash.
     * @return Hashed integer.
     */
    int hash(int i);
}
