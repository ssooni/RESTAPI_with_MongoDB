package com.ssooni.domain;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ssooni526")
public class InstaDomain {
	@Id
	private String id;
	private String alias;
	private String username;
	private ArrayList<String> posts;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getUserName() {
		return username;
	}
	public void setUserName(String userName) {
		this.username = userName;
	}
	public ArrayList<String> getPosts() {
		return posts;
	}
	public void setPosts(ArrayList<String> posts) {
		this.posts = posts;
	}
	
    @Override
    public String toString() {
        return String.format(
                "Instar[id=%s, alias='%s', userName='%s']",
                id, alias, username);
    }
}
