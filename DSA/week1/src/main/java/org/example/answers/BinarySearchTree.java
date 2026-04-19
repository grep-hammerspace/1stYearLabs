package org.example.answers;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree<T extends Comparable<T>> {

    private static class Node<T> {
        T value;
        Node<T> left, right;
        Node(T value) { this.value = value; }
    }

    private Node<T> root;

    public void insert(T value) {
        root = insertRec(root, value);
    }

    private Node<T> insertRec(Node<T> node, T value) {
        if (node == null) return new Node<>(value);
        int cmp = value.compareTo(node.value);
        if (cmp < 0) node.left = insertRec(node.left, value);
        else if (cmp > 0) node.right = insertRec(node.right, value);
        return node;
    }

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
        if (node == null) return null;
        int cmp = value.compareTo(node.value);
        if (cmp < 0) {
            node.left = deleteRec(node.left, value);
        } else if (cmp > 0) {
            node.right = deleteRec(node.right, value);
        } else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;
            // Replace with in-order successor (smallest in right subtree)
            Node<T> successor = node.right;
            while (successor.left != null) successor = successor.left;
            node.value = successor.value;
            node.right = deleteRec(node.right, successor.value);
        }
        return node;
    }

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

    private int heightRec(Node<T> node) {
        if (node == null) return 0;
        return 1 + Math.max(heightRec(node.left), heightRec(node.right));
    }

    public boolean isEmpty() {
        return root == null;
    }
}
