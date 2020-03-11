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

		// ArrayList constructor.
		adjectives = new ArrayListExample();
		
		// Add elements to the end of the ArrayList.
		adjectives.add("Beautiful");
		adjectives.add("Wonderful");
		adjectives.add("Excellent");
		adjectives.add("Incredible");

		// Trim ArrayList to actual size.
		adjectives.trimToSize();

		// Display the size and contents of the list.
		System.out.println("\nAfter calling the add() method four times, the list is " + adjectives.size() + " elements long."
				+ "\nIts contents are below:\n" + adjectives);

		// Modify current list elements via Object set(int index, Object element) method.
		adjectives.set(0, "Horrible");
		adjectives.set(1, "Terrible");
		adjectives.set(2, "Abominable");
		adjectives.set(3, "Impressive");

		// Display contents of the list.
		System.out.println("\nThis is the new content of the list, after modifying the existing elements with the set() method:\n" + adjectives);
		
		// Insert element at specific position.
		adjectives.add(3, "Amazing");

		// Print new contents of array list.
		System.out.println("\nAfter inserting an element at index 3, the new contents of the ArrayList are: \n" + adjectives);
		
		// Remove elements from specified range.
		adjectives.removeRange(0, 3);
		
		// Print new contents of array list.
		System.out.println("\nAfter removing elements from the index range of 0 to 3, the new contents of the ArrayList are: \n" + adjectives);

		// More documentation and ArrayList methods can be found at:
		// https://docsoracle.com/javase/8/docs/api/java/util/ArrayList.html
	}
}
