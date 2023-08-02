package multithreading;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.StampedLock;

public class OptimisticLockingEx {

	public static void main(String[] args) {
	ScheduledExecutorService executors = Executors.newScheduledThreadPool(2);
	
	StampedLock lock= new StampedLock();
	
	executors.submit(()-> { 
		long stamp = lock.tryOptimisticRead();
		System.out.println("the stamp for read is: " + stamp);
		try { 
			System.out.println("Optimistic lock valid: " +lock.validate(stamp));
			Thread.sleep(10);
			System.out.println("Optimistic lock valid: " +lock.validate(stamp));
			Thread.sleep(10);
			System.out.println("Optimistic lock valid: " +lock.validate(stamp));
			}catch (Exception e) { 
				e.getMessage();
			}finally { 
				lock.unlock(stamp);
			}
	});
	
	executors.schedule(()-> { 
		long stamp = lock.writeLock();
		try { 
			System.out.println("the stamp for write is: " + stamp);
			System.out.println("Write lock acquired");
			Thread.sleep(10000);
		}catch (Exception e) {
			e.getMessage();
		}finally {
			lock.unlock(stamp);
		}
		
	}, 10, TimeUnit.SECONDS);
	
	executors.shutdown();
	}

}
