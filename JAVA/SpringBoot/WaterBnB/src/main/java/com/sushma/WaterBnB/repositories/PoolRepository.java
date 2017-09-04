package com.sushma.WaterBnB.repositories;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sushma.WaterBnB.models.Pool;

public interface PoolRepository  extends CrudRepository<Pool, Long>{
	@Query("SELECT p FROM Pool p WHERE host_id = ?1")
	List<Pool> findHostPool(Long hostid);

	List<Pool> findByAddressContaining(String location);

}
