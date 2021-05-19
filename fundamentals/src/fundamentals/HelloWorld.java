package fundamentals;

import java.util.Scanner;

public class HelloWorld {
	public static void main(String[] args) {
		System.out.println("Hello World");
		
		Scanner s = new Scanner(System.in);
		String str = s.next();  // only takes one word of a line
		// taking full line as input
		str = s.nextLine();
		System.out.println(str);
		
		int a = s.nextInt();
		String str1 = s.next();
		System.out.print(a);
		System.out.println(str1);
	}
}
