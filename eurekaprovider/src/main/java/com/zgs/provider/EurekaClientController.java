package com.zgs.provider;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Smily on 2017/5/22.
 */
@RestController
public class EurekaClientController {
    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name){
        System.out.println(name+"wel come . My is microservice provider user");
        return name+" welcome . My is microservice provider user";
    }
}
