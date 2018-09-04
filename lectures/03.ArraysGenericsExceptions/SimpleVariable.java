public class SimpleVariable<T> implements Variable<T> {

    private T value;

    public SimpleVariable(T t) {
        this.value = t;
    }

    public T get() {
        return this.value;
    }

    public void set(T t) {
        this.value = t;
    }

    public static void main (String[] args){
        SimpleVariable si = new SimpleVariable("Mike");
        System.out.println("val: " + si.get() + " type: " + si.get().getClass().getName());
        si.set(1234);
        System.out.println("val: " + si.get() + " type: " + si.get().getClass().getName());
    }
}
