package com.sushma.BeltExam.services;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sushma.BeltExam.repositories.RoleRepository;
import com.sushma.BeltExam.repositories.UserRepository;
import com.sushma.BeltExam.models.GetPackage;
import com.sushma.BeltExam.repositories.PackageRepository;

@Service
public class PackageService {
	private UserRepository userRepository;
	private RoleRepository roleRepository;
	private PackageRepository packageRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public PackageService(UserRepository userRepository, RoleRepository roleRepository, PackageRepository packageRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.packageRepository = packageRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	public void savePackage(GetPackage getpackage) {
		packageRepository.save(getpackage);
		
	}

	public List<GetPackage> findallPackages() {
		return (List<GetPackage>) packageRepository.findAll();
	}

	public void deactivate(Long packid) {
		GetPackage pack = packageRepository.findOne(packid);
		pack.setAvailable("Unavailable");
		packageRepository.save(pack);
		
	}

	public void activate(Long packid) {
		GetPackage pack = packageRepository.findOne(packid);
		pack.setAvailable("Available");
		packageRepository.save(pack);
		
	}

	public void delete(Long id) {
		packageRepository.delete(id);
		
	}

//	public void addPackage(Package getpackage) {
////		packageRepository.save(getpackage);
//		
//	}

}
