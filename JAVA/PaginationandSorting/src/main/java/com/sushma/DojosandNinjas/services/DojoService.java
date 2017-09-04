package com.sushma.DojosandNinjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sushma.DojosandNinjas.models.Dojo;
import com.sushma.DojosandNinjas.repository.DojoRepository;
import com.sushma.DojosandNinjas.repository.NinjaRepository;

@Service
public class DojoService {
	private final DojoRepository dojoRepository;
	private final NinjaRepository ninjaRepository;
	
	public DojoService(DojoRepository dojoRepository, NinjaRepository ninjaRepository) {
		this.dojoRepository = dojoRepository;
		this.ninjaRepository = ninjaRepository;
	}

	public void addDojo(Dojo dojo) {
		dojoRepository.save(dojo);
		
	}
	
	public List<Dojo> allDojos(){
		System.out.println("in allDojos of Dojo Service");
		return (List<Dojo>) dojoRepository.findAll();
	}

	public Dojo findDojoById(Long id) {
		return dojoRepository.findOne(id);
	}
	
	

}
