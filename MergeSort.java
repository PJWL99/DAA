package Practical_Exam;

public class MergeSort {
	
	static void conquer(int[] arr, int low, int mid, int high) {
		int[] sorted = new int[(high-low)+1];
		int i = low;
		int j = mid+1;
		int k = 0;
		while(i<=mid && j <= high) {
			if(arr[i] < arr[j]) {
				sorted[k] = arr[i];
				k++;
				i++;
			}
			
			else {
				sorted[k] = arr[j];
				k++;
				j++;
			}
		}
		
			while(j<=high) {
				sorted[k] = arr[j];
				j++;
				k++;
			}
		
		
			while(i<=mid) {
				sorted[k] = arr[i];
				i++;
				k++;
			}
		
		
		for(int a = 0, b = low; a < sorted.length; a++, b++) {
			arr[b] = sorted[a];
		}
	}
	
	static void divide(int[] arr, int low, int high) {
		if(low<high) {
			int mid = (low+high)/2;
			divide(arr,low,mid);
			divide(arr,mid+1,high);
			conquer(arr,low,mid,high);
		}
	}
	
	public static void main(String args[]) {
		int[] arr = {8,5,4,2,3};
		int n = arr.length;
		divide(arr,0,n-1);
		for(int i = 0; i < n; i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
}
