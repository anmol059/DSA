/* 
for n = 5
 	1	2	3	4	5
 	11	12	13	14	15
 	21	22	23	24	25
 	16	17	18	19	20
 	6	7	8	9	10
 	
 for n = 4
 	1	2	3	4
 	9	10	11 	12
 	13	14	15	16
 	5 	6	7	8
*/

package webinarPatterns;
import java.util.Scanner;
public class randomPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int row = s.nextInt();
		int index = 0;
		int i;
		for(i = 1; i <= (row / 2) + 1; i++)
		{
			int count = 1;
			for(int j = row * index + 1; count <= row; j++)
			{
				System.out.print(j + "\t");
				count++;
			}
			index += 2;
			System.out.println();
		}
		if(i == (row / 2) + 2)
		{
			index -= 3;
		}
		for(i = (row / 2) + 2; i <= row; i++)
		{
			int count = 1;
			for(int j = row * index + 1; count <= row; j++)
			{
				System.out.print(j + "\t");
				count++;
			}
			index -= 2;
			System.out.println();
		}
	}
}
