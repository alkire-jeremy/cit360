package threadsrevisted;

/*
 * This is a simple multithreading program that demonstrates the creation of two threads, via two different methods.
 * The thread Evens subclasses the Thread class.
 * The thread Odds is an implementation of Runnable, and is executed with an executor (SimpleExecutor).
 * With one executed immediately before the other, via a call to start(), and the second executed with an executor immediately after,
 * the two threads run concurrently. One displays only even numbers, one displays only odd numbers.
 * 
 * If this program is working as intended, the console will display both even and odd numbers, counting up to 100 for each.
 * It should look like a seamless counting effort from 1-100, with no numbers skipped. Granted, they may sometimes display in an imperfect order.
 * Author: Jeremy Alkire
 */
import java.util.concurrent.Executor;

public class ThreadsRevisted {
	
	public static void main(String args[]) {
		// Create executor.
		SimpleExecutor se = new SimpleExecutor();
		
		// Create thread objects.
		Odds oddsThread = new Odds();
		Evens evensThread = new Evens();
		
		// Execute both threads. One with start(), one with an executor.
		evensThread.start();
		se.execute(oddsThread);
	}
}

// Just a simple executor.
class SimpleExecutor implements Executor {
	public void execute(Runnable command) {
		command.run();
	}
}

// A thread subclassed from Thread.
class Evens extends Thread {
	int evens = 0;
	
	public void run() {
		displayEvens();
	}
	
	// Display even numbers up to 100.
	void displayEvens() {
		for (int i = 0; i < 100; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			evens = evens + 2;
			System.out.println(evens);
		}
	}
}

// A thread implementation of Runnable.
class Odds implements Runnable {
	int odds = 1;

	@Override
	public void run() {
		displayOdds();
	}

	// Display odd numbers up to 100.
	void displayOdds() {
		for (int i = 0; i < 100; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			odds = odds +2;
			System.out.println(odds);
		}
	}
}
