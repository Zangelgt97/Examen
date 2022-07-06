package com.example.Luis_Angel_Glez_H.Examen2.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.Luis_Angel_Glez_H.Examen2.Model.Employee;
//import com.example.springboot.app.exception.ResourceNotFoundException;
import com.example.Luis_Angel_Glez_H.Examen2.Repository.EmployeeRepository;
import com.example.Luis_Angel_Glez_H.Examen2.Service.EmployeeService;
import com.example.Luis_Angel_Glez_H.Examen2.Exception.ResourceNotFoundException;

@Service 
@Transactional 
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee neww(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee update(Employee employee) {
		Optional<Employee> employeedb = this.employeeRepository.findById(employee.getId());

		if (employeedb.isPresent()) {
			Employee employeeUpdate = employeedb.get();
			employeeUpdate.setId(employee.getId());
			employeeUpdate.setFirstname(employee.getFirstname());
			employeeUpdate.setSurname(employee.getSurname());
			employeeRepository.save(employeeUpdate);
			return employeeUpdate;
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + employee.getId());
		}
	}

	@Override
	public List<Employee> getAll() {
		return this.employeeRepository.findAll();
	}

	@Override
	public Employee getById(long employeeId) {

		Optional<Employee> employeedb = this.employeeRepository.findById(employeeId);

		if (employeedb.isPresent()) {
			return employeedb.get();
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + employeeId);
		}
	}

	@Override
	public void deleteEmployee(long employeeId) {
		Optional<Employee> employeedb = this.employeeRepository.findById(employeeId);

		if (employeedb.isPresent()) {
			this.employeeRepository.delete(employeedb.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + employeeId);
		}

	}
}