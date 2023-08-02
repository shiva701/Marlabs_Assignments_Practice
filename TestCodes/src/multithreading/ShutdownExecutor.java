package multithreading;

import java.time.LocalDateTime;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ShutdownExecutor {
	public static void main(String[] args) throws InterruptedException {
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(3);

		System.out.println("WorkerTasks scheduled at : " + LocalDateTime.now());

		ScheduledFuture<String> result1 = executor.schedule(new WorkerTask("WorkerTask-1"), 1, TimeUnit.SECONDS);

		ScheduledFuture<String> result2 = executor.schedule(new WorkerTask("WorkerTask-2"), 2, TimeUnit.SECONDS);

		ScheduledFuture<String> result3 = executor.schedule(new WorkerTask("WorkerTask-3"), 300, TimeUnit.SECONDS);

		Thread.sleep(1000);
		System.out.println("***********Shutting down the executor service*********");
		executor.shutdown();

		System.out.println("***********Tasks are partially completed*********");

		System.out.println("Task-1 is done : " + result1.isDone());
		System.out.println("Task-2 is done : " + result2.isDone());
		System.out.println("Task-3 is done : " + result3.isDone());

		System.out.println("***********Waiting for tasks to be complete*********");
		System.out
				.println("checking the return of await termination: " + executor.awaitTermination(60, TimeUnit.SECONDS));

		System.out.println("***********All tasks are completed now*********");

		System.out.println("Task-1 is done : " + result1.isDone());
		System.out.println("Task-2 is done : " + result2.isDone());
		System.out.println("Task-3 is done : " + result3.isDone());
	}
}

class WorkerTask implements Callable<String> {
	private final String name;

	public WorkerTask(String name) {
		this.name = name;
	}

	@Override
	public String call() throws Exception {
		System.out.println("WorkerTask [" + name + "] executed on : " + LocalDateTime.now().toString());
		return "WorkerTask [" + name + "] is SUCCESS !!";
	}
}
