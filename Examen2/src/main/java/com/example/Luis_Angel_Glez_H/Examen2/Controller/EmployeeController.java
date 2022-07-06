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


import com.example.Luis_Angel_Glez_H.Examen2.Model.Employee;
import com.example.Luis_Angel_Glez_H.Examen2.Service.EmployeeService;
import com.example.Luis_Angel_Glez_H.Examen2.Exception.Mensaje;



@RestController
@RequestMapping("/Examen2Employee")
public class EmployeeController {

	@Autowired
	private	EmployeeService employeeservice;

	
	@GetMapping("/Find_AllEmployee")
	public ResponseEntity<?> getAll() {
		List<Employee> lista = employeeservice.getAll();
		if(lista.isEmpty()){
			return new ResponseEntity<>(new Mensaje("Sin cosas en la Base de Datos"), HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok().body(employeeservice.getAll());
	}


	@GetMapping("/Find_By_id_Employee/{id}")
	public ResponseEntity<Employee> getbyId(@PathVariable long id) {
		return ResponseEntity.ok().body(employeeservice.getById(id));
	
	}
	
	
	@PostMapping("/NewEmployee")
	public ResponseEntity<Employee>neww(@RequestBody Employee employee) {
		return ResponseEntity.ok().body(this.employeeservice.neww(employee));
	}
	


	@PutMapping("/UpdateEmployee/{id}")
	public ResponseEntity<Employee> update(@PathVariable long id, @RequestBody Employee employee) {
		employee.setId(id);
		return ResponseEntity.ok().body(this.employeeservice.update(employee));
	}

	
	@DeleteMapping("/DeleteEmployee/{id}")
	public HttpStatus delete(@PathVariable long id) {
		this.employeeservice.deleteEmployee(id);
		return HttpStatus.OK;
	}
}