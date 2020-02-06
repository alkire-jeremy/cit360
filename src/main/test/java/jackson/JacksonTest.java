package jackson;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import json.model.Employee;

public class JacksonTest {

	private static final Logger logger = LogManager.getLogger(JacksonTest.class);

//	@Ignore
	@Test
	public void testJsonToJava() {
		File json = new File("src/test/resources", "Employee.json");
//		logger.debug(json.getAbsolutePath());
		ObjectMapper mapper = new ObjectMapper();

		try {
			// Convert JSON string from file to Object
			Employee employee = mapper.readValue(json, Employee.class);
			
			System.out.println("Print the employee data from the Employee class after hydrating from JSON");
			System.out.println(employee);

			// Pretty print
			String prettyStaff1 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(employee);
			System.out.println("Print the employee JSON, after dehydrating JSON from the Employee class");
			System.out.println(prettyStaff1);

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

//	@Ignore
	@Test
	public void testJavaToJson() {
		File json = new File("src/test/resources", "EmployeeOut.json");
		ObjectMapper mapper = new ObjectMapper();
		Employee employee = createEmployee();

		try {
			// Convert object to JSON string and save into a file directly
			mapper.writeValue(json, employee);

			// Convert object to JSON string
			String jsonInString = mapper.writeValueAsString(employee);
			System.out.println(jsonInString);

			// Convert object to JSON string and pretty print
			jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(employee);
			System.out.println(jsonInString);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Employee createEmployee() {
		Employee employee = new Employee();
		employee.setFirstName("Roho");
		employee.setLastName("Dragon");
		return employee;
	}
}
