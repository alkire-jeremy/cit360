/*
 * @author Jeremy James Alkire
 */
package mvc.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RequestData {
	
	static String name = "";
	static int height = 0;
	static double weight = 0;
	
	// Request data from user necessary to configure athlete information.
	public static String requestAthleteData() {
		
		System.out.println("What is the name of the athlete?");
		name = (getData());
		
		getHeight();
		getWeight();
		
		return (name + "," + height + "," + weight);
	}
	
	public static void announceCreation() {
		System.out.println("An athlete has been created and configured successfully.");
	}
	
	static int getHeight() {
		System.out.println("What is the athlete's height?");
		try {
			height = (Integer.parseInt(getData()));			
		} catch (NumberFormatException e) {
			System.out.println("Please enter a number.");
			getHeight();
		}
		return height;
	}
	
	static double getWeight() {
		System.out.println("What is the athlete's weight?");
		try {
			weight = (Integer.parseInt(getData()));		
		} catch (NumberFormatException e) {
			System.out.println("Please enter a number.");
			getWeight();
		}
		return weight;
	}
	
	// Generic method to read user input.
	static String getData() {
		String data = "";
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			data = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}
}
