import java.util.Scanner;

public class Q1
{
        public static void main(String[] args)
        {
                Scanner input = new Scanner(System.in);
                int levels = 0;
                int i = 0;
                int spaces = 0;
                int templvl=0;

                System.out.println("How tall would you like your pyramid?");
                levels = input.nextInt();
                templvl=levels;
              
                for(i=1; i<=levels; i++)
                {
                	spaces = templvl*2 + (templvl+2);
                	
                    String format = "%"+ spaces +"s";
                    System.out.printf(format,"");

                    for(int j=1; j<=i; j++)
                    {
                        if(j<10)
                        {
                        	if(j==i)
                        		System.out.print(" "+j+"  ");
                        	else
                        		System.out.printf(j+"  ");
                        }
                        
                        if(j==10 && i==10)
                        	System.out.printf(j+"  ");
                        	
                        if(j>=10 && i >10)
                        	System.out.print(j+" ");
                    }
                    
                    for(int k=i-1; k>=1; k--)
                    {
                        if(k<=10)
                        	System.out.print(k+"  ");
                        else
                        	System.out.printf(k+" ");
                    }
                    
                    templvl--;
                    System.out.println();
               }
                
               input.close();
        }
}
