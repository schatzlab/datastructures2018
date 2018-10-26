/**
 *  Exception for empty data structure.
 *
 *  Data structures that can be empty throw EmptyException
 *  if asked to produce a value when they have none.
 */
public class EmptyException extends RuntimeException {
    private static final long serialVersionUID = 0L;
}
