package org.example.answers;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class MyQueue<T> {

    private final LinkedList<T> data = new LinkedList<>();

    public void enqueue(T item) {
        data.addLast(item);
    }

    public T dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue is empty");
        return data.removeFirst();
    }

    public T peek() {
        if (isEmpty()) throw new NoSuchElementException("Queue is empty");
        return data.getFirst();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    public int size() {
        return data.size();
    }
}
