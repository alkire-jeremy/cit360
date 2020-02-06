// This class is an implementation of the Set interface in the Java Collections Framework.
package collections;

import java.util.HashSet;
import java.util.Set;

public class HashSetExample {
    
    public static void main(String args[]) {
        // HashSet constructor.
        Set<String> hash = new HashSet<String>();
        
        // Add elements to the HashSet.
        hash.add("Fragment");
        hash.add("Break");
        hash.add("Hail");
        hash.add("Diminish");
        hash.add("Eliminate");
        hash.add("Gate");
        hash.add("Crumble");
        hash.add("Invalidate");
        hash.add("Juxtapose");
        hash.add("Kludge");
        
        // Display the contents of the HashSet.
        System.out.println(hash);
        
        // More documentation and HashSet methods can be found at: https://docs.oracle.com/javase/7/docs/api/java/util/HashSet.html
    }
}
