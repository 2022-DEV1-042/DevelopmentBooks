package com.store.developmentbooks;

import com.store.developmentbooks.controller.StoreController;
import com.store.developmentbooks.object.Order;
import com.store.developmentbooks.service.StoreService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DevelopmentbooksApplicationTests {

	@Autowired
	StoreService storeService;

	@Test
	void contextLoads() {
		Assert.notNull(StoreController.class, "StoreController cannot be loaded");
	}

	@Test
	void greatestNumber(){
		Order order = new Order(0, 1, 2, 3, 5);
		assertEquals(storeService.returnGreatestNumber(order), 5);

		order = new Order(0, 6, 2, 3, 4);
		assertEquals(storeService.returnGreatestNumber(order), 6);
	}

	@Test
	void oneBookFiftyEuros(){
		Assert.isTrue(false, "Implement the test");
	}
}
