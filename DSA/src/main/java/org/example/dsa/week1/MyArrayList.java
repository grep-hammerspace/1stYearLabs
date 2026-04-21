package org.example.dsa.week1;

public class MyArrayList<T> {
    // Hint
    // Java does not allow creating a generic array (new T[capacity]) due to type
    // erasure, so we store Object[] and cast on retrieval instead.
    private Object[] data;
    private final double growthFactor = 2;
    private final int defaultSize = 5;

    public MyArrayList(int capacity) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public int length() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public T get(int index) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void set(int index, T value) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public boolean contains(T value) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /** Returns the index of the first occurrence of value, or -1 if not present. */
    public int indexOf(T value) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
