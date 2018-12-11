public class MyProgram {
    public static void main(String[] args) {
        List<Integer> myList = new NodeList<>();

        myList.insertFront(4);
        myList.insertFront(3);
        myList.insertFront(1);

        myList.front();  // 1

        // Now insert between 1 and 3
        // TODO - How????
    }
}


// Take 2
public class MyProgram {
    public static void main(String[] args) {
        List<Integer> myList = new NodeList<>();

        myList.insertFront(4);
        Node<Integer> n = myList.insertFront(3);
        myList.insertFront(1);

        // Now insert between 1 and 3
        myList.insertBefore(n, 2);  // Woohoo
        Node<Integer> n2 = myList.front();

        n2.put(400);
        n2.next = null; // FIXME
        // myList is now broken - breaks the ADT specification because we gave
        // the user too much access. We need to be responsible for managing this
    }
}
