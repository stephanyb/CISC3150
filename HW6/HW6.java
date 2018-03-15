import java.util.Scanner;

public class HW6 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int arr[];
		int N_queens = 0;
		int row = 0;
		
		System.out.println("Enter Number of Queens: ");
		
		N_queens = input.nextInt();
		arr = new int[N_queens];		
		
		PlaceQueens(arr,row,N_queens);
		
		input.close();
	}
	
	public static void PlaceQueens(int[] arr, int row, int N_queens)
	{
		for(int col = 0; col < N_queens; col++)
		{
			if(isPlaceable(arr, row, col))
			{
				arr[row] = col;
				
				if(row == arr.length-1)//Places one queen per row and prints the current row
				{
					//System.out.println("In print");
					for(int i = 0; i<arr.length; i++)
					{
						for(int j = 0; j<arr.length; j++)
						{
							if(arr[i] == j )
								System.out.print(" Q ");
							else
								System.out.print(" x ");
						}
						
						System.out.println();
					}
					System.out.println();
				}
				
				else;
					PlaceQueens(arr,row+1,N_queens);//recursive call
			}
		}
	}
	
	public static boolean isPlaceable(int[] arr,int row, int col){
		
		for(int i =0; i < row; i++)
		{
			//checks to see if a Queen can be placed in current row, returns true if possible
			if( arr[i] == col || (i-row)==(arr[i]-col) || (i-row)==(col-arr[i]) )
			{
				return false;
			}
		}
		
		return true;
	}
	
	
}



/*
 * Citation1: https://www.geeksforgeeks.org/backtracking-set-3-n-queen-problem/
 * Citation2: https://stackoverflow.com/questions/35371519/n-queens-puzzle-in-java-with-1d-array
 * Used to understand logic of backtracking and how it related to this problem
 */
