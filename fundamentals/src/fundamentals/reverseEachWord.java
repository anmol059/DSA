package fundamentals;



public class reverseEachWord {

	public static String reverseEachWord(String str)
	{
		String ans = "";
		int currentWordStart = 0;
		int currentWordEnd = 0;
		int i = 0;
		for(; i < str.length(); i++)
		{
			String reversedWord = "";
			if(str.charAt(i) == ' ')
			{
				currentWordEnd = i - 1;
				for(int j = currentWordStart; j <= currentWordEnd; j++)
				{
					reversedWord = str.charAt(j) + reversedWord;
				}
				currentWordStart = i + 1;
				ans += reversedWord + " ";
			}
		}
		currentWordEnd = i - 1;
		String reversedWord = "";
		for(int k = currentWordStart; k <= currentWordEnd; k++)
		{
			reversedWord = str.charAt(k) + reversedWord;
		}
		ans += reversedWord;
		return ans;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "11224545465 6564";
//		System.out.println(reverseEachWord(str));
//		System.out.println(str);
//		System.out.println(Math.max(str.charAt(3), str.charAt(4)) - 48);
		char a = (char)48;
		System.out.println(a);
	}

}
