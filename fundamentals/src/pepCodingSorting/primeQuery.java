package pepCodingSorting;

public class primeQuery {
	
	public static void main(String[] args) {
//		constraint is arr[i] < 40;
		
		int arr[] = new int[1000000000];
		boolean isPrime[] = new boolean[40];
		
		for(int i = 0; i < isPrime.length; i++) {
			isPrime[i] = isNumPrime(i);
		}
		
		for(int i = 0; i < arr.length; i++) {
			if(isPrime[arr[i]]) {
				System.out.println("true");
			}else {
				System.out.println("false");
			}
		}
	}

	private static boolean isNumPrime(int num) {
		// TODO Auto-generated method stub
		for(int i = 2; i * i <= num; i++) {
			if(num % i == 0) {
				return false;
			}
		}
		return true;
	}
}
