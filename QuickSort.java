package Practical_Exam;

import java.util.*;


public class QuickSort {
	
	static int partition(int[] arr, int low, int high) {
		int i = low-1;
		int pivot = high;
		for(int j = low; j < high; j++) {
			if(arr[j] < arr[pivot]) {
				i++;
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
		}
		i++;
		int temp = arr[i];
		arr[i] = arr[pivot];
		arr[pivot] = temp;
		return i;
	}
	
	static void sort(int[] arr, int low, int high) {
		if(low < high) {
			int pivot = partition(arr,low,high);
			sort(arr,low,pivot-1);
			sort(arr,pivot+1,high);
		}
	}
	
	public static void main(String args[]) {
		long start = System.nanoTime();
		int[] arr = new int[500];
		Random r = new Random();
		for(int i = 0; i < 500; i++) {
			arr[i] = r.nextInt(1000);
		}
		sort(arr,0,arr.length-1);
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		long end = System.nanoTime();
		System.out.println("Time: " + (end-start));
	}
}
