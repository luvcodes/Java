# Spring Cache

Spring Cache 是一个框架，实现了基于注解的缓存功能，只需要简单地加一个注解，就能实现缓存功能。

Spring Cache 提供了一层抽象，底层可以切换不同的缓存实现，例如：

- EHCache
- Caffeine
- Redis(常用)

在SpringCache中提供了很多缓存操作的注解，常见的是以下的几个：

|   |   |
|---|---|
|**注解**|**说明**|
|@EnableCaching|开启缓存注解功能，通常加在启动类上|
|@Cacheable|在方法执行前先查询缓存中是否有数据，如果有数据，则直接返回缓存数据；如果没有缓存数据，调用方法并将方法返回值放到缓存中|
|@CachePut|将方法的返回值放到缓存中|
|@CacheEvict|将一条或多条数据从缓存中删除|

在spring boot项目中，使用缓存技术只需在项目中导入相关缓存技术的依赖包，并在启动类上使用@EnableCaching开启缓存支持即可。

## @EnableCaching**说明**

开启缓存注解功能，通常加在启动类上。

## **@CachePut说明**

- 作用: 将方法返回值，放入缓存
- value: 缓存的名称, 每个缓存名称下面可以有很多key
- key: 缓存的key ----------> 支持Spring的表达式语言SPEL语法

**在save方法上加注解** `@CachePut`

当前UserController的save方法是用来保存用户信息的，我们希望在该用户信息保存到数据库的同时，也往缓存中缓存一份数据，我们可以在save方法上加上注解 @CachePut，用法如下：

```Java
	@PostMapping
    @CachePut(value = "userCache", key = "\#user.id")//key的生成：userCache::1
    public User save(@RequestBody User user){
        userMapper.insert(user);
        return user;
    }
```

**说明：**key的写法如下

`\#user.id` : #user指的是方法形参的名称, id指的是user的id属性 , 也就是使用user的id属性作为key ;

`\#result.id` : #result代表方法返回值，该表达式代表以返回对象的id属性作为key。这个点 "." 叫做对象导航。

`\#p0.id`：#p0指的是方法中的第一个参数，id指的是第一个参数的id属性, 也就是使用第一个参数的id属性作为key ;

`\#a0.id`：#a0指的是方法中的第一个参数，id指的是第一个参数的id属性, 也就是使用第一个参数的id属性作为key ;

`\#root.args[0].id`:#root.args[0]指的是方法中的第一个参数，id指的是第一个参数的id属性,也就是使用第一个参数的id属性作为key

## **@Cacheable说明**

作用: 在方法执行前，spring先查看缓存中是否有数据，如果有数据，则直接返回缓存数据；若没有数据，调用方法并将方法返回值放到缓存中

value: 缓存的名称，每个缓存名称下面可以有多个key

key: 缓存的key ----------> 支持Spring的表达式语言SPEL语法

## **@CacheEvict说明**

作用: 清理指定缓存

value: 缓存的名称，每个缓存名称下面可以有多个key

key: 缓存的key ----------> 支持Spring的表达式语言SPEL语法