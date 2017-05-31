package com.zgs.oauth2server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by Shmily on 2017/5/30.
 */
@Repository
public class RedisDataSource {
    @Autowired
    private StringRedisTemplate template;
}
