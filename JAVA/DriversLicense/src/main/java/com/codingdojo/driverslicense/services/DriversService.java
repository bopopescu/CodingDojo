package com.codingdojo.driverslicense.services;

import org.springframework.stereotype.Service;

import java.util.List;

import com.codingdojo.driverslicense.models.Person;
import com.codingdojo.driverslicense.repositories.*;

@Service
public class DriversService {
	private PersonRepository personRepository;
	public DriversService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	public void addPerson(Person person) {
		personRepository.save(person);
	}

	public List<Person> allPeople() {
		return (List<Person>) personRepository.findAll();
	}

}
