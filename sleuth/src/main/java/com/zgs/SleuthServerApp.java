package com.zgs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.EnableZipkinServer;

/**
 * Created by Smily on 2017/5/24.
 */
@SpringBootApplication
@EnableZipkinServer
public class SleuthServerApp {
    public static void main(String[] args) {
        SpringApplication.run(SleuthServerApp.class, args);
    }
}
