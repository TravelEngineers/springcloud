package com.zgs.oauth2server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by Shmily on 2017/5/30.
 */
@Repository
public class JdbcDataSource {
    @Autowired
    private JdbcTemplate jdbcTemplate;
}
