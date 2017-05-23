package com.zgs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * Created by Smily on 2017/5/19.
 */
@SpringBootApplication
@EnableEurekaClient //启动EnableEureka客户端
@EnableFeignClients
public class EurekaClientApp {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApp.class, args);
    }
}
