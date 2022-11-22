package com.mashibing.com.cloudalibabagateway9999.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GateWayConfig {

//    @Bean
//    public RouteLocator getLocator(RouteLocatorBuilder builder) {
//        RouteLocatorBuilder.Builder routes = builder.routes();
//        routes.route("id", r -> r.path("/msb/test").uri("http://localhost:9001/nacos-provider")).build();
//        return routes.build();
//    }
}
