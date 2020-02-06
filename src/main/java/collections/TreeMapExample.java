// This class is an implementation of the Map interface in the Java Collections Framework.
package collections;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapExample {
    public static void main(String args[]) {
        // TreeMap constructor.
        Map<Integer, String> rank = new TreeMap<Integer, String>();
        
        // Add elements to the TreeMap via the put() method inherited from the Map class.
        rank.put(10, "Second Lieutenant");
        rank.put(9, "First Lieutenant");
        rank.put(8, "Captain");
        rank.put(7, "Major");
        rank.put(6, "Lieutenant Colonel");
        rank.put(5, "Colonel");
        rank.put(4, "Brigadier General");
        rank.put(3, "Major General");
        rank.put(2, "Lieutenant General");
        rank.put(1, "Chief of Staff");
        
        // Display contents of the TreeMap.
        System.out.println(rank + "\n");
        
        // Get a set of entries from the TreeMap.
        Set<?> set = rank.entrySet();
        
        // Get an iterator from the Set.
        Iterator<?> i = set.iterator();
        
        // Display elements of the TreeMap, by referencing key and value one at a time.
        while(i.hasNext()) {
            @SuppressWarnings("unchecked")
            Map.Entry<Integer, String> entry = (Map.Entry<Integer, String>)i.next();
            System.out.print(entry.getKey() + ": ");
            System.out.println(entry.getValue());
        }
        /* Documentation on TreeMap can be found at: https://docs.oracle.com/javase/7/docs/api/java/util/TreeMap.html
         * Additional documentation can be found at: https://www.tutorialspoint.com/java/java_treemap_class.htm
         */
    }
}
