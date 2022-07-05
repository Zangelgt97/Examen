package com.examen_Luis_Angel_Glez.Examen.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examen_Luis_Angel_Glez.Examen.Model.Thinks;

//import com.example.springboot.app.model.Product;

//Notación para indicar que es un repositorio
@Repository
public interface ThinksRepository extends JpaRepository<Thinks, Long> {
	// Con @Repository le indico los metodos principales select, create, update, delete
}

