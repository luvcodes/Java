# 分类

1. **Jedis**:
    - **用法**: Jedis是一个轻量级且简单的Redis客户端，直接提供了对Redis命令的访问。
    - **优势**: 简单易用，性能良好，适合快速开发。
    - **劣势**: 不支持异步操作，线程不安全。
2. **Lettuce**:
    - **用法**: Lettuce是一个高级Redis客户端，支持同步、异步和响应式模式。它基于Netty构建，适用于多线程应用。
    - **优势**: 支持高级功能如集群、管道、事务和流水线，适合大型、复杂的应用。
    - **劣势**: 相较于Jedis，学习曲线较陡峭。
3. **Redisson**:
    - **用法**: Redisson提供了对Java常见数据结构和服务的**分布式实现**，如Map、Set、List、分布式锁和原子操作。
    - **优势**: 提供了丰富的分布式数据结构和服务，易于集成。
    - **劣势**: 相对较重，可能不适合只需要简单Redis客户端功能的场景。
4. **Spring Data Redis**:
    - **用法**: 作为Spring框架的一部分，Spring Data Redis提供了与Redis交互的高级抽象，支持声明式配置和访问。
    - **优势**: 与Spring生态系统集成良好，提供了丰富的功能和方便的配置。
    - **劣势**: 主要适用于使用Spring框架的项目。

# Jedis

## 快速上手

1. 引入依赖
2. 建立连接
3. 测试string
4. 释放资源
## Jedis连接池

这段代码定义了一个 `JedisPool` 对象，它是 Jedis 客户端用来管理 Redis 连接的连接池。使用连接池是一种常见的模式，用于优化资源的使用、提高性能并减少延迟。

1. **最大连接数（**`**setMaxTotal**`**）**：这个参数设置连接池中可以同时分配的最大活跃连接数。如果所有的连接都在使用中，而且连接池已经达到最大连接数，那么新的请求将等待，直到有可用连接。在高负载情况下，如果这个值设置得太低，可能会导致性能瓶颈。
2. **最大空闲连接数（**`**setMaxIdle**`**）**：这是连接池中允许保持空闲状态的最大连接数。当连接池中的空闲连接超过此值时，多余的空闲连接会被关闭并移除。这有助于控制资源的使用，特别是在低负载或空闲时段。
3. **最小空闲连接数（**`**setMinIdle**`**）**：这是连接池中希望保持的最小空闲连接数。即使没有足够的活跃请求，连接池也会尝试保持这么多的连接开启，以便快速响应新的请求。
4. **最大等待时间（**`**setMaxWaitMillis**`**）**：如果连接池中没有可用的空闲连接，这个参数定义了一个请求等待空闲连接的最大时间（以毫秒为单位）。超过这个时间后，如果仍然没有可用连接，将抛出异常。这有助于避免无限期等待连接的情况。

在实际应用中，这些概念用于确保连接池能够高效地管理 Redis 连接，同时避免资源的过度使用。正确的配置取决于应用的具体需求和负载情况。例如，在高负载的生产环境中，可能需要较高的最大连接数来处理并发请求，而在开发或测试环境中，较低的数值可能就足够了。

```Java
public class JedisConnectionFactory {
    private static final JedisPool JEDIS_POOL;

    static {
        // 配置连接池
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(8);
        // 空闲连接
        jedisPoolConfig.setMaxIdle(8);
        jedisPoolConfig.setMinIdle(0);
        // 等待时长1000ms就会报错了
        jedisPoolConfig.setMaxWaitMillis(1000);
        // 创建连接池对象
        JEDIS_POOL = new JedisPool(jedisPoolConfig, "127.0.0.1",
                6379, 1000, "123456");
    }

    public static Jedis getJedis() {
        return JEDIS_POOL.getResource();
    }
}
```

# SpringDataRedis

SpringData是Spring中数据操作的模块，包含对各种数据库的集成，其中对Redis的集成模块就叫做SpringDataRedis，官网地址：[https://spring.io/projects/spring-data-redis](https://spring.io/projects/spring-data-redis)

- 提供了对不同Redis客户端的整合（Lettuce和Jedis）
- 提供了RedisTemplate统一API来操作Redis
- 支持Redis的发布订阅模型
- 支持Redis哨兵和Redis集群
- 支持基于Lettuce的响应式编程
- 支持基于JDK.JSON.字符串.Spring对象的数据序列化及反序列化
- 支持基于Redis的JDKCollection实现

SpringDataRedis中提供了RedisTemplate工具类，其中封装了各种对Redis的操作。并且将不同数据类型的操作API封装到了不同的类型中：

![[%E6%88%AA%E5%B1%8F2024-01-04_%E4%B8%8B%E5%8D%884.13.14.png]]

## 使用方法

1. 导入依赖
2. 编写配置 - springboot默认使用的lettuce连接池

```YAML
spring:
  data:
    redis:
      host: 127.0.0.1
      port: 6379
      password: 123456
      lettuce:
        pool:
          max-active: 8
          max-idle: 8
          min-idle: 0
          max-wait: 1000ms
```

1. 注入

```Java
@Autowired
    private RedisTemplate redisTemplate;
```

1. 测试

```Java
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class RedisDemo1ApplicationTests {
    @Autowired
    private RedisTemplate redisTemplate;
    @Test
    void contextLoads() {
        redisTemplate.opsForValue().set("name", "mark");

        Object name = redisTemplate.opsForValue().get("name");
        System.out.println("name" + name);
    }
}
```

使用这样的方式存入redis中发现数据的名称与内容难以阅读，所以就引出了序列化RedisTemplate的解决方法

![[%E6%88%AA%E5%B1%8F2024-01-04_%E4%B8%8B%E5%8D%884.45.51.png]]

## 方式一

1. 自定义RedisTemplate
2. 修改RedisTemplate的序列化器为`GenericJackson2JsonRedisSerializer`

```Java
@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
        // 创建RedisTemplate对象
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        // 设置连接工厂
        template.setConnectionFactory(connectionFactory);
        // 设置JSON序列化工具
        GenericJackson2JsonRedisSerializer jsonRedisSerializer = new GenericJackson2JsonRedisSerializer();
        // 设置Key的序列化
        template.setKeySerializer(RedisSerializer.string());
        template.setHashKeySerializer(RedisSerializer.string());
        // 设置Value的序列化
        template.setValueSerializer(jsonRedisSerializer);
        template.setHashValueSerializer(jsonRedisSerializer);
        // 返回
        return template;
    }
}
```

首先设置连接工厂以建立与Redis的连接，然后设置键和值的序列化方式，确保数据可以正确地写入和读取Redis。

  

但是这样的方式也有一个问题，就是在每一个存入的数据中都会包括一个类字节码 (`@Class`)，占用额外空间

## 方式二

1. 使用StringRedisTemplate
2. 写入Redis时，手动把对象序列化为JSON
3. 读取Redis时，手动把读取到的JSON反序列化为对象

```Java
@SpringBootTest
class StringRedisTests {
    // 用这样的方式写的话，就不需要config.RedisConfig文件中的定义了

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    void testString() {
        stringRedisTemplate.opsForValue().set("age", "18");
        Object age = stringRedisTemplate.opsForValue().get("age");
        System.out.println(age);
    }

    private static final ObjectMapper mapper = new ObjectMapper();


    @Test
    void testSaveUser() throws JsonProcessingException {
        // 创建对象
        User user = new User("mark", 22);
        // 手动序列化
        String json = mapper.writeValueAsString(user);
        // 导入数据
        stringRedisTemplate.opsForValue().set("user:2", json);
        // 获取数据
        String jsonUser = stringRedisTemplate.opsForValue().get("user:2");
        // 手动反序列化
        mapper.readValue(jsonUser, User.class);
        System.out.println("User2 = " + user);
    }

    @Test
    void testHash() {
        stringRedisTemplate.opsForHash().put("user:3", "name", "mark");
        stringRedisTemplate.opsForHash().put("user:3", "age", "21");
        Map<Object, Object> entries = stringRedisTemplate.opsForHash().entries("user:3");
        System.out.println(entries);
    }
}
```