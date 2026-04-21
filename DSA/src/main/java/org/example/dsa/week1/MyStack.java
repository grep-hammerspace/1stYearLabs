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
        if (elements.isEmpty()) {
            throw new EmptyStackException();
        }
        T tailElement = elements.get(elements.size()-1);
        elements.remove(elements.size()-1);
        return tailElement;
    }

    /** @throws EmptyStackException if the stack is empty */
    public T peek() {
        if (elements.isEmpty()){
            throw new EmptyStackException();
        }
        return elements.get(elements.size()-1);
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public int size() {
        return  elements.size();
    }
}
