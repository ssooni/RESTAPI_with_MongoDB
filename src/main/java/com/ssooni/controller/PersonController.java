package com.ssooni.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssooni.domain.PersonDomain;
import com.ssooni.repository.PersonRepository;

@RestController
@RequestMapping(value="/people")
public class PersonController {
	
	@Autowired
	private PersonRepository personRepo;
	
	private Logger logger = LoggerFactory.getLogger(PersonController.class);
	
	@RequestMapping(method=RequestMethod.POST)
	public void create(@RequestBody PersonDomain person) {
		logger.error(person.toString());
		personRepo.save(person);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<PersonDomain> list() {
		return personRepo.findAll();
	}
	
	@RequestMapping(value= "/{name}", method=RequestMethod.GET)
	public PersonDomain read(@PathVariable String name) {
		return personRepo.findOndByName(name);
	}
	
	@RequestMapping(value="/{name}", method=RequestMethod.DELETE)
	public void remove(@PathVariable String name){
		PersonDomain target = personRepo.findOndByName(name);
		personRepo.delete(target);
	}
	
	@RequestMapping(value="/{name}", method=RequestMethod.PUT)
	public void update(@RequestBody PersonDomain person) {
		personRepo.save(person);
	}
}
