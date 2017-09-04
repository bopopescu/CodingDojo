package com.sushma.WaterBnB.services;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sushma.WaterBnB.models.Pool;
import com.sushma.WaterBnB.repositories.*;

@Service
public class PoolService {
	private UserRepository userRepository;
	private PoolRepository poolRepository;
	private ReviewRepository reviewRepository;
	public PoolService(UserRepository userRepository, PoolRepository poolRepository, ReviewRepository reviewRepository) {
		this.userRepository = userRepository;
		this.poolRepository = poolRepository;
		this.reviewRepository = reviewRepository;
	}
	public void addPool(Pool pool) {
		poolRepository.save(pool);
		
	}
	public List<Pool> findHostPool(Long hostid) {
		return poolRepository.findHostPool(hostid);
	}
	public Pool findPool(Long poolid) {
		return poolRepository.findOne(poolid);
	}
	public List<Pool> findAll() {
		return (List<Pool>) poolRepository.findAll();
	}
	public List<Pool> findlocationforPool(String location) {
		return poolRepository.findByAddressContaining(location);
	}
	

}
