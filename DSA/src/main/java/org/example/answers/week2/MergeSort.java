package org.example.answers.week2;

public class MergeSort {

    public void sort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }

        int mid = arr.length / 2;

        // Split the array into two halves
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        for (int i = 0; i < left.length; i++) {
            left[i] = arr[i];
        }
        for (int i = 0; i < right.length; i++) {
            right[i] = arr[mid + i];
        }

        // Sort each half recursively
        sort(left);
        sort(right);

        // Merge the two sorted halves back into the original array
        int[] merged = merge(left, right);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = merged[i];
        }
    }

    public int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int leftIndex = 0;
        int rightIndex = 0;
        int resultIndex = 0;

        // Pick the smaller element from the front of each array, one at a time
        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] <= right[rightIndex]) {
                result[resultIndex] = left[leftIndex];
                leftIndex++;
            } else {
                result[resultIndex] = right[rightIndex];
                rightIndex++;
            }
            resultIndex++;
        }

        // Copy any remaining elements from the left array
        while (leftIndex < left.length) {
            result[resultIndex] = left[leftIndex];
            leftIndex++;
            resultIndex++;
        }

        // Copy any remaining elements from the right array
        while (rightIndex < right.length) {
            result[resultIndex] = right[rightIndex];
            rightIndex++;
            resultIndex++;
        }

        return result;
    }
}
