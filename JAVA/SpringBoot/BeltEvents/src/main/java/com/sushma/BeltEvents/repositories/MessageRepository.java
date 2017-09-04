package com.sushma.BeltEvents.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sushma.BeltEvents.models.Message;

public interface MessageRepository extends CrudRepository<Message, Long>{
	@Query("SELECT m FROM Message m WHERE event_id = ?1")
	List<Message> findMessageforEvent(Long eventid);
	
	@Query("DELETE FROM Message m WHERE event_id = ?1")
	List<Message> deleteMessageforEvent(Long eventid);
	
	

}
