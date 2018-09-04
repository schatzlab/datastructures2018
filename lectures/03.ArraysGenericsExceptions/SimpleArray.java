/**
    Array implementation on top of basic Java array.

    The obvious implementation of the Array interface, absolutely positively
    nothing fancy going on here.

    There are two reasons for this class to exist: First it's an example for
    the style of code we're about to write a lot of. Second it's useful
    because Java's generics don't really play well with Java's basic arrays;
    we'll use SimpleArray in lots of places where Java's arrays would give us
    generic grief.

    @param <T> Element type.
*/
public class SimpleArray<T> implements Array<T> {
    // The obvious representation of our abstract Array.
    private T[] data;

    /**
        Constructs a new SimpleArray.

        @param n Length of array, must be n &gt; 0.
        @param t Default value to store in each slot.
        @throws LengthException if n &le; 0.
    */
    public SimpleArray(int n, T t) throws LengthException {
        if (n <= 0) {
            throw new LengthException();
        }

        // This cast works around Java's problems with generic arrays.
        // The resulting warning is acceptable because there simply is
        // no better way of doing this.
        this.data = (T[]) new Object[n];

        // Array slots are null by default.
        if (t == null) {
            return;
        }

        for (int i = 0; i < n; i++) {
            this.data[i] = t;
        }
    }

    // If we let ArrayIndexOutOfBoundsException propagate, we leak an
    // implementation detail we should probably hide. (Also that name
    // is so horrible, it deserves to live in a dark cave in Mordor.)

    @Override
    public T get(int i) throws IndexException {
        try {
            return this.data[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IndexException();
        }
    }

    @Override
    public void put(int i, T t) throws IndexException {
        try {
            this.data[i] = t;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IndexException();
        }
    }

    @Override
    public int length() {
        return this.data.length;
    }

    public static void main(String [] args) throws 
      IndexException, LengthException {
        Array<String> a = new SimpleArray<String>(4, "226"); 
        assert a.length() == 4;
        for (int i =0; i <a.length(); i++){
            assert a.get(i).equals("226");
        }
        a.put(2, "Peter");
        assert a.length() == 4;
        assert a.get(2).equals ("Peter"); 
        assert a.get(0).equals ("226");
        assert a.get(1).equals ("226");
        assert a.get(3).equals ("226");

        System.out.println("Passed the value assertions");

        try {
          a.put(a.length(), "Paul");
          System.out.println("Didnt get the exception");
        }
        catch (IndexException e)
        {
          System.out.println("Caught IndexException (as expected)");
        }

        try {
          Array<String> b = new SimpleArray<String>(0, "Mike");
          System.out.println("No exception after creating second array");
        }
        catch (LengthException e)
        {
          System.out.println("Caught LengthException (as expected)");
        }
    }
}
