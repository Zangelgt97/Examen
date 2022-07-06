package com.example.Luis_Angel_Glez_H.Examen2.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.Luis_Angel_Glez_H.Examen2.Model.Airport;
import com.example.Luis_Angel_Glez_H.Examen2.Service.AirportService;
import com.example.Luis_Angel_Glez_H.Examen2.Exception.Mensaje;



@RestController
@RequestMapping("/Examen2Airport")
public class AirportController {

	@Autowired
	private	AirportService airportservice;

	
	@GetMapping("/Find_AllAirport")
	public ResponseEntity<?> getAll() {
		List<Airport> lista = airportservice.getAll();
		if(lista.isEmpty()){
			return new ResponseEntity<>(new Mensaje("Sin cosas en la Base de Datos"), HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok().body(airportservice.getAll());
	}


	@GetMapping("/Find_By_id_Airport/{id}")
	public ResponseEntity<Airport> getbyId(@PathVariable long id) {
		return ResponseEntity.ok().body(airportservice.getById(id));
	
	}
	
	
	@PostMapping("/NewAirport")
	public ResponseEntity<Airport>neww(@RequestBody Airport airport) {
		return ResponseEntity.ok().body(this.airportservice.neww(airport));
	}
	


	@PutMapping("/UpdateAirport/{id}")
	public ResponseEntity<Airport> update(@PathVariable long id, @RequestBody Airport airport) {
		airport.setId(id);
		return ResponseEntity.ok().body(this.airportservice.update(airport));
	}

	
	@DeleteMapping("/DeleteAirport/{id}")
	public HttpStatus delete(@PathVariable long id) {
		this.airportservice.deleteAirport(id);
		return HttpStatus.OK;
	}
}