package com.example.Luis_Angel_Glez_H.Examen2.Service;

import java.util.List;

import com.example.Luis_Angel_Glez_H.Examen2.Model.Employee;
public interface EmployeeService {


	Employee neww(Employee employee);

	
	Employee update(Employee employee);
	
	
	List<Employee> getAll();


	Employee getById(long employeeId);

	
	void deleteEmployee(long id);
}
