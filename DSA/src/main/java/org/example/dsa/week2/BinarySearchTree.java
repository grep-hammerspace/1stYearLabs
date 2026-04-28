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
        // Base case, we have reached an empty spot in the tree
        if (currentNode == null) {
            return new Node(value);
        }

        if (value < currentNode.value){
            currentNode.left = insertHelper(currentNode.left, value);
        } else if ( value > currentNode.value) {
            currentNode.right = insertHelper(currentNode.right, value);
        }

        // if value equals an existing node, do nothing.
            return currentNode;

    }

    public boolean search(int value) {

        Node currentNode = root;

        while(currentNode != null) {
            if (value < currentNode.value){
                currentNode = currentNode.left;
            } else if ( value > currentNode.value) {
                currentNode = currentNode.right;
            } else {
                // value is equal to value we are seaching for
                return true;
            }
        }

        return false;
    }

    public void delete(int value) {
        // Three cases 1) Deleting the root node, 2) deleting a leaf node (no children) and 3) Deleting
    }

    /** Left → root → right. Result is always sorted ascending for a valid BST. */
    public List<Integer> inOrder() {
        List<Integer> result = new ArrayList<>();

        inOrderTraverseHelper(root, result);
        return result;
    }

    private void inOrderTraverseHelper(Node currentNode, List<Integer> result){
        // We want to get an ordered list of nodes froma Binary Search Tree.
        // We do this by visiting each sub tree, left, root right.

        if (currentNode == null ){
            return;
        }

        inOrderTraverseHelper(currentNode.left, result);
        result.add(currentNode.value);
        inOrderTraverseHelper(currentNode.right, result);
    }


    /** Returns 0 for an empty tree, 1 for a single node. */
    public int height() { return  heightHelper(root);

    }

    private int heightHelper(Node currentNode){
        if (currentNode == null){
            return 0;
        }

        // Height of a tree = 1 (root) + height of tallest subtree, we can do that recursively.
        int leftHeight = heightHelper(currentNode.left);
        int rightHeight = heightHelper(currentNode.right);

        return 1 + Math.max(leftHeight,rightHeight);
    }

    public boolean isEmpty() {
        return root == null;
    }

    // Optional extensions other kinds of tree traversal
//    /** Root → left → right. Preserves tree structure; useful for serialisation. */
//    public List<Integer> preOrder() {
//        throw new UnsupportedOperationException("Not implemented yet");
//    }
//
//    /** Left → right → root. Children processed before parent; useful for deletion. */
//    public List<Integer> postOrder() {
//        throw new UnsupportedOperationException("Not implemented yet");
//    }

}
