/** The essence of any counter. */
public interface Counter {
  /** Current value of this counter. */
  int value();
  /** Increment this counter. */
  void up();
  /** Decrement this counter. */
  void down();
}
