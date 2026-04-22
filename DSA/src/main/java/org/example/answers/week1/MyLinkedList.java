package org.example.answers.week1;

import java.util.NoSuchElementException;

public class MyLinkedList<T> {

    // Each node holds its value and a pointer to the next node in the chain.
    private static class Node<T> {
        T data;
        Node<T> next;
        Node(T data) { this.data = data; }
    }

    // We keep a tail pointer so addLast is O(1) instead of O(n).
    private Node<T> head;
    private Node<T> tail;
    private int size;

    // Point the new node at the current head, then promote it to head.
    // If the list was empty, the new node is also the tail.
    public void addFirst(T data) {
        Node<T> node = new Node<>(data);
        node.next = head;
        head = node;
        if (tail == null) tail = head;
        size++;
    }

    // Wire the current tail to the new node, then advance the tail pointer.
    // If the list was empty, the new node becomes both head and tail.
    public void addLast(T data) {
        Node<T> node = new Node<>(data);
        if (tail == null) {
            head = tail = node;
        } else {
            tail.next = node;
            this.tail = node;
        }
        size++;
    }

    public T removeFirst() {
        if (isEmpty()) throw new NoSuchElementException("List is empty");
        T data = head.data;
        head = head.next;
        // If removing the only element, tail must also be cleared to avoid a dangling pointer.
        if (head == null) tail = null;
        size--;
        return data;
    }

    public T removeLast() {
        if (isEmpty()) throw new NoSuchElementException("List is empty");
        // Single-element case: both head and tail point at the same node.
        if (head == tail) {
            T data = head.data;
            head = tail = null;
            size--;
            return data;
        }
        // Walk to the node just before the tail so we can update the tail pointer.
        // This is O(n) because singly-linked lists have no back-pointer.
        Node<T> current = head;
        while (current.next != tail) {
            current = current.next;
        }
        T data = tail.data;
        tail = current;
        tail.next = null; // Detach the old tail so it can be garbage-collected.
        size--;
        return data;
    }

    // Sequential traversal is the only way to reach an arbitrary index in a linked list — O(n).
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    public boolean contains(T data) {
        Node<T> current = head;
        while (current != null) {
            // Guard against null to avoid NullPointerException when calling equals().
            if (data == null ? current.data == null : data.equals(current.data)) return true;
            current = current.next;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
