# 启动

解决方法：在命令行中运行

redis-cli.exe

127.0.0.1:6379>shutdown

not connected>exit

然后重新运行redis-server.exe redis.windows.conf，启动成功！

[https://www.cnblogs.com/suanshun/p/7699084.html](https://www.cnblogs.com/suanshun/p/7699084.html)

# Redis数据结构介绍

Redis是一个key-value的数据库，key一般是string类型，value的类型多种多样

# String及其常见命令

## String类型的三种格式

- 字符串
- int
- float

存储都会转换成字节形式

## String类型的常见命令

![[%E6%88%AA%E5%B1%8F2024-01-04_%E4%B8%8A%E5%8D%888.43.39.png]]

## key的结构

Redis的key允许有多个单词形成层级结构，多个单词之间用’:’隔开

这个格式并非固定，根据自己的需求

![[%E6%88%AA%E5%B1%8F2024-01-04_%E4%B8%8A%E5%8D%888.53.28.png]]

存入4条数据就可以有下面的结果:

`set heima:user:1 ‘{“id”:1, “name”:”Jack”, “age”: 18}’`

`set heima:user:2 ‘{“id”:2, “name”:”Rose”, “age”: 20}’`

`set heima:product:1 ‘{“id”:1, “name”:”xiaomi11”, “price”: 4999}’`

`set heima:product:2 ‘{“id”:2, “name”:”honor6”, “price”: 2999}’`

![[/Untitled 13.png|Untitled 13.png]]

# Hash类型

Hash类型，也叫散列，其value是一个无序字典，类似于HashMap结构。

![[%E6%88%AA%E5%B1%8F2024-01-04_%E4%B8%8A%E5%8D%889.18.48.png]]

在Redis的哈希数据结构中，一个 `field` 只能有一个对应的 `value`。每个 `field` 是唯一的，并且与一个特定的 `value` 相关联。如果你尝试为同一个 `field` 设置新的 `value`，它将覆盖原有的 `value`。

要理解这一点，可以将Redis哈希视为类似于Java中的 `HashMap` 或Python中的字典。就像在这些数据结构中一样，每个键（`field`）都映射到一个单独的值（`value`）。

# List类型

![[%E6%88%AA%E5%B1%8F2024-01-04_%E4%B8%8A%E5%8D%8811.03.57.png]]

1. **LRANGE**: 获取列表指定范围内的元素。
    
    示例：`LRANGE mylist 0 -1` - 获取 'mylist' 中的所有元
    
2. **LLEN**: 获取列表的长度。
    
    示例：`LLEN mylist` - 返回 'mylist' 的长度。
    
3. **LINDEX**: 获取列表中指定位置的元素。
    
    示例：`LINDEX mylist 0` - 获取 'mylist' 第一个元素。
    
4. **LSET**: 将列表中指定位置的元素设置为另一个值。
    
    示例：`LSET mylist 0 x` - 将 'mylist' 中第一个元素的值设置为 'x'。
    
5. **LTRIM**: 对一个列表进行修剪(trim)，就是说，让列表只保留指定区间内的元素，不在指定区间之内的元素都将被删除。
    
    示例：`LTRIM mylist 1 -1` - 移除列表 'mylist' 中第一个元素之外的所有元素。
    

## 如何利用List结构模拟一个栈？

入口出口在同一边

## 如何利用List结构模拟一个队列？

入口出口在不同边

## 如何利用List结构模拟一个阻塞队列？

入口和出口在不同边

出队时采用BLPOP或BRPOP (因为指定时间之后，如果数据库中没有这个数据，就会阻塞)

# Set类型

Redis的set结构与java中的HashSet类似，可以看作是一个value为null的HashMap

- 无序
- 元素不可重复
- 查找快
- 支持交集、并集、差集等功能

  

![[%E6%88%AA%E5%B1%8F2024-01-04_%E4%B8%8A%E5%8D%8811.22.30.png]]

# SortedList类型

Redis的SortedSet是一个可排序的set集合，与Java中的TreeSet有些类似，但是底层数据结构却差别很大。

每个元素都带有一个score属性，可以基于score属性对元素排序，底层的实现是一个SkipList + Hash表

- 可排序
- 元素不重复
- 查询速度快

![[%E6%88%AA%E5%B1%8F2024-01-04_%E4%B8%8A%E5%8D%8811.37.14.png]]

## 练习题

![[%E6%88%AA%E5%B1%8F2024-01-04_%E4%B8%8A%E5%8D%8811.46.25.png]]

  

[[Redis的Java客户端]]

[[Redis实战项目]]

[[Redis缓存]]

[[优惠劵秒杀]]

[[分布式锁]]

[[消息队列]]