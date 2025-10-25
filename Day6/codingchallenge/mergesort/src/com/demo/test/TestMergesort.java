package com.demo.test;

import java.util.Arrays;

import com.demo.service.MergeSortAlgorithm;



public class TestMergesort {

	public static void main(String[] args) {
		int[] arr= {5,7,3,10,6,4};
		MergeSortAlgorithm.mergeSort(arr, 0,arr.length-1);
		System.out.println("final array : "+Arrays.toString(arr));

	}

}
