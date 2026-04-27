package org.example.dsa.week2;

import java.util.List;

public class BinarySearchTree<T extends Comparable<T>> {

    // T must implement Comparable so we can decide left/right placement without
    // needing a separate Comparator parameter.
    private static class Node<T> {
        T value;
        Node<T> left, right;
        Node(T value) { this.value = value; }
    }

    // The first node in ant BST is called the root.
    private Node<T> root;

    public void insert(T value) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public boolean search(T value) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void delete(T value) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /** Left → root → right. Result is always sorted ascending for a valid BST. */
    public List<T> inOrder() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /** Root → left → right. Preserves tree structure; useful for serialisation. */
    public List<T> preOrder() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /** Left → right → root. Children processed before parent; useful for deletion. */
    public List<T> postOrder() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /** Returns 0 for an empty tree, 1 for a single node. */
    public int height() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
