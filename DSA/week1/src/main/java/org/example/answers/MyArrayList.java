package org.example.answers;

public class MyArrayList<T> {

    // Java does not allow creating a generic array (new T[capacity]) due to type
    // erasure, so we store Object[] and cast on retrieval instead.
    private final Object[] data;
    private final double growthFactor =1.5;
    private final int defaultSize = 10;

    public MyArrayList() {
        this.data = new Object[10];
    }

    public int length() {
        return data.length;
    }

    // The cast is safe because set() only accepts T values, so every stored element
    // is actually a T. The suppression silences the unchecked-cast compiler warning.
    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index < 0 || index >= data.length) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + data.length);
        }
        return (T) data[index];
    }

    public void set(int index, T value) {
        if (index < 0 || index >= data.length) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + data.length);
        }
        data[index] = value;
    }

    public boolean contains(T value) {
        return indexOf(value) >= 0;
    }

    public int indexOf(T value) {
        for (int i = 0; i < data.length; i++) {
            // Handle null separately to avoid a NullPointerException when calling equals().
            if (value == null ? data[i] == null : value.equals(data[i])) {
                return i;
            }
        }
        return -1; // Signal that the value was not found.
    }
}
