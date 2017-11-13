package com.ssooni.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ssooni.domain.InstaDomain;

public interface InstaRepository extends MongoRepository<InstaDomain, Long>{
	public List<InstaDomain> findAll();
//	public InstaDomain find(@Param("username") String username);
}
