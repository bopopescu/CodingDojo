package com.sushma.CountriesJPA.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sushma.CountriesJPA.models.Cities;
@Repository
public interface CityRepo extends CrudRepository<Cities, Long>{

}
