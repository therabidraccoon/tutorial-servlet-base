package it.objectmethod.tutorial.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/get-session")
public class SessionGetServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1657439038092754166L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		String output = "";
		String sessionName = (String) session.getAttribute("nome-session");

		if (sessionName != null) {
			output = "Visualizzo nome in session : " + sessionName;
		} else {
			output = "Nessun nome in session ";
		}

		PrintWriter out = resp.getWriter();
		out.print(output);

	}

}
