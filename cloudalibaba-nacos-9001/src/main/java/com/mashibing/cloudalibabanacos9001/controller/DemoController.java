package com.mashibing.cloudalibabanacos9001.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;

@RestController
@RequestMapping("/msb")
public class DemoController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/get")
    public String getServerPort() {
        return "库存-1：" + serverPort;
    }

    @GetMapping("/test")
    public String test() {
        return "test" + serverPort;
    }

    public static void main(String[] args) {
        System.out.println(ZonedDateTime.now());
    }
}