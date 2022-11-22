package com.mashibing.cloudalibabaconsumer8084.service;

import com.mashibing.cloudalibabacommons.entity.JsonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@FeignClient(value = "nacos-provider", fallback = FeignServiceFallback.class)
public interface FeignService {

    @GetMapping("/info/{id}")
    public JsonResult<String> getGoods(@PathVariable("id") Integer id);

}
