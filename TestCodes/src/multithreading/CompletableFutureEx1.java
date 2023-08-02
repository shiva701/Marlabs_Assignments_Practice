package multithreading;

import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureEx1 {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(3);
		
		CompletableFuture.runAsync(()-> performTask("firstStage"), executor)
		.thenRunAsync(()-> performTask("secondStage"), executor)
		.thenRun(()-> performTask("thirdStage"))
		.join();
		System.out.println("Main Existing :: "  +Thread.currentThread().getName());
		executor.shutdown();
	}

	private static void performTask(String stage) {
		System.out.println("-------------------------");
		System.out.printf("stage: %s, time before task: %s, thread:%s%n",
				stage,LocalDateTime.now(),Thread.currentThread().getName());
		try { 
			Thread.sleep(1000L);
		}catch(InterruptedException e) { 
			e.printStackTrace();
		}
		System.out.printf("stage: %s, time after task: %s, thread:%s%n",
				stage,LocalDateTime.now(),Thread.currentThread().getName());
	 
		 
	}

}
