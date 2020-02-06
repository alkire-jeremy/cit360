package json.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class Employee {
	 private String firstName;
	 private String lastName;
//	 List <Address> address = new ArrayList <Address> ();

	 // Getter Methods 
	 public String getFirstName() {
	  return firstName;
	 }

	 public String getLastName() {
	  return lastName;
	 }

	 // Setter Methods 
	 public void setFirstName(String firstName) {
	  this.firstName = firstName;
	 }

	 public void setLastName(String lastName) {
	  this.lastName = lastName;
	 }
	 
	 public String toString(){
		return "Employee[firstName= "+firstName+"   lastName= "+lastName+"]";
	 }
	}