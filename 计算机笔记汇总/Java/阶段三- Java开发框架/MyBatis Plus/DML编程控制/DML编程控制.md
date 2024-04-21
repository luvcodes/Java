# id生成策略控制

## 不同的表应用不同的id生成策略

![[/Untitled 28.png|Untitled 28.png]]

这里面所有的TableName和IdType都可以提取出来

![[/Untitled 1 12.png|Untitled 1 12.png]]

转换成全局配置

![[/Untitled 2 11.png|Untitled 2 11.png]]

在 MyBatis Plus 中，@TableId 注解用于标识实体类的属性映射到数据库表的主键字段。type 属性用于指定主键的生成策略。您的代码段中展示了三种不同的主键生成策略的注释示例，但没有明确启用任何一种。下面是对这三种主键生成策略的简要说明：

1. IdType.AUTO：
    - 自增主键。数据库会自动为新插入的记录生成一个唯一的主键值，通常是数字类型并且每次递增。这要求数据库表的主键列被设置为自增（AUTO_INCREMENT）。
    - 示例：@TableId(type = IdType.AUTO)
2. IdType.INPUT：
    - 手动输入。这意味着在插入数据时，主键的值需要你在应用层面提供，MyBatis Plus 不会自动生成它。
    - 示例：@TableId(type = IdType.INPUT)
3. IdType.ASSIGN_ID：
    - 分配ID（默认策略）。当实体的主键类型为Long或String时，如果没有指定主键的值，MyBatis Plus 会使用雪花算法（Snowflake）或UUID生成一个主键值。这适用于分布式系统中生成唯一标识符的场景。
    - 示例：@TableId(type = IdType.ASSIGN_ID)

要激活其中一种策略，你需要取消对应行的注释，并确保你的实体类中只有一个字段使用了 @TableId 注解，因为每个实体类只能有一个主键字段。选择哪种主键生成策略取决于你的具体需求和数据库表的配置。

例如，如果你希望数据库自动为每条新记录分配一个唯一的数字ID，你可以使用 IdType.AUTO。如果你的应用或服务生成了主键值，并希望直接插入这个值，那么 IdType.INPUT 会是合适的选择。对于分布式系统，IdType.ASSIGN_ID 可以自动生成一个全局唯一的ID，无需依赖数据库的特定特性。

# 多记录操作

## 多数据删除

```Java
@Test
    void testDelete() {
        List<Long> list = new ArrayList<Long>();
        list.add(1721033084409384962L);
        list.add(1721035040897036290L);
		// userDao.deleteById(4L);
        userDao.deleteBatchIds(list);
    }
```

# 逻辑删除

逻辑删除是在数据库管理中的一种做法，它涉及将数据标记为已删除，而不是从数据库中物理删除它。在逻辑删除的做法中，通常会有一个字段用来指示某行数据是否被“删除”。

逻辑删除的优势包括：安全和合规： 某些情况下出于审计或合规要求，需要保留记录的历史。

在实现逻辑删除时，需要在查询数据时总是考虑到这个逻辑删除的字段，确保“删除”的数据不会在应用程序中显示。

## 逻辑删除案例

数据库表中添加逻辑删除标记字段，要记着给默认值。

![[/Untitled 3 8.png|Untitled 3 8.png]]

  

实体类中添加对应字段，并设定当前字段为逻辑删除标记字段 (**不推荐**，因为太繁琐)

![[/Untitled 4 6.png|Untitled 4 6.png]]

  

配置逻辑删除字面值 (开启逻辑删除功能)

![[/Untitled 5 5.png|Untitled 5 5.png]]

  

开启逻辑删除功能之后，就会替换原来的DELETE语句而改成了UPDATE语句。会用设置的逻辑删除标记字段来判断是否被删除，并且被标记删除的数据，是不会参与到MP的API查询的过程中的 (也就是说再查数据，是不会查出来标记删除的这条数据的)。

举例来说，比如执行了这样的一条MP的语句: userDao.deleteById(1752533337792716802L);, 这条语句所接收的ID值的那条数据就会被标记成逻辑删除，执行的是这样的一条SQL语句:

```SQL
==>  Preparing: UPDATE tbl_user SET deleted=1 WHERE id=? AND deleted=0
==> Parameters: 1752533337792716802(Long)
<==    Updates: 1
```

刷新数据库就可以发现对应ID的这条数据被标记成逻辑删除，deleted列的值由0变成1。

  

接下来查询数据库的情况:

![[/Untitled 6 5.png|Untitled 6 5.png]]

  

查询所有的数据: System.out.println(userDao.selectList(null));

```SQL
==>  Preparing: SELECT id,name,age,tel,deleted,version FROM tbl_user WHERE deleted=0
==> Parameters:
<==    Columns: id, name, age, tel, deleted, version
<==        Row: 1, update, 3, 18866668888, 0, 0
<==        Row: 1752533233518223362, 后端程序员, 12, 4006184000, 0, 0
<==      Total: 2
Closing non transactional SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@554188ac]
[User(id=1, name=update, password=null, age=3, tel=18866668888, online=null, deleted=0, version=0), User(id=1752533233518223362, name=后端程序员, password=null, age=12, tel=4006184000, online=null, deleted=0, version=0)]
```

发现被标记逻辑删除的两条数据不会被查出来。

# 乐观锁

需要进行并发控制的时候

## 乐观锁案例

数据库表中添加锁标记字段

![[/Untitled 7 5.png|Untitled 7 5.png]]

  

实体类中添加对应字段

```Java
@Data
public class User {
    // 乐观锁
    @Version
    private Integer version;
}
```

配置乐观锁拦截器实现锁机制对应的动态SQL语句拼装

```Java
@Configuration
public class MyBatisPlusConfig {
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        // 乐观锁的拦截器
        interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());

        return interceptor;
    }
}
```

使用乐观锁机制在修改前必须先获取到对应数据的version就可以执行了

编写测试方法:

```Java
@Test
    void testUpdate() {
        User user = new User();
        user.setId(1752539431835492354L);
        user.setName("Jock666");
        user.setVersion(1);
        userDao.updateById(user);
    }
```

查看运行结果:

```SQL
==>  Preparing: UPDATE tbl_user SET name=?, version=? WHERE id=? AND version=? AND deleted=0
==> Parameters: Jock666(String), 2(Integer), 1752539431835492354(Long), 1(Integer)
<==    Updates: 0
```

如果不想直接用setter方法确定version，可以先通过将要修改的数据的id将数据查询出来，然后将要修改的属性值设置进去。

```Java
// 1. 先通过修改的数据id将当前数据查询出来
User user = userDao.selectById(1752539431835492354L);
// 2. 将要修改的属性逐一设置进去
user.setName("Jock888");
userDao.updateById(user);
```

这样做的条件就是数据库中一定要先给这条ID所对应的数据提前设置了version值。

## 验证加锁的操作

```Java
@Test
    void testUpdate() {
        // 验证加锁的操作
        User user1 = userDao.selectById(1752539431835492354L);
        User user2 = userDao.selectById(1752539431835492354L);
        user2.setName("Jock999");
        userDao.updateById(user2);
        user1.setName("Jock101010");
        userDao.updateById(user1);
    }
```

下面这条一定会失效，因为读的version值 还依然是上面Jock999之前的version值。

然后，尝试同样更新 user1（注意，此时 user1 的版本号还是旧的）。因为数据库中的版本号已经被 user2的操作增加了，user1 的更新将会失败，因为它的版本号不再与数据库中的版本号匹配。

这正是乐观锁的工作原理：只有当版本号匹配时，更新操作才会成功，否则会失败，从而避免了并发修改的数据冲突。

## 版本号加一的操作？

在使用MyBatis-Plus框架时，带有 @Version 注解的字段（在您的例子中是 version 字段），在进行更新操作时，框架会自动处理这个字段的增加。可以理解成OptimisticLockerInnerInterceptor 乐观锁拦截器来处理+1的任务。

当您调用 userDao.updateById(user) 方法时，如果user对象中包含一个通过 @Version 注解的字段，MyBatis-Plus将生成一个类似下面的SQL更新语句：

```SQL
UPDATE user SET name = 'newName', version = version + 1 WHERE id = ? AND version = ?
```

在这个更新语句中：

- name = 'newName' 是您想要更新的字段。
- version = version + 1 是由MyBatis-Plus自动生成的，用于确保乐观锁的版本控制。
- WHERE id = ? 确保您只更新指定的记录。
- AND version = ? 是乐观锁的关键，它检查当前记录的版本号是否与您尝试更新的记录的版本号相同。如果不相同，更新将失败。

在MyBatis-Plus框架中，OptimisticLockerInnerInterceptor 乐观锁拦截器确保每次在执行带有 @Version 注解的字段的更新操作时，该字段的值会自动加1。这个操作是自动发生的，确保每次数据库记录被成功更新时，对应的版本号都会递增，这样来避免并发问题。