package com.mashibing.seataorder8801.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
@FeignClient(value = "seata-stock")
public interface StockClient {

    @GetMapping("/stock/decr")
    String decrement();

}
