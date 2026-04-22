package org.example.dsa.week1;

public class BubbleSort {

    /** Sorts arr in ascending order in-place. */
    public void sort(int[] arr) {
        for (int i =0; i < arr.length; i++){
            for (int j = 0;j < arr.length -1; j++){
                if (arr[j] > arr[j+1]){
                    // we are going to switch them
                    int greaterValue = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = greaterValue;
                }
            }
        }
    }

    /** Sorts arr in descending order in-place. */
    public void sortDescending(int[] arr) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
