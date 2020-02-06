package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import threads.PlaySong;

public class ServBase extends HttpServlet {
	private String message;

	public void init() throws ServletException {
		// Do required initialization
		message = "Hello world.";
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Set response content type
		response.setContentType("text/html");

		// Actual logic goes here.
		PrintWriter out = response.getWriter();
		out.println("" + "<head>\r\n" + "<meta charset=\"UTF-8\">\r\n"
				+ "<link rel=\"stylesheet\" href=\"index.css\">\r\n" + "<title>Servlet Demo</title>\r\n"
				+ "<link href=\"https://fonts.googleapis.com/css?family=Permanent+Marker\" rel=\"stylesheet\">\r\n"
				+ "</head>" + "<body bgcolor=\"black\">\r\n" + "	<video autoplay muted loop id=\"bgvideo\">\r\n"
				+ "	<source src=\"http://music.faintdev.net/bluewave.mp4\" type=\"video/mp4\">\r\n" + "</video>\r\n"
				+ "<br>\r\n" + "<center>" + "<h3>Choose a song:</h3>\r\n" + "<form method=\"get\">\r\n"
				+ "		<input type=\"checkbox\" name=\"artist\" value=\"RZX\">RZX <input\r\n"
				+ "			type=\"checkbox\" name=\"artist\" value=\"SOUL\">SOUL <input\r\n"
				+ "			type=\"checkbox\" name=\"artist\" value=\"CHRISTMAS\">CHRISTMAS <input\r\n"
				+ "			type=\"checkbox\" name=\"artist\" value=\"STOP\">STOP MUSIC <input\r\n"
				+ "			type=\"submit\" value=\"Query\">\r\n" + "	</form>");
		PlaySong player = new PlaySong();
		
		// getServletContext().setAttribute("player", player);
		String[] artist = request.getParameterValues("artist");
		if (artist != null) {

			out.println("<div class=\"container\">You have selected:\n");
			for (int i = 0; i < artist.length; ++i) {
				out.println(artist[i]);
			}

			String value = Arrays.toString(artist);
			
			// Trim [ and ] characters before and after string.
			value = value.substring(1);
			value = value.substring(0, value.length() - 1);

			switch (value) {
			case "RZX":
				System.out.println("RZX case called.");
				player.stopSongs();
				player.setInstrumentals("http://music.faintdev.net/rzxbass.wav");
				player.setVocals("http://music.faintdev.net/starlight.wav");
				player.startSongs();
				break;
			case "SOUL":
				System.out.println("SOUL case called.");
				player.stopSongs();
				player.setInstrumentals("http://music.faintdev.net/soul.wav");
				player.setVocals("http://music.faintdev.net/starlight.wav");
				player.startSongs();
				break;
			case "CHRISTMAS":
				System.out.println("CHRISTMAS case called.");
				player.stopSongs();
				player.setInstrumentals("http://music.faintdev.net/christmas.wav");
				player.setVocals("http://music.faintdev.net/starlight.wav");
				player.startSongs();
				break;
			case "STOP":
				System.out.println("STOP case called.");
				player.stopSongs();
			}
		}
		out.println("</div><a href=\" + request.getRequestURI() + \">BACK</a></center></body>" + "</html>");
	}

	public void destroy() {
		// do nothing.
	}
}
