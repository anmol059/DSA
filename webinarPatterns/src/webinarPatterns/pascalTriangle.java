package webinarPatterns;
import java.util.Scanner;
public class pascalTriangle {
	
	public static int fac(int n)
	{
		int ans = 1;
		for(int i = 2; i <= n; i++)
		{
			ans *= i;
		}
		return ans;
	}
	
	public static int com(int n, int r)
	{
		int nfac = fac(n);
		int nrfac = fac(n - r);
		int rfac = fac(r);
		
		return nfac/(nrfac * rfac);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j <= i; j++)
			{
				System.out.print(com(i,j));
			}
			System.out.println();
		}
	}

}
