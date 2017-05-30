package com.zgs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * Created by Smily on 2017/5/27.
 */
@EnableEurekaClient //启动EnableEureka客户端
@EnableFeignClients
@EnableCircuitBreaker
@SpringBootApplication
public class OuathApp {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(OuathApp.class, args);
    }
}
