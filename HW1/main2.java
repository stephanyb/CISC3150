import java.util.Scanner;
import java.lang.Math;

public class Q2 
{
	public static void main(String[] args)
	{
		double area = 0.0, radius = 0.0;
		Scanner input = new Scanner(System.in);
		
		while(input.hasNextLine())
		{
		radius = input.nextDouble();
		area = CalcR(radius);
		
		System.out.println(area);
		
		}
		input.close();
	}
	public static double CalcR(double num)
	{
		num = (Math.PI)*Math.pow(num , 2.0);
		return num;
	}
	
}											
