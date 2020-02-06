package Assertions;

/*
 * This program tests various assert methods in JUnit, including assertEquals(), assertTrue(), assertNotSame() and assertNotNull()
 * When this test is run, it should only result in one failure, as the comparison between strings hashOne and hashTwo are not equal, on line 24.
 * All other assert methods should pass the test.
 * Author: Jeremy Alkire
 */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AssertionsExample {

	@Test
	public void testAssertions() {

		String hashOne = "76d80224611fc919a5d54f0ff9fba446";
		String hashTwo = "3ea594bd990e34810fd3bd7d0aa616ce";
		String hashThree = "76d80224611fc919a5d54f0ff9fba446";

		assertEquals(hashOne, hashTwo); // Should FAIL the test.
		assertEquals(hashOne, hashThree); // Should pass the test.
		
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
}
