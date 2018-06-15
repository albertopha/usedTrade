package com.usedTrade.usedTrade;

import com.usedTrade.repository.CommentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication()
@ComponentScan({"com.usedTrade.domain", "com.usedTrade.repository", "com.usedTrade.service", "com.usedTrade.controller"})
@EntityScan({"com.usedTrade.domain"})
@EnableJpaRepositories({"com.usedTrade.repository"})
public class UsedTradeApplication {
	public static void main(String[] args) {
		SpringApplication.run(UsedTradeApplication.class, args);
	}
}
