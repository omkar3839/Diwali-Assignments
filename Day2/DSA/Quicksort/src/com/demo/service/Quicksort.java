package com.demo.service;

import java.util.Arrays;

public class Quicksort {

    // Partition method for String array
    public static int partition(String[] arr, int start, int end) {
        int pivot = start;
        int i = start;
        int j = end;

        while (i < j) {
            // Increment i while element <= pivot
            while (i < end && arr[i].compareTo(arr[pivot]) <= 0) {
                i++;
            }

            // Decrement j while element > pivot
            while (j > pivot && arr[j].compareTo(arr[pivot]) > 0) {
                j--;
            }

            // Swap arr[i] and arr[j] if i < j
            if (i < j) {
                String temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap pivot and arr[j]
        String temp = arr[pivot];
        arr[pivot] = arr[j];
        arr[j] = temp;

        System.out.println(Arrays.toString(arr));
        System.out.println("Pivot position: " + j + ", Pivot value: " + arr[j]);
        System.out.println(j + " swapped with " + pivot);
        return j;
    }

    // QuickSort method
    public static void quickSort(String[] arr, int start, int end) {
        if (start < end) {
            int p = partition(arr, start, end);
            quickSort(arr, start, p - 1);
            quickSort(arr, p + 1, end);
        }
    }

   
    
}
