package com.sushma.WaterBnB.services;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sushma.WaterBnB.models.Pool;
import com.sushma.WaterBnB.models.Review;
import com.sushma.WaterBnB.repositories.*;

@Service
public class ReviewService {
	private UserRepository userRepository;
	private PoolRepository poolRepository;
	private ReviewRepository reviewRepository;
	public ReviewService(UserRepository userRepository, PoolRepository poolRepository, ReviewRepository reviewRepository) {
		this.userRepository = userRepository;
		this.poolRepository = poolRepository;
		this.reviewRepository = reviewRepository;
	}
	public void addReview(Review review, Long poolid) {
//		Pool yeppool = poolRepository.findOne(poolid);
//		System.out.println(poolid);
//		review.setPool(yeppool);
		reviewRepository.save(review);
		
	}
	public List<Review> findReviewsPool(Long poolid) {
		return reviewRepository.findReviewsforPool(poolid);
	}
	public Float findTotalAvgRatingforPool(Long poolid) {
		return reviewRepository.findTotalAvgRatingforPool(poolid);
	}
}
