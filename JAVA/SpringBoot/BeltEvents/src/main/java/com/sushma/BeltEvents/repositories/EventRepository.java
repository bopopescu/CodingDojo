package com.sushma.BeltEvents.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sushma.BeltEvents.models.Event;

public interface EventRepository extends CrudRepository<Event, Long>{

	@Query("SELECT e FROM Event e WHERE state = ?1")
	List<Event> findAllEventNearBy(String state);
	
	@Query("SELECT e FROM Event e WHERE state != ?1")
	List<Event> findAllEventsNotNearYou(String state);

}
