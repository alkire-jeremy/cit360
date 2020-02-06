package acp;

import java.util.HashMap;
import java.util.Map;

public class CommandHelper {
	private static final Map<String, String> commandMap = new HashMap<String, String>();
	static {
		commandMap.put("Christmas1", "Christmas1.jsp");
		commandMap.put("Christmas2", "Christmas2.jsp");
		commandMap.put("Christmas3", "Christmas3.jsp");
		commandMap.put("Christmas4", "Christmas4.jsp");
		commandMap.put("SystemTest", "SystemTest.jsp");
	}
	
	// get(key) and return value from commandMap.
    public static String getPage(String command) {
        return commandMap.get(command);
    }
}