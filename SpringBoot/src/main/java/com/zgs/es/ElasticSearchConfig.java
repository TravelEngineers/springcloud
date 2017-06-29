package com.zgs.es;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by Smily on 2017/6/29.
 */
@Component
@Configuration
@ConfigurationProperties(prefix = "elasticsearch")
public class ElasticSearchConfig {
    private Logger logger= LoggerFactory.getLogger(ElasticSearchConfig.class);
    private String clusterName;
    private String clusterNodes;
    @Bean
    public Client getESClient() {
        logger.debug("---------ES-Client-Init------------------");
       // 设置集群名字
        Settings settings = Settings.builder().put("cluster.name", this.clusterName).build();
        Client client = new PreBuiltTransportClient(settings);
        try {
           // 读取的ip列表是以逗号分隔的
            for (String clusterNode : this.clusterNodes.split(",")) {
                String ip = clusterNode.split(":")[0];
                String port = clusterNode.split(":")[1];
                ((TransportClient) client).addTransportAddress(
                        new InetSocketTransportAddress(InetAddress.getByName(ip), Integer.parseInt(port)));
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return client;
    }
    public String getClusterName() {
        return clusterName;
    }

    public void setClusterName(String clusterName) {
        logger.debug("---------ES-Client-Init---clusterName----"+clusterName);
        this.clusterName = clusterName;
    }

    public String getClusterNodes() {
        return clusterNodes;
    }

    public void setClusterNodes(String clusterNodes) {
        logger.debug("---------ES-Client-Init---clusterNodes----"+clusterNodes);
        this.clusterNodes = clusterNodes;
    }
}
