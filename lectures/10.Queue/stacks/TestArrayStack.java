import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;

public class TestArrayStack {
    private Stack<Integer> stack;

    @Before
    public void makeStack() {
        stack = new ArrayStack<Integer>();
    }

    @Test
    public void testNewEmpty() {
        assertEquals(true, stack.empty());
    }

    @Test
    public void testPushNotEmpty() {
        stack.push(12);
        assertEquals(false, stack.empty());
    }

    @Test
    public void testPushPopEmpty() {
        stack.push(12);
        stack.pop();
        assertEquals(true, stack.empty());
    }



    @Test
    public void testPushTopEqual() {
        stack.push(12);
        int hack = stack.top();
        assertEquals(12, hack);
    }


    @Test
    public void testLotsOfPush() {
        for (int i = 0; i < 100; i++) {
            stack.push(i);
        }
        int pops;
        for (pops = 0; !stack.empty(); pops++) {
            int hack = stack.top();
            assertEquals(99-pops, hack);
            stack.pop();
       }
        assertEquals(100, pops);
    }
}
