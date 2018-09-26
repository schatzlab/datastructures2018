import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;

public class TestList {
    List<String> list ;

    @Before
    public void setupList () {
        list = new NodeList<String>();
    }

    @Test
    public void testEmptyList () { 
        assertEquals ("[]", list.toString()); 
        assertEquals (0, list.length());
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
        assertEquals ("[Peter, Paul]", list.toString ());
        assertEquals (2, list.length ());
    }
}

