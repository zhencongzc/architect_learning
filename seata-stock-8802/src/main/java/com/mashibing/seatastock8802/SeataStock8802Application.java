package com.mashibing.seatastock8802;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SeataStock8802Application {

    public static void main(String[] args) {
        SpringApplication.run(SeataStock8802Application.class, args);
    }

}
