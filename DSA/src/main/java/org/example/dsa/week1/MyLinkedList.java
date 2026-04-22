package org.example.dsa.week1;

import java.util.NoSuchElementException;

public class MyLinkedList<T> {

    // Each node holds its value and a pointer to the next node in the chain.
    private static class Node<T> {
        T data;
        org.example.dsa.week1.MyLinkedList.Node<T> next;
        Node(T data) { this.data = data; }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public void addFirst(T data) {
        throw new UnsupportedOperationException();
    }

    public void addLast(T data) {
        throw new UnsupportedOperationException();
    }

    /** @throws NoSuchElementException if the list is empty */
    public T removeFirst() {
        throw new UnsupportedOperationException();
    }

    /** @throws NoSuchElementException if the list is empty */
    public T removeLast() {
        throw new UnsupportedOperationException();
    }

    // Throw NoSuchElementException if empty
    // Allows you to get data from the head node without removing anything from the linkedList
    public T peekFirst(){
        throw new UnsupportedOperationException();
    }

    // Throw NoSuchElementException if empty
    // Allows you to get data from the tail node without removing anything from the linkedList
    public T peekLast() {
        throw new UnsupportedOperationException();
    }

    /** @throws IndexOutOfBoundsException if index is out of range */
    public T get(int index) {
        if (index < 0 || index >= this.size) throw new IndexOutOfBoundsException();
        Node<T> currentNode = this.head;

        //Iterate up to the correct index
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }

        return currentNode.data;
    }

    public boolean contains(T data) {
        Node<T> currentNode = head;
        while(currentNode != null){
            if ( data != null && currentNode.data.equals(data)) return true;
            currentNode = currentNode.next;
        }
        return false;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }
}
