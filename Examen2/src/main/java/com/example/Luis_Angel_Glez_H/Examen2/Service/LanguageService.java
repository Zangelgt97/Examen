package com.example.Luis_Angel_Glez_H.Examen2.Service;

import java.util.List;

import com.example.Luis_Angel_Glez_H.Examen2.Model.Language;
public interface LanguageService {


	Language neww(Language language);

	
	Language update(Language language);
	
	
	List<Language> getAll();


	Language getById(long languajeId);

	
	void deleteLanguaje(long id);
}
