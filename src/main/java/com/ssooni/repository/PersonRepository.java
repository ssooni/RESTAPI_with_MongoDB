package com.ssooni.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.ResponseEntity;

import com.ssooni.domain.PersonDomain;

public interface PersonRepository extends MongoRepository<PersonDomain, Long>{
	public List<PersonDomain> findAll();
	public PersonDomain findOndByName(String name);
	public void deleteOneByName(String name);
}
