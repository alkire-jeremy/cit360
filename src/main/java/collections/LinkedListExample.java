// This class is an implementation of the Queue and List interface in the Java Collections Framework.
package collections;

import java.util.LinkedList;
import java.util.Queue;

public class LinkedListExample {
    public static void main(String args[]) {
        /* LinkedList constructor.
         * LinkedList is an implementation that inherits from both the List and Queue interfaces.
         * Left side of this statement references one of the corresponding
         * interfaces of a LinkedList, for sake of meeting coding practices / standards.
         */
        Queue<String> elements = new LinkedList<String>();
        
        // Add elements to LinkedList.
        elements.add("Hydrogen");
        elements.add("Helium");
        elements.add("Lithium");
        elements.add("Beryllium");
        elements.add("Boron");
        elements.add("Carbon");
        elements.add("Nitrogen");
        elements.add("Oxygen");
        elements.add("Fluorine");
        elements.add("Neon");
        
        // Display the contents of the LinkedList.
        System.out.println(elements);
        
        /*
         * Documentation on the Queue interface can be found at https://docs.oracle.com/javase/tutorial/collections/interfaces/queue.html
         * Additional documentation on the Queue interface can be found at: http://www.codejava.net/java-core/collections/java-queue-collection-tutorial-and-examples
         * Documentation on the LinkedList implementation can be found at: https://docs.oracle.com/javase/7/docs/api/java/util/LinkedList.html
         */
    }
}
