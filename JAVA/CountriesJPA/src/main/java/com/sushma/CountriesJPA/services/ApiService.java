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

	public List<Object[]> findCountryByLanguage() {
		
		return CountryRepo.findAllCountriesWLanguage();
	}

	public List<Object[]> findTotalNumberCitiesCountry() {
		// TODO Auto-generated method stub
		return CityRepo.findTotalCities();
	}

	public List<Object[]>  getMexicoCities() {
		return CityRepo.getMexicoCities();
	}

	public List<Object[]> percentagegreaterthan89() {
		return LanguageRepo.precentagegreaterthan89();
	}

	public List<Object[]>  findSAandpopulation() {
		return CountryRepo.findSAandpopulation();
	}

	public List<Object[]> findCMlife() {
		// TODO Auto-generated method stub
		return CountryRepo.findCMlife();
	}

	public Object findArgentina() {
		return CountryRepo.findArgentina();
	}

	public List<Object[]> summarizeNumberCountries() {
		return CountryRepo.summarizeNumberCountries();
	}

}
