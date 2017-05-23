package com.zgs.provider;

import com.zgs.hystrix.HystrixClientFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by Smily on 2017/5/22.
 */
@FeignClient(name = "microservice-provider-user",fallback=HystrixClientFallback.class)
public interface EurekaApiClient {
    @GetMapping("/hello/{name}")
    public String hello(@PathVariable("name") String name);
}
