package com.store.developmentbooks.controller;

import com.store.developmentbooks.object.Order;
import com.store.developmentbooks.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/store")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @PostMapping("/buy")
    public String buy(@RequestBody Order order) throws Exception {
        storeService.computePrice(order);
        return "toto";
    }
}
