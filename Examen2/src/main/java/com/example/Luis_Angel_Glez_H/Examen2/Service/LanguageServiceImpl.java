package com.example.Luis_Angel_Glez_H.Examen2.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.Luis_Angel_Glez_H.Examen2.Model.Language;
//import com.example.springboot.app.exception.ResourceNotFoundException;
import com.example.Luis_Angel_Glez_H.Examen2.Repository.LanguageRepository;
import com.example.Luis_Angel_Glez_H.Examen2.Service.LanguageService;
import com.example.Luis_Angel_Glez_H.Examen2.Exception.ResourceNotFoundException;

@Service 
@Transactional 
public class LanguageServiceImpl implements LanguageService {

	@Autowired
	private LanguageRepository languageRepository;

	@Override
	public Language neww(Language language) {
		return languageRepository.save(language);
	}

	@Override
	public Language update(Language language) {
		Optional<Language> employeedb = this.languageRepository.findById(language.getId());

		if (employeedb.isPresent()) {
			Language languageUpdate = employeedb.get();
			languageUpdate.setId(language.getId());
			languageUpdate.setCode(language.getCode());
			languageUpdate.setName(language.getName());
			languageRepository.save(languageUpdate);
			return languageUpdate;
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + language.getId());
		}
	}

	@Override
	public List<Language> getAll() {
		return this.languageRepository.findAll();
	}

	@Override
	public Language getById(long languageId) {

		Optional<Language> employeedb = this.languageRepository.findById(languageId);

		if (employeedb.isPresent()) {
			return employeedb.get();
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + languageId);
		}
	}

	@Override
	public void deleteLanguaje(long languageId) {
		Optional<Language> employeedb = this.languageRepository.findById(languageId);

		if (employeedb.isPresent()) {
			this.languageRepository.delete(employeedb.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + languageId);
		}

	}
}
