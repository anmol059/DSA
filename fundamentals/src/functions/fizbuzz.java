package functions;

public class fizbuzz {
	public static void  fizbuzzz(int n)
	{
		int c3 = 1; int c5 = 1;
		for(int i = 1; i <= n; i++)
		{
			boolean flag = false;
			if(c3 == 3)
			{
				System.out.print("fizz");
				c3 = 0;
				flag = true;
			}
			if(c5 == 5)
			{
				System.out.print("buzz");
				c5 = 0;
				flag = true;
			}
			if(!flag)
			{
				System.out.print(i);
			}
			c3++; c5++;
			System.out.println();
		}
	}
	public static void main(String[] args) 
	{ 
	    fizbuzzz(30);
	    return;
	} 
}
