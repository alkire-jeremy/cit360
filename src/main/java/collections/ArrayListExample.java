// This class is an implementation of the List interface in the Java Collections Framework.
package collections;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {
    
    public static void main (String args[]) {
        // ArrayList constructor.
        List<String> strings = new ArrayList<String>();
        
        // Add elements to list via boolean add() method.
        strings.add("One");
        strings.add("Two");
        strings.add("Three");
        strings.add("Four");
        strings.add("Five");
        strings.add("Six");
        strings.add("Seven");
        strings.add("Eight");
        strings.add("Nine");
        strings.add("Ten");

        // Display the size and contents of the list.
        System.out.println("The list is " + strings.size() + " elements long. It's contents are below:\n\n" + strings);
        
        // Modify current list elements via Object set(int index, Object element) method.
        strings.set(0, "Dauntless");
        strings.set(1, "Intrepid");
        strings.set(2, "Daring");
        strings.set(3, "Heroic");
        strings.set(4, "Valorous");
        strings.set(5, "Audacious");
        strings.set(6, "Bold");
        strings.set(7, "Valiant");
        strings.set(8, "Stouthearted");
        strings.set(9, "Courageous");
        
        // Display contents of the list.
        System.out.println("\n\nThis is the new content of the list, after editing the existing elements:\n\n" + strings);
        
        // More documentation and ArrayList methods can be found at: https://docsoracle.com/javase/8/docs/api/java/util/ArrayList.html
    }
}
