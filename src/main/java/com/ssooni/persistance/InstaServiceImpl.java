package com.ssooni.persistance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssooni.domain.InstaDomain;
import com.ssooni.repository.InstaRepository;

@Service
public class InstaServiceImpl implements InstaService{
	
	@Autowired
	InstaRepository instaRepository;

	@Override
	public HashMap<String, Integer> getHashTag() {
		
		List<InstaDomain> lists = instaRepository.findAll();
    	ArrayList<String> postList = lists.get(0).getPosts();
    	HashMap<String, Integer> hashTagMap = new HashMap<String, Integer>();
      	try{
	    	for(String post : postList){
	    		JSONObject jsonObject = (JSONObject) new JSONParser().parse(post);
	    		String description = (String) jsonObject.get("description");
	    		// /#[^#\s,;]+/gm
	    		
	    	    Pattern pattern = Pattern.compile("\\#([0-9a-zA-Z가-힣]*)");
	    	    Matcher matcher = pattern.matcher(description);
	    	    
	    	    while(matcher.find()){
	    	    	int count = 0;
	    	    	if(hashTagMap.get(matcher.group()) != null){
	    	    		count = hashTagMap.get(matcher.group());
	    	    	}
	    	    	count++;
	    	    	if(matcher.group() != null )
	    	    		hashTagMap.put(matcher.group(), count);
	    	    	
	    	    }
	    		
	    	}
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return hashTagMap;
	}
	
	
}
