import java.io.*;
import java.util.*;

public class MinCostPathTraversal {

	public static void main(String[] args) throws Exception {
		// write your code here
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int arr[][] = new int[n][m];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		System.out.println(minCostIterative(arr));
		
		// recursive call
//		System.out.println(minCostTraversalRecursive(arr, 0, 0));

		// changes for memorization
//		int dp[][] = new int[n + 1][m + 1];
//		for (int i = 0; i < n + 1; i++) {
//			for (int j = 0; j < m + 1; j++) {
//				dp[i][j] = Integer.MIN_VALUE;
//			}
//		}
//		System.out.println(minCostTraversal(arr, 0, 0, dp));

	}

	private static int minCostTraversalRecursive(int[][] arr, int row, int col) {
		// Recursive code
		if (row == arr.length - 1 && col == arr[0].length - 1) {
			return arr[row][col];
		}
		if (row >= arr.length || col >= arr[0].length) {
			return Integer.MAX_VALUE;
		}

		int hm = minCostTraversalRecursive(arr, row, col + 1);
		int vm = minCostTraversalRecursive(arr, row + 1, col);

		return arr[row][col] + Math.min(hm, vm);
	}

	public static int minCostTraversal(int arr[][], int row, int col, int dp[][]) {
		// Memorization
		if (row == arr.length - 1 && col == arr[0].length - 1) {
			// base case unclear
			return arr[row][col];
		}
		if (row >= arr.length || col >= arr[0].length) {
			return Integer.MAX_VALUE;
		}

		int hm = 0;
		int vm = 0;

		if (dp[row][col + 1] == Integer.MIN_VALUE) {
			hm = minCostTraversal(arr, row, col + 1, dp);
			dp[row][col + 1] = hm;
		} else {
			hm = dp[row][col + 1];
		}

		if (dp[row + 1][col] == Integer.MIN_VALUE) {
			vm = minCostTraversal(arr, row + 1, col, dp);
			dp[row + 1][col] = vm;
		} else {
			vm = dp[row + 1][col];
		}

		return arr[row][col] + Math.min(hm, vm);
	}
	
	public static int minCostIterative(int arr[][]) {
		int dp[][] = new int[arr.length][arr[0].length];
		for(int i = dp.length - 1; i >= 0; i--) {
			for(int j = dp[0].length - 1; j >= 0; j--) {
				if(i == dp.length - 1 && j == dp[0].length - 1) {
					dp[i][j] = arr[i][j]; 
				}
				else if(i == dp.length - 1) {
					dp[i][j] = arr[i][j] + dp[i][j + 1];
				}else if(j == dp[0].length - 1) {
					dp[i][j] = arr[i][j] + dp[i + 1][j];
				}else {
					dp[i][j] = arr[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
				}
			}
		}
		return dp[0][0];
	}

}
