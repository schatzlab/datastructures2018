/*
    Testing implementations of the Array<T> interface.
*/

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ArrayTest {

    // Unit under test.
    private Array<String> unit;
    // Factory to create units under test.
    private Factory<String> factory;

    // Factory interface.
    private interface Factory<T> {
        Array<T> create(int n, T t);
    }

    // Factory implementations (one per Array<T> implementation).
    private static class SimpleArrayFactory<T> implements Factory<T> {
        @Override
        public Array<T> create(int n, T t) {
            return new SimpleArray<T>(n, t);
        }
    }

    private static class ListArrayFactory<T> implements Factory<T> {
        @Override
        public Array<T> create(int n, T t) {
            return new ListArray<T>(n, t);
        }
    }

    public ArrayTest(Factory<String> f) {
        this.factory = f;
    }

    @Parameters
    public static Collection<Object[]> getParameters() {
        return Arrays.asList(new Object[][] {
            {new SimpleArrayFactory<String>()},
            {new ListArrayFactory<String>()},
        });
    }

    @Before
    public void createArray() {
        this.unit = this.factory.create(10, "Yes?");
    }

    @Test
    public void initialLength() {
        assertEquals(10, this.unit.length());
    }

    @Test
    public void initialSlots() {
        for (String s: this.unit) {
            assertEquals("Yes?", s);
        }
    }

    @Test
    public void putPreservesLength() {
        this.unit.put(0, "Aha!");
        assertEquals(10, this.unit.length());
    }

    @Test
    public void putModifiesSlot() {
        this.unit.put(0, "Aha!");
        assertEquals("Aha!", this.unit.get(0));
    }

    @Test
    public void putPreservesSlots() {
        this.unit.put(0, "Aha!");
        for (int i = 1; i < this.unit.length(); i++) {
            assertEquals("Yes?", this.unit.get(i));
        }
    }
}
