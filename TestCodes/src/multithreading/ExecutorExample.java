package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class ExecutorExample {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		System.out.println("thread inside main: " + Thread.currentThread().getName());
		executor.submit(new Runnable() {

			@Override
			public void run() {
				try {
					System.out.println("Thread for first tak: " + Thread.currentThread().getName());
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Submit the first task" + Thread.currentThread().getName());
			}
		});
		executor.submit(new Runnable() {

			@Override
			public void run() {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Submit the second task" + Thread.currentThread().getName());
			}
		});

		executor.submit(new Runnable() {

			@Override
			public void run() {
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Submit the third task" + Thread.currentThread().getName());
			}
		});
		
		executor.shutdown();
		
		try {
			executor.awaitTermination(1, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		IntStream.of(1,2,3,4,5).map(x-> 2*x).forEach(System.out::println);
	}

}
