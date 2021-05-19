package fundamentals;

public class palindromeString {
	
	public static boolean palindrome(String str)
	{
		int start = 0;
		int end = str.length() - 1;
		while(start < end)
		{
			if(str.charAt(start) != str.charAt(end))
			{
				return false;
			}
			start++;
			end--;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abgcgbaa";
		System.out.println(palindrome(str));
	}

}
