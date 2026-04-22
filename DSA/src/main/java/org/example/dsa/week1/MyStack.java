package org.example.dsa.week1;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class MyStack<T> {

    private ArrayList<T> elements = new ArrayList<>();

    public void push(T item) {
        elements.add(item);
    }

    /** @throws EmptyStackException if the stack is empty */
    public T pop() {
        throw new UnsupportedOperationException();
    }

    /** @throws EmptyStackException if the stack is empty */
    public T peek() {
        throw new UnsupportedOperationException();
    }

    public boolean isEmpty() {
        throw new UnsupportedOperationException();
    }

    public int size() {
        throw new UnsupportedOperationException();
    }
}
