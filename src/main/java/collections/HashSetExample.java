// This class is an implementation of the Set interface in the Java Collections Framework.
package collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class HashSetExample {

	static boolean done = false;
	static Scanner scanner = new Scanner(System.in);

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String args[]) {

		// HashSet constructor.
		Set<String> winners = new HashSet<String>();
		
		slowPrint("Welcome. This is a demonstration of the HashSet collection.");
		System.out.println("\n");
		slowPrint("For example's sake, let's say we need to store the winners of a sports team."
				+ "\nEach member of team will receive an identical medal."
				+ "\n\nNo two players are identical, and each player should only receive a medal once."
				+ "\nIf the same player were to be listed twice, that could lead to confusion, or a single player receiving two medals."
				+ "\n\nFor this reason, we'll use a HashSet called \"winners\"."
				+ "\nA HashSet is optimal because it does not allow duplicate entries, which aptly resolves the potential problem of duplicates. "

				+ "\n\nTo begin, please enter the names of each person on the hypothetical winning team."
				+ "\nNote: The player names you provide will not be sorted sequentially or alphabetically."
				+ "\nWhen you've finished providing names, type Exit or exit.\n");
		
		System.out.println();

		// Prompt the user for input while not done.
		while (!done) {
			String answer = scanner.nextLine();

			// If the user's answer is not equal to "Exit" or "exit", add their answer to
			// the set.
			if (!answer.equals("Exit") && !answer.equals("exit")) {
				winners.add(answer);
			} else {
				done = true;
			}
		}

		done = false;

		// Display the contents of the HashSet.
		System.out.println("\nHere are the contents of the set \"winners\", according to the values you provided: \n\n" + winners);
		System.out.println("\nNote that they are (probably) not listed in the same order in which you added them to the set.");
		System.out.println("However, if you run this program twice and provide the same entries twice, they should retain the same order regardless of what order you add them in.");
		System.out.println("This is because while a HashSet does not have an easily recognizable sembalance of order, elements are in fact determined by the hashing algorithm.");
		
		waitForInput();

		// TEST CLONING METHOD.
		System.out.println("Now, let's test the clone() method."
				+ "\nThis method returns a shallow copy of the HashSet instance, meaning the elements themselves are not cloned, but the HashSet is."
				+ "\nTo begin, let's create a HashSet called \"people\" and another empty HashSet called \"clones\".");
		HashSet<Person> people = new HashSet<Person>();
		HashSet<Person> clones;
		
		waitForInput();
		
		System.out.println("SYSTEM: HashSet \"people\" has been created.");
		System.out.println("SYSTEM: HashSet \"clones\" has been created.");
		
		waitForInput();

		System.out.println("Next, we'll create person \"robert\" and person \"irene\", and add them to the \"people\" set.\n");
		// Create an object instance of Person.
		Person robert = new Person();
		robert.setName("Robert");
		robert.setAge(60);

		// Create another object instance of Person.
		Person irene = new Person();
		irene.setName("Irene");
		irene.setAge(63);
		
		waitForInput();

		// Add objects to the 'people' HashSet.
		people.add(robert);
		people.add(irene);
		System.out.println("SYSTEM: Two Person objects have been added to the HashSet \"people\".\n");
		
		System.out.println("Here are the names of the people we've added to the \"people\" set, called with their getName() methods:\n");
		// Iterate through the set.
		Iterator iterator = people.iterator();
		while (iterator.hasNext()) {
			// Print the name of each element.
			Person person = (Person) iterator.next();
			System.out.println(person.getName());
		}
		
		waitForInput();

		System.out.println("Now, we clone the set \"people\" and assign it to the \"clones\" variable.");
		// Clone the set.
		clones = (HashSet) people.clone();
		System.out.println("SYSTEM: The \"people\" HashSet has been cloned and assigned to the \"clones\" variable.");
		
		waitForInput();
		
		System.out.println("From here, we iterate through the \"clones\" set and change the names of each Person object to \"James\".");

		// Iterate through the clone set.
		Iterator iterator2 = people.iterator();
		while (iterator2.hasNext()) {
			// Print the name of each element.
			Person clone = (Person) iterator2.next();
			clone.setName("James");
		}
		System.out.println("SYSTEM: The names of all Person objects in the \"clones\" HashSet have been changed to \"James\".");
		
		waitForInput();
		
		System.out.println("Finally, we print the names of Person objects \"robert\" and \"irene\":");
		System.out.println("\n" + robert.getName());
		System.out.println(irene.getName());
		System.out.println("\nBoth names have been changed to James. This is because we did not clone the objects."
				+ "\nWe merely cloned the HashSet. The cloned set contains references to the same objects referenced in the first set.");
		
		waitForInput();

		System.out.println("To prove which sets are the same and which are different, let's print their hash codes:\n");
		System.out.println("The hash code of the winners HashSet is: " + winners.hashCode());
		System.out.println("The hash code of the people HashSet is: " + people.hashCode());
		System.out.println("The hash code of the clones HashSet is: " + clones.hashCode());
		
		waitForInput();
		
		slowPrint("Note that \"winners\" has a different hash code than \"people\" and \"clones\"."
				+ "\nThis is because \"winners\" is a different HashSet."
				+ "\nHowever, \"clones\" has the same hash code as \"people\" because it is a copy of the \"people\" set."
				+ "\nThat's the end of this demonstration. Thank you for your time.");

		// More documentation and HashSet methods can be found at:
		// https://docs.oracle.com/javase/7/docs/api/java/util/HashSet.html
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
	
	public static void slowPrint(String text) {
		String[] message = text.split("");
		
		for (int i = 0; i < message.length; i ++) {
			System.out.print(message[i]);
			sleep(15);
		}
	}
}