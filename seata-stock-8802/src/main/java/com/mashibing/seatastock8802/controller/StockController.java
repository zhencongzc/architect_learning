package com.mashibing.seatastock8802.controller;

import com.mashibing.seatastock8802.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockController {

    @Autowired
    StockService stockService;

    @GetMapping("/stock/decr")
    public String decrement() {
        stockService.decrement();
        return "Success";
    }

}
