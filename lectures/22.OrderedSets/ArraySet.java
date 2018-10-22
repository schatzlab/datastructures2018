import java.util.Iterator;

public class ArraySet<T> implements Set<T> { 
    private int length;
    private T[] data;

    private static class SetIterator <T> implements Iterator<T> { 
        private int current;
        private int length;
        private T[] data;

        public SetIterator (int length, T[] data) {
            this.data = data;
            this.length = length; 
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public boolean hasNext () {
            return this.current < this.length; 
        }

        public T next () {
            T t = this.data[this.current];
            this.current +=1; 
            return t;
        } 
    }

    public ArraySet () {
        this.data = (T[]) new Object[1];
    }

    private void grow() {
        T[] bigger = (T[]) new Object[2 * this.length]; 
        for (int i = 0; i < this.length; i++){
            bigger[i] = this.data[i]; 
        }
        this.data = bigger; 
    }

    public void insert (T t) {
        // System.out.println("inserting: " + t);
        if (this.has(t)) { return; }
        if (this.length == this.data.length) {
            this.grow(); 
        }
        this.data[this.length] = t;
        this.length += 1; 
    }

    private int find(T t) {
        for (int i = 0; i <length; i++){
            if (this.data[i].equals(t)) { return i; } 
        }
        return -1; 
    }

    public void remove(T t ) {
        int position = this.find(t);
        if (position == -1) { return; }
        for (int i = position; i < this.length-1; i++) {
            this.data[i] = this.data[i+1];
        }
        this.length -= 1;
    }

    public boolean has(T t) {
        return this.find(t) != -1; 
    }

    public Iterator <T> iterator () {
        return new SetIterator <T> (this.length, this.data);
    }

    public static void main(String[] args)
    {
        ArraySet<String> set = new ArraySet<String>();
        set.insert("Mike");
        set.insert("Peter");
        set.insert("Kelly");
        set.insert("Mike");
        set.insert("Mike");
        
        System.out.println("Printing Set");
        for (String s : set) {
            System.out.println(s);
        }

        System.out.println("Removing Peter");
        set.remove("Peter");

        System.out.println("Printing Set");
        for (String s : set) {
            System.out.println(s);
        }
    }
}


