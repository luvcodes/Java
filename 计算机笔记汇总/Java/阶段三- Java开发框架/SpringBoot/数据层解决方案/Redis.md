# 启动

解决方法：在命令行中运行

redis-cli.exe

127.0.0.1:6379>shutdown

not connected>exit

然后重新运行redis-server.exe redis.windows.conf，启动成功！

[https://www.cnblogs.com/shaosks/p/7089786.html](https://www.cnblogs.com/shaosks/p/7089786.html)

### SpringBoot整合Redis

操作步骤:

- 导入SpringBoot整合Redis坐标
- 配置Redis (这里其实在application.yml文件中加不加都是默认配置，也就是`host: localhost`和`port: 6379`
- 测试类自动装配RedisTemplate。它提供操作各种数据类型的接口API

```Java
@SpringBootTest
class Springboot18RedisApplicationTests {
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void set() {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set("age", 41);
    }

    @Test
    void get() {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        Object age = valueOperations.get("age");
        System.out.println(age);
    }

    @Test
    void hset() {
        HashOperations opsedForHash = redisTemplate.opsForHash();
        opsedForHash.put("info", "b", "b");
    }

    @Test
    void hget() {
        HashOperations opsedForHash = redisTemplate.opsForHash();
        Object o = opsedForHash.get("info", "b");
        System.out.println(o);
    }
}
```

客户端: `RedisTemplate`以对象作为key和value，内部对数据进行序列化。就像上面这样。但是就会发现如果以`RedisTemplate`来取得Redis数据库中的类似于`name`或者`name2`这样的key-value，就会发现无法读取，读到的结果是null。引出下面的`StringRedisTemplate`

而`StringRedisTemplate`以字符串作为key和value，与Redis客户端操作等效。

```Java
@SpringBootTest
public class StringRedisTemplateTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    void get() {
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        String name = ops.get("name");
        System.out.println(name);
    }
}
```

### Lettuce和Jedis

Jedis 不是数据库类型，也不是数据源，而是一个用于 Java 应用的 Redis 客户端库。它是一个轻量级的库，用于在 Java 程序中连接和操作 Redis，这是一种流行的开源键值对数据库。

### Jedis 的本质

1. **客户端库**：Jedis 提供了一组 API，允许 Java 程序通过网络与 Redis 服务器进行交互。
2. **Redis 接口**：它实现了 Redis 支持的各种命令，使得开发者可以在 Java 应用中方便地执行这些命令。
3. **轻量级和高效**：Jedis 设计简单，对系统资源的占用相对较小，非常适合需要与 Redis 进行高效通信的应用。

### 使用场景

- 当开发者在 Java 应用中需要使用 Redis 作为数据存储或缓存解决方案时，他们会选择 Jedis 作为连接和操作 Redis 的工具。
- Jedis 支持 Redis 的各种操作，如设置键值对、读取数据、处理列表、集合和有序集合、发布/订阅等。

### 与数据库和数据源的关系

- **不是数据库**：Jedis 自身不存储任何数据，它仅作为连接 Redis（实际的数据库系统）的中介。
- **不是数据源**：在数据库技术中，数据源通常指的是提供数据的系统或软件（例如数据库服务器）。Jedis 只是一个让 Java 应用能够访问这些数据源（即 Redis 服务器）的工具。

总结来说，Jedis 是一个连接 Java 应用和 Redis 数据库的桥梁，它本身不存储数据，而是让 Java 开发者能够方便地使用 Redis。