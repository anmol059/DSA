package functions;

import java.util.Scanner;

public class SubArrays {
	public static void printSubArray(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				for (int k = i; k <= j; k++) {
					System.out.print(arr[k] + "\t");
				}
				System.out.println();
			}
		}
		// my basic approach came with taking the help of the strings
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		printSubArray(arr);
		sc.close();
	}
}
