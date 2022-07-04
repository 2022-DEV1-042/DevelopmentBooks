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
		assertEquals(5, storeService.returnGreatestNumber(order));

		order = new Order(0, 6, 2, 3, 4);
		assertEquals(6, storeService.returnGreatestNumber(order));
	}

	@Test
	void howManyDifferentBooksForSerie() {
		BookCounterUpdate bookCounterUpdate = new BookCounterUpdate(true, true, true, true, true);
		assertEquals(5, storeService.howManyDifferentBooksForSerie(bookCounterUpdate));

		bookCounterUpdate = new BookCounterUpdate(true, false, true, true, false);
		assertEquals(3, storeService.howManyDifferentBooksForSerie(bookCounterUpdate));

		bookCounterUpdate = new BookCounterUpdate(false, false, false, false, false);
		assertEquals(0, storeService.howManyDifferentBooksForSerie(bookCounterUpdate));
	}

	@Test
	void oneBookFiftyEuros() throws Exception{
		Order order = new Order(0, 1, 0, 0, 0);
		assertEquals(50, storeService.computePrice(order));
	}

	@Test
	void twoBooksNinetyFiveEuros() throws Exception{
		Order order = new Order(0, 1, 0, 1, 0);
		assertEquals(95, storeService.computePrice(order));
	}

	@Test
	void threeBooks() throws Exception{
		Order order = new Order(0, 1, 0, 1, 1);
		assertEquals(135, storeService.computePrice(order));
	}

	@Test
	void fourBooks() throws Exception{
		Order order = new Order(1, 1, 0, 1, 1);
		assertEquals(160, storeService.computePrice(order));
	}

	@Test
	void fiveBooks() throws Exception{
		Order order = new Order(1, 1, 1, 1, 1);
		assertEquals(187.5, storeService.computePrice(order));
	}

	@Test
	void multipleSeries() throws Exception{
		Order order = new Order(2, 1, 3, 1, 2);
		// 187.5 + 135 + 50
		assertEquals(372.5, storeService.computePrice(order));

		order = new Order(0, 1, 3, 3, 2);
		// 160 + 135 + 95
		assertEquals(390, storeService.computePrice(order));
	}
}
