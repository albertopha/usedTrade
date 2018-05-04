package com.usedTrade.usedTrade;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UsedTradeApplicationTests {

	@Test
	public void contextLoads() {
		//testing bean validation (null name)
//		User user = new User();
//		user.setName(null);
//		user.setAge(24);
//		user.setCreditCard("123445678901");
//		user.setEmail("albertopha@gmail.com");
//		user.setPosts(null);
//
//		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
//		Validator validator =  factory.getValidator();
//		Set<ConstraintViolation<User>> violations = validator.validate(user);
//		for(ConstraintViolation<User> violation: violations) {
//			System.out.println(violation.getMessage());
//		}
	}

}
