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


import com.example.Luis_Angel_Glez_H.Examen2.Model.Language;
import com.example.Luis_Angel_Glez_H.Examen2.Service.LanguageService;
import com.example.Luis_Angel_Glez_H.Examen2.Exception.Mensaje;



@RestController
@RequestMapping("/Examen2")
public class LanguageController {

	@Autowired
	private	LanguageService languageservice;

	
	@GetMapping("/Find_All")
	public ResponseEntity<?> getAll() {
		List<Language> lista = languageservice.getAll();
		if(lista.isEmpty()){
			return new ResponseEntity<>(new Mensaje("Sin cosas en la Base de Datos"), HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok().body(languageservice.getAll());
	}


	@GetMapping("/Find_By_id/{id}")
	public ResponseEntity<Language> getbyId(@PathVariable long id) {
		return ResponseEntity.ok().body(languageservice.getById(id));
	
	}
	
	
	@PostMapping("/New")
	public ResponseEntity<Language>neww(@RequestBody Language language) {
		return ResponseEntity.ok().body(this.languageservice.neww(language));
	}
	


	@PutMapping("/Update/{id}")
	public ResponseEntity<Language> update(@PathVariable long id, @RequestBody Language language) {
		language.setId(id);
		return ResponseEntity.ok().body(this.languageservice.update(language));
	}

	
	@DeleteMapping("/Delete/{id}")
	public HttpStatus delete(@PathVariable long id) {
		this.languageservice.deleteLanguage(id);
		return HttpStatus.OK;
	}
}