package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionExample {
    
    // List collection of Strings: variable declaration and initialization.
    // The declaration below is equivalent to the following comment.
    //    List<String> groupA = new ArrayList<>();
    //    {
    //        groupA.add("1");
    //        groupA.add("2");
    //        groupA.add("3");
    //    }
    static List<String> groupA = Arrays.asList(new String[] {"1","2","3"});
    
    public static void main(String[] args) {
        /* The code below accomplishes a few things:
         * - It is a conversion constructor, which initializes a new collection.
         * - It declares a variable for a List of Strings called "groupB".
         * - This populates the collection "groupB" with all of the elements in another specified collection (groupA).
         * In other words, it initializes the collection variable "groupB" with the collection type and collection elements specified on the right (groupA).
         * 
         * The below statement is formatted as: 
         * CollectionInterface<DataType> VariableName = new CollectionImplementation<DataType>(Collection)
         * */
    	System.out.println("At the beginning of this program we create two collections, each of which are mere Lists of Strings.\n");
    
    	System.out.println("The first collection, groupA, is initialized with three values: 1, 2, and 3.");
    	System.out.println("The second collection, groupB, is initialized with the elements of groupA via a conversion constructor.\n");
    	
        List<String> groupB = new ArrayList<String>(groupA);
        
        System.out.println("The contents of groupB are as follows:\n");
        
        for (String name : groupB)
            System.out.println(name);
        
        System.out.println("\nNow, let's add numbers 4-9 to the end of groupB with the add() method.\n");
        groupB.add("4");
        groupB.add("5");
        groupB.add("6");
        groupB.add("7");
        groupB.add("8");
        groupB.add("9");
        System.out.println(groupB);
        
        System.out.println("\nNow, let's remove all items included in groupA from groupB with the removeAll() method.\n");
        groupB.removeAll(groupA);
        System.out.println(groupB);
        
        System.out.println("\nNow, let's add all items included in groupA back into groupB with the addAll() method.\n");
        groupB.addAll(groupA);
        System.out.println(groupB);
        
        System.out.println("\nNow, let's remove all items from the list with the clear() method.");
        groupB.clear();
        System.out.println(groupB);
        
        /*
         * Collection methods include:
         * - size()
         * - isEmpty()
         * - contains()
         * - iterator()
         * - toArray()
         * - add()
         * - remove()
         * - containsAll()
         * - addAll()
         * - removeAll()
         * - removeIf()
         * - retainAll()
         * - clear()
         * - hashCode()
         * - spliterator()
         * - stream()
         * - parallelStream()
         */
    }
}
