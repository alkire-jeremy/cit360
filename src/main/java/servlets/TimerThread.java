package servlets;

public class TimerThread extends Thread {
	int time;
	
	public void run() {
		displayTime();
	}
	
	void displayTime() {
		while(true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			time++;
			System.out.println("Seconds passed: " + time);
		}
	}
}
