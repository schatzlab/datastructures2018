public class StringNode {
  private String data;
  private StringNode next;

  public StringNode(String d) {
    this.data = d;
    this.next = null; // will do this by default
  }

  public void setNext(StringNode n) {
    this.next = n;
  }

  public StringNode getNext() {
    return this.next;
  }

  public String getData() {
    return this.data;
  }
};


