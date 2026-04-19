package org.example.answers;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class MyStack<T> {

    // ArrayList gives O(1) amortised add/remove at the tail, which maps directly
    // to push and pop without needing any index arithmetic.
    private final List<T> data = new ArrayList<>();

    // Adding to the end of the list is the "top" of the stack — O(1) amortised.
    public void push(T item) {
        data.add(item);
    }

    // Remove and return the last element (top of stack).
    // Removing from the end of an ArrayList is O(1) with no element shifting.
    public T pop() {
        if (isEmpty()) throw new EmptyStackException();
        return data.remove(data.size() - 1);
    }

    // Like pop but does not remove the element — just inspects the top.
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
