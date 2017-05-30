package com.zgs.oauth2resource;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Smily on 2017/5/22.
 */
@Component
public class Oauth2ClientFallback implements Oauth2ClientService {
    @Override
    public String authorize(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }

    @Override
    public String token(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }
}
