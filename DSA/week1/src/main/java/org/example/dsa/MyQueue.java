package org.example.dsa;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class MyQueue<T> {

    private ArrayList<T> elements = new ArrayList<>();

    public void enqueue(T item) {
        elements.add(elements.size(),item);
    }

    /** @throws NoSuchElementException if the queue is empty */
    public T dequeue() {
        if (elements.isEmpty()){
            throw new NoSuchElementException();
        }
        T headElement = elements.get(0);
        elements.remove(0);
        return headElement;
    }

    /** @throws NoSuchElementException if the queue is empty */
    public T peek() {
        if (elements.isEmpty()) {
            throw new NoSuchElementException();
        }
        return elements.get(elements.size()-1);
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public int size() {
       return elements.size();
    }
}
