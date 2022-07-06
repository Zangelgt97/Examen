package com.example.Luis_Angel_Glez_H.Examen2.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.Luis_Angel_Glez_H.Examen2.Model.Airport;
//import com.example.springboot.app.exception.ResourceNotFoundException;
import com.example.Luis_Angel_Glez_H.Examen2.Repository.AirportRepository;
import com.example.Luis_Angel_Glez_H.Examen2.Service.AirportService;
import com.example.Luis_Angel_Glez_H.Examen2.Exception.ResourceNotFoundException;

@Service 
@Transactional 
public class AirportServiceImpl implements AirportService {

	@Autowired
	private AirportRepository airportRepository;

	@Override
	public Airport neww(Airport airport) {
		return airportRepository.save(airport);
	}

	@Override
	public Airport update(Airport airport) {
		Optional<Airport> employeedb = this.airportRepository.findById(airport.getId());
        //gettes and setters
		if (employeedb.isPresent()) {
			Airport airportUpdate = employeedb.get();
			airportUpdate.setId(airport.getId());
			airportUpdate.setName(airport.getName());
			airportRepository.save(airportUpdate);
			return airportUpdate;
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + airport.getId());
		}
	}

	@Override
	public List<Airport> getAll() {
		return this.airportRepository.findAll();
	}

	@Override
	public Airport getById(long airportId) {

		Optional<Airport> employeedb = this.airportRepository.findById(airportId);

		if (employeedb.isPresent()) {
			return employeedb.get();
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + airportId);
		}
	}

	@Override
	public void deleteAirport(long airportId) {
		Optional<Airport> employeedb = this.airportRepository.findById(airportId);

		if (employeedb.isPresent()) {
			this.airportRepository.delete(employeedb.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + airportId);
		}

	}
}