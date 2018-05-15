package com.usedTrade.usedTrade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class UsedTradeApplication {

	/**
	* TODO: Test if hibernate, service and controller work using commendLineRunner.
	 *
	 * Example:
		 @Bean
		 public CommandLineRunner demo(PersonRepositary repository) {
	 		findAll(repository);
	 		return null;
	 	}
	**/


	public static void main(String[] args) {
		SpringApplication.run(UsedTradeApplication.class, args);
	}
}
