package generics_prog;

public interface MinMax<T extends Comparable<T>> {

	T min();

	T max();
}

