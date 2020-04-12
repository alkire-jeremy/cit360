// This class is an implementation of the List interface in the Java Collections Framework.
package collections;

import java.util.ArrayList;
import java.util.Scanner;

@SuppressWarnings("rawtypes")
public class ArrayListExample extends ArrayList {

	private static final long serialVersionUID = 1L;
	static Scanner scanner = new Scanner(System.in);
	static ArrayListExample adjectives;

	@SuppressWarnings("unchecked")
	public static void main(String args[]) {
		
		System.out.println("Welcome. This is an example of an ArrayList.");
		System.out.println("An ArrayList is an implementation of the Serialiable, Cloneable, Iterable, Collection, List, and RandomAccess interfaces");
		System.out.println("ArrayLists cannot store primitive data types. If you insert a primitive data type into one (such as a string) it will be converted to an object.");
		System.out.println("They have a capacity that is at least as large as the list size, and always as large as the array used to store elements in the list.");
		System.out.println("Unlike an array, the size of an ArrayList grows automatically as elements are added to it. It does not have a fixed size.");
		System.out.println("ArrayLists take up as much memory as is allocated for the specified capacity, regarldess of whether elements have been added to it.");
		System.out.println("Adding/removing from any position in the array other than the end forces elements to shift over.");
		System.out.println("To begin, let us create an ArrayList called adjectives.");
		
		waitForInput();
		
		// ArrayList constructor.
		adjectives = new ArrayListExample();
		
		// Add elements to the end of the ArrayList.
		adjectives.add("Beautiful");
		adjectives.add("Wonderful");
		adjectives.add("Excellent");
		adjectives.add("Incredible");
		
		System.out.println("Now, let's check the size.");
		System.out.println("Size: " + adjectives.size());
		System.out.println("Whle the size is four, the capacity may be larger. Let's fix that.");
		
		waitForInput();
		
		System.out.println("trimToSize()");
		// Trim ArrayList to actual size.
		adjectives.trimToSize();
		
		// Display the size and contents of the list.
		System.out.println("\nAfter calling the add() method four times, the list is " + adjectives.size() + " elements long."
				+ "\nIts contents are below:\n" + adjectives);
		
		waitForInput();
		
		System.out.println("Now, let's modify the ArrayList's contents with the set() method:");

		// Modify current list elements via Object set(int index, Object element) method.
		adjectives.set(0, "Horrible");
		adjectives.set(1, "Terrible");
		adjectives.set(2, "Abominable");
		adjectives.set(3, "Impressive");

		// Display contents of the list.
		System.out.println("\nThis is the new content of the list, after modifying the existing elements with the set() method:\n" + adjectives);
		
		waitForInput();
		
		System.out.println("Now, let's insert a new element at a specific position.");
		// Insert element at specific position.
		adjectives.add(3, "Amazing");

		// Print new contents of array list.
		System.out.println("\nAfter inserting an element at index 3, the new contents of the ArrayList are: \n" + adjectives);
		System.out.println("Other elements in the ArrayList were pushed aside to make room for the new entry.");
		
		waitForInput();
		
		System.out.println("Now, let's remove elements from a specified index range.");
		System.out.println("removeRange(0,3):");
		// Remove elements from specified range.
		adjectives.removeRange(0, 3);
		
		// Print new contents of array list.
		System.out.println("\nAfter removing elements from the index range of 0 to 3, the new contents of the ArrayList are: \n" + adjectives);
		
		System.out.println("This is just a taste of what ArrayList is capable of. In short, it should be used when you want a collection that can change size dynamically, and does not have a fixed length.");
		System.out.println("ArrayLists are cloneable, and will automatically convert primitive data types into objects. They're good for accessing elements by their index number, i.e. a specific position and performing operations on them directly.");
		System.out.println("In addition to this, they allow you to perform operations on a range of elements, rather than just one, and allow you to access elements with methods and iterators rather than []");

		// More documentation and ArrayList methods can be found at:
		// https://docsoracle.com/javase/8/docs/api/java/util/ArrayList.html
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
