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
        if (this.head == null) {
            // The linked list was totally empty
            Node<T> node = new Node<>(data);
            head = node;
            return;
        }
        // There was a pre-existing head node.
        Node<T> newHeadNode = new Node<>(data);

        // Set current head as next of new head node
        newHeadNode.next = this.head;

        // Set the objects head to the new one
        this.head = newHeadNode;

        // There is no existing tail node, so the head is also the tail
        if (tail == null) {
            this.tail = head;
        }

        size++;
    }

    public void addLast(T data) {
        Node<T> newTailNode = new Node<>(data);
        this.tail.next = newTailNode;
        size++;
    }

    /** @throws NoSuchElementException if the list is empty */
    public T removeFirst() {
        if (this.head == null) throw new NoSuchElementException();

        // Get data from existing head
        T data = this.head.data;

        // The classes head node is now what the element that the previous node points to
        this.head = this.head.next;

        // The head node was the only node
        if (this.head == null) this.tail = null;

        size--;
        return data;
    }

    /** @throws NoSuchElementException if the list is empty */
    public T removeLast() {
        if (tail == null) throw new NoSuchElementException();

        // Only one node
        if (this.head == this.tail){
            T data = this.head.data;
            this.head = null;
            this.tail = null;
            size --;
            return data;
        }

        //More than on node, walk down to it and set next == null
        Node<T> currentNode = head;

        while(currentNode.next != this.tail){
            currentNode = currentNode.next;
        }
        // Get data from last node
        T data = currentNode.next.data;
        this.tail = currentNode;

        // Mark last node as null
        currentNode.next = null;

        size--;
        return data;
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
        return this.size > 0;
    }
}
