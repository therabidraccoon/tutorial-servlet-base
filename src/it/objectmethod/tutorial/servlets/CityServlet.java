package it.objectmethod.tutorial.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.objectmethod.tutorial.dao.ICityDao;
import it.objectmethod.tutorial.dao.impl.CityDaoImpl;
import it.objectmethod.tutorial.model.City;

@WebServlet("/get-city")
public class CityServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cityIdReq = req.getParameter("idCitta");
		ICityDao cityDao = new CityDaoImpl();

		Long cityId = Long.parseLong(cityIdReq);
		City city = cityDao.findCityById(cityId);

		req.getSession().setAttribute("citta", city);

		PrintWriter wr = resp.getWriter();
		wr.write("Found city: { " + city.getName() + " - " + city.getCountry() + " - " + city.getPopulation() + " }");
	}
}
