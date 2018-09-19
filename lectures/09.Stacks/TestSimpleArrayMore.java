import org.junit.Test;
import org.junit.BeforeClass;
import static org.junit.Assert.assertEquals;

public class TestSimpleArrayMore {
    static Array<String> shortArray;

    @BeforeClass
    public static void setupArray() throws LengthException {
       shortArray = new SimpleArray<String>(10, "Bla");
    }

    @Test
    public void newArrayLengthGood() throws LengthException {
        assertEquals("Length inconsistent", 10, shortArray.length());
    }

    @Test
    public void newArrayInitialized() throws LengthException, IndexException {
        for (int i = 0; i < shortArray.length(); i++) {
            assertEquals("Bla", shortArray.get(i));
        }
    }

    @Test(expected=IndexException.class)
    public void IndexDetected() throws IndexException {
        shortArray.put(shortArray.length(), "Paul");
    }

    @Test(expected=LengthException.class)
    public void newArrayLengthBad() {
        Array<String> badArray = new SimpleArray<String>(-10, "Mike");
    }

    @Test(expected=LengthException.class)
    public void newArrayLengthZero() {
        Array<String> badArray = new SimpleArray<String>(0, "Mike");
    }

    @Test
    public void putandget() {
        shortArray.put(3,"FOO");
        asssetEquals("FOO", shortArray.get(3));
    }


}
