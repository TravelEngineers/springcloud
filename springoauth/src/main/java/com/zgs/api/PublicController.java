package com.zgs.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Shmily on 2017/5/30.
 */
@RestController
@RequestMapping("/public")
public class PublicController {
    @GetMapping("/hello")
    public String show(){
        return "Hello Public !";
    }
}
