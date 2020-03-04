package hibernate.utils;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import hibernate.Employee;
import hibernate.Strings;
import hibernate.Student;

public class CreateData {

private static final Logger logger = LogManager.getLogger(CreateData.class);

	public static void main(String[] args) throws Exception {
		
		SessionFactory sessFact = HibernateUtil.getSessionFactory();
		Session session = sessFact.getCurrentSession();
		org.hibernate.Transaction tr = session.beginTransaction();
		
		Employee employee = new Employee();
		employee.setId(0);
		employee.setFirstName("Jeremy");
		employee.setLastName("Alkire");
		employee.setMobileNumber("9998887777");
		employee.setAddress("1776 Independence Rd");
		session.save(employee);
		
		Employee employee1 = new Employee();
		employee1.setId(1);
		employee1.setFirstName("Jeremy");
		employee1.setLastName("Alkire");
		employee1.setMobileNumber("9998887777");
		employee1.setAddress("1776 Independence Rd");
		session.save(employee1);
		
		Student student = new Student();
		student.setId(318457);
		student.setStudentName("Ruby");
		session.save(student);

		Student student2 = new Student();
		student2.setId(654814);
		student2.setStudentName("Shadow");
		session.save(student2);
		
//		System.out.println("Please enter a name.");
//		Scanner scanner = new Scanner(System.in);
//		String name = scanner.nextLine();
//		
//		Strings tester = new Strings();
//		tester.setId(1);
//		tester.setUsername(name);
//		session.save(tester);
		
		tr.commit();
		System.out.println("Successfully inserted");
		sessFact.close();
	}
}