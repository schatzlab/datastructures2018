public class Node {
  private int data;
  private Node next;

  public Node(int d) {
    this.data = d;
    this.next = null; // will do this by default
  }

  public void setNext(Node n) {
    this.next = n;
  }

  public Node getNext() {
    return this.next;
  }

  public int getData() {
    return this.data;
  }

  public static void main(String[] args) {
    Node n1 = new Node(1);
    Node n2 = new Node(2);
    Node n3 = new Node(3);

    n1.setNext(n2);
    n2.setNext(n3);

    System.out.println(n1.getData() + " -> " + n1.getNext().getData());
    System.out.println(n2.getData() + " -> " + n2.getNext().getData());
    //System.out.println(n3.getData() + " -> " + n3.getNext().getData());

    Node x = new Node(11);
    x.setNext(new Node(22));
    x.getNext().setNext(new Node(33));

    System.out.println(x.getData() + " -> " + x.getNext().getData());
    System.out.println(x.getNext().getData() + " -> " + x.getNext().getNext().getData());
    System.out.println(x.getNext().getNext().getData() + " -> " + x.getNext().getNext().getNext().getData());
  }
};


