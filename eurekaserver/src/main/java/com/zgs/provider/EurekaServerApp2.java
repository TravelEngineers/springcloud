package com.zgs.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by Smily on 2017/6/5.
 */
@SpringBootApplication
@EnableEurekaServer//开启Eureka Server
public class EurekaServerApp2 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApp2.class, args);
    }
}
