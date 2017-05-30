package com.zgs.oauth2resource;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Shmily on 2017/5/30.
 */
@FeignClient(name = "microservice-provider-oauth2",fallback=Oauth2ClientFallback.class)
public interface Oauth2ClientService {
    @RequestMapping("/oauth2/authorize")
    public String authorize(HttpServletRequest request, HttpServletResponse response);
    @RequestMapping("/oauth2/token")
    public String token(HttpServletRequest request, HttpServletResponse response);
}
