package com.mukho.ranksystem;

import com.mukho.ranksystem.Model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class RankSystemApplicationTests {

	@Test
	void contextLoads() {
		User user = new User("mukho", null, "묵호", "special");
		assertEquals("mukho", user.getId());
	}

}
