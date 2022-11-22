package com.mashibing.cloudalibabaprovider9003.controller;

import com.mashibing.cloudalibabacommons.entity.JsonResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class DataController {
    @Value("${server.port}")
    private String serverPort;

    public static HashMap<Integer, String> hashMap = new HashMap<>();

    static {
        hashMap.put(1, "鼠标");
        hashMap.put(2, "键盘");
        hashMap.put(3, "二级");
    }

    @GetMapping("/info/{id}")
    public JsonResult<String> getGoods(@PathVariable("id") Integer id) {
        return new JsonResult<>(id, "serverPort:" + serverPort + hashMap.get(id));
    }

    @GetMapping("/timeOut")
    public JsonResult<String> timeOut() {
        try {
            System.out.println(serverPort + "延迟响应");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new JsonResult<String>(1, serverPort);
    }
}
