package com.zgs.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 *  客户端凭证方式获取授权token
 *  Created by Shmily on 2017/5/31.
 */
@Component
public class ClinetcredentTokenService {
    @Autowired
    private StringRedisTemplate  redisTemplate;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public JSONObject getToken(HttpServletRequest request){
        JSONObject respData=new JSONObject();
        String client_id=request.getParameter("client_id");
        String client_secret=request.getParameter("client_secret");
        if(checkInfo(client_id,client_secret)){
             redisTemplate.opsForValue().set("client_id","client_secret");
            //生成调用方授权信息
        }else{
            respData.put("respCode",2001);
            respData.put("respDesc","调用方身份异常");
        }
        return respData;
    }

    /**
     * 校验客户端有效性
     * @param client_id
     * @param client_secret
     * @return
     */
    private boolean checkInfo(String client_id,String client_secret){
        return true;
    }
}
