package com.zgs.api;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Shmily on 2017/5/30.
 */
@RestController
@RequestMapping("/private")
public class PrivateController {

    @RequestMapping("/hello")
    public String index(){
        return "Hello private!";
    }
}
