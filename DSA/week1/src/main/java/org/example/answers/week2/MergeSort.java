package org.example.answers.week2;

public class MergeSort {

    // Sorts in-place by mutating the original array at the end of each call.
    // We copy into left/right sub-arrays so each half can be sorted independently,
    // then we merge them back — this is the classic divide-and-conquer pattern
    // that gives O(n log n) time at the cost of O(n) extra space.
    public void sort(int[] arr) {
        if (arr.length <= 1) return; // Base case: a single element is already sorted.
        int mid = arr.length / 2;
        int[] left = new int[mid];
        // right gets arr.length - mid so odd-length arrays are handled correctly.
        int[] right = new int[arr.length - mid];
        System.arraycopy(arr, 0, left, 0, mid);
        System.arraycopy(arr, mid, right, 0, arr.length - mid);
        sort(left);
        sort(right);
        int[] merged = merge(left, right);
        // Write the merged result back into the original array so the caller sees it.
        System.arraycopy(merged, 0, arr, 0, arr.length);
    }

    // Merges two already-sorted arrays into one sorted array.
    // We walk both arrays simultaneously, always picking the smaller front element.
    public int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;
        // Compare heads of both arrays and take the smaller one each step.
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) result[k++] = left[i++];
            else result[k++] = right[j++];
        }
        // One array may still have leftover elements — append them directly since
        // they are already sorted and all larger than everything merged so far.
        while (i < left.length) result[k++] = left[i++];
        while (j < right.length) result[k++] = right[j++];
        return result;
    }
}
