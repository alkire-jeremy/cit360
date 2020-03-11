// This class is an implementation of the Map interface in the Java Collections Framework, although Map is not technically a collection.
package collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class HashMapExample {
	
	static Scanner scanner = new Scanner(System.in);
    
    public static void main(String args[]) {
    	
    	System.out.println("Welcome. This is an example of a HashMap.\n");

    	System.out.println("To begin, let's create a map called \"winners\".");
    	System.out.println("This map will contain a list of winners, from 1st to 6th place.");
    	
    	System.out.println("\nTo give us an easily iterable list of keys, let's populate our keys from an array.");
    	System.out.println("(This is likely bad practice, but this is just for an example.)");
    	String[] keyNames = { "First", "Second", "Third", "Fourth", "Fifth", "Sixth" };
    	
    	waitForInput();
    	
        // HashMap constructor. It takes two arguments in the diamond operator to specify object data types.
        Map<String, String> winners = new HashMap<String, String>();
        
        // Add elements to the HashMap with the put() method inherited from the Map class.
        winners.put(keyNames[0], "James");
        winners.put(keyNames[1], "Franky");
        winners.put(keyNames[2], "Robert");
        winners.put(keyNames[3], "Nancy");
        winners.put(keyNames[4], "Margie");
        winners.put(keyNames[5], "Rusty");
        
        System.out.println("SYSTEM: A HashMap has been created.");
        
        // Display the contents of the HashMap.
        System.out.println("\nThe contents of the map are as follows: \n" + winners);
        
        waitForInput();
        
        System.out.println("Maps allow us to pair two values together in the same structure.");
        System.out.println("They are segmented into key-value pairs. This allows us to access specific items in the map based on their key.");

        waitForInput();
        
        System.out.println("To demonstrate this, let us begin by listing the keys in the map:");
        System.out.println(winners.keySet());
        
        waitForInput();
        
        System.out.println("Now, let's get the values of these keys by passing each of these keys (one at a time) into the arguments of the get() method.\n");
        
        System.out.println(winners.get("First"));
        System.out.println(winners.get("Second"));
        System.out.println(winners.get("Third"));
        System.out.println(winners.get("Fourth"));
        System.out.println(winners.get("Fifth"));
        System.out.println(winners.get("Sixth"));
        
        waitForInput();
        
        System.out.println("This is the power of maps. Rather than arbitrarily accessing elements by their index number (such as in arrays), we have a meaningful key name attached to each value.");
        
        waitForInput();
        
        System.out.println("Additionally, we can detect whether the map contains a specific value or key as well. Let's search for the key called \"First\".");
        System.out.println("To do this, we'll call the containsKey() method and pass \"First\" to it as an argument. This should return true below.\n");
        System.out.println(winners.containsKey("First"));
        
        waitForInput();
        
        System.out.println("Now, let's see if the map contains a certain value: Robert.");
        System.out.println("To do this, we'll call the containsValue() method and pass \"Robert\" to it as an argument. This should return true below.\n");
        System.out.println(winners.containsValue("Robert"));
        
        waitForInput();
        
        System.out.println("Now, let's try to change who is in First Place.");
        System.out.println("To do this, let's call the replace() method and give it two arguments: A key (\"First\") and a new value.");
        System.out.println("\nBear in mind, the existing value for the key \"First\" is " + winners.get("First") + ".");
        
        waitForInput();
        
        winners.replace("First", "Travis");
        System.out.println("Now, let's see the results of our changes:\n");
        
        // Get a set of entries from the HashMap.
        Set<?> set = winners.entrySet();
        
        // Get an iterator from the Set.
        Iterator<?> i = set.iterator();
        
        // Display elements of the HashMap, by referencing key and value one at a time.
        while(i.hasNext()) {
            @SuppressWarnings("unchecked")
            Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>)i.next();
            System.out.print(entry.getKey() + ": ");
            System.out.println(entry.getValue());
        }

        waitForInput();
        
        System.out.println("Now, let's do something really fancy. Let's call the forEach() method and combine it with the replace() method.");
        System.out.println("We'll use this to convert all map values to lower case.");
        
        winners.forEach((k, v) -> winners.replace(k, v.toLowerCase()));

        System.out.println("\nLet's see the results: \n");
        
        for (int x = 0; x < keyNames.length; x++) {
        	System.out.println(winners.get(keyNames[x]));
        }
        
        System.out.println("\nIn short: Maps are an excellent way of storing data that needs to be structured in pairs. "
        		+ "\nCases in which maps may be useful or optimal should be extremely common!"
        		+ "\nThese could be used to store definitions, accounts, placements, and many more items with paired structures.");
        
        waitForInput();
        
        System.out.println("However, HashMaps only allow one null key. That said, they allow many null values.");
        System.out.println("Another thing to note is that they don't have a guaranteed or reliable order.");
        System.out.println("This was likely noticable when we added the keys First, Second, Third, Fourth, Fifth, and Sixth, only to see them displayed out of order.");
        
        waitForInput();
        
        System.out.println("That summarizes this example of HashMaps.");
        
        
        /* Documentation on the Map class can be found at: https://docs.oracle.com/javase/7/docs/api/java/util/Map.html
         * Documentation on the HashMap class can be found at: https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html 
         * Additional HashMap documentation and examples can be found at: https://www.tutorialspoint.com/java/java_hashmap_class.htm
         * Documentation on the Set class can be found at: https://docs.oracle.com/javase/7/docs/api/java/util/Set.html
         * Documentation on the Iterator class can be found at: https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
         * Additional Iterator usage documentation can be found at: https://www.tutorialspoint.com/java/java_using_iterator.htm */
    }
    
	public static void sleep(int milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void waitForInput() {
		sleep(500);
		System.err.print("\nHit any key to continue.\n");
		scanner.nextLine();
	}
}
