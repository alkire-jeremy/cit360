package acp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ClientServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Create a new application controller, and request the parameter value entered into the "nextPage" field.
		String page = new ApplicationController().process(request.getParameter("nextPage"));
		
		// Create new dispatcher, and dispatch this request, response, and page.
		new Dispatcher().dispatch(request, response, page);
	}
}
