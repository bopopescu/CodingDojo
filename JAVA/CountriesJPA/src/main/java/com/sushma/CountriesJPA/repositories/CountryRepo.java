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

    @Query(value="SELECT c.name, c.surface_area, c.population from Countries c WHERE c.surface_area < 501 and c.population > 100000")
	List<Object[]> findSAandpopulation();

    @Query(value="SELECT c.name, c.government_form, c.capital, c.life_expectancy from Countries c WHERE c.government_form='Constitutional Monarchy' and c.capital > 200 and c.life_expectancy > 75")
	List<Object[]> findCMlife();

    @Query(value="SELECT c.name, ci.name, ci.district, ci.population from Countries c, Cities ci WHERE ci.district='Buenos Aires' and c.name = 'Argentina' and ci.population >  500000")
	List<Object[]> findArgentina();

    @Query(value="SELECT c.region, count(c) from Countries c group by region order by count(c) desc")
    List<Object[]> summarizeNumberCountries();


}
