import java.util.*;

class HW7{
	
	public static Stack<String> postfixExp = new Stack();
	public static void main(String args[]){
	try{
		String strExpression = new String();
		String[] expreArr = new String[args.length+2];//to accommodate for parenthesis
		
		expreArr[0] = new String("(");
		expreArr[args.length+1] = new String(")");
		
		for(int i = 1; i < args.length+1; i++)
		{
			expreArr[i] = new String(args[i-1]);
			
		}
		for(int j = 0; j<expreArr.length; j++)
		{
			strExpression += expreArr[j];
		}
		
		System.out.println(strExpression);//prints out expression as String
		toPostFix(expreArr);
		System.out.println(postfixExp);
		System.out.println("Answer: " +solveExp(postfixExp));
	}
	catch(Exception e){}
	
	}//end of main
	//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	public static void toPostFix(String[] expreArr) throws IllegalArgumentException
	{
		Stack<String> op = new Stack();
		Stack<String> temp = new Stack();
		String str = new String();
		
		for(int k = 0; k < expreArr.length; k++)
		{
			/*
			if(expreArr[k].equals("+")==false || expreArr[k].equals("-")==false ||
			   expreArr[k].equals("/")==false || expreArr[k].equals("x")==false ||
			   expreArr.equals("(")==false || expreArr.equals(")")==false)
			{
				throw new QuitMashingOnYourKeyBoardException();
			}
			*/
			if(expreArr[k].equals("+") || expreArr[k].equals("-") ||
					expreArr[k].equals("/") || expreArr[k].equals("x"))
			{
				if(op.isEmpty())
					op.add(expreArr[k]);
				else
				{
					if(precedence(op.peek()) > precedence(expreArr[k])
							&& !op.peek().equals("("))
					{
						temp.add(op.pop());
						op.add(expreArr[k]);
					}
					else
						op.add(expreArr[k]);
				}		
			}
			else if (expreArr[k].equals("(") )
			{
				op.add(expreArr[k]);//adds the current operation to the stack 
			}
			else if(expreArr[k].equals(")") )
			{
				boolean parenthesis = false;
				while(!parenthesis)
				{
					if(op.isEmpty())
                    			{
                        			throw new UserIsADumbAssException();
                    			}
                    			if(op.peek().equals("("))
                    			{
                        			op.pop();
                        			parenthesis = true;}
                    			else
                       			{
                        			temp.add(op.pop());
                      		 	}
					  			
				}
			}
			
			else
			{
				char[] test = expreArr[k].toCharArray();
				for(int l = 0; l< test.length; l++)
				{
					if(test[l]=='0' || test[l]=='1' || test[l]=='2' || test[l]=='3' || test[l]=='4' 
							|| test[l]=='5' || test[l]=='6' || test[l]=='7' || test[l]=='8' || test[l]=='9')
					{}
					
					else
					{
						throw new QuitMashingOnYourKeyBoardException();//UserIsADumbAssException();
					}					
				}
				temp.add(expreArr[k]);
			}
			  

		}//end of k for loop
		
		while(!temp.isEmpty())
		{
			postfixExp.add(temp.pop());
		}
		System.out.println("Finished changing to postfix.");
	}//end of toPostfix class
	
	
	//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%	
	public static int precedence(String operator)
	{
		if(operator.equals("+") || operator.equals("-"))
			return 0;
		else if(operator.equals("x") || operator.equals("/"))
			return 1;
		else if(operator.equals("(") || operator.equals(")"))
			return 2;
		else 
			return -1;
	}
	//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	public static double subtract(double two, double one)
	{
		double temp = two + one * -1;
		return temp;
	}
	//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	public static double solveExp(Stack<String> tempPostfixExp) throws IllegalArgumentException
	{
		Stack<String> ans = new Stack();
		
		Double tempNum = 0.0;//of type Double not double, for ease of toString method
		double num1 = 0.0, num2 = 0.0;
		
		while(!postfixExp.isEmpty())
		{
			if(precedence(tempPostfixExp.peek()) == -1)
			{
				ans.add(tempPostfixExp.pop());
			}
			else
				{
					switch(tempPostfixExp.peek()){
						case("+"):
							tempPostfixExp.pop();
							try{
							num1 = Double.parseDouble(ans.pop());
							num2 = Double.parseDouble(ans.pop());
							tempNum = num1 + num2;
							ans.add(tempNum.toString());
							}
							catch(Exception e){
								throw new UserIsADumbAssException();
						    	}
							break;
						case("-"):
							tempPostfixExp.pop();
							//try{
							num1 = Double.parseDouble(ans.pop());
							num2 = Double.parseDouble(ans.pop());
							tempNum = subtract(num2,num1);
							ans.add(tempNum.toString());
							//}
							//catch(Exception e){
							//	throw new UserIsADumbAssException();
							//}
							break;
						case("x"):
							tempPostfixExp.pop();
							num1 = Double.parseDouble(ans.pop());
							num2 = Double.parseDouble(ans.pop());
							tempNum = num1 * num2;
							ans.add(tempNum.toString());
							break;
						case("/"):
							tempPostfixExp.pop();
						try{
								num1 = Double.parseDouble(ans.pop());
								num2 = Double.parseDouble(ans.pop());
								if(num1 == 0.0)
								{
									throw new DivisionOfZeroException();
								}
								else
								{
									tempNum = num2 / num1;
									ans.add(tempNum.toString());
								}
							}
						catch(Exception e){ 
							throw new UserIsADumbAssException();
							}
							break;
					}//end of switch
				}//end of else
		}//end of while
		//ans.add(tempNum.toString());
		if(ans.size()>1)
		{
			throw new AlgebraFailException();
		}
		
		return Double.parseDouble(ans.pop());
		//return tempNum;
	}//end of solveExp class
}//end of main Calculator class

class QuitMashingOnYourKeyBoardException extends IllegalArgumentException{
    {
        System.out.println("Operation not supported");
    }
}
class UserIsADumbAssException extends IllegalArgumentException{
    {
        System.out.println("User did not Input a Number or Invalid Parenthesis Match");

    }
}
class AlgebraFailException extends IllegalArgumentException{
    {
        System.out.println("Invalid Number / Input");
    }
}
class DivisionOfZeroException extends Exception{
    {
        System.out.println("Cannot Divide by zero");
    }
}

/* Side Note: Was not able to resolve problem in which '*' provided no errors during testing
 * so instead replaced '*' and used 'x' to resemble multiplication.
 *
 * Sources: https://github.com/jeffersonvivanco/Calculator/blob/master/ExpressionTools.java
 *	    https://github.com/sahands/postfix-calculator/blob/master/Expression.java
 * Used as guides in understanding the functions of stacks and understandings of how to go
 * about implementing the program. The Stack API was also a huge help.
 * 
 */
