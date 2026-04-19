package org.example.answers;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class MyStack<T> {

    private final List<T> data = new ArrayList<>();

    public void push(T item) {
        data.add(item);
    }

    public T pop() {
        if (isEmpty()) throw new EmptyStackException();
        return data.remove(data.size() - 1);
    }

    public T peek() {
        if (isEmpty()) throw new EmptyStackException();
        return data.get(data.size() - 1);
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    public int size() {
        return data.size();
    }
}
