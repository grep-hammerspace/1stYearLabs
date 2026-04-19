package org.example.dsa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    private org.example.answers.BinarySearch bs;
    private final int[] arr = {1, 3, 5, 7, 9, 11, 13, 15};

    @BeforeEach
    void setUp() {
        bs = new org.example.answers.BinarySearch();
    }

    @Test
    void foundAtStart() {
        assertEquals(0, bs.search(arr, 1));
    }

    @Test
    void foundAtEnd() {
        assertEquals(7, bs.search(arr, 15));
    }

    @Test
    void foundInMiddle() {
        assertEquals(3, bs.search(arr, 7));
    }

    @Test
    void notFoundReturnsMinusOne() {
        assertEquals(-1, bs.search(arr, 4));
    }

    @Test
    void emptyArrayReturnsMinusOne() {
        assertEquals(-1, bs.search(new int[]{}, 5));
    }

    @Test
    void singleElementFound() {
        assertEquals(0, bs.search(new int[]{42}, 42));
    }

    @Test
    void singleElementNotFound() {
        assertEquals(-1, bs.search(new int[]{42}, 99));
    }

    @Test
    void recursiveMatchesIterative() {
        for (int target : new int[]{1, 7, 15, 4}) {
            assertEquals(
                bs.search(arr, target),
                bs.searchRecursive(arr, target, 0, arr.length - 1)
            );
        }
    }
}
