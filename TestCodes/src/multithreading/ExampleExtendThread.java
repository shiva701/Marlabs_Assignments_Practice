package multithreading;

import java.time.LocalDateTime;

public class ExampleExtendThread extends Thread {
	static int cnt = 0;

	public ExampleExtendThread() {
		cnt++;
		System.out.println("\nconstructor called : " + cnt);
	}

	public void run() {
		System.out.println("\nThread: " + Thread.currentThread().getName());
		System.out.println("\nDate is: " + LocalDateTime.now());
	}

	public static void main(String[] args) {

		System.out.println("\nthe main thread: " + Thread.currentThread().getName());
		Thread t1 = new ExampleExtendThread();
		Thread t2 = new ExampleExtendThread();
		t1.start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		t2.start();
	}

}
