public class List {
  private StringNode list;

  public List() {
    this.list = null; // not really necessary
  }

  public void add(String value){
    StringNode n = new StringNode(value);
    n.setNext(this.list);
    this.list = n;
  }

  public StringNode find(String value) {
    StringNode cur = list;
    while (cur != null) {
      System.out.println("checking: " + value + " at " + cur.getData());
      if (cur.getData().equals(value)){
        return cur;
      }

      cur = cur.getNext();
    }

    return cur; // must be null
  }



  public static void main(String[] args) {
    List mylist = new List();
    mylist.add("Mike");
    mylist.add("Peter");
    mylist.add("Kelly");

    StringNode f1 = mylist.find("Mike");
    System.out.println("f1 finished");
    System.out.println(f1.getData());

    StringNode f2 = mylist.find("James");
    System.out.println("f2 finished");
    //System.out.println(f2.getData());
  }
};
