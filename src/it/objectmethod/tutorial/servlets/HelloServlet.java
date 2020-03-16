package it.objectmethod.tutorial.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2756160116478862035L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String nome = req.getParameter("nomeutente"); // http://localhost:8080/tutorial-servlet-etlabora/ciao?nomeutente=Ivan

//		PrintWriter out = resp.getWriter();
//		out.write("<html><body><h1> CIAO " + nome + "!!!</h1></body></html>");
		
		req.setAttribute("nomepassato", nome);
		req.getRequestDispatcher("pages/hello.jsp").forward(req, resp); 

	}

}
