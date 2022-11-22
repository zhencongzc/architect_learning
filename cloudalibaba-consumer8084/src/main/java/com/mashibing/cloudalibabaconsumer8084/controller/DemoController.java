package com.mashibing.cloudalibabaconsumer8084.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.mashibing.cloudalibabacommons.entity.JsonResult;
import com.mashibing.cloudalibabaconsumer8084.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DemoController {

    @Autowired
    public RestTemplate restTemplate;
    @Autowired
    public FeignService feignService;

    @Value("${service-url.nacos-user-service}")
    private String serverUrl;

    @GetMapping("/consumer/fallback/{id}")
    @SentinelResource(value = "test1", fallback = "fallbackHandler", blockHandler = "blockHandler")
    public JsonResult<String> fallback(@PathVariable("id") Integer id) {
        if (id > 3) throw new RuntimeException("没有大于3的商品");
        JsonResult forObject = restTemplate.getForObject(serverUrl + "/info/" + id, JsonResult.class);
        return forObject;
    }

    public JsonResult<String> fallbackHandler(Integer id, Throwable e) {
        JsonResult forObject = new JsonResult(444, "出错啦！java错误信息：" + e.getMessage());
        return forObject;
    }

    public JsonResult<String> blockHandler(Integer id, BlockException e) {
        JsonResult forObject = new JsonResult(445, "出错啦！sentinel错误信息：" + e.getMessage());
        return forObject;
    }

    @GetMapping("/testFeign/{id}")
    public JsonResult<String> getInfo(@PathVariable Integer id) {
        if (id > 3) throw new RuntimeException("id>3，出错啦！");
        return feignService.getGoods(id);
    }
}
