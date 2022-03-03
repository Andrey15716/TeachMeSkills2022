package task3;

import java.util.Arrays;

public class MinMax<T extends Comparable<T>> {
    private T[] array;

    public MinMax(T[] array) {
        this.array = array;
    }

    public T getMinElement() {
        if (array.length > 0) {
            T min = array[0];
            for (T t : array) {
                if (t.compareTo(min) < 0) {
                    min = t;
                }
            }
            return min;
        }
        return null;
    }

    public T getMaxElement() {
        if (array.length > 0) {
            T max = array[0];
            for (T t : array) {
                if (t.compareTo(max) > 0) {
                    max = t;
                }
            }
            return max;
        }
        return null;
    }

    @Override
    public String toString() {
        return "Массив " + Arrays.toString(array);
    }
}