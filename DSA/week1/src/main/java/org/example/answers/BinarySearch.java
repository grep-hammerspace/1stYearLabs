package org.example.answers;

public class BinarySearch {

    // Requires a sorted array. Each iteration halves the search space, giving O(log n) time.
    public int search(int[] arr, int target) {
        int lo = 0, hi = arr.length - 1;
        while (lo <= hi) {
            // Use lo + (hi - lo) / 2 instead of (lo + hi) / 2 to avoid integer overflow when lo and hi are both large.
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == target) return mid;
            // Target must be in the right half, so discard everything up to and including mid.
            if (arr[mid] < target) lo = mid + 1;
            // Target must be in the left half.
            else hi = mid - 1;
        }
        // lo > hi means the search space is empty — target is not present.
        return -1;
    }

    // Same logic as the iterative version, but expressed recursively.
    // lo/hi are passed explicitly so we never need to copy or slice the array.
    public int searchRecursive(int[] arr, int target, int lo, int hi) {
        // Base case: empty search space.
        if (lo > hi) return -1;
        int mid = lo + (hi - lo) / 2;
        if (arr[mid] == target) return mid;
        if (arr[mid] < target) return searchRecursive(arr, target, mid + 1, hi);
        return searchRecursive(arr, target, lo, mid - 1);
    }
}
