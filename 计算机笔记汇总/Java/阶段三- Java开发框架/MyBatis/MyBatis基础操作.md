# 查询

```Java
@Mapper
public interface UserMapper {
    //查询所有用户数据
    @Select("select id, name, age, gender, phone from user")
    public List<User> list();
}
```

```Java
@SpringBootTest
class SpringbootMybatisQuickstartApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testList() {
        List<User> userList = userMapper.list();
        for (User user : userList) {
            System.out.println(user);
        }
    }
}
```

# 删除

SQL语句中的id值不能写成固定数值，需要变为动态的数值。因此，在delete方法中添加一个参数(用户id)，将方法中的参数，传给SQL语句

```Java
@Mapper
public interface EmpMapper {
    @Delete("delete from emp where id = #{id}")
    public void delete(Integer id);
}
```

```Java
@SpringBootTest
class SpringbootMybatisCrudApplicationTests {
    @Autowired
    private EmpMapper empMapper;

    @Test
    void testDelete() {
        empMapper.delete(18);
    }
}
```

@Delete注解：用于编写delete操作的SQL语句

如果mapper接口方法形参只有一个普通类型的参数，#{…} 里面的属性名可以随便写，如：#{id}、#{value}。但是建议保持名字一致。

最后返回的结果是按照0和1来判断的，如果删除成功就是1，否则就是0。

## 配置MyBatis的日志信息

**在Mybatis当中我们可以借助日志，查看到sql语句的执行、执行传递的参数以及执行结果**。具体操作如下：

1. 打开application.properties文件
2. 开启mybatis的日志，并指定输出到控制台

```Plain
#指定mybatis输出日志的位置, 输出控制台
mybatis.configuration.log-impl=org.apache.ibatis.logging.stdout.StdOutImpl
```

开启日志之后，我们再次运行单元测试，可以看到在控制台中，输出了以下的SQL语句信息：

[![](https://cdn.nlark.com/yuque/0/2024/png/38953059/1711339878011-371fea8a-a900-4aed-ae73-41843795a551.png)](https://cdn.nlark.com/yuque/0/2024/png/38953059/1711339878011-371fea8a-a900-4aed-ae73-41843795a551.png)

但是我们发现输出的SQL语句：delete from emp where id = ?，我们输入的参数16并没有在后面拼接，id的值是使用?进行占位。那这种SQL语句我们称为预编译SQL。

## 预编译SQL

预编译SQL有两个优势：

1. 性能更高
2. 更安全(防止SQL注入)

[![](https://cdn.nlark.com/yuque/0/2024/png/38953059/1711340107906-a4510386-8f82-497c-b6fb-f593aca585eb.png)](https://cdn.nlark.com/yuque/0/2024/png/38953059/1711340107906-a4510386-8f82-497c-b6fb-f593aca585eb.png)

性能更高：预编译SQL，编译一次之后会将编译后的SQL语句缓存起来，后面再次执行这条语句时，不会再次编译。（只是输入的参数不同）

更安全(防止SQL注入)：将敏感字进行转义，保障SQL的安全性。

### SQL注入

SQL注入：是通过操作输入的数据来修改事先定义好的SQL语句，以达到执行代码对服务器进行攻击的方法。

由于没有对用户输入进行充分检查，而SQL又是拼接而成，在用户输入参数时，在参数中添加一些SQL关键字，达到改变SQL运行结果的目的，也可以完成恶意攻击。

由于没有对用户输入内容进行充分检查，而SQL又是字符串拼接方式而成，在用户输入参数时，在参数中添加一些SQL关键字，达到改变SQL运行结果的目的，从而完成恶意攻击。

[![](https://cdn.nlark.com/yuque/0/2024/png/38953059/1711340470879-0b855b3e-1c6b-40d5-a99c-2e498358ce8a.png)](https://cdn.nlark.com/yuque/0/2024/png/38953059/1711340470879-0b855b3e-1c6b-40d5-a99c-2e498358ce8a.png)

[![](https://cdn.nlark.com/yuque/0/2024/png/38953059/1711340496454-78bbab4e-bd40-4330-afe5-2f16c04f2378.png)](https://cdn.nlark.com/yuque/0/2024/png/38953059/1711340496454-78bbab4e-bd40-4330-afe5-2f16c04f2378.png)

用户在页面提交数据的时候人为的添加一些特殊字符，使得sql语句的结构发生了变化，最终可以在没有用户名或者密码的情况下进行登录。

### 参数占位符 (面试题)

在Mybatis中提供的参数占位符有两种：`${...}` 、`#{...}`

- `#{...}`
- 执行SQL时，会将#{…}替换为?，**生成预编译SQL**，会自动设置参数值。
- 使用时机：参数传递，都使用`#{…}`。
- `${...}`
- 拼接SQL。直接将参数拼接在SQL语句中，存在SQL注入问题。
- 使用时机：如果对表名、列表进行动态设置时使用。

注意事项：在项目开发中，建议使用`#{...}`，生成预编译SQL，防止SQL注入安全。

# 新增

## 基本新增

```Java
@Mapper
public interface EmpMapper {
    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time) values (#{username}, #{name}, #{gender}, #{image}, #{job}, #{entrydate}, #{deptId}, #{createTime}, #{updateTime})")
    public void insert(Emp emp);

}
```

```Java
@SpringBootTest
class SpringbootMybatisCrudApplicationTests {
    @Autowired
    private EmpMapper empMapper;

    @Test
    public void testInsert(){
        //创建员工对象
        Emp emp = new Emp();
        emp.setUsername("tom");
        emp.setName("汤姆");
        emp.setImage("1.jpg");
        emp.setGender((short)1);
        emp.setJob((short)1);
        emp.setEntrydate(LocalDate.of(2000,1,1));
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        emp.setDeptId(1);
        //调用添加方法
        empMapper.insert(emp);
    }
}
```

## 主键返回

如：添加套餐数据时，还需要维护套餐菜品关系表数据。

[![](https://cdn.nlark.com/yuque/0/2024/png/38953059/1707430676950-05c03890-c334-4123-9e03-87a51933b4ef.png)](https://cdn.nlark.com/yuque/0/2024/png/38953059/1707430676950-05c03890-c334-4123-9e03-87a51933b4ef.png)

业务场景：菜品与套餐模块的表结构，**菜品与套餐是多对多的关系**，一个套餐对应多个菜品。既然是多对多的关系，是不是有一张套餐菜品中间表来维护它们之间的关系。

[![](https://cdn.nlark.com/yuque/0/2024/png/38953059/1707430693883-c98c7569-6f0a-45c5-bc80-cb8fd8a966e9.png)](https://cdn.nlark.com/yuque/0/2024/png/38953059/1707430693883-c98c7569-6f0a-45c5-bc80-cb8fd8a966e9.png)

在添加套餐的时候，我们需要在界面当中来录入套餐的基本信息，还需要来录入套餐与菜品的关联信息。这些信息录入完毕之后，我们一点保存，就需要将套餐的信息以及套餐与菜品的关联信息都需要保存到数据库当中。

其实具体的过程包括两步，首先第一步先需要将套餐的基本信息保存了，接下来第二步再来保存套餐与菜品的关联信息。

**套餐与菜品的关联信息就是往中间表当中来插入数据**，来维护它们之间的关系。而**中间表当中有两个外键字段**，一个是菜品的ID，就是当前菜品的ID，还有一个就是套餐的ID，而这个套餐的 ID 指的就是此次我所添加的套餐的ID，所以我们在第一步保存完套餐的基本信息之后，就**需要将套餐的主键值返回来供第二步进行使用**。这个时候就**需要用到主键返回功能**。

那要如何实现在插入数据之后返回所插入行的主键值呢？

- 默认情况下，执行插入操作时，是不会主键值返回的。如果我们想要拿到主键值，需要在Mapper接口中的方法上添加一个`Options`注解，并在注解中指定属性`useGeneratedKeys=true`和`keyProperty="实体类属性名"`

主键返回代码实现：

```Java
@Mapper
public interface EmpMapper {
    //会自动将生成的主键值，赋值给emp对象的id属性
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time) values (#{username}, #{name}, #{gender}, #{image}, #{job}, #{entrydate}, #{deptId}, #{createTime}, #{updateTime})")
    public void insert(Emp emp);
}
```

测试：

```Java
@SpringBootTest
class SpringbootMybatisCrudApplicationTests {
    @Autowired
    private EmpMapper empMapper;

    @Test
    public void testInsert(){
        //创建员工对象
        Emp emp = new Emp();
        emp.setUsername("jack");
        emp.setName("杰克");
        emp.setImage("1.jpg");
        emp.setGender((short)1);
        emp.setJob((short)1);
        emp.setEntrydate(LocalDate.of(2000,1,1));
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        emp.setDeptId(1);
        //调用添加方法
        empMapper.insert(emp);

        System.out.println(emp.getId());
    }
}
```

# 更新

功能：修改员工信息

[![](https://cdn.nlark.com/yuque/0/2024/png/38953059/1707430728350-14d304a0-6e4c-431b-b44f-52f8760c1900.png)](https://cdn.nlark.com/yuque/0/2024/png/38953059/1707430728350-14d304a0-6e4c-431b-b44f-52f8760c1900.png)

点击"编辑"按钮后，会查询所在行记录的员工信息，并把员工信息**回显**在修改员工的窗体上(下个知识点学习)

在修改员工的窗体上，可以修改的员工数据：用户名、员工姓名、性别、图像、职位、入职日期、归属部门

思考：在修改员工数据时，要以什么做为条件呢？

答案：**员工id**

```Java
@Update("update emp set username=#{username}, name=#{name}, gender=#{gender}, image=#{image}, job=#{job}, entrydate=#{entrydate}, dept_id=#{deptId}, update_time=#{updateTime} where id=#{id}")
public void update(Emp emp);
```

```Java
@Test
void testUpdate() {
    // 更新员工对象
    Emp emp = new Emp();
    emp.setId(23);
    emp.setUsername("songdaxia");
    emp.setPassword(null);
    emp.setName("老宋");
    emp.setImage("2.jpg");
    emp.setGender((short)1);
    emp.setJob((short)2);
    emp.setEntrydate(LocalDate.of(2012,1,1));
    emp.setCreateTime(null);
    emp.setUpdateTime(LocalDateTime.now());
    emp.setDeptId(2);
    // 调用方法，修改员工数据
    empMapper.update(emp);
}
```

# 查询

## 根据ID查询

在员工管理的页面中，当我们进行更新数据时，会点击 “编辑” 按钮，然后此时会发送一个请求到服务端，会根据Id查询该员工信息，并将员工数据回显在页面上。

[![](https://cdn.nlark.com/yuque/0/2024/png/38953059/1707430771493-446eef3d-e203-4f14-9c80-fa10cc989082.png)](https://cdn.nlark.com/yuque/0/2024/png/38953059/1707430771493-446eef3d-e203-4f14-9c80-fa10cc989082.png)

接口方法：

```Java
@Mapper
public interface EmpMapper {
    @Select("select id, username, password, name, gender, image, job, entrydate, dept_id, create_time, update_time from emp where id=#{id}")
    public Emp getById(Integer id);
}
```

测试类：

```Java
@Test
public void testGetById(){
  Emp emp = empMapper.getById(1);
  System.out.println(emp);
}
```

[![](https://cdn.nlark.com/yuque/0/2024/png/38953059/1707430801211-92c29656-238e-4a4c-8460-43e4e34c25c1.png)](https://cdn.nlark.com/yuque/0/2024/png/38953059/1707430801211-92c29656-238e-4a4c-8460-43e4e34c25c1.png)

而在测试的过程中，我们会发现有几个字段(deptId、createTime、updateTime)是**没有数据值**的

想要解决这个没有数据值的问题就需要进行数据封装。

我们看到查询返回的结果中大部分字段是有值的，但是deptId，createTime，updateTime这几个字段是**没有值**的，而数据库中是有对应的字段值的，这是为什么呢？

## 数据封装

[![](https://cdn.nlark.com/yuque/0/2024/png/38953059/1707430843610-fdae7d41-5985-4974-90c4-835f284be991.png)](https://cdn.nlark.com/yuque/0/2024/png/38953059/1707430843610-fdae7d41-5985-4974-90c4-835f284be991.png)

原因如下：

- 实体类属性名和数据库表查询返回的字段名一致，mybatis会自动封装。
- 如果实体类属性名和数据库表查询返回的字段名不一致，不能自动封装。

解决方案：

1. 起别名：在SQL语句中，对不一样的列名起别名，别名和实体类属性名一样

```Java
// 方案一: 给字段起别名，让别名与实体与属性一致
@Select("select id, username, password, name, gender, image, job, entrydate,
dept_id deptId, create_time createTime, update_time updateTime from emp where id=#{id}")
public Emp getById(Integer id);
```

1. 结果映射：通过 @Results及@Result 进行手动结果映射

```Java
// 方案二: 通过@Results、@Result注解手动映射封装
@Results({
    @Result(column = "dept_id", property = "deptId"),
    @Result(column = "create_time", property = "createTime"),
    @Result(column = "update_time", property = "updateTime")
})
@Select("select * from emp where id = #{id}")
public Emp getById(Integer id);
```

1. **开启驼峰命名 (推荐)**如果字段名与属性名符合驼峰命名规则，mybatis会自动通过驼峰命名规则映射

驼峰命名规则：   abc_xyz    =>   abcXyz

- 表中字段名：abc_xyz
- 类中属性名：abcXyz

```Plain
# 在application.properties中添加：
mybatis.configuration.map-underscore-to-camel-case=true
```

要使用驼峰命名前提是 实体类的属性 与 数据库表中的字段名严格遵守驼峰命名。

## **条件查询**

在员工管理的列表页面中，我们需要根据条件查询员工信息，查询条件包括：姓名、性别、入职时间。

[![](https://cdn.nlark.com/yuque/0/2024/png/38953059/1707430869642-07f96bd4-96fa-4e22-a4db-f50ff5e4fa09.png)](https://cdn.nlark.com/yuque/0/2024/png/38953059/1707430869642-07f96bd4-96fa-4e22-a4db-f50ff5e4fa09.png)

通过页面原型以及需求描述我们要实现的查询：

- 姓名：要求支持模糊匹配
- 性别：要求精确匹配
- 入职时间：要求进行范围查询
- 根据最后修改时间进行降序排序

SQL语句

```SQL
select id, username, password, name, gender, image, job, entrydate, dept_id, create_time, update_time
from emp
where name like '%张%'
      and gender = 1
      and entrydate between '2010-01-01' and '2020-01-01 '
order by update_time desc;
```

### 接口方法三种

- 方式一

```Java
@Mapper
public interface EmpMapper {
    @Select("select * from emp " +
            "where name like '%${name}%' " +
            "and gender = #{gender} " +
            "and entrydate between #{begin} and #{end} " +
            "order by update_time desc")
    public List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);
}
```

[![](https://cdn.nlark.com/yuque/0/2024/png/38953059/1711357281423-b3dae521-7d4b-4d33-9ec9-1be6cb04f2d9.png)](https://cdn.nlark.com/yuque/0/2024/png/38953059/1711357281423-b3dae521-7d4b-4d33-9ec9-1be6cb04f2d9.png)

以上方式注意事项：

1. 方法中的形参名和SQL语句中的参数占位符名保持一致
2. **模糊查询使用${...}进行字符串拼接**，这种方式呢，由于是字符串拼接，并不是预编译的形式，所以**效率不高**、且**存在sql注入风险**。

- 方式二（解决SQL注入风险）
- 使用MySQL提供的字符串拼接函数：concat('%' , '关键字' , '%')

```Java
@Mapper
public interface EmpMapper {

    @Select("select * from emp " +
            "where name like concat('%',#{name},'%') " +
            "and gender = #{gender} " +
            "and entrydate between #{begin} and #{end} " +
            "order by update_time desc")
    public List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);
}
```

执行结果：生成的SQL都是预编译的SQL语句（性能高、安全）

[![](https://cdn.nlark.com/yuque/0/2024/png/38953059/1711357355047-2180164c-1c25-4c75-88a9-08281cffd539.png)](https://cdn.nlark.com/yuque/0/2024/png/38953059/1711357355047-2180164c-1c25-4c75-88a9-08281cffd539.png)