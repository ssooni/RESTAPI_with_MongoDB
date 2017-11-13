package com.ssooni.persistance;

import java.util.HashMap;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public interface InstaService {
	public HashMap<String, Integer> getHashTag();
}
