public class HW10{
	
	public static void main(String args[]){
	
		MyFlagClass flagObj = new MyFlagClass();

		Thread one = new Thread1(flagObj);
		Thread two = new Thread2(flagObj);
		Thread three = new Thread3(flagObj);
		Thread four = new Thread4(flagObj);
	
		one.start();
		two.start();
		three.start();
		four.start();

	}
}

class MyFlagClass{
	static public volatile int flag = 0;
}

class Thread1 extends Thread{
	MyFlagClass flagObj;

	Thread1(MyFlagClass flagObj)
	{
		this.flagObj = flagObj;
	}


	public void run()
	{
		String strArr[] = {"A","E","I","M","Q","U","Y"};
		try{
			synchronized (flagObj){	//preventing illegalMonitor Exception
				for(int i = 0; i<strArr.length; i++)
				{
					while(flagObj.flag!=0)//waits until Thread4 sets flag to 0 again (almost like recurssion)
					{

						flagObj.wait();
					}
					System.out.println("	"+strArr[i]);
					Thread.sleep(200);
					flagObj.flag = 1;
					flagObj.notifyAll();
				}//end of for loop
			}//end of synchronized
		}catch(Exception e){
			System.out.println("Error in Thread 1" + e);
		}//end of catch
	}//end of run()
}//end of Thread1 class


class Thread2 extends Thread{
	MyFlagClass flagObj;

	Thread2(MyFlagClass flagObj)
	{
		this.flagObj = flagObj;
	}

	public void run()
	{
		String strArr2[] = {"B","F","J","N","R","V","Z"};
		try{
			synchronized (flagObj){
				for(int i = 0; i<strArr2.length; i++)
				{
					while(flagObj.flag != 1)
					{
						flagObj.wait();
					}
					System.out.println("	"+strArr2[i]);
					Thread.sleep(200);
					flagObj.flag = 2;
					flagObj.notifyAll();
				}//end of for loop
			}//end of synchronized
		}catch(Exception e){
			System.out.println("Error in Thread 2" + e);
		}//end of catch
	}//end of run
}//end of Thread2 class

class Thread3 extends Thread{
	MyFlagClass flagObj;

	Thread3(MyFlagClass flagObj)
	{
		this.flagObj = flagObj;
	}

	public void run()
	{
		String strArr3[] = {"C","G","K","O","S","W"};
		try{
			synchronized (flagObj){

			for(int i = 0; i<strArr3.length; i++)
			{
				while(MyFlagClass.flag != 2)
				{
					flagObj.wait();
				}
				System.out.println("	"+strArr3[i]);
				Thread.sleep(200);
				flagObj.flag = 3;
				flagObj.notifyAll();
			}//end of for loop
			}//end of synchronized
		}catch(Exception e){
			System.out.println("Error in Thread 3" + e);
		}//end of catch
	}//end of run
}//end of Thread3 class

class Thread4 extends Thread{
	MyFlagClass flagObj;

	Thread4(MyFlagClass flagObj)
	{
		this.flagObj = flagObj;
	}

	public void run()
	{
		String strArr4[] = {"D","H","L","P","T","X"};
		try{
			synchronized (flagObj){

			for(int i = 0; i<strArr4.length; i++)
			{
				while(MyFlagClass.flag != 3)
				{
					flagObj.wait();
				}
				System.out.println("	"+strArr4[i]);
				Thread.sleep(200);
				flagObj.flag = 0;
				flagObj.notifyAll();
			}//end of for loop
			}//end of synchronized
		}catch(Exception e){
			System.out.println("Error in Thread 4" + e);
		}//end of catch
	}//end of run
}//end of Thread4 class


/*
 *Sources:
 *	1. https://stackoverflow.com/questions/27671381/how-to-make-two-threads-take-turns-in-modifying-an-arraylist
 *	2. https://codereview.stackexchange.com/questions/51486/sequential-thread-execution-using-wait-and-notifyall 
 *
 */ 
