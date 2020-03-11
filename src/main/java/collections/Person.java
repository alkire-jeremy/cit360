package collections;

public class Person {
	
	private String name;
	private int age;
	
	// Constructor.
	public Person() {
		System.out.println("A new person has been created.");
	}
	
	// Getters & setters.
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
