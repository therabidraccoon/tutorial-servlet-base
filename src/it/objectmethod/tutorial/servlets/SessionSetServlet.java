package it.objectmethod.tutorial.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/set-session")
public class SessionSetServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5631585320458316099L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		String output = "";

		String param = req.getParameter("nome");

		String sessionName = (String) session.getAttribute("pippo");
		session.setAttribute("pippo", param);

		if (sessionName != null) {
			output = "Nome già presente in session : " + sessionName + ", setto nuovo nome: " + param;
		} else {
			output = "Settato nome in session: " + param;
		}

		PrintWriter out = resp.getWriter();
		out.print(output);

	}
}
