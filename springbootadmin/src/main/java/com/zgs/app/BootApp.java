package com.zgs.app;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by Smily on 2017/6/23.
 */
@SpringBootApplication
@EnableEurekaClient
@EnableAdminServer
public class BootApp {
    public static void main(String[] args) {
        SpringApplication.run(BootApp.class, args);
    }
}
