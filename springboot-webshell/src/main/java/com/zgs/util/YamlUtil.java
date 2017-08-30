package com.zgs.util;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.config.YamlMapFactoryBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.util.Map;

/**
 * Created by Smily on 2017/8/29.
 */
public class YamlUtil {
    public static void main(String[] args) {
        loadYml("application.yml");
    }
    public static void loadYml(String location){
        try {
            Yaml yaml = new Yaml();
            Resource res = new ClassPathResource(location);
            Map<String,Object> yamlObj = (Map<String,Object>)yaml.load(res.getInputStream());
            System.out.println(JSONObject.toJSON(yamlObj).toString());
            JSONObject yamlJSONObj=JSONObject.parseObject(JSONObject.toJSON(yamlObj).toString());
            System.out.println(yamlJSONObj.getJSONObject("spring").getJSONObject("resources").getString("static-locations"));
        }catch (Exception e){
            e.printStackTrace();;
        }
    }
}
