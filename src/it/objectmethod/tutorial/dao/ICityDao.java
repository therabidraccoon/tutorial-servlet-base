package it.objectmethod.tutorial.dao;

import it.objectmethod.tutorial.model.City;

//ho aggiunto log4h2
public interface ICityDao {

	public City findCityById(Long id);

}
