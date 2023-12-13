package com.itheima;

import com.itheima.dao.BookDao;
import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class Springboot20EsApplicationTests {
//    @Autowired
//    private BookDao bookDao;

//    @Test
//    void fn() {
//        bookDao.selectById(1);
//    }

    // 低级别
//    @Autowired
//    private ElasticsearchRestTemplate template;

    // 高级别
    // 因为这是自己做的，SpringBoot没有整合，所以没有@Autowired
    private RestHighLevelClient client;

    @Test
    void testCreateClient() throws IOException {
        HttpHost host = HttpHost.create("http://localhost:9200");
        RestClientBuilder builder = RestClient.builder(host);
        client = new RestHighLevelClient(builder);

        client.close();
    }

    // 创建客户端，使用客户端发送请求。
    // 创建一个叫做books的索引
    // 关闭客户端
    @Test
    void testCreateIndex() throws IOException {
        HttpHost host = HttpHost.create("http://localhost:9200");
        RestClientBuilder builder = RestClient.builder(host);
        client = new RestHighLevelClient(builder);

        CreateIndexRequest request = new CreateIndexRequest("books");
        client.indices().create(request, RequestOptions.DEFAULT);

        client.close();
    }
}
