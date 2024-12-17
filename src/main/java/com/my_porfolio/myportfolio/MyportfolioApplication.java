package com.my_porfolio.myportfolio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class MyportfolioApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyportfolioApplication.class, args);
	}

}
