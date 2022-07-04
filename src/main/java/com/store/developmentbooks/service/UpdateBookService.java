package com.store.developmentbooks.service;

import com.store.developmentbooks.object.BookCounterUpdate;
import org.springframework.stereotype.Service;

@Service
public class UpdateBookService {

    public void updateCleanCodeAndCleanCoder(BookCounterUpdate bookCounterUpdate){
        if (bookCounterUpdate.getCleanCode() > 0) {
            bookCounterUpdate.setCleanCode(bookCounterUpdate.getCleanCode() - 1);
            bookCounterUpdate.setCleanCodeSuperiorZero(true);
        }
        else
            bookCounterUpdate.setCleanCodeSuperiorZero(false);
        if (bookCounterUpdate.getCleanCoder() > 0){
            bookCounterUpdate.setCleanCoder(bookCounterUpdate.getCleanCoder() - 1);
            bookCounterUpdate.setCleanCoderSuperiorZero(true);
        }
        else
            bookCounterUpdate.setCleanCoderSuperiorZero(false);
    }

    public void updateOtherBooks(BookCounterUpdate bookCounterUpdate) {
        if (bookCounterUpdate.getCleanArchitecture() > 0){
            bookCounterUpdate.setCleanArchitecture(bookCounterUpdate.getCleanArchitecture() - 1);
            bookCounterUpdate.setCleanArchitectureSuperiorZero(true);
        }
        else
            bookCounterUpdate.setCleanArchitectureSuperiorZero(false);
        if (bookCounterUpdate.getTestDriverDevelopment() > 0){
            bookCounterUpdate.setTestDriverDevelopment(bookCounterUpdate.getTestDriverDevelopment() - 1);
            bookCounterUpdate.settTDSuperiorZero(true);
        }
        else
            bookCounterUpdate.settTDSuperiorZero(false);
        if (bookCounterUpdate.getWorkingEffectivelyWithLegacyCode() > 0){
            bookCounterUpdate.setWorkingEffectivelyWithLegacyCode(bookCounterUpdate.getWorkingEffectivelyWithLegacyCode() - 1);
            bookCounterUpdate.setWewlcSuperiorZero(true);
        }
        else
            bookCounterUpdate.setWewlcSuperiorZero(false);
    }
}
