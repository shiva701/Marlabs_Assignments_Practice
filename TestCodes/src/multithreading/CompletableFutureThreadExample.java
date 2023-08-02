package multithreading;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureThreadExample {

	public static void main(String[] args) {
	 CompletableFuture<Void> cf = CompletableFuture.runAsync(()->{
		 System.out.println("Thread Name :: " +Thread.currentThread().getName());
		 System.out.println("Thread executing parallely");
	 });
	 cf.join();
	 System.out.println("Exisiting Main Thread !!! ");
	}

}
