import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;
import java.util.Iterator;

public class TestListSetIterator {
    Set<String> set;

    @Before
    public void setupSet() {
        set = new ListSet<String>();
    }

    @Test
    public void testEmptyIterator() {
        Iterator<String> i = set.iterator();
        assertEquals(false, i.hasNext());
    }

    @Test
    public void testSingletonIterator() {
        set.insert("Paul");
        Iterator<String> i = set.iterator();
        assertEquals(true, i.hasNext());
        String s = i.next();
        assertEquals("Paul", s);
        assertEquals(false, i.hasNext());
    }
    
    @Test
    public void testIterator() {
        String [] data = {"Peter", "Paul", "Mary", "Beverly"};
        for (String d: data) {
            set.insert(d);
        }

        for(String s : set) {
            int count = 0;
            for (String d: data) {
                if (s.equals(d)) {
                    count += 1;
                }
            }
            assertEquals(1, count);
        }
    }
}
