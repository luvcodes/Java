# 简介

MongoDB, MySQL和Redis是三种不同类型的数据库，它们各自拥有独特的优势和用途。了解这三者的区别，可以帮助你根据具体的应用需求选择合适的数据库。以下是MongoDB相对于MySQL和Redis的一些优势：

1. **文档导向的存储**：MongoDB是一个NoSQL数据库，专门用于存储JSON风格的文档。这种灵活的数据模型使得它非常适合存储复杂或者没有固定模式的数据。
2. **查询性能**：MongoDB在处理大量数据和复杂查询时表现良好。虽然Redis在读写性能上有优势（因为数据存储在内存中），但MongoDB在处理复杂查询和大型数据集时更加高效，特别是当数据不能完全加载到内存中时。
3. **可扩展性**：MongoDB提供了高度的可扩展性，支持分片（sharding）和复制集（replication sets），使得它可以很好地处理大规模的数据分布和高可用性需求。
4. **结构化和半结构化数据**：与MySQL这种传统的关系型数据库相比，MongoDB可以更好地处理半结构化或无结构化的数据。MongoDB不需要预先定义模式，使得数据的存储和查询更加灵活。
5. **索引和聚合框架**：MongoDB提供了强大的索引功能和聚合框架，使得处理和分析数据变得更加高效。
6. **社区和生态系统**：MongoDB有一个强大的社区支持和广泛的生态系统，提供了丰富的资源和工具，便于开发和集成。

然而，这些优势并不意味着MongoDB总是比MySQL或Redis更好。MySQL作为一个成熟的关系型数据库，在事务处理、数据一致性和标准化方面表现出色。而Redis作为一个内存数据存储，提供了极高的性能和简单的数据结构，适合作为缓存和消息传递系统。

# 安装

初次下载，在bin文件夹开启cmd，执行这个指令: C:\Users\ryanw\Downloads\mongodb-5.0.23\bin>mongod --dbpath=..\data\db

连接mongodb，在bin文件夹下开启cmd，使用这个指令: C:\Users\ryanw\Downloads\mongodb-5.0.23\bin>mongo

# 指令

```Plain
// 添加操作
db.book.save({"name":"springboot",type:"springboot"})、

// 删除操作
db.book.remove({type:"springboot"})
db.book.remove({})

// 修改操作
db.book.update({name:"springboot2"},{$set:{name:"springboot2"}})
```

# MongoDB配合SpringBoot

先添加配置

```XML
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-data-mongodb</artifactId>
</dependency>
```

配合mongodb访问url，定义在application.yml文件中

```YAML
spring:
  data:
    mongodb:
      uri: mongodb://localhost/ryanyang
```

提供操作MongoDB接口对象MongoTemplate

```Java
@SpringBootTest
class Springboot19MongodbApplicationTests {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    void contextLoads() {
        Book book = new Book();
        book.setId(2);
        book.setName("java2");
        book.setType("springboot2");
        book.setDescription("springboot2");

        mongoTemplate.save(book);
    }

    @Test
    void find() {
        List<Book> bookList = mongoTemplate.findAll(Book.class);
        System.out.println(bookList);
    }
}
```