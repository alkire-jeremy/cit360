// This class is an implementation of the Map interface in the Java Collections Framework.
package collections;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapExample {
	
	static Scanner scanner = new Scanner(System.in);
	
    public static void main(String args[]) {
        // TreeMap constructor.
        TreeMap<Integer, String> leaderboard = new TreeMap<Integer, String>();
        
        System.out.println("Welcome. This is an example of a TreeMap.");
        System.out.println("A TreeMap is not a true collection as it does not implement the Collection interface.");
        System.out.println("It cannot contain null keys but may contain null values.");
        System.out.println("It implements NavigableMap and SortedSet, and thus it has access to methods that HashMaps and other collections don't.");
        System.out.println("To begin, let us create a HashMap called leaderboard.");
        
        waitForInput();
        
        // Add elements to the TreeMap via the put() method inherited from the Map class.
        leaderboard.put(10, "James");
        leaderboard.put(9, "Franky");
        leaderboard.put(8, "Travis");
        leaderboard.put(7, "Selene");
        leaderboard.put(6, "Robert");
        leaderboard.put(5, "Nancy");
        leaderboard.put(4, "Margie");
        leaderboard.put(3, "Draven");
        leaderboard.put(2, "Jean");
        leaderboard.put(1, "Alexander");
        
        System.out.println("Now, let's display the contents of the map:");
        
        // Display contents of the TreeMap.
        System.out.println(leaderboard + "\n");
        
        System.out.println("The elements are displayed not in the order in which they were added to the map, but in the natural order of its keys.");
        System.out.println("In this way, a TreeMap has a typical semblance of order that other maps, such as a HashMap, do not.");
        System.out.println("This makes a TreeMap an optimal choice when you need key-value pairings that are ordered. A leaderboard is a case in which this might be needed, as you'll want to show placement, i.e. order by key, not name.");
        
        waitForInput();
        
        System.out.println("Now, let's use an iterator to display the contents of the map again, but in a more formatted manner, by individually referencing key and value one at a time:\n");
        
        
        // Get a set of entries from the TreeMap.
        Set<?> set = leaderboard.entrySet();
        
        // Get an iterator from the Set.
        Iterator<?> i = set.iterator();
        
        // Display elements of the TreeMap, by referencing key and value one at a time.
        while(i.hasNext()) {
            @SuppressWarnings("unchecked")
            Map.Entry<Integer, String> entry = (Map.Entry<Integer, String>)i.next();
            System.out.print(entry.getKey() + ": ");
            System.out.println(entry.getValue());
        }
        
        waitForInput();
        
        System.out.println("Now, let's use some of the methods we have at our disposal that we inherited from SortedMap and NavigableMap.\n");
        System.out.println("subMap(1,7):");
        System.out.println(leaderboard.subMap(1, 7));
        System.out.println("\nThis provided us with a sub map, a list of elements inside of our original map between the first and second key arguments (inclusive). So, elements 1, 2, 3, 4, 5, and 6 were displayed.");
        
        waitForInput();
        
        System.out.println("headMap(5):");
        System.out.println(leaderboard.headMap(5));
        System.out.println("\nThis provided us with a head map, a list of elements inside of our original map whose key values are LESS than the key argument we provided.");
        
        waitForInput();
        
        System.out.println("tailMap(5):");
        System.out.println(leaderboard.tailMap(5));
        System.out.println("\nThis provided us with a tail map, a list of elements inside of our original map whose key values are GREATER than the key argument we provided.");
        
        waitForInput();
        
        System.out.println("firstKey():");
        System.out.println(leaderboard.firstKey());
        System.out.println("\nThis provided us with the first key in our map.");
        
        waitForInput();
        
        System.out.println("lastKey():");
        System.out.println(leaderboard.lastKey());
        System.out.println("\nThis provided us with the last key in our map.");
        
        waitForInput();
        
        System.out.println("keySet():");
        System.out.println(leaderboard.keySet());
        System.out.println("\nThis provided us with a set of the keys in our map and returned them in ascending order.");
        
        waitForInput();
        
        System.out.println("values():");
        System.out.println(leaderboard.values());
        System.out.println("\nThis provided us with a Collection of the values contained in our map, and it returned them in key ascending order.");
        
        waitForInput();
        
        System.out.println("entrySet():");
        System.out.println(leaderboard.entrySet());
        System.out.println("This provided us with a set of the mappings contained in this map. The set's iterator returns the entries in key ascending order, telling us which value is mapped to which key.");

        waitForInput();

        System.out.println("lowerEntry(5):");
        System.out.println(leaderboard.lowerEntry(5));
        System.out.println("\nThis provided us with a key-value mapping associated with the greatest key less than the key argument we provided.");
        System.out.println("There is another method called higherEntry() that does the inverse of this.");

        waitForInput();

        System.out.println("lowerKey(5):");
        System.out.println(leaderboard.lowerKey(5));
        System.out.println("\nThis provided us with the greatest key less than the key argument we provided.");
        System.out.println("There is another method called higherKey() that does the inverse of this.");
        
        waitForInput();

        System.out.println("floorEntry(5):");
        System.out.println(leaderboard.floorEntry(5));
        System.out.println("\nThis provided us with the key-value mapping associated with the greatest key less than OR EQUAL TO the argument we provided.");
        System.out.println("There is another method called ceilingEntry() that does the inverse of this.");
        
        waitForInput();
        
        System.out.println("floorKey(5)");
        System.out.println(leaderboard.floorKey(5));
        System.out.println("\nThis provided us with the greatest key less than OR EQUAL TO the argument we provided.");
        System.out.println("There is another method called ceilingKey() that does the inverse of this.");
        
        waitForInput();
        
        System.out.println("The above was just some of the methods at our disposal when using a TreeMap. In summary, a TreeMap is a navigable, sorted map that cannot contain null keys, but can contain many null values.");
        System.out.println("TreeMaps are not as fast as HashMaps, but they are more conservative of memory.");
        System.out.println("TreeMaps are the preferred choice when we want key-value pairings, key order sorting, memory convervation, and the ability to use methods inherited from NavigableMap and SortedMap.");
        
        /* Documentation on TreeMap can be found at: https://docs.oracle.com/javase/7/docs/api/java/util/TreeMap.html
         * Additional documentation can be found at: https://www.tutorialspoint.com/java/java_treemap_class.htm
         */
    }
    
	public static void sleep(int milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void waitForInput() {
		sleep(1000);
		System.err.print("\nHit any key to continue.\n");
		scanner.nextLine();
	}
}
