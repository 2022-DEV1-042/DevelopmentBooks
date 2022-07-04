package com.store.developmentbooks.service;

import com.store.developmentbooks.object.BookCounterUpdate;
import com.store.developmentbooks.object.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreService {

    @Autowired
    private UpdateBookService updateBookService;

    private Boolean cleanCodeSuperiorZero, cleanCoderSuperiorZero, cleanArchitectureSuperiorZero, tTDSuperiorZero, wewlcSuperiorZero;

    private int returnGreatestNumber(Order order){
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

    private BookCounterUpdate initBookCounterUpdate(Order order){
        BookCounterUpdate bookCounterUpdate = new BookCounterUpdate();
        bookCounterUpdate.setCleanCode(order.getCleanCode());
        bookCounterUpdate.setCleanCoder(order.getCleanCoder());
        bookCounterUpdate.setCleanArchitecture(order.getCleanArchitecture());
        bookCounterUpdate.setTestDriverDevelopment(order.getTestDriverDevelopment());
        bookCounterUpdate.setWorkingEffectivelyWithLegacyCode(order.getWorkingEffectivelyWithLegacyCode());
        return bookCounterUpdate;
    }

    public void computePrice(Order order) throws Exception {
        int greatestNumber = returnGreatestNumber(order);
        BookCounterUpdate bookCounterUpdate = initBookCounterUpdate(order);
        for (int i = 0; i <= greatestNumber; i++){
            updateBookService.updateCleanCodeAndCleanCoder(bookCounterUpdate);
            updateBookService.updateOtherBooks(bookCounterUpdate);
        }
    }
}
