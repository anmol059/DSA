
public class printSubsequences {
	
	public static void printSubsequences(String str, String output) {
		if(str.length() == 0) {
			System.out.println(output);
			return;
		}
		
		printSubsequences(str.substring(1), output);
		printSubsequences(str.substring(1), output + str.charAt(0));
	}
	
	public static void printSubsequences(String str) {
		printSubsequences(str, "");
	}
	
	public static void main(String[] args) {
		printSubsequences("xyz");
	}

	
}
