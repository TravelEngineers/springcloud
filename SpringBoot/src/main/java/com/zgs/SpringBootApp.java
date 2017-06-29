package com.zgs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Smily on 2017/5/5.
 */
@Controller
@SpringBootApplication
public class SpringBootApp {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "哈喽，Spring Boot ！";
    }

    public static void main(String[] args) {
        //第一个简单的应用
        SpringApplication.run(SpringBootApp.class,args);
    }
}
