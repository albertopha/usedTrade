package com.usedTrade.usedTrade;

import com.usedTrade.domain.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

@SpringBootApplication
public class UsedTradeApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsedTradeApplication.class, args);
	}
}
