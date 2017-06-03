package com.zgs.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
            redisTemplate.opsForValue().set("client_id",client_id,10,TimeUnit.SECONDS);
            //生成调用方授权信息
            respData.put("access_token","2YotnFZFEjr1zCsicMWpAA");
            respData.put("token_type","Bearer");
            respData.put("refresh_token","tGzv3JOkF0XG5Qx2TlKWIA");
            respData.put("expires_in",3600);
            respData.put("respCode",200);
            respData.put("respDesc","success");
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
        String sql="select *  from client_info  where client_secret='"+client_secret+"' and client_id='"+client_id+"'";
        List l=this.jdbcTemplate.queryForList(sql);
        if(l!=null&&l.size()>0){
            return true;
        }
        return false;
    }
}
