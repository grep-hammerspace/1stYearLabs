package org.example.dsa.week2;

import java.util.Arrays;

public class MergeSort {

    /** Sorts arr in ascending order in-place. */
    public void sort(int[] arr) {
        if (arr.length <=1){
            //List is one element long
            return;
        }

        int mid = (arr.length/2);
        int[] left  = new int[mid];
        int[]right = new int[arr.length-mid];

        // Copy data into left and right arrays
        for (int i = 0;i < left.length;i++){
            left[i] = arr[i];
        }

        for (int i = 0; i < right.length; i++) {
            right[i] = arr[mid + i];
        }

        //Sort each half
        sort(left);
        sort(right);

        // Merge the two sorted halves back into the original array
        int[] merged = merge(left, right);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = merged[i];
        }
    }

    /** Merges two sorted arrays into a new sorted array. */
    public int[] merge(int[] left, int[] right) {
        int[] mergeResult = new int[left.length + right.length];

        int i = 0,j =0, k = 0;

        while (i < left.length && j < right.length){
            // We will exit when we reach the last element in the shorter array.
            if (left[i] < right[j]){
                mergeResult[k] = left[i];
                i +=1;
            }else {
                mergeResult[k] = right[j];
                j +=1;
            }
            k +=1;
        }

        // Copy over leftover elements directly as everything else is already sorted.
        while (i < left.length) mergeResult[k++] = left[i++];
        while (j < right.length) mergeResult[k++] = right[j++];

        return mergeResult;



    }
}
