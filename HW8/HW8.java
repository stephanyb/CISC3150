import java.io.File;
import java.util.*;

public class HW8{
	public static void main(String args[]){
		//String currentDir = "/Users/Stephany B/Documents/Spring 2018";
		Scanner input = new Scanner(System.in);
		String currentDir = "";

		System.out.println("Please enter a path (e.g C:/home/user/path) :");
		currentDir = input.nextLine();

		int spaces = 8;
		printDirectory(currentDir,spaces);
	}
	
	public static void printDirectory(String currentPath,int spaces)
	{
		File directory = new File(currentPath);
		File[] files = directory.listFiles();//creates an array of files

		String format = "%" + spaces + "s"; //for spacing each folder and sub-folder

		System.out.println(directory.getName());

		if(files == null)
		{			
			System.out.println("No Files");
			return;
		}
		
		for(int i=0; i < files.length; i++)
		{
			if(files[i].isDirectory())
			{
				String temp = files[i].getName();
				if(!temp.contains("."))//end of directory,no more subfolders
				{
					//System.out.printf(format,"|---");
					System.out.printf(format, "\u2502\u2500\u2500");

					printDirectory(files[i].getAbsolutePath(),spaces+2);
				}
			/*	else
				{
					if(spaces > 2)
					spaces = spaces - 2;
				}
			*/

			}
			if(spaces < 8)
				spaces-=2;
		}
	}
}
/*Sources:
 * 1. https://stackoverflow.com/questions/33437166/print-directory-like-tree-command
 * 2. https://www.geeksforgeeks.org/file-class-in-java/
 * 
 * Both sources were used to assist my understanding on how to use the File class in Java
 * and how to go about implementing the code to create the File tree. 
 *
 */

