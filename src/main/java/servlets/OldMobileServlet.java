package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;

import javax.persistence.criteria.CriteriaQuery;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.*;
import hibernate.utils.HibernateUtil;

/**
 * Servlet implementation class MobileServlet
 */
public class OldMobileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static long counter = 0;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OldMobileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String copyResponse = response.toString();
		System.out.println("RESPONSE IS: " + copyResponse);
		
        PrintWriter out = response.getWriter();
        out.println(copyResponse);
        
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Print response to the console.
		System.out.println("Request is: " + request.getParameter("artStyle"));
		
		// Randomize request counter.
		Random rand = new Random();
		counter = rand.nextInt(999999999);
        
        // Parse Android's request and use to configure a new Project object.
        Project project = new Project();
        project.setId(counter);
        project.setProjectName(request.getParameter("project_name"));
        project.setClientName(request.getParameter("client_name"));
        project.setCharacterName(request.getParameter("character_name"));
        project.setArtStyle(request.getParameter("art_style"));
        project.setSpecifications(request.getParameter("specifications"));
        project.setPersonCount(Integer.parseInt(request.getParameter("person_count")));
        project.setPrice(Integer.parseInt(request.getParameter("price")));
        project.setStatus(Integer.parseInt(request.getParameter("status")));
        
        // Create a new hibernate session factory.
		SessionFactory sessFact = HibernateUtil.getSessionFactory();
		// Get the current session from the session factory.
		Session session = sessFact.getCurrentSession();
		// Begin the session transaction.
		org.hibernate.Transaction tr = session.beginTransaction();
		
		// Save new project in the session variable.
		session.save(project);
		
		// Insert project object into the database.
		tr.commit();
		System.out.println("Successfully inserted");
//		sessFact.close();
		
		// Create a variable to store eventual response to Android.		
		String responseToAndroid = "";
		
        // Create a new hibernate session factory.
		sessFact = HibernateUtil.getSessionFactory();
		// Get the current session from the session factory.
		session = sessFact.getCurrentSession();
		// Begin the session transaction.
		tr = session.beginTransaction();
        
		// QUERY THE DATABASE
		CriteriaQuery<Project> cq = session.getCriteriaBuilder().createQuery(Project.class);
		cq.from(Project.class);
		List<Project> projectList = session.createQuery(cq).getResultList();
		
		for (Project projects : projectList) {
			
			responseToAndroid += "PROJECT NAME: " + projects.getProjectName() + " ";
			responseToAndroid += "CLIENT NAME: " + projects.getClientName() + " ";
			responseToAndroid += "CHARACTER NAME: " + projects.getCharacterName() + " ";
			responseToAndroid += "ART STYLE: " + projects.getArtStyle() + " ";
			responseToAndroid += "SPECIFICATIONS: " + projects.getSpecifications() + " ";
			responseToAndroid += "PERSON COUNT: " + Integer.toString(projects.getPersonCount()) + " ";
			responseToAndroid += "PRICE: $" + Double.toString(projects.getPrice()) + " ";
			responseToAndroid += "STATUS: " + Integer.toString(projects.getStatus()) + "% ";
			responseToAndroid += "|";
		}

		tr.commit();
		System.out.println("Data printed");
//		sessFact.close();
		
		// Send response to Android.
        PrintWriter out = response.getWriter();
        out.println(responseToAndroid);
	}
}
