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
        List<String> groupB = new ArrayList<String>(groupA);
        
        for (String name : groupB)
            System.out.println(name);
    }
}
