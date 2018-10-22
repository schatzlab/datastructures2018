import java.util.Iterator; 
import java.util.ArrayList;

public class ArrayListSet <T> implements Set<T> {
    private ArrayList<T> data; 
    public ArrayListSet() {
        this.data = new ArrayList<T>();
    }
    
    public void insert (T t ) {
        if (this.has(t)) { return; }
        this.data.add(t);
    }


    private int find(T t) {
        for (int i = 0; i < this.data.size (); i++) {
            if (this.data.get(i).equals(t)) { 
                return i;
            }
        }
        return -1;
    }

    public void remove(T t) {
        int position = this.find(t);
        if ( position == -1) { return; } 
        this.data.remove(position);
    }

    public boolean has(T t ) { 
          return this.find(t) != -1;
    }

    public Iterator <T> iterator () { 
        return this.data.iterator();
    }
}

   
