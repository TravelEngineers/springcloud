package com.zgs.oauth2filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shmily on 2017/5/30.
 */
@Component
public class AppFilterConfig {
    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        ResourceFilter actionFilter = new ResourceFilter();
        registrationBean.setFilter(actionFilter);
        List<String> urlPatterns = new ArrayList<String>();
        urlPatterns.add("/service/extract/json/*");
        registrationBean.setUrlPatterns(urlPatterns);
        return registrationBean;
    }

}
