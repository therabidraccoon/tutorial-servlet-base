package it.objectmethod.tutorial.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.objectmethod.tutorial.dao.ICityDao;
import it.objectmethod.tutorial.model.City;

public class CityDaoImpl implements ICityDao {

	private Connection getConnection() {
		Connection conn = null;

		try {
			// Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:33060/world", "omdev", "omdev");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return conn;
	}

	@Override
	public City findCityById(Long id) {
		Connection conn = getConnection();
		City city = null;

		String sql = "SELECT * FROM city WHERE ID = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setLong(1, id);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				city = new City();
				city.setId(rs.getLong("ID"));
				city.setCountry(rs.getString("CountryCode"));
				city.setName(rs.getString("Name"));
				city.setPopulation(rs.getLong("Population"));
			}
			rs.close();
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return city;
	}

}
