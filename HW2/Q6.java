import java.util.Scanner;

/*
 * Citation used for help:
 * https://stackoverflow.com/questions/28766377/how-do-i-use-a-delimiter-in-java-scanner
 * 
 * Explanation:
 *	In order to extract the individual characters, we should set the 
 *  delimiter to ".", which will return any Character which we then 
 *  assign to a char variable or simply print out as the follwing code 
 *  does: 
 */

public class Q6 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter a word to be Tokenized(then CTRL + Z to exit): ");
		
		while(input.hasNext())
		{
			char c = input.findInLine(".").charAt(0);
			System.out.println("Char:" + c);
		}
		
		input.close();
	}

}