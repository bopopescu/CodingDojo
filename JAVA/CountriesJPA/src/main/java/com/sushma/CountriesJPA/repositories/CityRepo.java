package com.sushma.CountriesJPA.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sushma.CountriesJPA.models.Cities;
@Repository
public interface CityRepo extends CrudRepository<Cities, Long>{
    @Query(value="SELECT c.name, count(ci.id) as total from Cities ci JOIN ci.country c group by c.id order by total desc")
    List<Object[]> findTotalCities();

    @Query(value="SELECT c.name, ci.name, ci.population from Cities ci JOIN ci.country c where c.name = 'Mexico' and ci.population > 500000 order by ci.population desc")
	List<Object[]> getMexicoCities();
    

}
