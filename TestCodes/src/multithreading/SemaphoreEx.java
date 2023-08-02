package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class SemaphoreEx {

	public static void main(String[] args) {
	ExecutorService executors = Executors.newFixedThreadPool(10);
	
	Semaphore semaphore = new Semaphore(5);
	
	Runnable task = ()-> { 
		boolean permit = false;
		try { 
			permit = semaphore.tryAcquire(1,TimeUnit.SECONDS);
			if(permit) {
				System.out.println("Semaphore Acquired "); 
				Thread.sleep(2000);
			}else {
				System.out.println("Semaphore could not acquire");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(permit) {
				semaphore.release();
			}
		}
	};
	IntStream.range(1,10)
	.forEach(i-> executors.submit(task));
	
	executors.shutdown();

	}

}
