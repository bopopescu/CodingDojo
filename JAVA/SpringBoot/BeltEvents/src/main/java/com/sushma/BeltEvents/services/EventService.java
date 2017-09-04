package com.sushma.BeltEvents.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sushma.BeltEvents.models.Event;
import com.sushma.BeltEvents.models.User;
import com.sushma.BeltEvents.repositories.*;

@Service
public class EventService {
	private EventRepository eventRepository;
	private UserRepository userRepository;
	public EventService(EventRepository eventRepository,  UserRepository userRepository) {
		this.eventRepository = eventRepository;
		this.userRepository = userRepository;
	}

	public void addEvent(Event event) {
		// TODO Auto-generated method stub
		eventRepository.save(event);
	}

	public List<Event> findAllEventNearBy(String state) {
		return eventRepository.findAllEventNearBy(state);
	}

	public List<Event> findAllEventsNotNearYou(String state) {
		return eventRepository.findAllEventsNotNearYou(state);
	}

	public void removeEvent(Long id) {
		eventRepository.delete(id);
		
	}

	public Event findEvent(Long id) {
		return eventRepository.findOne(id);
		
	}

	public void updateEvent(Long eventid, Event event) {
		eventRepository.save(event);
		
	}

	public void addUserToEvent(Long eventid, Long userid) {
		Event event = eventRepository.findOne(eventid);
		User user = userRepository.findOne(userid);
		event.getUsersattending().add(user);
		eventRepository.save(event);
		
		
	}

	public void removeUserFromEvent(Long eventid, Long userid) {
		Event event = eventRepository.findOne(eventid);
		User user = userRepository.findOne(userid);
		event.getUsersattending().remove(user);
		eventRepository.save(event);
		
	}

}
