package com.zgs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * Created by Smily on 2017/5/27.
 */
@SpringBootApplication
@EnableAuthorizationServer
@EnableResourceServer
public class OuathApp {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(OuathApp.class, args);
    }
}
