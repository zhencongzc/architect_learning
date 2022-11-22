package com.mashibing.cloudalibabaopenfeignconsumer8888.server;

import com.mashibing.cloudalibabacommons.entity.JsonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("nacos-provider")
public interface OpenFeignService {

    @GetMapping("/info/{id}")
    public JsonResult<String> getGoods(@PathVariable("id") Integer id);

    @GetMapping("/timeOut")
    public JsonResult<String> timeOut();
}
