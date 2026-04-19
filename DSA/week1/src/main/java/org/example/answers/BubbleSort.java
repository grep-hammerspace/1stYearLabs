package org.example.answers;

public class BubbleSort {

    // After each outer pass i, the i largest elements have bubbled to their final
    // positions at the end of the array, so the inner loop only needs to go up to
    // arr.length - 1 - i (no need to re-compare already-sorted tail).
    public void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j]; arr[j] = arr[j + 1]; arr[j + 1] = tmp;
                    swapped = true;
                }
            }
            // Early exit: if no swaps happened the array is already sorted,
            // so there's no point doing more passes (best-case O(n)).
            if (!swapped) break;
        }
    }

    // Same as sort() but we swap when the left element is SMALLER, so larger values
    // sink to the right first instead of bubbling up — producing descending order.
    public void sortDescending(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] < arr[j + 1]) {
                    int tmp = arr[j]; arr[j] = arr[j + 1]; arr[j + 1] = tmp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }
}
