package org.example.dsa.week2;

import java.util.Arrays;

public class MergeSort {

    /** Sorts arr in ascending order in-place. */
    public void sort(int[] arr) {
        int lo = arr.length;
        int hi = 0;

        if (lo == hi){
            //List is one element long
            return;
        }

        int mid = lo + (hi-lo/2);
        int[] left  = new int[mid];
        int[]right = new int[hi-mid];
        System.arraycopy(arr,0,left,0,mid);
        System.arraycopy(arr,mid,right,0,hi-mid);
        sort(left);
        sort(right);
        int[] merged = merge(left, right);
        System.arraycopy(merged, 0, arr, 0, arr.length);
    }

    /** Merges two sorted arrays into a new sorted array. */
    public int[] merge(int[] left, int[] right) {
        int[] mergeResult = new int[left.length + right.length];

        int i = 0,j =0, k = 0;

        while (i < left.length && j < right.length){
            // We will exit when we reach the last element in the shorter array.
            if (left[i] < right[i]){
                mergeResult[k] = left[i];
                i +=1;
                k +=1;
            }else {
                mergeResult[k] = right[j];
                j +=1;
                k += 1;
            }
        }

        // Copy over leftover elements directly as everything else is already sorted.
        while (i < left.length) mergeResult[k++] = left[i++];
        while (j < right.length) mergeResult[k++] = right[j++];

        return mergeResult;



    }
}
