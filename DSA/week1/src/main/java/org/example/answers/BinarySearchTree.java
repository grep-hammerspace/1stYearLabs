package org.example.answers;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree<T extends Comparable<T>> {

    // T must implement Comparable so we can decide left/right placement without
    // needing a separate Comparator parameter.
    private static class Node<T> {
        T value;
        Node<T> left, right;
        Node(T value) { this.value = value; }
    }

    private Node<T> root;

    public void insert(T value) {
        root = insertRec(root, value);
    }

    // Returns the (possibly new) node at this position so the parent can update
    // its child pointer — a clean pattern that avoids a separate parent reference.
    private Node<T> insertRec(Node<T> node, T value) {
        if (node == null) return new Node<>(value); // Found the correct empty slot.
        int cmp = value.compareTo(node.value);
        if (cmp < 0) node.left = insertRec(node.left, value);  // Smaller: go left.
        else if (cmp > 0) node.right = insertRec(node.right, value); // Larger: go right.
        // cmp == 0: duplicate — we silently ignore it (BST property: no duplicates).
        return node;
    }

    // Iterative search avoids recursion overhead; the BST property lets us discard
    // half the remaining tree at each step — O(h) where h is the tree height.
    public boolean search(T value) {
        Node<T> current = root;
        while (current != null) {
            int cmp = value.compareTo(current.value);
            if (cmp == 0) return true;
            current = cmp < 0 ? current.left : current.right;
        }
        return false;
    }

    public void delete(T value) {
        root = deleteRec(root, value);
    }

    private Node<T> deleteRec(Node<T> node, T value) {
        if (node == null) return null; // Value not found; nothing to delete.
        int cmp = value.compareTo(node.value);
        if (cmp < 0) {
            node.left = deleteRec(node.left, value);
        } else if (cmp > 0) {
            node.right = deleteRec(node.right, value);
        } else {
            // Node to delete found. Handle the three cases:
            if (node.left == null) return node.right;  // No left child: replace with right.
            if (node.right == null) return node.left;  // No right child: replace with left.
            // Two children: replace this node's value with its in-order successor
            // (the smallest value in the right subtree) to preserve BST ordering,
            // then delete that successor from the right subtree.
            Node<T> successor = node.right;
            while (successor.left != null) successor = successor.left;
            node.value = successor.value;
            node.right = deleteRec(node.right, successor.value);
        }
        return node;
    }

    // In-order (left → node → right) visits nodes in ascending sorted order,
    // which is a useful property of BSTs.
    public List<T> inOrder() {
        List<T> result = new ArrayList<>();
        inOrderRec(root, result);
        return result;
    }

    private void inOrderRec(Node<T> node, List<T> result) {
        if (node == null) return;
        inOrderRec(node.left, result);
        result.add(node.value);
        inOrderRec(node.right, result);
    }

    // Pre-order (node → left → right) visits the root first — useful for
    // serialising or copying a tree while preserving its shape.
    public List<T> preOrder() {
        List<T> result = new ArrayList<>();
        preOrderRec(root, result);
        return result;
    }

    private void preOrderRec(Node<T> node, List<T> result) {
        if (node == null) return;
        result.add(node.value);
        preOrderRec(node.left, result);
        preOrderRec(node.right, result);
    }

    // Post-order (left → right → node) visits children before the parent —
    // useful when you need to process/delete children before their parent.
    public List<T> postOrder() {
        List<T> result = new ArrayList<>();
        postOrderRec(root, result);
        return result;
    }

    private void postOrderRec(Node<T> node, List<T> result) {
        if (node == null) return;
        postOrderRec(node.left, result);
        postOrderRec(node.right, result);
        result.add(node.value);
    }

    public int height() {
        return heightRec(root);
    }

    // Height = 1 (this node) + the taller of the two subtrees.
    // A null node contributes 0, so leaf nodes correctly return height 1.
    private int heightRec(Node<T> node) {
        if (node == null) return 0;
        return 1 + Math.max(heightRec(node.left), heightRec(node.right));
    }

    public boolean isEmpty() {
        return root == null;
    }
}
