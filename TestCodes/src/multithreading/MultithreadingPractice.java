package multithreading;

public class MultithreadingPractice implements Runnable {

	//overriding the run method as the class implements the runnable interface.
	@Override
	public void run() {
		System.out.println("using method overriding of the run method.");
	}

	public static void main(String[] args) {

		// using method overriding of the run method
		Runnable run = new MultithreadingPractice();
		Thread t = new Thread(run);
		t.start();

		// using anonymous inner class
		Runnable runAnonymous = new Runnable() {

			@Override
			public void run() {
				System.out.println("\n\nusing anonymous interface.");
			}
		};
		Thread tAnon = new Thread(runAnonymous);
		tAnon.start();

		// using lambda expression
		// since it is a functional interface, it only has one method to implement.
		// the method we define using the lambda expression will be an implementation of
		// that one method only.
		Runnable runLambda = () -> {
			System.out.println("\n\nusing lambda expression.");
		};
		Thread tLambda = new Thread(runLambda);
		tLambda.start();
	}

}
