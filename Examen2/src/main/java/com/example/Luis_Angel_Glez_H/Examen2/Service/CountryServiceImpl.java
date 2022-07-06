package com.example.Luis_Angel_Glez_H.Examen2.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.Luis_Angel_Glez_H.Examen2.Model.Country;
//import com.example.springboot.app.exception.ResourceNotFoundException;
import com.example.Luis_Angel_Glez_H.Examen2.Repository.CountryRepository;
import com.example.Luis_Angel_Glez_H.Examen2.Service.CountryService;
import com.example.Luis_Angel_Glez_H.Examen2.Exception.ResourceNotFoundException;

@Service 
@Transactional 
public class CountryServiceImpl implements CountryService {

	@Autowired
	private CountryRepository countryRepository;

	@Override
	public Country neww(Country country) {
		return countryRepository.save(country);
	}

	@Override
	public Country update(Country country) {
		Optional<Country> employeedb = this.countryRepository.findById(country.getId());
        //gettes and setters
		if (employeedb.isPresent()) {
			Country countryUpdate = employeedb.get();
			countryUpdate.setId(country.getId());
			countryUpdate.setCode(country.getCode());
			countryUpdate.setName(country.getName());
			countryRepository.save(countryUpdate);
			return countryUpdate;
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + country.getId());
		}
	}

	@Override
	public List<Country> getAll() {
		return this.countryRepository.findAll();
	}

	@Override
	public Country getById(long countryId) {

		Optional<Country> employeedb = this.countryRepository.findById(countryId);

		if (employeedb.isPresent()) {
			return employeedb.get();
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + countryId);
		}
	}

	@Override
	public void deleteCountry(long countryId) {
		Optional<Country> employeedb = this.countryRepository.findById(countryId);

		if (employeedb.isPresent()) {
			this.countryRepository.delete(employeedb.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + countryId);
		}

	}
}