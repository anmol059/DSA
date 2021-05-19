package pepCodingSorting;

public class SelectSort {
	public static void main(String[] args) {
		int arr[] = { 8, 6, 7, 5, 3, 32, 96, 0, 7, 9, 5, 2, 1, 3 };
		selectSort(arr);
		for (int i : arr) {
			System.out.println(i);
		}
	}

	private static void selectSort(int[] arr) {
		// TODO Auto-generated method stub

		/*
		 * for(int i = 0; i < arr.length; i++) { int min = arr[i]; for(int j = i + 1; j
		 * < arr.length; j++) { if(arr[j] < min) { int temp = arr[j]; arr[j] = min;
		 * arr[i] = temp; min = temp; } } }
		 */

		for (int i = 0; i < arr.length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			// swapping value at minIndex with value at i
			int temp = arr[minIndex];
			arr[minIndex] = arr[i];
			arr[i] = temp;
		}
	}
}
