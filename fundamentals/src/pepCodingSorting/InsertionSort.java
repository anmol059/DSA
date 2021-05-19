package pepCodingSorting;

public class InsertionSort {
	public static void main(String[] args) {
		int arr[] = { 8, 6, 7, 5, 3, 32, 96, 0, 7, 9, 5, 2, 1, 3 };
		insertionSort(arr);
		for (int i : arr) {
			System.out.println(i);
		}
	}

	private static void insertionSort(int[] arr) {
		// TODO Auto-generated method stub
		for(int i = 0; i < arr.length - 1; i++) {
			for(int j = i + 1; j > 0; j--) {
				if(arr[j] < arr[j - 1]) {
					//swap
					int temp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = temp;
				}else {
					break;
				}
			}
		}
	}   // if the array is sorted then it's best time complexity is o(n).
}
