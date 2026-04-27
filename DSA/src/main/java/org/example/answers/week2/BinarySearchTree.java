package org.example.answers.week2;

import java.util.ArrayList;
import java.util.List;

/*
 * A Binary Search Tree (BST) is a tree where every node follows one rule:
 *   - values smaller than the node go to its LEFT child
 *   - values larger than the node go to its RIGHT child
 *
 * This rule means we can always find, insert, or delete a value by going left
 * or right at each step — we never have to check every node.
 */
public class BinarySearchTree {

    /*
     * Each node in the tree holds a value and references to its left and right children.
     * If a child doesn't exist, it is null.
     */
    private static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }

    // The root is the top-most node. An empty tree has root == null.
    private Node root;

    /*
     * INSERT
     *
     * Adds a new value to the tree in the correct position.
     * We delegate to a recursive helper that walks the tree and returns
     * the (possibly new) node at each position, so the parent can update
     * its child pointer automatically.
     */
    public void insert(int value) {
        root = insertRec(root, value);
    }

    private Node insertRec(Node node, int value) {
        // We've reached an empty spot — this is where the new value belongs.
        if (node == null) {
            return new Node(value);
        }

        // The BST rule: smaller values go left, larger values go right.
        if (value < node.value) {
            node.left = insertRec(node.left, value);
        } else if (value > node.value) {
            node.right = insertRec(node.right, value);
        }
        // if value == node.value, it already exists — do nothing

        return node;
    }

    /*
     * SEARCH
     *
     * Checks whether a value exists in the tree.
     * At each node we compare the target value and move left or right,
     * discarding the other half of the tree each time.
     * If we reach null, the value isn't in the tree.
     */
    public boolean search(int value) {
        Node current = root;

        while (current != null) {
            if (value == current.value) {
                return true;
            } else if (value < current.value) {
                // Target is smaller, so it can only be in the left subtree.
                current = current.left;
            } else {
                // Target is larger, so it can only be in the right subtree.
                current = current.right;
            }
        }

        return false;
    }

    /*
     * DELETE
     *
     * Removes a value from the tree while keeping the BST rule intact.
     * There are three cases to handle depending on how many children the
     * node being deleted has (see deleteRec below).
     */
    public void delete(int value) {
        root = deleteRec(root, value);
    }

    private Node deleteRec(Node node, int value) {
        // Value not found in the tree — nothing to do.
        if (node == null) {
            return null;
        }

        // Navigate left or right until we find the node to delete.
        if (value < node.value) {
            node.left = deleteRec(node.left, value);
        } else if (value > node.value) {
            node.right = deleteRec(node.right, value);
        } else {
            // Found the node to delete. There are three possible cases:

            // Case 1: No left child — just replace this node with its right child.
            if (node.left == null) {
                return node.right;
            }

            // Case 2: No right child — just replace this node with its left child.
            if (node.right == null) {
                return node.left;
            }

            // Case 3: Two children.
            // We can't simply remove this node, because we'd lose the subtrees.
            // The trick is to find the in-order successor — the smallest value in
            // the right subtree. That value can legally replace the deleted node
            // because it is:
            //   - larger than everything in the left subtree (BST rule satisfied)
            //   - smaller than everything else in the right subtree (BST rule satisfied)
            // Then we delete the successor from the right subtree, which is easier
            // because the successor has at most one child (it has no left child,
            // otherwise it wouldn't be the smallest).
            Node successor = node.right;
            while (successor.left != null) {
                successor = successor.left;
            }

            node.value = successor.value;
            node.right = deleteRec(node.right, successor.value);
        }

        return node;
    }

    /*
     * TRAVERSALS
     *
     * A traversal visits every node in a specific order and collects the values.
     * Each order has a different use case:
     *
     *   In-order   (left → current → right): gives values in ascending sorted order
     *   Pre-order  (current → left → right): visits the root first — useful for copying a tree
     *   Post-order (left → right → current): visits children before the parent — useful for deleting a tree
     *
     * All three use the same recursive pattern: visit left subtree, do something
     * with the current node, visit right subtree — just in a different order.
     */

    public List<Integer> inOrder() {
        List<Integer> result = new ArrayList<>();
        inOrderRec(root, result);
        return result;
    }

    private void inOrderRec(Node node, List<Integer> result) {
        if (node == null) {
            return;
        }
        inOrderRec(node.left, result);
        result.add(node.value);
        inOrderRec(node.right, result);
    }

    public List<Integer> preOrder() {
        List<Integer> result = new ArrayList<>();
        preOrderRec(root, result);
        return result;
    }

    private void preOrderRec(Node node, List<Integer> result) {
        if (node == null) {
            return;
        }
        result.add(node.value);
        preOrderRec(node.left, result);
        preOrderRec(node.right, result);
    }

    public List<Integer> postOrder() {
        List<Integer> result = new ArrayList<>();
        postOrderRec(root, result);
        return result;
    }

    private void postOrderRec(Node node, List<Integer> result) {
        if (node == null) {
            return;
        }
        postOrderRec(node.left, result);
        postOrderRec(node.right, result);
        result.add(node.value);
    }

    /*
     * HEIGHT
     *
     * The height is the number of levels in the tree (a single node has height 1).
     * We find it by recursively asking: what is the height of my left subtree, and
     * what is the height of my right subtree? The height of this node is 1 + whichever
     * subtree is taller. A null node contributes 0, which is our base case.
     */
    public int height() {
        return heightRec(root);
    }

    private int heightRec(Node node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = heightRec(node.left);
        int rightHeight = heightRec(node.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public boolean isEmpty() {
        return root == null;
    }
}
