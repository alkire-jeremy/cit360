/*
 * @author Jeremy James Alkire
 */
package mvc.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RequestData {
	
	// Request data from user necessary to configure athlete information.
	public static String requestAthleteData() {

		String name = "";
		int height = 0;
		double weight = 0;
		
		System.out.println("What is the name of the athlete?");
		name = (getData());
		
		System.out.println("What is the athlete's height?");
		height = (Integer.parseInt(getData()));
		
		System.out.println("What is the athlete's weight?");
		weight = (Integer.parseInt(getData()));
		
		return (name + "," + height + "," + weight);
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
