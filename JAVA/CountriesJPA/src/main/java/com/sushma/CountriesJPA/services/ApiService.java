package com.sushma.CountriesJPA.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sushma.CountriesJPA.repositories.*;


@Service
public class ApiService {
	private CityRepo CityRepo;
	private CountryRepo CountryRepo;
	private LanguageRepo LanguageRepo;
	public ApiService(CityRepo CityRepo, CountryRepo CountryRepo, LanguageRepo LanguageRepo) {
		this.CityRepo = CityRepo;
		this.CountryRepo = CountryRepo;
		this.LanguageRepo = LanguageRepo;
	}

	public List<Object[]> findCountryByLanguage(String string) {
		
		return CountryRepo.findAllCountriesWLanguage();
	}

}
