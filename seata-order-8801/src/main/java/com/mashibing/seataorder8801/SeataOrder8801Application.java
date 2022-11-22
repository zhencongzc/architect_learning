package com.mashibing.seataorder8801;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@MapperScan("com.mashibing.seataorder8801.mapper")
@EnableDiscoveryClient
@EnableFeignClients
public class SeataOrder8801Application {

    public static void main(String[] args) {
        SpringApplication.run(SeataOrder8801Application.class, args);
    }

}
