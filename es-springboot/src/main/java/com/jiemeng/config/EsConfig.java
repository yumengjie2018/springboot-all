package com.jiemeng.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EsConfig {
    @Bean
    public RestHighLevelClient restHighLevelClient(){
        RestHighLevelClient restHighLevelClient=
                new RestHighLevelClient(RestClient.builder(new HttpHost("192.168.3.15",9200,"http")));
        return restHighLevelClient;
    }
}
