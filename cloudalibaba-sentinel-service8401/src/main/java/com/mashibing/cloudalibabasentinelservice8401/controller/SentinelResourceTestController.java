package com.mashibing.cloudalibabasentinelservice8401.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.mashibing.cloudalibabasentinelservice8401.handler.CustomerBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SentinelResourceTestController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "byResource_handler")
    public String byResource() {
        return "byResource";
    }

    public String byResource_handler(BlockException e) {
        return "错误了哦";
    }

    @GetMapping("/byCustomer")
    @SentinelResource(value = "byCustomer",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handlerException1")
    public String byCustomer() {
        return "byResource";
    }

    @GetMapping("/byCustomer2")
    @SentinelResource(value = "byCustomer2",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handlerException2")
    public String byCustomer2() {
        return "byResource2";
    }

}
