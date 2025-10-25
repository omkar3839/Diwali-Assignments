package com.demo.test;
import java.util.Arrays;

import com.demo.service.Quicksort;

public class TestQuickSort {


	
	    public static void main(String[] args) {
	        String[] arr = { "banana", "apple", "grape", "mango", "cherry" };

	        System.out.println("Before sorting: " + Arrays.toString(arr));
	        Quicksort.quickSort(arr, 0, arr.length - 1);
	        System.out.println("After sorting: " + Arrays.toString(arr));
	    
	}


}
