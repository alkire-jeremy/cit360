package threads;

public class ExecuteThreads {
	
	public static void main(String args[]) {
		Thread.currentThread().setName("main");
		System.out.println("Starting " + Thread.currentThread().getName() + " thread.");
	
		// Construct objects.
		Audio instrumentalThread = new Audio(); // Audio is a subclass of Thread, and starts with the start() method.
		Audio vocalThread = new Audio(); // Audio is a subclass of Thread, and starts with the start() method.
		Delay delayRunnable = new Delay(); // Note: Delay is actually an implementation of Runnable.
		
		// Runnables can start either via being passed into the Thread constructor, or by being passed to an executor.
		
		// Pass audio path into object's setSong() method parameters.
		instrumentalThread.setSong("http://music.faintdev.net/paulgift.wav");
		vocalThread.setSong("http://music.faintdev.net/undermyfeet.wav");
		
		// Set timer.
		delayRunnable.setTime(20);
		
		// Name threads.
		instrumentalThread.setName("instrumental");
		vocalThread.setName("vocal");
		
		// Start instrumental thread.
		instrumentalThread.start();
		
		// Create executor.
		Exec exec = new Exec();
		// Execute delay thread.
		exec.execute(delayRunnable);
		
		// Start vocal thread.
		System.err.println("\nCue vocals!");
		vocalThread.start();
	}
}
