import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;

public class TestListMore {
    List<String> list;

    @Before
    public void setupList () {
        list = new NodeList<String>();
    }

    @Test
    public void testEmptyList () { 
        assertEquals("[]", list.toString()); 
        assertEquals(0, list.length());
    }

    @Test
    public void testInsertFront () {
        list.insertFront("Peter");
        list.insertFront("Paul");
        assertEquals("[Paul, Peter]", list.toString()); 
        assertEquals(2, list.length());
    }

    @Test
    public void testInsertBack () { 
        list.insertBack("Peter"); 
        list.insertBack("Paul");
        assertEquals("[Peter, Paul]", list.toString());
        assertEquals(2, list.length());
    }

    @Test
    public void testRemoveFront () { 
        list.insertBack("Peter"); 
        list.insertBack("Paul");
        list.insertBack("Mike");
        assertEquals("[Peter, Paul, Mike]", list.toString());
        assertEquals(3, list.length());

        list.removeFront();
        assertEquals("[Paul, Mike]", list.toString());
        assertEquals(2, list.length());

        list.removeFront();
        assertEquals("[Mike]", list.toString());
        assertEquals(1, list.length());

        list.removeFront();
        assertEquals("[]", list.toString());
        assertEquals(0, list.length());
    }

    @Test
    public void testRemoveBack () { 
        list.insertBack("Peter"); 
        list.insertBack("Paul");
        list.insertBack("Mike");
        assertEquals("[Peter, Paul, Mike]", list.toString());
        assertEquals(3, list.length());

        list.removeBack();
        assertEquals("[Peter, Paul]", list.toString());
        assertEquals(2, list.length());

        list.removeBack();
        assertEquals("[Peter]", list.toString ());
        assertEquals(1, list.length());

        list.removeFront();
        assertEquals("[]", list.toString ());
        assertEquals(0, list.length());
    }

    @Test
    public void testRemoveMiddle () { 
        list.insertBack("Peter"); 
        Position p = list.insertBack("Paul");
        list.insertBack("Mike");
        assertEquals("[Peter, Paul, Mike]", list.toString ());
        assertEquals(3, list.length ());

        list.remove(p);
        assertEquals("[Peter, Mike]", list.toString ());
    }
}

