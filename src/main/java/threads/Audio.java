package threads;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;

public class Audio extends Thread {

	private String songPath;
	private static final AtomicBoolean running = new AtomicBoolean(false);

	public Audio() {
	}
	
	public void setRunningTrue() {
		running.set(true);
	}
	
	public void stopSong() {
		running.set(false);
	}

	@Override
	public synchronized void run() {
//		System.out.println("Starting " + currentThread().getName() + " thread.");
		running.set(true);
		try {
			playAudio();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setSong(String song) {
		songPath = song;
	}

	public void playAudio() throws IOException {
		if (songPath == null) {
			songPath = "http://music.faintdev.net/paulgift.wav";
		}
		AudioInputStream din = null;
		SourceDataLine line = null;
		try (AudioInputStream in = AudioSystem.getAudioInputStream(new URL(songPath))) {

			AudioFormat baseFormat = in.getFormat();
			AudioFormat decodedFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, baseFormat.getSampleRate(), 16,
					baseFormat.getChannels(), baseFormat.getChannels() * 2, baseFormat.getSampleRate(), false);
			din = AudioSystem.getAudioInputStream(decodedFormat, in);
			DataLine.Info info = new DataLine.Info(SourceDataLine.class, decodedFormat);
			line = (SourceDataLine) AudioSystem.getLine(info);
			if (line != null) {
				line.open(decodedFormat);
				byte[] data = new byte[4096];
				// Start
				line.start();

				int nBytesRead;
				while (running.get()) {
					nBytesRead = din.read(data, 0, data.length);
					running.set(nBytesRead != -1);
					if (running.get()) {
						line.write(data, 0, nBytesRead);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (din != null) {
				din.close();
			}
			if (line != null) {
				line.drain();
				line.stop();
				line.close();
			}
		}
	}
}
