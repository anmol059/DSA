 package pepCodingSorting;

import java.io.*;
import java.util.*;

public class CountSort {

	public static void countSort(int[] arr, int min, int max) {
		// write your code here
		int range = max - min;
		int freq[] = new int[range + 1];
		
		for(int i = 0; i < arr.length; i++) {
			int index = arr[i] - min;  // this is done to save the space suppose we are given the min element it's frequency will come in 0th index
			freq[index]++;
		}
		
		// we will make the frequency array as prefix sum frequency array
		for(int i = 1; i < freq.length; i++) {
			freq[i] += freq[i - 1];
		}
		
		// this algo is not inplace algorithm when we try to maintain the stability
		int[] ans = new int[arr.length];
		for(int i = arr.length - 1; i >= 0; i--) {
			int val = arr[i];
			int pos = freq[val - min];
			int index = pos - 1;
			ans[index] = val;
			freq[val - min]--;
		}
		
		for(int i = 0; i < arr.length; i++){
		    arr[i] = ans[i];
		}
	}

	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public static void main(String[] args) throws Exception {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
			max = Math.max(max, arr[i]);
			min = Math.min(min, arr[i]);
		}
		countSort(arr, min, max);
		print(arr);
	}

}