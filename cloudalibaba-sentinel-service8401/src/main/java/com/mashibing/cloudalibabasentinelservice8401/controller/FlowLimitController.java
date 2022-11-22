package com.mashibing.cloudalibabasentinelservice8401.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.mashibing.cloudalibabasentinelservice8401.server.TestService;
import com.sun.deploy.security.BlockedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class FlowLimitController {

    @Autowired
    public TestService testService;

    @GetMapping("/testA")
    public String testA() {
        log.info(Thread.currentThread().getName() + ":testA");
        return testService.common();
    }

    @GetMapping("/testB")
    public String testB() {
        return testService.common();
    }

    @GetMapping("/testC")
    public String testC(Integer id) {
        if (id == 2) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "testC";
    }

    @GetMapping("/testD")
    public String testD(Integer id) {
        if (id != null && id > 1) throw new RuntimeException("异常测试");
        return "testD";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "handler_HotKey")
    public String testHotKey(@RequestParam(value = "hot1", required = false) String hot1,
                             @RequestParam(value = "hot2", required = false) String hot2,
                             @RequestParam(value = "hot3", required = false) String hot3) {
        return "testHotKey";
    }

    public String handler_HotKey(String hot1, String hot2, String hot3, BlockException exception) {
        return "xxxxxxxxxxx";
    }

}
