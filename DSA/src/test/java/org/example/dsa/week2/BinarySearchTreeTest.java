package org.example.dsa.week2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    private org.example.dsa.week2.BinarySearchTree bst;

    @BeforeEach
    void setUp() {
        bst = new org.example.dsa.week2.BinarySearchTree();
    }

    // Helper: build the reference tree [4,2,6,1,3,5,7]
    private void buildTree() {
        for (int v : new int[]{4, 2, 6, 1, 3, 5, 7}) bst.insert(v);
    }

    @Test
    void isEmptyOnNew() {
        assertTrue(bst.isEmpty());
    }

    @Test
    void notEmptyAfterInsert() {
        bst.insert(5);
        assertFalse(bst.isEmpty());
    }

    @Test
    void insertAndSearch() {
        buildTree();
        assertTrue(bst.search(4));
        assertTrue(bst.search(1));
        assertTrue(bst.search(7));
    }

    @Test
    void searchMissingReturnsFalse() {
        buildTree();
        assertFalse(bst.search(99));
    }

    @Test
    void inOrderIsSorted() {
        buildTree();
        assertEquals(List.of(1, 2, 3, 4, 5, 6, 7), bst.inOrder());
    }

    @Test
    void heightOfEmptyIsZero() {
        assertEquals(0, bst.height());
    }

    @Test
    void heightOfSingleNodeIsOne() {
        bst.insert(10);
        assertEquals(1, bst.height());
    }

    @Test
    void heightOfBalancedTree() {
        buildTree();
        assertEquals(3, bst.height());
    }

    @Test
    void deleteLeafNode() {
        buildTree();
        bst.delete(1);
        assertFalse(bst.search(1));
        assertEquals(List.of(2, 3, 4, 5, 6, 7), bst.inOrder());
    }

    @Test
    void deleteNodeWithOneChild() {
        // Build: insert 4, 2, 3 — node 2 has only a right child (3)
        bst.insert(4);
        bst.insert(2);
        bst.insert(3);
        bst.delete(2);
        assertFalse(bst.search(2));
        assertTrue(bst.search(3));
        assertTrue(bst.search(4));
    }

    @Test
    void deleteNodeWithTwoChildren() {
        buildTree();
        bst.delete(6);
        assertFalse(bst.search(6));
        // Tree should still be a valid BST
        List<Integer> inOrder = bst.inOrder();
        assertEquals(List.of(1, 2, 3, 4, 5, 7), inOrder);
    }

    @Test
    void deleteRootNode() {
        buildTree();
        bst.delete(4);
        assertFalse(bst.search(4));
        // Remaining nodes still searchable
        assertTrue(bst.search(2));
        assertTrue(bst.search(6));
    }

    @Test
    void levelOrderEmptyTree() {
        assertEquals(List.of(), bst.levelOrder());
    }

    @Test
    void levelOrderSingleNode() {
        bst.insert(10);
        assertEquals(List.of(10), bst.levelOrder());
    }

    @Test
    void levelOrderBalancedTree() {
        buildTree();
        assertEquals(List.of(4, 2, 6, 1, 3, 5, 7), bst.levelOrder());
    }
}
