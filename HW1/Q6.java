import java.util.*;

public class Q6 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		double distance = 0.0; //distance between both centers
		double centerX1 = 0.0, centerY1 = 0.0; //center coordinates of circle1
		double centerX2 = 0.0, centerY2 = 0.0; //center coordinates of circle2
		double radius1 = 0.0, radius2 = 0.0;
		
		System.out.print("Center 1 Coordinates: ");
		centerX1 = input.nextInt();
		centerY1 = input.nextInt();
		System.out.print("Center 2 Coordinates: ");
		centerX2 = input.nextInt();
		centerY2 = input.nextInt();
		
		System.out.print("Radius 1: ");
		radius1 = input.nextDouble();
		System.out.print("Radius 2: ");
		radius2 = input.nextDouble();
		System.out.println(" ");
		
		distance = Math.pow(( ((centerX2 - centerX1)*(centerX2 - centerX1)) + ((centerY2 - centerY1)*(centerY2 - centerY1)) ), 0.5);
		
		if(distance == (radius1+radius2))//touching
			System.out.println("Circles TOUCH");
		
		/*The following link was used for assistance for the distance versus radius1 and radius2 comparison 
		 * https://stackoverflow.com/questions/22032342/java-two-circles-overlap-or-inside
		*/
		
		else if( (distance <= (radius1 -radius2) && (radius1 >= radius2)) || ( (distance <= (radius2-radius1)) && (radius2 >= radius1)) 
				|| (distance == 0) || distance == radius1 || distance == radius2)
			System.out.println("Circles ARE WITHIN ONE ANOTHER"); //within one another
		else if( (distance < (radius1+radius2) && distance > (radius1-radius2))|| distance == radius1 || distance == radius2 )
			System.out.println("Circles OVERLAP"); //overlapping
		else if( (distance == radius1 && radius1 > radius2) || (distance == radius2 && radius2 > radius1) )
			System.out.println("Circles OVERLAP");
		
		else
			System.out.println("Circles ARE SEPARATE");
		
		input.close();
		
	}

}
