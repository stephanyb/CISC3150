import java.util.Scanner;

public class Q2 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String day = "";
		int year = 0;
		int spaces = 0;
		boolean leapYear = false;
		String months[] = {"","January", "February", "March",
							"April","May","June","July","August",
							"September","October","November","December"};
		int tot_days[]={0,31,28,31,30,31,30,31,31,30,31,30,31};//Days per month
														       //Not including leap years
		
		System.out.println("Choose a Year: ");
		year = input.nextInt();
		
		System.out.println("What day did the 1st of January fall on (type as mo,tu,we,etc): ");
		day = input.next(); //string value
		
		/*
		 * citation: https://en.wikipedia.org/wiki/Leap_year
		 * Testing to see if Year is a Leap Year
		 */
		if( ((year % 4 == 0) && (year%100 != 0)) || (year % 400 == 0) )//leap year occurs every four years
			leapYear = true;
		else 
			leapYear = false;
		
		if(leapYear == true)
			tot_days[2] = 29;//makes February 29 days long for the leap year
		
		switch(day)
		{
		case "su":
			spaces=0;
			break;
		case "mo":
			spaces=1;
			break;
		case "tu":
			spaces=2;
			break;
		case "we":
			spaces=3;
			break;
		case "th":
			spaces=4;
			break;
		case "fr":
			spaces=5;
			break;
		case "sa":
			spaces=6;
			break;
			
		default:
			System.out.println("Invalid Month, Please try again.");
			break;
		}
		
		for(int i=1; i<=12; i++)
		{			
			System.out.printf("%10s%5d\t\n", months[i],year);
			System.out.println("Su Mo Tu We Th Fr Sa");
			
			spaces = (tot_days[i-1]+spaces)%7;
			
			for(int k=0; k<spaces;k++)
			{
				System.out.printf("   ");//before numbers print 
			}
			
			for(int j=1; j<=tot_days[i]; j++)
			{
				System.out.printf("%2d ",j);
				
				if(((j + spaces) % 7 == 0) || (j == tot_days[i]))//to move onto next week  
					System.out.println();
			}
			System.out.println();
			
		}
			
		input.close();
	}
	/*
	 * Citation: https://introcs.cs.princeton.edu/java/21function/Calendar.java.html 
	 * Used as a reference and help in understanding the for loops logic.
	 */
	

}
