public class HW3 {

	public static void main(String[] args) 
	{
		char[] charArr = {'h','e','l','l','o'};
		char[] charToCompare = {'h','e','m','l','o'};
		char[] charUpperCase = {'U','P','P','E','R'};
		char[] charLowerCase = {'l','o','w','e','r'};
		MyString str = new MyString(charArr);
		MyString str1 = new MyString(charLowerCase);
		MyString str2 = new MyString(charUpperCase);
		MyString str3 = new MyString(charToCompare);
		MyString str4 = new MyString();
		
		/*Tests charAt()*/
		System.out.printf("%40s\n","Testing CharAt Method");
		for(int i = 0; i<charArr.length; i++)
		{
			System.out.print("CharAt["+i+"]:"+str.charAt(i));
			System.out.printf("%3s","");
		}
		System.out.println();
		
		/*Tests length()*/
		System.out.println();
		System.out.printf("%40s\n","Testing length() Method");
		System.out.println("Length of str.charArr: "+str.length());
		System.out.println();
		
		/*Tests Substring Method*/
		System.out.printf("%40s\n","Testing Substring Method");
		System.out.print("Substring of charArr[] from index 0 to 1: ");
		System.out.print((str.substring(0, 2)).getch_arr());
		System.out.println();
		
		/*Tests toLowerCase Method*/
		System.out.println();
		System.out.printf("%40s\n","Testing toLowerCase() Method");
		System.out.print("charUpperCase: "+str2.toString()+"   toLowerCase: ");
		System.out.print((str2.toLowerCase()).getch_arr());
		System.out.println();
		
		/*Tests toUpperCase Method*/
		System.out.println();
		System.out.printf("%40s\n","Testing toUpperCase() Method");
		System.out.print("charLowerCase: "+str1.toString()+"   toUpperCase: ");
		System.out.print((str1.toUpperCase()).getch_arr());
		System.out.println();
		
		/*Tests CompareTo Method*/
		System.out.println();
		System.out.printf("%40s\n","Testing compareTo Method");
		System.out.println("charArr[]:"+str.toString()+"  charToCompare:"+str3.toString());
		System.out.print("charArr compareTo charToCompare Value = "+str.compareTo(str3));
		System.out.println();
		
		/*Tests getMyString Method*/
		System.out.println();
		System.out.printf("%40s\n","Testing getMyString() Method");
		System.out.println("str.charArr: "+str.getMyString());
		System.out.println();
		
		/*Tests toString Method*/
		String test = "";
		test = str.toString();
		System.out.printf("%40s\n","Testing toString() Method");
		System.out.println("str.charArr toString: " + test);
		System.out.println();
		
		/* Tests valueOf Method*/
		System.out.printf("%40s\n","Testing valueOf Method");
		System.out.print("str4.valueOf(9824): ");
		System.out.print(str4.valueOf(9824));
		System.out.print("    Length = "+ (str4.valueOf(9824).length()));
		 
	}
}


class MyString
{
	private String str = "hello";
	private int length = 1;
	private char[] ch_arr = new char[length];
	
	
	public MyString(){};//empty constructor
	public MyString(char[] chars)//set char array
	{
		length = chars.length;
		ch_arr = new char[length];
		
		ch_arr=chars;
	}
	/*Returns character at specified index*/
	public char charAt(int index)
	{
		return ch_arr[index];
	}
	/*Returns the length of the array*/
	public int length()
	{	
		int i = length;
		i = ch_arr.length;		
		return i;
	}
	public MyString substring(int begin, int end)
	{
		int size = end+1;//end of substring + 1
		char[] temp = new char[size];//temporary array
		
		for(int i=begin; i<end; i++)
		{
			temp[i] = ch_arr[i];
		}
		
		MyString substring = new MyString(temp);
			
		return substring;
		
	}
	/*Converts a char array to LowerCase*/
	public MyString toLowerCase()
	{
		int size = ch_arr.length;
		for(int i=0; i<size; i++)
		{
			if(ch_arr[i]>='A' && ch_arr[i]<='Z')
				ch_arr[i] = (char) (ch_arr[i] + 32);//ASCII values; 'A'=65 'Z'=90 'a'=97 'z'=122	
		}
		MyString LowerCase = new MyString(ch_arr);
		
		return LowerCase;
	}
	/*Converts a char array to UpperCase*/
	public MyString toUpperCase()
	{
		int size = ch_arr.length;
		for(int i=0; i<size; i++)
		{
			if(ch_arr[i]>='a' && ch_arr[i]<='z')
				ch_arr[i] = (char) (ch_arr[i] - 32);	
		}
		MyString UpperCase = new MyString(ch_arr);
		
		return UpperCase;
	}
	/*Compares the Character values of two MyString character arrays*/
	public int compareTo(MyString s)//int diff = MyStr1.compareTo(MyStr2);
	{
		int diff = 0;
		int size = ch_arr.length;
		
		char[] tempS = s.ch_arr;//passed MyString s
		char[] tempCh = ch_arr;//MyString str1
		
		if(tempS.length<=0 || tempCh.length<=0)
			return 0;
		
		for(int i=0; i<size; i++)
		{
			if(tempCh[i]!=tempS[i])
			{
				diff = tempCh[i]-tempS[i];
				break;
			}
		}
		return diff;//ASCII character difference
	}
	/*Returns MyString*/
	public MyString getMyString()
	{
		return new MyString(this.ch_arr);
	}
	/*Converts the value to a String*/
	public String toString()
	{
		String ch_arrStr = "";
		for(int i = 0; i<ch_arr.length; i++)
		{
			ch_arrStr+=ch_arr[i];
		}
		
		return ch_arrStr;
	}
	/*
	 * Returns integer value as a MyString
	 * Citation: https://codereview.stackexchange.com/questions/32109/implement-strings-valueof-function-code-review-request
	 * Used to help figure out the logic behind the method
	 */
	public static MyString valueOf(int i)
	{
		int temp = i;
		int len = 0;
		
		while(temp>0)
		{
			len++;
			temp = temp/10;
		}
		
		temp = i;
		char[] tempchar = new char[len];
		
		for(int j = tempchar.length -1; j>=0; j--)
		{
			tempchar[j] = (char)((temp%10)+'0');
			temp = temp/10;
		}
		
		MyString valueMyString = new MyString(tempchar);
		
		return valueMyString;
	}
	/*Getter method for character array*/
	public char[] getch_arr()
	{
		return ch_arr;
	}
	/*Getter method for string*/
	public String getString()
	{
		return str;
	}
}
