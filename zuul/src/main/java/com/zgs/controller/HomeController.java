package com.zgs.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Smily on 2017/5/23.
 */
@RestController
public class HomeController {
    @RequestMapping("/index")
    public String  index() {
        return "this is index page";
    }
    @RequestMapping("/home")
    public String home() {
        return "this is home page";
    }
}
