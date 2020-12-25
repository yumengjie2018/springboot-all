package com.jiemeng;

import com.alibaba.fastjson.JSON;
import com.jiemeng.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.MatchAllQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.FetchSourceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

@SpringBootTest
@Slf4j
class JdEsApplicationTests {

    @Autowired
    @Qualifier("restHighLevelClient")
    private RestHighLevelClient client;
    @Test
    void testCreateIndex() throws IOException {
        //创建索引
        CreateIndexRequest request=new CreateIndexRequest("jd_goods");
        //客户端执行请求
        CreateIndexResponse createIndexResponse=client.indices().create(request,RequestOptions.DEFAULT);
        System.out.println(createIndexResponse);
    }
    //判断是否存在
    @Test
    void isExistIndex() throws IOException {
        GetIndexRequest request=new GetIndexRequest("yu_index");
        boolean exist=client.indices().exists(request,RequestOptions.DEFAULT);
        System.out.println(exist);
    }
    //测试删除索引
    @Test
    void testDeleteIndex() throws IOException {
        DeleteIndexRequest request=new DeleteIndexRequest("yu_index");
        AcknowledgedResponse acknowledgedResponse = client.indices().delete(request, RequestOptions.DEFAULT);
        System.out.println(acknowledgedResponse.isAcknowledged());
    }
    @Test
    void testAddDocument() throws IOException {
        //创建对象
        User user = new User("玉玉", 9);
        //创建请求
        IndexRequest request = new IndexRequest("yu_index");
        request.id("1");
        request.timeout(TimeValue.timeValueSeconds(1));
        request.timeout("1s");
        //将我们的数据放入请求json
        request.source(JSON.toJSONString(user),XContentType.JSON);
        //客户端发送请求，获取响应的结果
        IndexResponse index = client.index(request, RequestOptions.DEFAULT);
        System.out.println(index.toString());
        System.out.println(index.status());
    }
    //获取文档，判断是否存在
    @Test
    void testIsExists() throws IOException {
        GetRequest request = new GetRequest("yu_index", "1");
        //不获取返回_source上下文
        request.fetchSourceContext(new FetchSourceContext(false));
        request.storedFields("_none_");
        boolean exists = client.exists(request, RequestOptions.DEFAULT);
        System.out.println(exists);
    }
    //获取文档信息
    @Test
    void testGetRequest() throws IOException {
        GetRequest request = new GetRequest("yu_index", "1");
        GetResponse response = client.get(request, RequestOptions.DEFAULT);
        System.out.println(response.getSourceAsString());//打印文档的内容
        System.out.println(response);
    }
    //更新文档信息
    @Test
    void testUpdateRequest() throws IOException {
        UpdateRequest request = new UpdateRequest("yu_index", "1");
        request.timeout("1s");
        User user = new User("更新测试", 10);
        request.doc(JSON.toJSONString(user),XContentType.JSON);
        UpdateResponse response = client.update(request, RequestOptions.DEFAULT);
        System.out.println(response.status());
    }
    //删除文档信息
    @Test
    void testDeleteRequest() throws IOException {
        DeleteRequest request = new DeleteRequest("yu_index", "3");
        request.timeout("1s");
        DeleteResponse response = client.delete(request, RequestOptions.DEFAULT);
        System.out.println(response.status());
    }
    //批量插入更新文档信息
    @Test
    void testBulkRequest() throws IOException {
        BulkRequest request = new BulkRequest();
        request.timeout("10s");
        ArrayList<User> userList=new ArrayList<>();
        userList.add(new User("测试1",1));
        userList.add(new User("测试2",1));
        userList.add(new User("测试3",1));
        userList.add(new User("测试4",1));
        userList.add(new User("测试5",1));
        userList.add(new User("测试6",1));
        userList.add(new User("测试7",1));
        userList.add(new User("测试8",1));
        //批处理请求
        for (int i = 0; i < userList.size(); i++) {
            request.add(new IndexRequest("yu_index").id(""+i+1).source(JSON.toJSONString(userList.get(i)),XContentType.JSON));
        }
        BulkResponse response = client.bulk(request, RequestOptions.DEFAULT);
        System.out.println(response.hasFailures());  //是否失败
    }
    //查询
    @Test
    void searchTest() throws IOException {
        SearchRequest request = new SearchRequest("jd_goods");
        //构建搜索条件
        SearchSourceBuilder builder = new SearchSourceBuilder();
        //查询条件
        //QueryBuilders.termQuery 精确查找
        //QueryBuilders.matchAllQuery 匹配所有
//        TermQueryBuilder query = QueryBuilders.termQuery("name", "测试1");
        MatchAllQueryBuilder query = QueryBuilders.matchAllQuery();
        builder.query(query);
        builder.timeout(new TimeValue(60,TimeUnit.SECONDS));
        request.source(builder);

        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        System.out.println(JSON.toJSONString(response.getHits()));
        System.out.println("====================");

        for (SearchHit documentFields: response.getHits().getHits()) {
            System.out.println(documentFields.getSourceAsMap());
        }
    }






    @Test
    void testZZ(){
        String str="我再测试";
        String pattern1 = ".*测试.*";
        boolean b1 = Pattern.matches(pattern1, str);

    }

}
