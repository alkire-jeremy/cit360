package hibernate.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.Employee;
import hibernate.Student;

public class CreateData {

private static final Logger logger = LogManager.getLogger(CreateData.class);

	public static void main(String[] args) throws Exception {
		
		SessionFactory sessFact = HibernateUtil.getSessionFactory();
		Session session = sessFact.getCurrentSession();
		org.hibernate.Transaction tr = session.beginTransaction();
		
		Employee employee = new Employee();
		employee.setFirstName("Jeremy");
		employee.setMobileNumber("9998887777");
		employee.setAddress("1776 Independence Rd");
		session.save(employee);
		
		Student student = new Student();
		student.setId(318457);
		student.setStudentName("Ruby");
		session.save(student);

		Student student2 = new Student();
		student2.setId(654814);
		student2.setStudentName("Shadow");
		session.save(student2);
		
		tr.commit();
		System.out.println("Successfully inserted");
		sessFact.close();
	}
}