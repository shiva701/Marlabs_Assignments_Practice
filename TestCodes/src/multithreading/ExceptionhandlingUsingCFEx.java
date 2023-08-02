package multithreading;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ExceptionhandlingUsingCFEx {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
	 CompletableFuture<Integer> cf = CompletableFuture
			 .supplyAsync(()-> {
				 System.out.println("running task");
				 return 10/0;
			 })
			 .exceptionally(exception -> {
				 System.err.println("exception caught :-" +exception);
				 return 1;
			 });
	 Thread.sleep(2000);
	 System.out.println("---Checking exceptions ----");
	 boolean b = cf.isCompletedExceptionally();
	 System.out.println("Completed Exception: " +b);
	 System.out.println("-- getting resutls -- ");
	 int result = cf.get();
	 System.out.println(result);

	}

}
