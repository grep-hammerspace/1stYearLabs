package org.example.dsa;

public class BinarySearch {

    /** Iterative binary search. Returns index of target, or -1 if not found. */
    public int search(int[] arr, int target) {

        int hi = arr.length - 1;
        int lo = 0;

        while (lo <= hi) {
            int mid = (lo) + (hi - lo) / 2;
            if(arr[mid] > target){
                // the target is smaller than the middle, move the upper bound down
                hi = mid - 1 ;
            } else if (arr[mid] < target) {
                // the target is greater than the middle, move the lower bound up
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /** Recursive binary search. Returns index of target, or -1 if not found. */

}
