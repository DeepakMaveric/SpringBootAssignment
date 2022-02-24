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
                .route("customerdetails", rt -> rt.path("/customers/**")
                        .uri("http://localhost:8042/customers/"))
                .route("customerbyid", rt -> rt.path("/customers/**")
                        .filters(rw -> rw.rewritePath("customers/?<id>","/customers/${id}"))
                        .uri("http://localhost:8042/customers/id/"))
                .route("deletecustomerbyid", rt -> rt.path("/customers/**")
                        .filters(rw -> rw.rewritePath("customers/?<id>","/customers/${id}"))
                        .uri("http://localhost:8042/customers/id/")).build();
    }
}

