package qcjson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quickconnectfamily.json.JSONException;
import org.quickconnectfamily.json.JSONUtilities;
import org.quickconnectfamily.json.ParseException;

public class Converter {
	private static final Logger logger = LogManager.getLogger(Converter.class);

	public static void main(String args[]) {

		String relativePath = "MiniSchnauzer.json";
		String absolutePath = "src/main/java/qcjson/MiniSchnauzer.json";

		// Create file.
		File qcjson = new File("src/main/java/qcjson", relativePath);

		// Create Java object.
		MiniSchnauzer prancer = new MiniSchnauzer();

		// Configure Java object.
		prancer.setName("Prancer");
		prancer.setFurColor("Salt and Pepper");
		prancer.setAge(15);
		prancer.setWeight(20);

		// Convert Java object to JSON string.
		String prancerString = convertToString(prancer);

		// Write JSON to file.
		writeToFile(qcjson, prancerString);

		// Read JSON from file.
		String fetchedJSON = readFromFile(absolutePath);
		System.out.println("JSON string written to file. JSON string:\n\n" + fetchedJSON);
		
		// Convert JSON to Java.
		MiniSchnauzer convertedObject = null;
		try {
			convertedObject = convertToJava(fetchedJSON);
		} catch (JSONException e) {
			// Logger
		} catch (ParseException e) {
			// Logger
		}
		
		System.out.println("\nJSON converted to Java object. Object attributes:\n");
		System.out.println("Name: " + convertedObject.getName());
		System.out.println("Fur color: " + convertedObject.getFurColor());
		System.out.println("Age: " + convertedObject.getAge());
		System.out.println("Weight: " + convertedObject.getWeight());
	}

	private static void writeToFile(File file, String data) {
		FileWriter fr = null;
		try {
			fr = new FileWriter(file);
			fr.write(data);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fr.close();
			} catch (IOException e) {
				// Logger
			}
		}
	}

	private static String readFromFile(String path) {
		FileReader reader = null;
		try {
			reader = new FileReader(path);
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
		}
		BufferedReader bufferedReader = new BufferedReader(reader);
		String jsonString = null;
		try {
			jsonString = bufferedReader.readLine();
		} catch (IOException e) {
			// Logger
		}
		return jsonString;
	}

	private static String convertToString(MiniSchnauzer schnauzer) {
		String data = null;
		try {
			data = JSONUtilities.stringify(schnauzer);
		} catch (org.quickconnectfamily.json.JSONException e1) {
			// Logger
		}
		return data;
	}

	private static MiniSchnauzer convertToJava(String jsonString) throws JSONException, ParseException {
		HashMap map = (HashMap)JSONUtilities.parse(jsonString);
		String name = (String)map.get("name");
		String furColor = (String)map.get("furColor");
		long age = (long)map.get("age");
		long weight = (long)map.get("weight");
		
		MiniSchnauzer fetched = new MiniSchnauzer();
		fetched.setName(name);
		fetched.setFurColor(furColor);
		fetched.setAge(age);
		fetched.setWeight(weight);
		
		return fetched;
	}
}
