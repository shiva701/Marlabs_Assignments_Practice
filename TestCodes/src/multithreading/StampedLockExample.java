package multithreading;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.StampedLock;


public class StampedLockExample {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(2); 
		 
		 Map<Integer,String> map = new HashMap<>();
		 StampedLock lock = new StampedLock();
		 
		 executor.submit(()-> {
			 long stamp = lock.writeLock();
			 try { 
				 Thread.sleep(1000); 
				 map.put(1,"Java"); 
				 map.put(2,"Multithreading"); 
			 }catch (Exception e) { 
				 e.printStackTrace();
			 }finally {  
				 lock.unlockWrite(stamp);
			 }
		 });
		 
		 Runnable readTask = ()-> { 
			 long stamp = lock.readLock();
			 try { 
				 System.out.println(Thread.currentThread().getName());
				  System.out.println(map.get(1));
				  Thread.sleep(1000L); 
				  System.out.println(map.get(2));
			 }catch (Exception e) { 
				 e.printStackTrace();
			 }finally { 
				 lock.unlockRead(stamp);
			 }
				 
		 };
		 
		 executor.submit(readTask);
		 
		 executor.shutdown();
		  

	}

}
