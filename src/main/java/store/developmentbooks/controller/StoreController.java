package store.developmentbooks.controller;

import store.developmentbooks.object.Order;
import store.developmentbooks.service.StoreService;
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
    public double buy(@RequestBody Order order) {
        return storeService.computePrice(order);
    }
}
