import java.util.*;
import java.io.*;
import java.net.*;

public class HW9blah{

	public static void main(String[] args) throws Throwable{
		economy myeconomy = new economy();
		
		Object myobj = new Object();

		Thread t1 = new Thread(new producer(myeconomy));
		Thread t2 = new Thread(new consumer(myeconomy));

		t2.start();
		t1.start();
	}
}

class producer implements Runnable{
	economy e;

	producer(economy e){
		this.e = e;
	}

	public void run(){
		try{
			e.producer();
		}catch(Throwable t){}
	}
}

class consumer implements Runnable{
	economy e;

	consumer(economy e){
		this.e = e;
	}

	public void run(){
		try{
			e.consumer();
		}catch(Throwable t){}
	}
}

class economy{
	boolean product = false;

	public synchronized void producer() throws Throwable{
		System.out.println("Running producer");
		while(true){
			if(product == true){
				try{
					System.out.println("Producer: Too much product exists. Gonna wait...");
					wait();
				}
				catch(Throwable t){}
			}
			System.out.println("Producer: Making more product now.");
			product = true;
			try{
			notifyAll();
			}catch(Throwable y){}
			Thread.sleep(1000);
			System.out.println("Producer ending");

		}
	}

	public synchronized void consumer() throws Throwable{
		System.out.println("Running Consumer");
		while(true){
			if(product == false){
				try{
					System.out.println("Consumer: No products available to consume. Gonna wait...");
					wait();
				}catch(Throwable t){}
			}

			System.out.println("Consumder: Now consuming product");
			product = false;
			try{
			notifyAll();
			} catch(Throwable t){}
			Thread.sleep(10);
			System.out.println("Consumer ending");
		}
	}
}
