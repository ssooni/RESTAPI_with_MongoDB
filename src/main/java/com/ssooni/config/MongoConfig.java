package com.ssooni.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration
@EnableMongoRepositories("mongo")
public class MongoConfig extends AbstractMongoConfiguration{

	
	// https://stackoverflow.com/questions/23515295/spring-boot-and-how-to-configure-connection-details-to-mongodb
	
    @Value("${spring.profiles}")
    private String profileActive;

    @Value("${spring.application.name}")
    private String proAppName;

    @Value("${spring.data.mongodb.host}")
    private String mongoHost;

    @Value("${spring.data.mongodb.port}")
    private String mongoPort;

    @Value("${spring.data.mongodb.database}")
    private String mongoDB;
	
	
	@Override
	protected String getDatabaseName() {
		return mongoDB;
	}

	@Override
	public Mongo mongo() throws Exception {
		return new MongoClient(mongoHost + ":" + mongoPort);
	}

	@Override
	public MongoMappingContext mongoMappingContext() throws ClassNotFoundException {
		return super.mongoMappingContext();
	}
	
}
