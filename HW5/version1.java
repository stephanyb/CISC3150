import java.util.Random;

public class version1 {

	public static void main(String[] args) {
		long before = System.currentTimeMillis();
		
		Random rand = new Random();
		final long number_dots = 4000000000L;		
		
		double x = 0.0, y = 0.0;//coordinate points
		long dots_in_circle = 0L;//Includes points on the perimeter of the circle
		long dots_in_square = 0L;
		
		//double ratio = 0.0;
		double pi = 0.0;
		Long i = 0L;
		
		/*
		 * Square that covers the top right quadrant of the circle
		 * will cover an area of: r^2.
		 * Area of the top right quadrant will be (Pi*r^2)/4.
		 * 
		 * The ratio of the area of the top right quadrant of the circle
		 * to the area of the square that covers it would be: pi:4
		 */	
		
		for(i= 0L; i < number_dots; i++)
		{
			//generate random dots from 0 to radius 2
			x = 2.0* rand.nextDouble();
											//System.out.println(x);
			
			y = 2.0* rand.nextDouble();
											//System.out.println(y);
			
			//tests to see if dot falls within or on the circle
			if( ((x*x) + (y*y)) <= 2)
			{
				dots_in_circle++;
			}
			dots_in_square++;//any dots that do not fall within/on the circle
		}
		
		//ratio = (double)dots_in_circle / number_dots;
		
		//System.out.println("dots_in_circle: "+dots_in_circle);
		//System.out.println("dots_in_square: "+dots_in_square);
		//System.out.println("Ratio of (dots_in_circle/"+number_dots+") = "+ratio);
		
		
		//calculating pi
		pi = 4.0 * ((double)dots_in_circle)/(dots_in_square);
		System.out.println("Estimated Value of Pi: "+ 2*pi);
		
		System.out.println(System.currentTimeMillis()-before);
	}

}
