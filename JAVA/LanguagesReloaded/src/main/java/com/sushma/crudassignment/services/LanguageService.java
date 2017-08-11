package com.sushma.crudassignment.services;

import java.util.*;

import org.springframework.stereotype.Service;

import com.sushma.crudassignment.models.Language;

@Service
public class LanguageService {
	//initialize the language variable with values
	private List<Language> languages = new ArrayList<Language>(Arrays.asList(
			new Language("Java", "James Gosling", "1.8"),
			new Language("Python", "Guido van Rossum", "3.6"),
			new Language("JavaScript", "Brendan Eich", "1.9.5.2.3.2472")
			
	));
	
	public List<Language> allLanguages(){
		return languages;
	}

	public Language findLanguagesByIndex(int index) {
		if(index < languages.size()) {
			return languages.get(index);
		}
		else {
			return null;
		}
	}
	
	public void addLanguage(Language language) {
		languages.add(language);
	}
	
	public void removeLanguage(int id) {
		languages.remove(id);
	}
	
	public void updateLanguage(int index, Language language) {
		if(index < languages.size()) {
			languages.set(index, language);
		}
	}
	

	

	
	
}
