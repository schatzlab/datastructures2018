// HelloTest.java - Test JUnit tests.

import org.junit.runner.JUnitCore;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class HelloTest {

    private Hello unit;

    // Runs before each @Test method.
    @Before
    public void setup() {
        this.unit = new Hello();
    }

    @Test
    public void testMessageSaysHello() {
        assertEquals(unit.getMessage(), "Hello, World!");
    }

    @Test
    public void assertTrueIsTrue() {
        assertTrue(true);
    }

    // Exception testing
    @Test(expected=AssertionError.class)
    public void exceptionForAssertFalseIsTrue() {
        assertTrue(false);
    }
}
