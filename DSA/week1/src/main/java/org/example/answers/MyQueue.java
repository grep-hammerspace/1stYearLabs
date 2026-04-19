package org.example.answers;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class MyQueue<T> {

    // LinkedList gives O(1) insertions at the tail and removals at the head,
    // which is exactly what a FIFO queue needs. An ArrayList would require O(n)
    // shifting on every dequeue from the front.
    private final LinkedList<T> data = new LinkedList<>();

    // New items join at the back (tail) — first in, first out.
    public void enqueue(T item) {
        data.addLast(item);
    }

    // The oldest item leaves from the front (head).
    public T dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue is empty");
        return data.removeFirst();
    }

    // Inspect the front without removing it.
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
