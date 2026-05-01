package org.example.dsa.week2;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {

    private static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }

    // The first node in a BST is called the root.
    private Node root;

    public void insert(int value) {
        root = insertHelper(root, value);
    }

    private Node insertHelper(Node currentNode, int value){
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public boolean search(int value) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void delete(int value) {
        root = deleteHelper(root, value);
    }

    private Node deleteHelper(Node currentNode, int value){
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /** Left → root → right. Result is always sorted ascending for a valid BST. */
    public List<Integer> inOrder() {
        List<Integer> result = new ArrayList<>();

        inOrderTraverseHelper(root, result);
        return result;
    }

    private void inOrderTraverseHelper(Node currentNode, List<Integer> result){
        throw new UnsupportedOperationException("Not implemented yet");
    }


    /** Visits every node level by level, left to right. */
    public List<Integer> levelOrder() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /** Returns 0 for an empty tree, 1 for a single node. */
    public int height() { return  heightHelper(root);

    }

    private int heightHelper(Node currentNode){
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

}
