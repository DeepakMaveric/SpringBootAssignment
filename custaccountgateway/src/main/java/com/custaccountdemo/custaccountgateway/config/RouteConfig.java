package com.custaccountdemo.custaccountgateway.config;


import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfig {
    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder routeLocatorBuilder){
        return routeLocatorBuilder.routes()
                .route("customerdetails", rt -> rt.path("/customer/**")
                        .uri("http://localhost:8010/customer/"))
                .route("accountdetails", rt -> rt.path("/account/**")
                        .uri("http://localhost:8020/account/"))
                .route("customerbyid", rt -> rt.path("/customer/id/**")
                        .filters(rw -> rw.rewritePath("customer/id/?<id>","/customer/id/${id}"))
                        .uri("http://localhost:8010/customer/id/")).build();
    }
}

