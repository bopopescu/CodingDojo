package com.sushma.DojosandNinjas.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sushma.DojosandNinjas.models.Ninja;

public interface NinjaRepository extends CrudRepository<Ninja, Long>{
	List<Ninja> findNinjaBydojo_id(Long dojo_id);
}
