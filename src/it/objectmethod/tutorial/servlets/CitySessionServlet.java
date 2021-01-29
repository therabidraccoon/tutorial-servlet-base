package it.objectmethod.tutorial.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.objectmethod.tutorial.model.City;

@WebServlet("/city-from-session")
public class CitySessionServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		City city = (City) req.getSession().getAttribute("citta");

		PrintWriter wr = resp.getWriter();
		wr.write("Found city from session: { " + city.getName() + " - " + city.getCountry() + " - "
				+ city.getPopulation() + " }");
	}

}
