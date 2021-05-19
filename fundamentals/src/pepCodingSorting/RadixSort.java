package pepCodingSorting;

import java.io.*;
import java.util.*;

public class RadixSort {

	public static void radixSort(int[] arr) {
		// write code here
		int max = Integer.MIN_VALUE;
		for (int i : arr) {
			if (i > max) {
				max = i;
			}
		}
		int exp = 1;
		while (exp <= max) {
			countSort(arr, exp);
			exp *= 10;
		}
	}

	public static void countSort(int[] arr, int exp) {
		// write code here
		int freq[] = new int[10];

		for (int i = 0; i < arr.length; i++) {
			int index = arr[i] / exp % 10; // this is done to save the space suppose we are given the min element it's
											// frequency will come in 0th index
			freq[index]++;
		}

		// we will make the frequency array as prefix sum frequency array
		for (int i = 1; i < freq.length; i++) {
			freq[i] += freq[i - 1];
		}

		// this algo is not inplace algorithm when we try to maintain the stability
		int[] ans = new int[arr.length];
		for (int i = arr.length - 1; i >= 0; i--) {
			int val = arr[i] / exp % 10;
			int pos = freq[val];
			int index = pos - 1;
			ans[index] = arr[i];
			freq[val]--;
		}

		for (int i = 0; i < arr.length; i++) {
			arr[i] = ans[i];
		}
		System.out.print("After sorting on " + exp + " place -> ");
		print(arr);
	}

	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) throws Exception {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		radixSort(arr);
		print(arr);
	}

}
