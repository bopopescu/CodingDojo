package com.sushma.WaterBnB.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sushma.WaterBnB.models.Review;

public interface ReviewRepository  extends CrudRepository<Review, Long>{
	@Query("SELECT q FROM Review q WHERE pool_id = ?1")
	List<Review> findReviewsforPool(Long poolid);

	@Query("SELECT AVG(rating) FROM Review q WHERE pool_id = ?1")
	Float findTotalAvgRatingforPool(Long poolid);

}
