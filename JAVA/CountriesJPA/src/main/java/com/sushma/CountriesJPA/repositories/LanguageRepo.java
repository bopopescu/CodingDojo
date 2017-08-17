package com.sushma.CountriesJPA.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sushma.CountriesJPA.models.Languages;
@Repository
public interface LanguageRepo extends CrudRepository<Languages, Long>{

}
