import java.util.Scanner;
import java.math.*;

public class Q5 {

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		//Boolean triangle = false;
		
		double x1= 0.0, y1= 0.0; //Point A (x1,y1)
		double x2= 0.0, y2= 0.0; //Point B (x2,y2)
		double x3= 0.0, y3= 0.0; //Point C (x3,y3)
		double sideAB =0.0, sideBC =0.0, sideCA =0.0; //length of sides
		
		System.out.print("Point A: ");
		x1 = input.nextInt(); y1 =input.nextInt();
		System.out.print("Point B: ");
		x2 = input.nextInt(); y2 =input.nextInt();
		System.out.print("Point C: ");
		x3 = input.nextInt(); y3 =input.nextInt();
		
		System.out.println(" ");

		sideAB= (double) (Math.sqrt( Math.pow((x2-x1),2) + Math.pow((y2-y1),2)) ) ;
		sideBC= (double) (Math.sqrt( Math.pow((x3-x2),2) + Math.pow((y3-y2),2)) ) ;
		sideCA= (double) (Math.sqrt( Math.pow((x1-x3),2) + Math.pow((y1-y3),2)) ) ;
		
		System.out.println("Side AB: "+ sideAB);
		System.out.println("Side BC: "+ sideBC);
		System.out.println("Side CA: "+ sideCA);
		
		if( (sideAB + sideBC) > sideCA && 
			(sideBC + sideCA) > sideAB &&(sideCA + sideAB) > sideBC )
		{
			//triangle = true;
			System.out.println("This IS a Triangle");
		}
		else
		{
			//triangle =false;
			System.out.println("This is NOT a Triangle");
		}
			 
		input.close();
	}
	
}
