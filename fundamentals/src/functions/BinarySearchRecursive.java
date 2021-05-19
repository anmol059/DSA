package functions;

public class BinarySearchRecursive {

	public static boolean binarySearchRecur(int[] arr, int si, int ei, int data) {
		if (si > ei) {
			return false;
		}
		boolean res = false;
		int mid = (si + ei)/2;
		if (arr[mid] == data) {
			res = true;
		} else if (arr[mid] < data) {
			// right call
			res = binarySearchRecur(arr, mid + 1, ei, data);
		} else {
			// left call
			res = binarySearchRecur(arr, si, mid - 1, data);
		}
		return res;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 5, 6, 7, 8, 9, 10, 15, 16 };
		int data = 1;
		System.out.println(binarySearchRecur(arr, 0, arr.length - 1, data));
	}
}
