package multithreading;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExample {

	public static void main(String[] args) throws InterruptedException {
	 ExecutorService executor = Executors.newFixedThreadPool(10);
	 
	 Map<Integer,String> map = new HashMap<>(); 
	 ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	 
	 executor.submit(()-> {
		 lock.writeLock().lock();
		 try {
			 Thread.sleep(1000); 
			 map.put(1,"Java");
			 map.put(2,"Multithreading");
		 }catch (Exception e) {
			 e.printStackTrace();
		 }finally { 
			 lock.writeLock().unlock();
		 }
			 
	 });
	 
	 Runnable readTask = ()->{ 
		lock.readLock().lock();
		try { 
			Thread.sleep(1000); 
			System.out.println(map.get(1)); 
			System.out.println(map.get(2));
		}catch (Exception e) {
			 e.printStackTrace();
		 }finally { 
			 lock.readLock().unlock();
		 }
	 };
	 
	 executor.submit(readTask); 
	 
	 executor.shutdown();
	 executor.awaitTermination(60, TimeUnit.MILLISECONDS);
	 
	 }

	}


