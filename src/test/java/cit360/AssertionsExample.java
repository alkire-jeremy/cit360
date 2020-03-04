package cit360;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

/*
 * Author: Jeremy Alkire
 */

public class AssertionsExample {

	@Test
	public void testAssertions() {

		String hashOne = "76d80224611fc919a5d54f0ff9fba446";
		String hashTwo = "3ea594bd990e34810fd3bd7d0aa616ce";
		String hashThree = "76d80224611fc919a5d54f0ff9fba446";
		
		String[] activeAccounts = {"James", "Franky", "Robert", "Nancy"};
		String[] frozenAccounts = {"Amber", "Amber", "Amber", "Amber"};
		String[] silverAccounts = {"James", "Franky", "Robert", "Nancy"};
		
		Person nicodemus = new Person("Nicodemus", 74);
		Person nicodemusClone = nicodemus;
		Person edwin = new Person("Edwin", 54);
		Person edwinClone = edwin;
		
		assertTrue("The hashes are equal.", hashOne == hashThree); // Should PASS the test.
		assertFalse("The hashes are not equal.", hashOne == hashTwo); // Should PASS the test.
		assertEquals(hashOne, hashThree); // Should PASS the test.
		assertArrayEquals(activeAccounts, silverAccounts); // Should PASS the test.
		assertNotSame(nicodemus, edwin); // Should PASS the test. These variables reference different objects.
		assertNotNull(edwin); // Should PASS the test. "edwin" is not null.
		assertSame(edwin, edwinClone); // Should PASS the test. "edwin" and "edwinClone" both reference the same object.

		assertArrayEquals(activeAccounts, frozenAccounts); // Should FAIL the test.
		assertNotSame(nicodemus, nicodemusClone); // Should FAIL the test. These variables both reference the same object.
		assertNull(edwin); // Should FAIL the test. "edwin" is not null.

		
		@SuppressWarnings("unused")
		int variableOne = 5;
		int variableTwo = 10;
		int answer = 15;
		boolean flag = false;
		
		if (variableOne + variableTwo == answer) {
			flag = true;
		}
		
		assertTrue(flag); // Should pass the test.
		
		Dog prancer = new Dog();
		prancer.setName("Prancer");
		prancer.setFurColor("Salt and Pepper");
		prancer.setEyeColor("Brown");
		
		Dog shadow = new Dog();
		prancer.setName("Shadow");
		prancer.setFurColor("Salt and Pepper");
		prancer.setEyeColor("Brown");
		
		Dog ruby = new Dog();
		ruby.setName("Ruby");
		ruby.setFurColor("Black");
		ruby.setEyeColor("Brown");
		
		// Should all pass the test.
		assertNotSame(prancer, shadow);
		assertNotSame(shadow, ruby);
		assertNotNull(prancer.getName());
		assertNotNull(prancer.getFurColor());
		assertNotNull(prancer.getEyeColor());
	}
	
	class Dog {
		String name;
		String furColor;
		String eyeColor;
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getFurColor() {
			return furColor;
		}
		public void setFurColor(String furColor) {
			this.furColor = furColor;
		}
		public String getEyeColor() {
			return eyeColor;
		}
		public void setEyeColor(String eyeColor) {
			this.eyeColor = eyeColor;
		}
	}
	
	public class Person {
		
		private String name;
		private int age;
		
		public Person(String name, int age) {
			setName(name);
			setAge(age);
			System.out.println("A new person has been created.");
		}
		
		public void setName(String name) {
			this.name = name;
		}
		
		public String getName() {
			return name;
		}
		
		public void setAge(int age) {
			this.age = age;
		}
		
		public int getAge() {
			return age;
		}
	}
}
