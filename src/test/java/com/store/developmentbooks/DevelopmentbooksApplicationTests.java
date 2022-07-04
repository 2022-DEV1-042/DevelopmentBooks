package com.store.developmentbooks;

import com.store.developmentbooks.controller.StoreController;
import com.store.developmentbooks.object.BookCounterUpdate;
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
	void howManyDifferentBooksForSerie() {
		BookCounterUpdate bookCounterUpdate = new BookCounterUpdate(true, true, true, true, true);
		assertEquals(storeService.howManyDifferentBooksForSerie(bookCounterUpdate), 5);

		bookCounterUpdate = new BookCounterUpdate(true, false, true, true, false);
		assertEquals(storeService.howManyDifferentBooksForSerie(bookCounterUpdate), 3);

		bookCounterUpdate = new BookCounterUpdate(false, false, false, false, false);
		assertEquals(storeService.howManyDifferentBooksForSerie(bookCounterUpdate), 0);
	}

	@Test
	void oneBookFiftyEuros() throws Exception{
		Order order = new Order(0, 1, 0, 0, 0);
		assertEquals(storeService.computePrice(order), 50);
	}

	@Test
	void twoBooksNinetyFiveEuros() throws Exception{
		Order order = new Order(0, 1, 0, 1, 0);
		assertEquals(storeService.computePrice(order), 95);
	}

	@Test
	void threeBooks() throws Exception{
		Order order = new Order(0, 1, 0, 1, 1);
		assertEquals(storeService.computePrice(order), 135);
	}

	@Test
	void fourBooks() throws Exception{
		Order order = new Order(1, 1, 0, 1, 1);
		assertEquals(storeService.computePrice(order), 160);
	}

	@Test
	void fiveBooks() throws Exception{
		Order order = new Order(1, 1, 1, 1, 1);
		assertEquals(storeService.computePrice(order), 187.5);
	}

	@Test
	void multipleSeries() throws Exception{
		Order order = new Order(2, 1, 3, 1, 2);
		// 187.5 + 135 + 50
		assertEquals(storeService.computePrice(order), 372.5);

		order = new Order(0, 1, 3, 3, 2);
		// 160 + 135 + 95
		assertEquals(storeService.computePrice(order), 390);
	}
}
