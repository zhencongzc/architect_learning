package com.mashibing.cloudalibabaconsumer8084.service;

import com.mashibing.cloudalibabacommons.entity.JsonResult;
import org.springframework.stereotype.Component;

@Component
public class FeignServiceFallback implements FeignService{
    @Override
    public JsonResult<String> getGoods(Integer id) {
        return new JsonResult<>(444,"错误降级");
    }
}
