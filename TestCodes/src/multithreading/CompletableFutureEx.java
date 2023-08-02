package multithreading;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureEx {

	public static void main(String[] args) {
		 CompletableFuture<Void> cf = CompletableFuture.runAsync(()-> {
			 System.out.println("Thread Name :" +Thread.currentThread().getName());
		 });
		 cf.join();//waits until task is completed 
		 System.out.println("Thread Name :" +Thread.currentThread().getName());
	}

}
