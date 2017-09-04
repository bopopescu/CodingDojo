package com.sushma.DojosandNinjas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sushma.DojosandNinjas.models.*;

public interface NinjaRepository extends CrudRepository<Ninja, Long>{
	List<Ninja> findNinjaBydojo_id(Long dojo_id);
    @Query(value="SELECT doj.name, nin.firstName, nin.lastName from Ninja nin, Dojo doj where nin.dojo.id = doj.id")
    List<Object[]> findNinjaforPages();

}
