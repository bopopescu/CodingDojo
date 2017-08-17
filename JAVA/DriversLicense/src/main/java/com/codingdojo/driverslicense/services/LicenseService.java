package com.codingdojo.driverslicense.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.driverslicense.models.License;
import com.codingdojo.driverslicense.models.Person;
import com.codingdojo.driverslicense.repositories.*;

@Service
public class LicenseService {
	private DriversLicenseRepository licenseRepository;
	public LicenseService(DriversLicenseRepository licenseRepository) {
		this.licenseRepository = licenseRepository;
	}
	public void addLicense(License license) {
		// TODO Auto-generated method stub
		licenseRepository.save(license);
		
	}
	public License findLicenseByIndex(Long id) {
		return  licenseRepository.findOne(id);
	}
	


}
