package acp;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class CommandHelper {
	private static final Map<String, String> commandMap = new HashMap<String, String>();
	static {
		commandMap.put("Hibernate", "HibernateTest.jsp");
		commandMap.put("Input", "Input.jsp");
		commandMap.put("Error", "Error.jsp");
		commandMap.put("Home", "SystemTest.jsp");
	}
	
	// get(key) and return value from commandMap.
    public static String getPage(String command) {
    	
    	// Create a validator variable to determine whether or not the command matches any of the key values of our commandMap.
    	int validator = 0;
    	
    	// Remove whitespaces from the command string.
    	command = command.replaceAll("\\s+","");
    	
        // Get a set of entries from the HashMap.
        Set<?> set = commandMap.entrySet();
        
        // Get an iterator from the Set.
        Iterator<?> i = set.iterator();
        
        // Iterate through the commandMap and access each of its key values.
        while(i.hasNext()) {
            @SuppressWarnings("unchecked")
            Map.Entry<String, String> entry = (Map.Entry<String, String>)i.next();
            
            // Assign key value to a string variable.
            String key = entry.getKey();
            
            // Remove whitespaces from the key.
            key = key.replaceAll("\\s+","");
            
            // Check if the key is equal to the command. If true, increment the validator.
            if (command.equals(key)) {
            	validator++;
            }
        }

        // If the validator has not incremented, no valid entry was provided. Change command to "Error", which will forward them to the error page.
        if (validator == 0) {
        	command = "Error";
        }
        
        // Return the command.
        return commandMap.get(command);
    }
}