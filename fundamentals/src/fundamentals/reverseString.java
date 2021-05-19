package fundamentals;
//import java.util.Scanner;
public class reverseString {
	
	public static String reverseString(String str)
	{
		String reversedString = "";
		for(int i = 0; i < str.length(); i++)
		{
			reversedString = str.charAt(i) + reversedString;
		}
		return reversedString;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Scanner s = new Scanner(System.in);
		
		
		String str = "abcde";
		String reversedString = reverseString(str);
		System.out.println(reversedString);
	}

}
