package edu.pnu.collection;

import edu.pnu.admin.Beverage;

import java.util.Arrays;
import java.util.Iterator;

public class GenericList<T> {
    private static final int DEFAULT_SIZE = 10;
    private Object[] data;
    private int size = 0;

    public GenericList() {
        this.data = new Object[DEFAULT_SIZE];
    }

    public Iterable<T> values() {
        Object[] ret = Arrays.copyOf(data, size);
        Iterable<T> iterable = (Iterable<T>) Arrays.asList(ret);
        return iterable;
    }

    public int getSize(){
        return size;
    }

    public void put(T newData) {
        this.data[size++] = newData;
    }

    public void clear() {
        this.size = 0;
        this.data = new Object[DEFAULT_SIZE];
    }

    public T get(int index) {
        return (T) this.data[index];
    }
}
