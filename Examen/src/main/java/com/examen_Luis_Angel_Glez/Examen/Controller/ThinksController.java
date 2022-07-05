package com.examen_Luis_Angel_Glez.Examen.Controller;

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

//import com.example.springboot.app.exception.Mensaje;
//import com.example.springboot.app.model.Product;
//import com.example.springboot.app.service.ProductService;
import com.examen_Luis_Angel_Glez.Examen.Model.Thinks;
import com.examen_Luis_Angel_Glez.Examen.ThinksServiceImp.ThinksService;
import com.examen_Luis_Angel_Glez.Examen.Exception.Mensaje;



@RestController
@RequestMapping("/Examen")
public class ThinksController {

	@Autowired
	private	ThinksService thinksservice;

	
	@GetMapping("/Find_All")
	public ResponseEntity<?> getAll() {
		List<Thinks> lista = thinksservice.getAll();
		if(lista.isEmpty()){
			return new ResponseEntity<>(new Mensaje("Sin cosas en la Base de Datos"), HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok().body(thinksservice.getAll());
	}


	@GetMapping("/Find_By_id/{id}")
	public ResponseEntity<Thinks> getbyId(@PathVariable long id) {
		return ResponseEntity.ok().body(thinksservice.getById(id));
	
	}
	
	
	@PostMapping("/New")
	public ResponseEntity<Thinks>neww(@RequestBody Thinks thinks) {
		return ResponseEntity.ok().body(this.thinksservice.neww(thinks));
	}
	


	@PutMapping("/Update/{id}")
	public ResponseEntity<Thinks> update(@PathVariable long id, @RequestBody Thinks thinks) {
		thinks.setId(id);
		return ResponseEntity.ok().body(this.thinksservice.update(thinks));
	}

	
	@DeleteMapping("/Delete/{id}")
	public HttpStatus delete(@PathVariable long id) {
		this.thinksservice.deleteThinks(id);
		return HttpStatus.OK;
	}
}
