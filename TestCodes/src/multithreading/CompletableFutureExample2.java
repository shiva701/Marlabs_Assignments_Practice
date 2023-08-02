package multithreading;

import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CompletableFutureExample2 {

	public static void main(String[] args) throws InterruptedException {
		 ExecutorService executor = Executors.newFixedThreadPool(3);
		 
		 CompletableFuture.runAsync(()-> performStage("firstStage"), executor)
		 .thenRun(()-> performStage( "secondStage"))
		 .thenRunAsync(()-> performStage("thirdStage"),executor)
		 .join();//waits until task completed 
		 System.out.println("Exisiting Main thread !!! ");
		 
		 executor.awaitTermination(60, TimeUnit.MILLISECONDS);
		 executor.shutdown();

	}

	private static void performStage(String stage) {
		System.out.println("-----------");
		System.out.format("Stage :: %s Time before task %s, Thread Name :: %s%n",
				stage,LocalDateTime.now(),Thread.currentThread().getName());
		try { 
			Thread.sleep(2000L);
		}catch(InterruptedException e) { 
			e.printStackTrace();
		}
		System.out.format("Stage :: %s Time after task %s, Thread Name :: %s%n",
				stage,LocalDateTime.now(),Thread.currentThread().getName());
		 
	}

}
