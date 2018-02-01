import java.util.Scanner;

public class Q4 
{

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num=0;
		
		while(input.hasNextLine())
		{
			num = input.nextInt();
			System.out.println(num);
		}
		
		input.close();

	}

}
