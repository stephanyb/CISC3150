import java.util.SplittableRandom;

public class version2 {

	public static void main(String[] args) {
		long before = System.currentTimeMillis();
		
		SplittableRandom rand = new SplittableRandom();		

		double x = 0.0, y = 0.0;//coordinate points
		long dots_in_circle = 0L;//Includes points on the perimeter of the circle
		long dots_in_square = 0L;

		long i = 0L;
		double pi = 0.0;
		
		for(i= 4000000000L; --i >= 0;)
		{	
			//Generating numbers from 0 to radius(2)
			x = rand.nextDouble(2.0);
			y = rand.nextDouble(2.0);
			
			if( (Math.pow(x,2)+Math.pow(y,2)) <= 2)
				dots_in_circle++;

			dots_in_square++;
		}
		
		//calculating pi
		pi = (2* 4.0) * ((double)dots_in_circle)/(dots_in_square);
		System.out.println("Estimated Value of Pi: "+ pi);
		
		System.out.println(System.currentTimeMillis()-before);
	}
	
}
