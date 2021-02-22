package it.objectmethod.tutorial.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/test")
public class TestSessionServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String nomeParam = req.getParameter("nome");

		String nomeSession = (String) session.getAttribute("nome-session");
		if (nomeSession == null) {
			nomeSession = "Nessun nome in session";
		}

		session.setAttribute("nome-session", nomeParam);

		PrintWriter writer = resp.getWriter();
		writer.write("Nome in session: " + nomeSession + "<br>Nuovo nome: " + nomeParam);
	}

}
