package org.example.dsa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {

    private org.example.dsa.MergeSort sorter;

    @BeforeEach
    void setUp() {
        sorter = new org.example.dsa.MergeSort();
    }

    @Test
    void sortRandomArray() {
        int[] arr = {5, 3, 8, 1, 2};
        sorter.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 5, 8}, arr);
    }

    @Test
    void sortAlreadySorted() {
        int[] arr = {1, 2, 3, 4, 5};
        sorter.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    void sortReverseSorted() {
        int[] arr = {5, 4, 3, 2, 1};
        sorter.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    void sortAllSameElements() {
        int[] arr = {7, 7, 7, 7};
        sorter.sort(arr);
        assertArrayEquals(new int[]{7, 7, 7, 7}, arr);
    }

    @Test
    void sortEmptyArray() {
        int[] arr = {};
        sorter.sort(arr);
        assertArrayEquals(new int[]{}, arr);
    }

    @Test
    void sortSingleElement() {
        int[] arr = {42};
        sorter.sort(arr);
        assertArrayEquals(new int[]{42}, arr);
    }

    @Test
    void mergeTwoSortedArrays() {
        int[] merged = sorter.merge(new int[]{1, 3, 5}, new int[]{2, 4, 6});
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, merged);
    }

    @Test
    void mergeWithEmptyLeft() {
        int[] merged = sorter.merge(new int[]{}, new int[]{1, 2, 3});
        assertArrayEquals(new int[]{1, 2, 3}, merged);
    }
}
