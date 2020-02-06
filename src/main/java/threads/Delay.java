package threads;

public class Delay implements Runnable {

	private int time;
	private static int seconds;
	
	public void run() {
    	countSeconds();
	}
	
	public void setTime(int multiplier) {
		time = multiplier;
	}
	
	public void countSeconds() {
		try {
			for (int i = 0; i <= time; i++) {
				Thread.sleep(1000);
				setSeconds(i);
				System.out.print("\r" + i + " seconds in.");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static int getSeconds() {
		return seconds;
	}

	public static void setSeconds(int seconds) {
		Delay.seconds = seconds;
	}
}
