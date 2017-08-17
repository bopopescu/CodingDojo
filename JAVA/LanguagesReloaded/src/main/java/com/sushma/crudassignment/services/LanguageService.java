package com.sushma.crudassignment.services;

import java.util.*;

import org.springframework.stereotype.Service;

import com.sushma.crudassignment.models.Language;
import com.sushma.crudassignment.repositories.LanguageRepository;

@Service
public class LanguageService {
	//initialize the language variable with values
	private LanguageRepository languageRepository;
	public LanguageService(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}
	
	private List<Language> languages = new ArrayList<Language>(Arrays.asList(
			new Language("Java", "James Gosling", "1.8"),
			new Language("Python", "Guido van Rossum", "3.6"),
			new Language("JavaScript", "Brendan Eich", "1.9.5.2.3.2472")
			
	));
	
	public List<Language> allLanguages(){
		return (List<Language>) languageRepository.findAll();
	}

	public Language findLanguagesByIndex(Long index) {
		return languageRepository.findOne(index);
	}
	
	public void addLanguage(Language language) {
		System.out.println("in addLanguage in service");
		languageRepository.save(language);
	}
	
	public void removeLanguage(Long id) {
		languageRepository.delete(id);
	}
	
	public void updateLanguage(Long index, Language language) {
		languageRepository.save(language);
	}
	

	

	
	
}
