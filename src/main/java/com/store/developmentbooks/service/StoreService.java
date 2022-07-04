package com.store.developmentbooks.service;

import com.store.developmentbooks.object.BookCounterUpdate;
import com.store.developmentbooks.object.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreService {

    @Autowired
    private UpdateBookService updateBookService;

    public int returnGreatestNumber(Order order) {
        int greatestNumber = order.getCleanCode();

        if (order.getCleanCoder() > greatestNumber)
            greatestNumber = order.getCleanCoder();
        if (order.getCleanArchitecture() > greatestNumber)
            greatestNumber = order.getCleanArchitecture();
        if (order.getTestDriverDevelopment() > greatestNumber)
            greatestNumber = order.getTestDriverDevelopment();
        if (order.getWorkingEffectivelyWithLegacyCode() > greatestNumber)
            greatestNumber = order.getWorkingEffectivelyWithLegacyCode();
        return greatestNumber;
    }

    private BookCounterUpdate initBookCounterUpdate(Order order) {
        BookCounterUpdate bookCounterUpdate = new BookCounterUpdate();
        bookCounterUpdate.setCleanCode(order.getCleanCode());
        bookCounterUpdate.setCleanCoder(order.getCleanCoder());
        bookCounterUpdate.setCleanArchitecture(order.getCleanArchitecture());
        bookCounterUpdate.setTestDriverDevelopment(order.getTestDriverDevelopment());
        bookCounterUpdate.setWorkingEffectivelyWithLegacyCode(order.getWorkingEffectivelyWithLegacyCode());
        return bookCounterUpdate;
    }

    public int howManyDifferentBooksForSerie(BookCounterUpdate bookCounterUpdate) {
        int numberOfBooksBooked = 0;
        if (bookCounterUpdate.isCleanCodeSuperiorZero())
            numberOfBooksBooked += 1;
        if (bookCounterUpdate.isCleanCoderSuperiorZero())
            numberOfBooksBooked += 1;
        if (bookCounterUpdate.isCleanArchitectureSuperiorZero())
            numberOfBooksBooked += 1;
        if (bookCounterUpdate.istTDSuperiorZero())
            numberOfBooksBooked += 1;
        if (bookCounterUpdate.isWewlcSuperiorZero())
            numberOfBooksBooked += 1;
        return numberOfBooksBooked;
    }

    private double computePriceForOneSerie(BookCounterUpdate bookCounterUpdate) {
        int numberOfBooksBooked = howManyDifferentBooksForSerie(bookCounterUpdate);
        if (numberOfBooksBooked == 1)
            return 50;
        if (numberOfBooksBooked == 2) // 100€ - 5%
            return 95;
        if (numberOfBooksBooked == 3) // 150 - 10%
            return 135;
        if (numberOfBooksBooked == 4) // 200 - 20%
            return 160;
        else // 250 - 25%
            return 187.5;
    }

    public double computePrice(Order order) throws Exception {
        int greatestNumber = returnGreatestNumber(order);
        double price = 0;
        BookCounterUpdate bookCounterUpdate = initBookCounterUpdate(order);
        for (int i = 0; i < greatestNumber; i++) {
            updateBookService.updateCleanCodeAndCleanCoder(bookCounterUpdate);
            updateBookService.updateOtherBooks(bookCounterUpdate);
            price += computePriceForOneSerie(bookCounterUpdate);
        }
        return price;
    }
}
