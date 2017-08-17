package com.codingdojo.driverslicense.repositories;

import org.springframework.data.repository.CrudRepository;


import com.codingdojo.driverslicense.models.License;

public interface DriversLicenseRepository extends CrudRepository<License, Long>{
	

}
