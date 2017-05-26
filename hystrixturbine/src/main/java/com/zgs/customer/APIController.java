package com.zgs.customer;

import com.zgs.provider.EurekaApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Smily on 2017/5/19.
 */
@RestController
public class APIController {

    @Autowired
    private EurekaApiClient service; // 远程服务

    @GetMapping("/eurekac/{name}")
    @ResponseBody
    public String apishow(@PathVariable String name){
        System.out.printf("-----/eurekac/show/"+name+"------");
        return service.hello(name);
    }
}
