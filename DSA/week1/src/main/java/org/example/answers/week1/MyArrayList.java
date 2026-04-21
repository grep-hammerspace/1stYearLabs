package org.example.answers.week1;

import java.util.NoSuchElementException;

public class MyArrayList<T> {

    // Java does not allow creating a generic array (new T[capacity]) due to type
    // erasure, so we store Object[] and cast on retrieval instead.
    private Object[] data;
    private final int growthFactor = 2;
    private final int defaultSize = 5;

    public MyArrayList() {
        this.data = new Object[defaultSize];
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
        if (data[index] == null){
            throw new NoSuchElementException();
        }
        return (T) data[index];
    }

    public void set(int index, T value) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + data.length);
        }

        if (index >= data.length){
            growBaseArray();
        }

        data[index] = value;
    }

    public boolean contains(T value) {
        return indexOf(value) >= 0;
    }

    public int indexOf(T value) {
        for (int i = 0; i < data.length; i++) {
            // Handle null separately to avoid a NullPointerException when calling equals().
            if (value == null){
                continue;
            } else {
                if (value.equals(data[i])){
                    return i;
                }
            }
        }
        return -1; // Signal that the value was not found.
    }

    private void growBaseArray(){
        int newLength = data.length * growthFactor;
        Object[] newDataArray = new Object[newLength];

        // Copy over old data
        for (int i =0 ; i < data.length -1; i++){
            newDataArray[i] = data[i];
        }

        // now data has more space in it.
        this.data = newDataArray;
    }
}
