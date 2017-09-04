package com.sushma.BeltEvents.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sushma.BeltEvents.models.Message;
import com.sushma.BeltEvents.models.User;
import com.sushma.BeltEvents.models.Event;
import com.sushma.BeltEvents.repositories.EventRepository;
import com.sushma.BeltEvents.repositories.MessageRepository;
import com.sushma.BeltEvents.repositories.UserRepository;

@Service
public class MessageService {
	private EventRepository eventRepository;
	private UserRepository userRepository;
	private MessageRepository messageRepository;
	public MessageService(EventRepository eventRepository,  UserRepository userRepository, MessageRepository messageRepository) {
		this.eventRepository = eventRepository;
		this.userRepository = userRepository;
		this.messageRepository = messageRepository;
	}
	public void addMessage(Message message, Long eventid, Long thatuserid) {
		messageRepository.save(message);
	}
	
	public List<Message> getAllMessageforEvent(Long eventid){
		return messageRepository.findMessageforEvent(eventid);
	}
	
	public void delete(Long id) {
		Event event  = eventRepository.findOne(id);
		List<Message> messages = (List<Message>) messageRepository.findAll();
		for(Message message: messages) {
			if(message.getEvent().getId().equals(id)) {
				messageRepository.delete(message);
			}
		}
		eventRepository.delete(event);
	}

}
