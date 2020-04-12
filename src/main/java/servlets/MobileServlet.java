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

import org.quickconnectfamily.json.JSONUtilities;

/**
 * Servlet implementation class MobileServlet
 */
public class MobileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static long counter = 0;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MobileServlet() {
        super();
    	TimerThread timer = new TimerThread();
    	timer.start();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Print response to the console.
//		System.out.println("Request is: " + request.getParameter("artStyle"));
		
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
		
		// Iterate through projectList.
		for (Project projects : projectList) {
			// Convert Project object from "projects" list to JSON string. Append to responseToAndroid variable. Separate with delimiter symbol to prepare for Android string parsing.
			responseToAndroid += convertToString(projects) + "|";
		}

		tr.commit();
		System.out.println("Data printed");
//		sessFact.close();
		
		// Send response to Android.
        PrintWriter out = response.getWriter();
        out.println(responseToAndroid);
	}
	
	private static String convertToString(Project project) {
		String data = null;
		try {
			data = JSONUtilities.stringify(project);
		} catch (org.quickconnectfamily.json.JSONException e1) {
			// Logger
		}
		return data;
	}
}
