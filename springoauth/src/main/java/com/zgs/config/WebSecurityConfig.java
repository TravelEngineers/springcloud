package com.zgs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by Shmily on 2017/5/30.
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.anonymous().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .exceptionHandling()
//                    .accessDeniedHandler(accessDeniedHandler()) // handle access denied in general (for example comming from @PreAuthorization
//                    .authenticationEntryPoint(entryPointBean()) // handle authentication exceptions for unauthorized calls.
                .and()
                .authorizeRequests()
//                    .antMatchers("/hystrix.stream/**", "/info", "/error").permitAll()
                .anyRequest().authenticated().and().csrf().disable();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        // 不需要权限控制的路径
        web.ignoring().antMatchers("/public/**", "/info", "/error");
    }
}
