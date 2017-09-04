package com.sushma.DojosandNinjas.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.sushma.DojosandNinjas.models.Ninja;
import com.sushma.DojosandNinjas.repository.DojoRepository;
import com.sushma.DojosandNinjas.repository.NinjaRepository;
import com.sushma.DojosandNinjas.repository.NinjaRepositoryPartTwo;

@Service
@Transactional
public class NinjaService {
	private final DojoRepository dojoRepository;
	private final NinjaRepository ninjaRepository;
    @Autowired 
    NinjaRepositoryPartTwo ninjaRepo;
    
    // static variable to set the number of ninjas that we want per page
    private static final int PAGE_SIZE = 2;

    public Page<Ninja> ninjasPerPage(int pageNumber) {
        // get all the ninjas page and sort them in ascending order the last name property
        PageRequest pageRequest = new PageRequest(pageNumber, PAGE_SIZE, Sort.Direction.ASC, "lastName");
        Page<Ninja> ninjas = ninjaRepo.findAll(pageRequest);
        return ninjaRepo.findAll(pageRequest);
//        return ninjaRepository.findNinjaforPages();
    }

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
