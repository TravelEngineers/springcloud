package com.zgs.hystrix;

import com.zgs.provider.EurekaApiClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by Smily on 2017/5/22.
 */
@Component
public class HystrixClientFallback implements EurekaApiClient {
    @Override
    public String hello(@PathVariable("name") String name) {
        return "some exception occur call fallback method";
    }
}
