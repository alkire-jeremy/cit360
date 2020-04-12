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
public class SystemTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static long counter = 0;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SystemTest() {
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
		
		// Randomize request counter.
		Random rand = new Random();
		counter = rand.nextInt(999999999);
        
        // Parse Android's request and use to configure a new Project object.
        Project project = new Project();
        project.setId(counter);
        project.setProjectName(request.getParameter("test_project_name"));
        project.setClientName(request.getParameter("test_client_name"));
        project.setCharacterName(request.getParameter("test_character_name"));
        project.setArtStyle(request.getParameter("test_art_style"));
        project.setSpecifications(request.getParameter("test_specifications"));
        project.setPersonCount(Integer.parseInt(request.getParameter("test_person_count")));
        project.setPrice(Integer.parseInt(request.getParameter("test_price")));
        project.setStatus(Integer.parseInt(request.getParameter("test_status")));
        
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
		System.out.println("Message received from Android. Data successfully inserted into the database via Hibernate.");
//		sessFact.close();
		
		// Create a variable to store eventual response to Android.		
		String responseToAndroid = "RESPONSE FROM SERVER: | You have successfully sent an HTTP POST request to the server and received a response. | You've started the TimerThread. | The data you sent was inserted into the database. | Here's a JSON string conversion of the data you sent: | ";
		
		responseToAndroid += convertToString(project);
		System.out.println("Database has been successfully queried.");
//		sessFact.close();
		
		// Send response to Android.
        PrintWriter out = response.getWriter();
        out.println(responseToAndroid);
        System.out.println("Response has been sent to Android.");
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
