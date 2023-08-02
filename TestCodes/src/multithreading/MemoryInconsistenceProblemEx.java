package multithreading;

public class MemoryInconsistenceProblemEx {
	
	private volatile static boolean sayHello = false; 

	public static void main(String[] args) throws InterruptedException {
	 Thread th = new Thread(()-> {  
		 System.out.println(Thread.currentThread().getName());
		 while(!sayHello) {}
		 System.out.println("Hello World !!!");
		 
		 while(sayHello) {}
		 System.out.println("Good Bye !!! ");
		 
	 });
	 th.start();
	 
	 Thread.sleep(1000);
	 System.out.println("Say Hello !!");
	 sayHello = true; 
	 
	 Thread.sleep(1000);
	 System.out.println("Bye !!!!"); 
	 sayHello = false; 
	 }

	}
