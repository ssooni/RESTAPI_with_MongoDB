package com.ssooni.mongoDemo;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.rest.RepositoryRestMvcAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableAutoConfiguration(exclude = RepositoryRestMvcAutoConfiguration.class)
@EnableMongoRepositories(basePackages = "com.ssooni.repository")
@EntityScan(basePackages = "com.ssooni.domain")
@ComponentScan(basePackages = "com.ssooni")
@SpringBootApplication
public class MongoDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoDemoApplication.class, args);
	}

	@Bean
	@ConfigurationProperties(prefix = "spring.data.db-main")
	public DataSource mainDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean
	@ConfigurationProperties(prefix = "spring.data.db-log")
	public DataSource contractDataSource() {
		return DataSourceBuilder.create().build();
	}

}
