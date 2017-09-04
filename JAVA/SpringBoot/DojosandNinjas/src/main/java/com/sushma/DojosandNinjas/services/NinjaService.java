package com.sushma.DojosandNinjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sushma.DojosandNinjas.models.Ninja;
import com.sushma.DojosandNinjas.repository.DojoRepository;
import com.sushma.DojosandNinjas.repository.NinjaRepository;

@Service
public class NinjaService {
	private final DojoRepository dojoRepository;
	private final NinjaRepository ninjaRepository;
	
	public NinjaService(DojoRepository dojoRepository, NinjaRepository ninjaRepository) {
		this.dojoRepository = dojoRepository;
		this.ninjaRepository = ninjaRepository;
	}

	public void addNinja(Ninja ninja) {
		ninjaRepository.save(ninja);
		
	}
	
	public List<Ninja> findNinjas(Long dojoId){
		System.out.println("in findNinjas of Ninja Service");
		return (List<Ninja>) ninjaRepository.findNinjaBydojo_id(dojoId);
	}

}
