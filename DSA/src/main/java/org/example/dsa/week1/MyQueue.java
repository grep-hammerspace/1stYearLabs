package org.example.dsa.week1;

import javax.swing.event.CellEditorListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class MyQueue<T> {

    private LinkedList<T> elements = new LinkedList<T>();

    public void enqueue(T item) {
        elements.addFirst(item);
    }

    /** @throws NoSuchElementException if the queue is empty */
    public T dequeue() {
        if (elements.isEmpty()) throw new NoSuchElementException();
        return elements.removeLast();
    }

    /** @throws NoSuchElementException if the queue is empty */
    public T peek() {
        if (elements.isEmpty()) throw new NoSuchElementException();
        return elements.peekLast();
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public int size() {
       return elements.size();
    }
}
