package com.example.Luis_Angel_Glez_H.Examen2.Model;




import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="employee")
public class Employee {
	@Id //Llave primaria de la tabla
	@GeneratedValue(strategy = GenerationType.AUTO) //Se le indica que el campo ID es Autonumerico
	private long id;

	@Column(name = "surname")
	private String surname;
	
	@Column(name = "firstname")
	private String firstname;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	

}