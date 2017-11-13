package com.ssooni.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssooni.domain.InstaDomain;
import com.ssooni.persistance.InstaService;
import com.ssooni.repository.InstaRepository;

@RestController
public class InstaController {
	
	@Autowired
	InstaService instaService;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public HashMap<String, Integer> listAll(){
		return instaService.getHashTag();
	}
}
