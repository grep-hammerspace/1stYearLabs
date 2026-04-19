package org.example.answers;

public class MyArray<T> {

    private final Object[] data;

    public MyArray(int capacity) {
        this.data = new Object[capacity];
    }

    public int length() {
        return data.length;
    }

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
            if (value == null ? data[i] == null : value.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }
}
