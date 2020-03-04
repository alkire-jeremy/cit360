/*
 * @author Jeremy James Alkire
 */
package mvc.model;

public class Athlete {

	private String name = "";
	private int height = 0;
	private double weight = 0;
	
	// Default constructor.
	public Athlete () {
		System.out.println("Athlete has been created.");
	}
	
	// Configure athlete according to method arguments.
	public void configureAthlete(String chosenName, int chosenHeight, double chosenWeight) {
		setName(chosenName);
		setHeight(chosenHeight);
		setWeight(chosenWeight);
	}
	
	// Getters & setters for name.
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
		System.out.println("The athlete name has been set to: " + name + ".");
	}
	
	// Getters & setters for height.
	public int getHeight() {
		return this.height;
	}
	public void setHeight(int height) {
		this.height = height;
		System.out.println("The athlete height has been set to: " + height + ".");
	}
	
	// Getters & setters for weight.
	public double getWeight() {
		return this.weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
		System.out.println("The athlete weight has been set to: " + weight + ".");
	}
}
