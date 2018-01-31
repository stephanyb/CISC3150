import java.util.Random;

public class Q3 {

	public static void main(String[] args) 
	{
		String months[] = {"January","February","March",
				"April","May","June","July","August","September",
				"October","November","December"};
		int number = 0;
		Random rnum = new Random();
		
		number = rnum.nextInt(12)+1;
		
		System.out.println(number);
		System.out.println(months[number-1]);
	}

}
