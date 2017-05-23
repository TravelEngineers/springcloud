package com.zgs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Created by Smily on 2017/5/23.
 */
@EnableZuulProxy
//使用@EnableZuulProxy时不需要再添加@EnableEurekaClient，否则eureka无法正常使用。
//@EnableZuulProxy默认已启用eureka支持
@SpringBootApplication
public class ZuulApp {
    public static void main(String[] args) {
        SpringApplication.run(ZuulApp.class, args);
    }
}
