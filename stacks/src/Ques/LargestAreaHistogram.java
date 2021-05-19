package Ques;

import java.io.*;
import java.util.*;

public class LargestAreaHistogram {
	
	public static int[] leftSmallerIndex(int arr[]) {
		int res[] = new int[arr.length];
		Stack<Integer> st = new Stack<>();
		st.push(arr.length - 1);
		for(int i = arr.length - 2; i >= 0; i--) {
			while(st.size() > 0 && arr[i] < arr[st.peek()]) {
				res[st.pop()] = i;
			}
			st.push(i);
		}
		while(st.size() > 0) {
			res[st.pop()] = -1;
		}
		return res;
	}
	
	public static int[] rightSmallerIndex(int arr[]) {
		int res[] = new int[arr.length];
		Stack<Integer> st = new Stack<>();
		st.push(0);
		for(int i = 1; i < arr.length; i++) {
			while(st.size() > 0 && arr[i] < arr[st.peek()]) {
				res[st.pop()] = i;
			}
			st.push(i);
		}
		while(st.size() > 0) {
			res[st.pop()] = arr.length;
		}
		return res;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		// code
//		1. Next smaller left 
		int lsi[] = leftSmallerIndex(arr);
		int rsi[] = rightSmallerIndex(arr);
		
		int area = 0;
		
		for(int i = 0; i < arr.length; i++) {
			int width = rsi[i] - lsi[i] - 1;
			int height = arr[i];
			
			area = Math.max(area, width * height);
		}
		
		System.out.println(area);
		
	}
}