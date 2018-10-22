public interface OrderedSet <T extends Comparable<T>> extends Iterable<T> { 
	void insert(T t);
	void remove(T t);
	boolean has(T t);
}

