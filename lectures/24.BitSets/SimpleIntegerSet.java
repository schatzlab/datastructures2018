import java.lang.Iterable;
import java.util.Iterator;

public class SimpleIntegerSet implements IntegerSet {
    private boolean[] data; 
    private int low; 
    private int high;

    public SimpleIntegerSet(int low, int high) { 
        if (low > high){
            throw new IllegalArgumentException("low " + low + " must be <= high " + high);
        }
        
        this.data = new boolean[high - low + 1]; 
        this .low = low;
        this.high = high;
    }

    public SimpleIntegerSet(int size) { 
       this (0, size - 1);
    }

    private int index(int i) {
        if (this.low<=i&&i<=this.high) {
            return i + this.low; 
        } else {
             throw new IndexOutOfBoundsException("element " + i + " must be >= low " + 
                                                 this.low + " and <= high " + this.high);
        }
    }

    private void put(int i, boolean b) { 
        this.data[this.index(i)] = b;
    }

    private boolean get(int i) {
        return this.data[this.index(i)];
    }

    public void insert(int i) { this.put(i, true); }
    public void remove(int i) { this.put(i, false); }
    public boolean has(int i) { return this.get(i); }
    public int low()  { return this.low; }
    public int high() { return this.high; }

    // TODO :-)
    public Iterator<Integer> iterator() { return null; }
}
