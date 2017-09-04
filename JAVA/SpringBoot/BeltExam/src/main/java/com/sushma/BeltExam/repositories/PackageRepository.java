package com.sushma.BeltExam.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sushma.BeltExam.models.GetPackage;

@Repository
public interface PackageRepository extends CrudRepository<GetPackage, Long> {
	@Query("SELECT p FROM GetPackage p")
	List<GetPackage> findAllPackages();


}
