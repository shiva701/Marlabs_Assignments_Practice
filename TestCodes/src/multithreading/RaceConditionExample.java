package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Counter {
	int count = 0;

	public void increment() {
		synchronized (this) {
			count = count + 1;
		}
	}

	public int getCount() {
		return count;
	}
}

public class RaceConditionExample {

	public static void main(String[] args) throws InterruptedException {

		ExecutorService executors = Executors.newFixedThreadPool(2);

		Counter counter = new Counter();
		for (int i = 0; i < 1000; i++) {
//			System.out.println("name: " + Thread.currentThread().getName());
//			System.out.println();
//			executors.submit(() -> counter.increment());
			executors.submit(() -> {
				System.out.println("increment: " + Thread.currentThread().getName());
				counter.increment();
			});
//			executors.submit(() -> System.out.println("\none extra thread : " + Thread.currentThread().getName()));

		}

		executors.awaitTermination(60, TimeUnit.MILLISECONDS);
		executors.shutdown();

		System.out.println("Final Count of the Counter Variable :: " + counter.getCount());

	}

}
