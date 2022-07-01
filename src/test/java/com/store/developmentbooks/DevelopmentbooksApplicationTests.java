package com.store.developmentbooks;

import com.store.developmentbooks.controller.StoreController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class DevelopmentbooksApplicationTests {

	@Test
	void contextLoads() {
		Assert.notNull(StoreController.class, "StoreController cannot be loaded");
	}

	@Test
	void oneBookFiftyEuros(){
		Assert.isTrue(false, "Implement the test");
	}
}
