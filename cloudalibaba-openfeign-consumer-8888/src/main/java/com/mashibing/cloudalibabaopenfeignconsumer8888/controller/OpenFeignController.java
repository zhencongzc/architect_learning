package com.mashibing.cloudalibabaopenfeignconsumer8888.controller;

import com.mashibing.cloudalibabacommons.entity.JsonResult;
import com.mashibing.cloudalibabaopenfeignconsumer8888.server.OpenFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OpenFeignController {

    @Autowired
    private OpenFeignService openFeignService;

    @GetMapping("/getInfo/{id}")
    public JsonResult<String> getInfo(@PathVariable("id") int id){
        return openFeignService.getGoods(id);
    }

    @GetMapping("/timeOut")
    public JsonResult<String> timeOut(){
        return openFeignService.timeOut();
    }


}
