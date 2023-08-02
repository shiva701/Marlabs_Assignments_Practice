package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

class Counters {
	int count = 0;

	private ReentrantLock lock = new ReentrantLock();

	public int incrementAndGet() {
		// check if the lock is acquired by the thread

		System.out.println("Method entry, thread is: " + Thread.currentThread().getName());
		System.out.println("isLocked:: " + lock.isLocked());

		System.out.println("isHeld:: " + lock.isHeldByCurrentThread());

		boolean isAcquired = lock.tryLock();
		System.out.println("Lock Acquired :: " + isAcquired);
		System.out.println("The hold count: " + lock.getHoldCount());

		if (isAcquired) {
//			try {
//				Thread.sleep(2000);
//				System.out.println("increment by thread: " + Thread.currentThread().getName());
//				count = count + 1;
//			} catch (InterruptedException e) {
//				throw new IllegalStateException(e);
//			} finally {
//				lock.unlock();
//			}
			System.out.println("increment by thread: " + Thread.currentThread().getName());
			count = count + 1;
			lock.unlock();
		}
		return count;
	}
}

//main class
public class ReentrantLockExample {

	public static void main(String[] args) throws InterruptedException {

		ExecutorService executor = Executors.newFixedThreadPool(30);

		Counters counter = new Counters();

		for(int i=0;i<100;i++) {
			executor.submit(() -> {
				System.out.println("Increment Count(FirstThread):" + counter.incrementAndGet());
			});
		}
//		executor.submit(() -> {
//			System.out.println("Increment Count(SecondThread):" + counter.incrementAndGet());
//		});
//		executor.submit(() -> {
//			System.out.println("Increment Count(ThirdThread):" + counter.incrementAndGet());
//		});

		executor.shutdown();
		executor.awaitTermination(10, TimeUnit.SECONDS);
	}

}
