import java.util.Iterator; 
import java.util.ArrayList;

public class OrderedArrayListSetFast<T extends Comparable<T>> implements OrderedSet<T> {
    private ArrayList<T> data; 
    public OrderedArrayListSetFast() {
        this.data = new ArrayList<T>();
    }
    
    // if not already there, insert into the correct place using sorted order
    public void insert (T t ) {
        int p = this.find(t);
        if (this.found(p, t)) { return; }
        this.data.add(p, t);
    }


    // The new find will always return the correct index for the value, 
    // regardless of whether the value is in the set or not
    private int find(T t) {
        int l = 0, u = this.data.size()-1;
        while(l <= u) {
            int m = (l + u) / 2;
            if (this.data.get(m).compareTo(t) > 0) {
                u = m - 1;
            } else if (this.data.get(m).compareTo(t) == 0) {
                return m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    // helper method to check if the find() value is actually the data
    // or the slot it should go next. O(1) time
    private boolean found(int p, T t) {
        return p < this.data.size() && this.data.get(p).equals(t);
    }

    public void remove(T t) {
        int position = this.find(t);
        if ( position == this.data.size()) { return; } 
        this.data.remove(position);
    }

    public boolean has(T t ) { 
        return this.found(this.find(t), t);
    }

    public Iterator <T> iterator () { 
        return this.data.iterator();
    }

    private void printData() {
        for (int i = 0; i < this.data.size(); i++) {
             System.out.println("data[" + i + "]: " + this.data.get(i));
        }
    }

    public static void main(String[] args) {
      OrderedArrayListSetFast<Integer> s = new OrderedArrayListSetFast();
      s.insert(42);
      s.insert(100);
      s.insert(3);
      s.insert(200);
      s.insert(1);
      s.printData();
    }
}
