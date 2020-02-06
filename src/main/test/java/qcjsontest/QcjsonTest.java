package qcjsontest;

import static org.junit.Assert.assertEquals;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.junit.Test;

public class QcjsonTest {
	
	@Test
	public void testAssertions() {
		
		String idealString = "{\"name\":\"Prancer\",\"furColor\":\"Salt and Pepper\",\"age\":16,\"weight\":20}";
		String actualString = readFromFile();
		assertEquals(idealString, actualString);
	}
	
	private static String readFromFile() {
		FileReader reader = null;
		try {
			reader = new FileReader("src/main/java/qcjson/MiniSchnauzer.json");
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
}
