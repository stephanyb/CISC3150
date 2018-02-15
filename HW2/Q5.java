import java.util.Scanner;

public class Q5 {
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		String str1 = "";//holds Tokenized strings
		String line = "";//holds complete input string
		
		System.out.println("Enter Comma Seperated Values: ");	
		
		
		line = input.next();//reads in entire string up until ""
		
		Scanner commaDel = new Scanner(line);//reads from the inputed string
		
		commaDel.useDelimiter(",");//reads up until a ','
		
		while(commaDel.hasNext())//reads strings from the string "line"
		{
			str1 = commaDel.next();
			System.out.println("Tokenized Str: " + str1 );
		}
				
		input.close();
		commaDel.close();
			
	}
	
}