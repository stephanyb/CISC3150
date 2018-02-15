import java.util.Scanner;

public class Q3 {

	public static void main(String[] args) {
		Scanner input =  new Scanner(System.in);
		String word = " ";
		String tmpWord= " ";
		
		System.out.println("Please Enter a Word: ");
		word = input.next();
		
		//word = word.toLowerCase();//In the case that Capitalization does not matter
		
		
		tmpWord = new StringBuilder(word).reverse().toString();
			
		if(word.equals(String.valueOf(tmpWord)))
			System.out.println(word + " is a Palindrome");
		else
			System.out.println(word + " is NOT a Palindrome");
		
		input.close();
	
	}
	
	/*
	*Citation:https://stackoverflow.com/questions/15249754/palindrome-checker-using-stringbuilder 
	*Reference to how to use the StringBuilder class 
	*/
}
