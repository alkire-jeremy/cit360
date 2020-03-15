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
	}
	
	// Configure athlete according to method arguments.
	public void configureAthlete(String chosenName, int chosenHeight, double chosenWeight) {
		setName(chosenName);
		setHeight(chosenHeight);
		setWeight(chosenWeight);
	}
	
	// Getters & setters for name.
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	// Getters & setters for height.
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
	// Getters & setters for weight.
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public boolean isConfigured() {
		boolean response = false;
		
		// If name has a length greater than 1, height is greater than 0, and weight is greater than 0, return true.
		if (name.length() > 1 && height > 0 && weight > 0) {
			response = true;
		}
		
		return response;
	}
}
