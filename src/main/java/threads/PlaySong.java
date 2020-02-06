package threads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PlaySong {
//	public static final PlaySong INSTANCE = new PlaySong();
//	public static PlaySong getInstance() {
//		return INSTANCE;
//	}
	private String instrumentals = "http://music.faintdev.net/paulgift.wav";
	private String vocals = "http://music.faintdev.net/undermyfeet.wav";

	private static final Logger logger = LogManager.getLogger(PlaySong.class);
	private static final Audio instrumentalThread = new Audio();
	private static final Audio vocalThread = new Audio();
	private static final String site = "http://music.faintdev.net/";
	
	
	public void stopSongs() {
		instrumentalThread.stopSong();
		vocalThread.stopSong();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void startSongs(){
		System.out.println("THIS IS FINALLY WORKING");
		
		// Sets 'running' flag of both thread objects to false.
		stopSongs();

		// Set audio path in Thread objects.
		instrumentalThread.setSong(instrumentals);
		vocalThread.setSong(vocals);
		
		if (instrumentalThread.getState() != Thread.State.NEW) {
			instrumentalThread.run(); // This sets 'running' flag to true and resumes a thread that has already started.
		} else {
			instrumentalThread.start(); // This starts a thread that has not yet started.
		}
		System.out.println("VOCAL THREAD STATE CHECKED.");
		if (vocalThread.getState() != Thread.State.NEW) {
			instrumentalThread.run(); // This sets 'running' flag to true and resumes a thread that has already started.
		} else {
			vocalThread.start(); // This starts a thread that has not started.
		}
	}
	
	public String getInstrumentals() {
		return instrumentals;
	}

	public void setInstrumentals(String instrumentals) {
		this.instrumentals = instrumentals;
//		System.out.println(this.instrumentals);
	}

	public String getVocals() {
		return vocals;
	}

	public void setVocals(String vocals) {
		this.vocals = vocals;
//		System.out.println(this.vocals);
	}
}