package com.mashibing.seataorder8801.controller;

import com.mashibing.seataorder8801.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/order/create")
    public String createOrder() {
        orderService.createOrder();
        return "Success";
    }

}
