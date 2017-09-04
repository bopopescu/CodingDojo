package com.sushma.CountriesJPA.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sushma.CountriesJPA.models.Languages;
@Repository
public interface LanguageRepo extends CrudRepository<Languages, Long>{

    @Query(value="SELECT l.language, c.name, l.percentage as percentage from Languages l JOIN l.country c where l.percentage > 89 order by percentage desc")
	List<Object[]> precentagegreaterthan89();
}
