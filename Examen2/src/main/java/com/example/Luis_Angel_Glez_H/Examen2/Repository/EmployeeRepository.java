package com.example.Luis_Angel_Glez_H.Examen2.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Luis_Angel_Glez_H.Examen2.Model.Employee;



//Notación para indicar que es un repositorio
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	// Con @Repository le indico los metodos principales select, create, update, delete
}

