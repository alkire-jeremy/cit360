package hibernate.utils;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.Employee;
import hibernate.Student;

public class GetAllData {
	public static void main(String[] args) throws Exception {

		SessionFactory sessFact = HibernateUtil.getSessionFactory();
		Session session = sessFact.getCurrentSession();
		org.hibernate.Transaction tr = session.beginTransaction();
		
		CriteriaQuery<Employee> cq = session.getCriteriaBuilder().createQuery(Employee.class);
		cq.from(Employee.class);
		List<Employee> employeeList = session.createQuery(cq).getResultList();

		CriteriaQuery<Student> cqs = session.getCriteriaBuilder().createQuery(Student.class);
		cqs.from(Student.class);
		List<Student> studentList = session.createQuery(cqs).getResultList();
		
		for (Employee employee : employeeList) {
			System.out.println("ID: " + employee.getId());
			System.out.println("First Name: " + employee.getFirstName());
			System.out.println("Last Name: " + employee.getLastName());
		}
		
		for (Student student : studentList) {
			System.out.println("Student ID: " + student.getId());
			System.out.println("Student Name: " + student.getStudentName());
		}

		tr.commit();
		System.out.println("Data printed");
		sessFact.close();
	}
}