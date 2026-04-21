package org.example.dsa.week1;

import java.util.NoSuchElementException;

public class MyLinkedList<T> {

    // Use this Node class to store your data and references to the next!!
    private static class Node<T> {
        T data;
        org.example.answers.week1.MyLinkedList.Node<T> next;
        Node(T data) { this.data = data; }
    }

    public void addFirst(T data) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void addLast(T data) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /** @throws NoSuchElementException if the list is empty */
    public T removeFirst() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /** @throws NoSuchElementException if the list is empty */
    public T removeLast() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /** @throws IndexOutOfBoundsException if index is out of range */
    public T get(int index) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public boolean contains(T data) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public int size() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
