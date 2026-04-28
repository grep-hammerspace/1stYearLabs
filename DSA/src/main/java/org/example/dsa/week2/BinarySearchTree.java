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
        root = deleteHelper(root, value);
        // Three cases 1) Deleting the root node, 2) deleting a leaf node (no children) and 3) Deleting
    }

    private Node deleteHelper(Node currentNode, int value){
        // Base case, ie there was no root or node with matching value wasnt found;
        if(currentNode == null) return null;

        // Navigate to the Node we are trying to delete
        if (value < currentNode.value){
            // look in left sub-tree
            currentNode.left = deleteHelper(currentNode.left,value);
        } else if (value > currentNode.value){
            // look in right sub tree
            currentNode.right = deleteHelper(currentNode.right,value);
        } else {
            // Node value == target and ew have arrived at what we want to delete

            // no left child, replace current node with right child
            if(currentNode.left == null){
                return currentNode.right;
            }

            //no right child, replace curent node with left child
            if (currentNode.right == null){
                return currentNode.left;
            }

            // currentNode has two children,
            // we need to replace it with the right child (successor) and add the left child
            // to the replaced node

            Node successor = currentNode.right;

            // iterate all the way down the left sub-tree of the successor
            while (successor.left != null){
                successor = successor.left;
            }

            // reassign
            currentNode.value = successor.value;
            currentNode.right = deleteHelper(currentNode.right, successor.value);

        }

        return currentNode;
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


    /** Visits every node level by level, left to right. */
    public List<Integer> levelOrder() {
        throw new UnsupportedOperationException("Not implemented yet");
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

}
