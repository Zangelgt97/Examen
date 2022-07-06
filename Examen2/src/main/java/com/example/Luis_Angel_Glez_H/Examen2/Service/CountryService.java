package com.example.Luis_Angel_Glez_H.Examen2.Service;

import java.util.List;

import com.example.Luis_Angel_Glez_H.Examen2.Model.Country;
public interface CountryService {


	Country neww(Country country);

	
	Country update(Country country);
	
	
	List<Country> getAll();


	Country getById(long countryId);

	
	void deleteCountry(long id);
}
