// This class is an implementation of the Queue and List interface in the Java Collections Framework.
package collections;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class LinkedListExample {
	
	static Scanner scanner = new Scanner(System.in);
	
    public static void main(String args[]) {
        /* LinkedList constructor.
         * LinkedList is an implementation that inherits from both the List and Queue interfaces.
         * Left side of this statement references one of the corresponding
         * interfaces of a LinkedList, for sake of meeting coding practices / standards.
         */
        Queue<String> elements = new LinkedList<String>();
        
        System.out.println("Welcome. This is a demonstration of a LinkedList, and by extension a Queue.");
        System.out.println("A LinkedList is an implementation that inherits from both the List and Queue interfaces.");
        System.out.println("A LinkedList stores pointers to the next and previous elements, and thus it uses more memory than alternatives such as an ArrayList.");
        System.out.println("As such, LinkedLists are often considered a suboptimal choice from a performance perspective, but this is sometimes controversial, depending on whom you ask.");
        System.out.println("To begin, we're going to add 9 elements to a LinkedList.");
        
        waitForInput();
        
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
        
        System.out.println("You can see the results below:\n");
        
        // Display the contents of the LinkedList.
        System.out.println(elements);
        
        System.out.println("\nThese elements were added in a FIFO (first-in-first-out) manner. Each new element was added to the tail of the queue. As such, it retained its order.");
        System.out.println("Since a LinkedList inherits from the Queue interface, it has access to the peek, poll, offer, element, and remove methods. Let's try those now.");
        
        waitForInput();
        
        System.out.println("poll():");
        elements.poll();
        System.out.println(elements);
        System.out.println("\nAs you can see, it removed the head of the queue. If the queue was empty, poll() would return null.");
        System.out.println("remove() does the same thing, however, if the queue was empty, remove() would throw an exception.");
        
        waitForInput();
        
        
        System.out.println("Let's try peek():");
        System.out.println(elements.peek());
        System.out.println("\npeek() retrieves (but does not remove) the head of the queue. Note that this is Helium now, not Hydrogen, was we removed the initial head with the poll() method in the previous step.");
        System.out.println("element() does the same thing, however, it throws an exception if the queue is empty.");
        
        waitForInput();
        
        System.out.println("Now, let's try offer(), with an argument of \"Silver\":");
        elements.offer("Silver");
        System.out.println(elements);
        System.out.println("\nNote that a new element called \"Silver\" was added to the end of the queue.");
        System.out.println("offer() attempts to insert the specified element at the end of the queue, provided that it is possible without violating capacity restrictions.");
        System.out.print("When inserting into capacity limited queues, this is preferable to add(), as it is a boolean method that returns true or false, and fails with a false, where as add() can only fail to insert an element by throwing an exception.");
        
        waitForInput();
        
        System.out.println("In addition to all of this, LinkedList has access to methods from the Deque interface, which allows it to be used as a LIFO (last-in-first-out) stack.");
        System.out.println("It can use methods such as: getFirst(), getLast(), removeFirst(), removeLast(), addFirst(), addLast(), offerFirst(), offerLast(), peekFirst(), peekLast(), pollFirst(), pollLast(), push(), pop(), removeFirstOccurence(), removeLastOccurence(), and more.");
        System.out.println("The power of a LinkedList is that it implements so many different interfaces. This gives it a wide range of tools that other Lists do not have, while retaining all methods inherited from the List and Collection interfaces.");
        
        /*
         * Documentation on the Queue interface can be found at https://docs.oracle.com/javase/tutorial/collections/interfaces/queue.html
         * Additional documentation on the Queue interface can be found at: http://www.codejava.net/java-core/collections/java-queue-collection-tutorial-and-examples
         * Documentation on the LinkedList implementation can be found at: https://docs.oracle.com/javase/7/docs/api/java/util/LinkedList.html
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
