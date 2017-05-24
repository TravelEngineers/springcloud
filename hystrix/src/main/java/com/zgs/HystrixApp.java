package com.zgs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * Created by Smily on 2017/5/19.
 */
@SpringBootApplication
@EnableEurekaClient //启动EnableEureka客户端
@EnableFeignClients
@EnableCircuitBreaker
//@EnableHystrix
@EnableHystrixDashboard
public class HystrixApp {

    public static void main(String[] args) {
        SpringApplication.run(HystrixApp.class, args);
    }
}