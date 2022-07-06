package com.example.Luis_Angel_Glez_H.Examen2.Service;

import java.util.List;

import com.example.Luis_Angel_Glez_H.Examen2.Model.Airport;
public interface AirportService {


	Airport neww(Airport airport);

	
	Airport update(Airport airport);
	
	
	List<Airport> getAll();


	Airport getById(long airportId);

	
	void deleteAirport(long id);
}
