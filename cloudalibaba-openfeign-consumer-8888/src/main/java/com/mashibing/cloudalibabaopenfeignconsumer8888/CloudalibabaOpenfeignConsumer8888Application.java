package com.mashibing.cloudalibabaopenfeignconsumer8888;

import feign.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class CloudalibabaOpenfeignConsumer8888Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudalibabaOpenfeignConsumer8888Application.class, args);
    }

    @Bean
    Logger.Level a() {
        return Logger.Level.FULL;
    }

}
