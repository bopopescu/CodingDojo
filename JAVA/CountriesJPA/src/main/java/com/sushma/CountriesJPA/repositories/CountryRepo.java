package com.sushma.CountriesJPA.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sushma.CountriesJPA.models.Countries;
import com.sushma.CountriesJPA.models.Languages;
import com.sushma.CountriesJPA.models.Cities;
@Repository
public interface CountryRepo  extends CrudRepository<Countries, Long>{
    @Query(value="SELECT c.name, l.language, l.percentage from Countries c JOIN c.languages l WHERE l.language='Slovene'"+ "ORDER BY l.percentage DESC")
    List<Object[]> findAllCountriesWLanguage();

}
