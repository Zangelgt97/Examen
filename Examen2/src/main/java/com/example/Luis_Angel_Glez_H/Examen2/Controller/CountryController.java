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


import com.example.Luis_Angel_Glez_H.Examen2.Model.Country;
import com.example.Luis_Angel_Glez_H.Examen2.Service.CountryService;
import com.example.Luis_Angel_Glez_H.Examen2.Exception.Mensaje;



@RestController
@RequestMapping("/Examen2Country")
public class CountryController {

	@Autowired
	private	CountryService countryservice;

	
	@GetMapping("/Find_AllCountry")
	public ResponseEntity<?> getAll() {
		List<Country> lista = countryservice.getAll();
		if(lista.isEmpty()){
			return new ResponseEntity<>(new Mensaje("Sin cosas en la Base de Datos"), HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok().body(countryservice.getAll());
	}


	@GetMapping("/Find_By_id_Country/{id}")
	public ResponseEntity<Country> getbyId(@PathVariable long id) {
		return ResponseEntity.ok().body(countryservice.getById(id));
	
	}
	
	
	@PostMapping("/NewCountry")
	public ResponseEntity<Country>neww(@RequestBody Country country) {
		return ResponseEntity.ok().body(this.countryservice.neww(country));
	}
	


	@PutMapping("/UpdateCountry/{id}")
	public ResponseEntity<Country> update(@PathVariable long id, @RequestBody Country country) {
		country.setId(id);
		return ResponseEntity.ok().body(this.countryservice.update(country));
	}

	
	@DeleteMapping("/DeleteCountry/{id}")
	public HttpStatus delete(@PathVariable long id) {
		this.countryservice.deleteCountry(id);
		return HttpStatus.OK;
	}
}