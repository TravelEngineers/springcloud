package com.zgs.web;

import com.zgs.es.ElasticSearchConfig;
import org.elasticsearch.action.bulk.byscroll.BulkByScrollResponse;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.reindex.DeleteByQueryAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

/**
 * Created by Smily on 2017/6/29.
 */
@RestController
public class EsController {
    private Logger logger= LoggerFactory.getLogger(EsController.class);
    @Autowired
    private Client esClient;
    @GetMapping("/es/doc/create")
    public void createDoc(){
        Map<String, Object> map = new HashMap<String, Object>();
        Random ran = new Random();
        map.put("nickname", "测试" + ran.nextInt(100));
        map.put("sex", ran.nextInt(100));
        map.put("age", ran.nextInt(100));
        map.put("mobile", "15014243232");
        IndexResponse response = esClient.prepareIndex("users", "user","1").setSource(map).get();
        logger.debug("/es/doc/create--"+response.getIndex()+','+response.getType()+","+response.getId()
        +","+response.getVersion()+","+response.status().getStatus());
    }
    @GetMapping("/es/doc/query")
    public String quesyDoc(){
        GetResponse response = esClient.prepareGet("users", "user", "1")
                .setOperationThreaded(false)
                .get();
        logger.debug("/es/doc/query--"+response.getIndex()+','+response.getType()+","+response.getId()
                +","+response.getVersion()+","+response.getSourceAsString());
        return response.getSourceAsString();
    }
    @GetMapping("/es/doc/delete")
    public void deleteDoc(){
        DeleteResponse response = esClient.prepareDelete("users", "user", "1").get();
        logger.debug("/es/doc/delete--"+response.getIndex()+','+response.getType()+","+response.getId()
                +","+response.getVersion());
    }
    @GetMapping("/es/doc/deleteByQuery")
    public void deleteDocByQuery(){
        BulkByScrollResponse response =
                DeleteByQueryAction.INSTANCE.newRequestBuilder(esClient)
                        //The field name,The query text
                        .filter(QueryBuilders.matchQuery("mobile", "15014243232"))
                        .source("users")//设置索引
                        .get();
        long deleted = response.getDeleted();//被删除的数量
        logger.debug("/es/doc/deleteByQuery--deleted num:"+deleted);
    }
    @GetMapping("/es/doc/update")
    public void updateDoc(){
        try {
            UpdateRequest updateRequest = new UpdateRequest();
            updateRequest.index("users");
            updateRequest.type("user");
            updateRequest.id("1");
            updateRequest.doc(jsonBuilder()
                    .startObject()
                    .field("mobile", "18221672681")
                    .endObject());
            UpdateResponse response=esClient.update(updateRequest).get();
            logger.debug("/es/doc/update--"+response.getIndex()+','+response.getType()+","+response.getId()
                    +","+response.getVersion());
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
