## 条件查询

MyBatisPlus将书写复杂的SQL查询条件进行了封装，使用编程的形式完成查询条件的组合。

## 设置查询条件

### 格式一: 常规格式

查询年龄大于等于10岁，小于30岁的用户

```Java
@SpringBootTest
class Mybatisplus02DqlApplicationTests {
    @Autowired
    private UserDao userDao;

    @Test
    void testGetAll() {
        // 多条件
        QueryWrapper<User> qw = new QueryWrapper<User>();
        qw.lt("age", 30);
        qw.gt("age", 10);
        List<User> userList = userDao.selectList(qw);
        System.out.println(userList);
    }
}
```

### 格式二: 链式编程格式

```Java
@SpringBootTest
class Mybatisplus02DqlApplicationTests {
    @Autowired
    private UserDao userDao;
    @Test
    void testGetAll() {
        QueryWrapper<User> qw = new QueryWrapper<User>();
        qw.lt("age", 30).qw.gt("age", 10);
        List<User> userList = userDao.selectList(qw);
        System.out.println(userList);
    }
}
```

### 格式三: lambda链式编程格式

使用lambda()函数

```Java
@SpringBootTest
class Mybatisplus02DqlApplicationTests {
    @Autowired
    private UserDao userDao;

    @Test
    void testGetAll() {
        // lambda按条件查询
        QueryWrapper<User> wrapper = new QueryWrapper<User>();
        wrapper.lambda().lt(User::getAge, 10).gt(User::getAge, 10);
        List<User> userList = userDao.selectList(wrapper);
        System.out.println(userList);
    }
}
```

### 格式四: lambda链式编程格式

```Java
@SpringBootTest
class Mybatisplus02DqlApplicationTests {
    @Autowired
    private UserDao userDao;

    @Test
    void testGetAll() {
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<User>();
        lqw.lt(User::getAge, 30).gt(User::getAge, 10);
        List<User> userList = userDao.selectList(lqw);
        System.out.println(userList);
    }
}
```

### 格式五: 使用or()函数分隔, 不用链式编程

```Java
@SpringBootTest
class Mybatisplus02DqlApplicationTests {
    @Autowired
    private UserDao userDao;

    @Test
    void testGetAll() {
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<User>();
        lqw.lt(User::getAge, 30).or().gt(User::getAge, 10);
        List<User> userList = userDao.selectList(lqw);
        System.out.println(userList);
    }
}
```

## null值处理

### if语句控制条件追加

[![](https://cdn.nlark.com/yuque/0/2023/png/38953059/1699235906112-8bcb886a-703a-44ff-a46c-94393cc9420f.png)](https://cdn.nlark.com/yuque/0/2023/png/38953059/1699235906112-8bcb886a-703a-44ff-a46c-94393cc9420f.png)

### 条件参数控制

```Plain
// 处理null值
@Test
void testGetAll2() {
    // 模拟页面传递过来的查询数据
    UserQuery uq = new UserQuery();
    uq.setAge(10);
    uq.setAge2(30);

    // null判定
    LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<User>();
    // 先判定第一个参数是否为true，如果为true连接当前条件
    lqw.lt(null != uq.getAge2(), User::getAge, uq.getAge2());
    lqw.gt(null != uq.getAge2(), User::getAge, uq.getAge());
    List<User> userList = userDao.selectList(lqw);
    System.out.println(userList);
}
```

### 条件参数控制 (链式编程)

[![](https://cdn.nlark.com/yuque/0/2023/png/38953059/1699235906155-75f38e14-0704-4bf3-8926-3fcd2b8f24b2.png)](https://cdn.nlark.com/yuque/0/2023/png/38953059/1699235906155-75f38e14-0704-4bf3-8926-3fcd2b8f24b2.png)

## 查询投影

查询出来看到的结果，叫做查询投影。

### 查询结果包含模型类中部分属性

[![](https://cdn.nlark.com/yuque/0/2023/png/38953059/1699235906072-7617a65a-d4ff-4dd8-898f-884d87130708.png)](https://cdn.nlark.com/yuque/0/2023/png/38953059/1699235906072-7617a65a-d4ff-4dd8-898f-884d87130708.png)

### 查询结果包含模型类中未定义的属性

[![](https://cdn.nlark.com/yuque/0/2023/png/38953059/1699235906148-997f13d5-7d41-4aa9-a77e-cdae44539fa5.png)](https://cdn.nlark.com/yuque/0/2023/png/38953059/1699235906148-997f13d5-7d41-4aa9-a77e-cdae44539fa5.png)

## 查询条件

### eq匹配 (用户登录)

[![](https://cdn.nlark.com/yuque/0/2023/png/38953059/1699235906108-ec745f64-c7ca-4db9-a786-ac9bbfc48a96.png)](https://cdn.nlark.com/yuque/0/2023/png/38953059/1699235906108-ec745f64-c7ca-4db9-a786-ac9bbfc48a96.png)

### le、ge、between (设定区间)

[![](https://cdn.nlark.com/yuque/0/2023/png/38953059/1699235907795-53227449-fef8-433e-bafb-696b5e638774.png)](https://cdn.nlark.com/yuque/0/2023/png/38953059/1699235907795-53227449-fef8-433e-bafb-696b5e638774.png)

### like匹配 (非全文检索版，查信息，搜索新闻)

[![](https://cdn.nlark.com/yuque/0/2023/png/38953059/1699235907935-cf6afe6f-411c-49c3-b160-371f75c3ec03.png)](https://cdn.nlark.com/yuque/0/2023/png/38953059/1699235907935-cf6afe6f-411c-49c3-b160-371f75c3ec03.png)

### Group (分组查询聚合函数，统计报表)

[![](https://cdn.nlark.com/yuque/0/2023/png/38953059/1699235907943-6ca7001d-8029-493d-bf8b-4de545baf928.png)](https://cdn.nlark.com/yuque/0/2023/png/38953059/1699235907943-6ca7001d-8029-493d-bf8b-4de545baf928.png)

### 查询条件函数总结

lt小于，gt大于，le小于等于，ge大于等于，eq等于

## 字段映射与表名映射

### 问题一: 表字段与编码属性设计不同步

[![](https://cdn.nlark.com/yuque/0/2023/png/38953059/1699235908129-c82142f1-ed6a-4661-83de-645db8ba7c8e.png)](https://cdn.nlark.com/yuque/0/2023/png/38953059/1699235908129-c82142f1-ed6a-4661-83de-645db8ba7c8e.png)

解决方法:

[![](https://cdn.nlark.com/yuque/0/2023/png/38953059/1699235908614-90166efd-3233-4552-9eaa-3bac4c4aa3d5.png)](https://cdn.nlark.com/yuque/0/2023/png/38953059/1699235908614-90166efd-3233-4552-9eaa-3bac4c4aa3d5.png)

### 问题二: 编码中添加了数据库中未定义的属性

[![](https://cdn.nlark.com/yuque/0/2023/png/38953059/1699235909141-96c22b5a-14b9-40ef-842f-7ce0fad69276.png)](https://cdn.nlark.com/yuque/0/2023/png/38953059/1699235909141-96c22b5a-14b9-40ef-842f-7ce0fad69276.png)

解决方法:

[![](https://cdn.nlark.com/yuque/0/2023/png/38953059/1699235909640-80b0231b-1db5-4caa-980a-33b4e9586696.png)](https://cdn.nlark.com/yuque/0/2023/png/38953059/1699235909640-80b0231b-1db5-4caa-980a-33b4e9586696.png)

### 问题三: 采用默认查询开放了更多的字段查看权限

[![](https://cdn.nlark.com/yuque/0/2023/png/38953059/1699235909687-f9147dc4-c966-4ee6-b125-2a809c5b019a.png)](https://cdn.nlark.com/yuque/0/2023/png/38953059/1699235909687-f9147dc4-c966-4ee6-b125-2a809c5b019a.png)

[![](https://cdn.nlark.com/yuque/0/2023/png/38953059/1699235909771-cfaa806c-4301-4143-bc66-0d47ac06c890.png)](https://cdn.nlark.com/yuque/0/2023/png/38953059/1699235909771-cfaa806c-4301-4143-bc66-0d47ac06c890.png)

### 问题四: 表名与编码开发设计不同步

[![](https://cdn.nlark.com/yuque/0/2023/png/38953059/1699235909861-d9287d3c-c211-4f48-9529-6db53a5956a4.png)](https://cdn.nlark.com/yuque/0/2023/png/38953059/1699235909861-d9287d3c-c211-4f48-9529-6db53a5956a4.png)

[![](https://cdn.nlark.com/yuque/0/2023/png/38953059/1699235910272-7f302062-c76e-4d02-89db-d5288988ca0a.png)](https://cdn.nlark.com/yuque/0/2023/png/38953059/1699235910272-7f302062-c76e-4d02-89db-d5288988ca0a.png)

## 讲解重点知识点

### 什么是QueryWrapper？

QueryWrapper 是 MyBatis Plus 提供的一个工具类，用于构建条件查询。这个类提供了丰富的链式调用方法来添加查询条件，这些条件最终会被转换成对应的 SQL 语句的一部分。

QueryWrapper 不是 QueryMapper，但我假设你是指的 QueryWrapper。这个类主要用于MyBatis Plus，不是MyBatis的标准部分。MyBatis Plus是MyBatis的一个增强工具，它简化了CRUD操作，并增加了一些强大的特性，比如自动分页、代码生成以及QueryWrapper等。

使用 QueryWrapper 通常包括**以下步骤**：

1. **实例化**：创建一个 QueryWrapper 的实例，泛型通常是你的实体类，例如 User。

```Plain
QueryWrapper<User> queryWrapper = new QueryWrapper<>();
```

1. **设置条件**：使用 QueryWrapper 提供的方法来构建你的查询条件。

- 例如 .eq("name", "John") 表示等于条件（WHERE name = 'John'）。

- .lt("age", 18) 表示小于条件（WHERE age < 18）。

1. **执行查询**：将 QueryWrapper 实例传递给 mapper 接口的方法执行查询。

List<User> users = userMapper.selectList(queryWrapper);

这是专门为 MyBatis Plus 设计的，并且只有在使用 MyBatis Plus 时才能使用。如果你在使用标准的 MyBatis，你会使用 Example 类或者在 XML 配置文件中手动编写条件查询语句。

### 使用QueryWrapper和LambdaQueryWrapper

LambdaQueryWrapper 和通过 QueryWrapper 调用 .lambda() 方法得到的 LambdaQueryWrapper 实例本质上是相同的。二者都是为了提供更类型安全的方式来构建查询条件，减少硬编码的字符串字段名，从而减少出错的机会，并允许IDE更好地进行代码提示和重构。

**LambdaQueryWrapper**：

- LambdaQueryWrapper 是直接使用 Lambda 表达式的特定类型的 QueryWrapper。
- 它允许你直接在代码中使用实体类的方法引用，而不是字符串表示的字段名，从而提供编译时类型检查和更清晰的语法。

例如：

```Plain
LambdaQueryWrapper<User> lambdaQuery = new LambdaQueryWrapper<>();
lambdaQuery.eq(User::getName, "John");
```

这里，User::getName 使用了方法引用，而不是传统的 QueryWrapper 中的字符串 "name"。这减少了拼写错误的可能性，并在重构字段名时提供了更好的支持。

**QueryWrapper.lambda()**：

- 当你使用 QueryWrapper 并调用 .lambda() 方法时，你实际上是获取了一个 LambdaQueryWrapper 的实例。
- 这种方式首先创建了一个 QueryWrapper 实例，然后通过 .lambda() 转换，但最终的行为和直接创建 LambdaQueryWrapper 实例是一样的。

例如：

```Plain
QueryWrapper<User> queryWrapper = new QueryWrapper<>();
LambdaQueryWrapper<User> lambdaQuery = queryWrapper.lambda();
lambdaQuery.eq(User::getName, "John");
```

**总结**：在功能上，LambdaQueryWrapper 和通过 QueryWrapper 的 .lambda() 方法获得的实例没有区别。选择使用哪一个主要取决于个人偏好或代码的一致性。如果你倾向于使用 Lambda 表达式，并且想要一开始就明确这一点，可能会直接使用 LambdaQueryWrapper。如果你在同一个查询中可能会混合使用 Lambda 表达式和传统的字符串字段名，可能会选择 QueryWrapper 然后在需要的时候调用 .lambda() 方法。

### 不能使用LambdaQueryWrapper的情况

存在一些特定情况下你不得不使用 QueryWrapper 而不是 LambdaQueryWrapper：

1. **动态字段名**：如果你需要构建的查询依赖于动态生成的或者运行时才知道的字段名，那么你可能需要用到 QueryWrapper，因为 LambdaQueryWrapper 需要在编译时就确定属性的方法引用。
2. **复杂的****SQL****操作**：虽然 LambdaQueryWrapper 提供了很多强大的功能，但可能在某些非常复杂的SQL操作中不够用。例如，当你需要执行非常特定的SQL函数或操作时，可能需要使用 QueryWrapper 以字符串形式精确地控制SQL语句。
3. **旧代码的****兼容性**：如果你在维护一个已经广泛使用 QueryWrapper 的旧项目，那么继续使用 QueryWrapper 可能更加合适，因为转换到 LambdaQueryWrapper 可能需要大量的重构工作。
4. **自定义****SQL**：有时，你可能需要在查询中使用非标准的SQL片段或子查询，这在 LambdaQueryWrapper 中可能不那么直观，而 QueryWrapper 可能更容易表达这些自定义SQL片段。
5. **MyBatis Plus 版本****兼容性**：如果你使用的是 MyBatis Plus 的早期版本，它可能不支持 LambdaQueryWrapper 或者其支持不够完全。这种情况下，你需要使用 QueryWrapper。

### 查询投影相关知识点

在 MyBatis Plus 中实现查询投影的常用方法是使用 QueryWrapper 或者 LambdaQueryWrapper 的 select 方法。这可以让你精确地指定需要查询的字段，而不是返回所有字段的数据。

下面是一个使用 QueryWrapper 来实现查询投影的简单例子：

```Plain
// 创建 QueryWrapper 实例
QueryWrapper<User> queryWrapper = new QueryWrapper<>();
// 指定要查询的字段
queryWrapper.select("id", "username", "email");

// 使用 User Mapper 来执行查询
List<Map<String, Object>> users = userMapper.selectMaps(queryWrapper);
// 这里每个Map代表一条记录，只包含我们指定的字段
```

如果你想要使用 LambdaQueryWrapper 来避免硬编码字符串作为列名，你可以按照以下方式操作：

```Plain
// 创建 LambdaQueryWrapper 实例
LambdaQueryWrapper<User> lambdaQuery = Wrappers.<User>lambdaQuery()
                                                .select(User::getId, User::getUsername, User::getEmail);

// 使用 User Mapper 来执行查询
List<User> users = userMapper.selectList(lambdaQuery);
// 返回的列表中的 User 对象只会包含我们指定的字段值
```

请注意，selectList 方法返回的是一个包含完整 User 对象的列表，但是**只有你在** **select** **方法中指定的字段会被填充数据**，**其他的字段**都会是 **null** 或者其**基本类型的默认值**。

如果你想要返回一个键值对的列表，其中只包含你指定的字段，你可以使用 selectMaps 方法：

```Plain
List<Map<String, Object>> users = userMapper.selectMaps(lambdaQuery);
// 每个Map对应一条数据库记录，其中只包含指定的字段
```

这样，selectMaps 会返回一个 Map 列表，其中每个 Map 包含字段名和对应的值，这是一个非常灵活的方式，尤其是当你不需要映射结果到一个完整的实体类时。

在进行查询投影时，要记得这会影响 MyBatis Plus 的结果映射处理。如果查询投影仅返回部分字段，那么 ORM 框架不会尝试填充缺失的字段，它们将保持为 null 或者其类型的默认值。这可能对后续逻辑造成影响，所以使用时应谨慎考虑。