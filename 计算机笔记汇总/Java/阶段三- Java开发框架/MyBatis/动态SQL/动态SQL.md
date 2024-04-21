# 什么是动态SQL？

在页面原型中，列表上方的条件是动态的，是可以不传递的，也可以只传递其中的1个或者2个或者全部。

![[/Untitled 26.png|Untitled 26.png]]

  

![[/Untitled 1 11.png|Untitled 1 11.png]]

  

而在我们刚才编写的SQL语句中，我们会看到，我们将**三个条件直接写死了**。 如果页面只传递了参数姓名name 字段，其他两个字段 性别 和 入职时间没有传递，那么这两个参数的值就是null。

  

此时，执行的SQL语句为：

![[/Untitled 2 10.png|Untitled 2 10.png]]

  

**这个查询结果是不正确的**。正确的做法应该是：

- 传递了参数，再组装这个查询条件；也就是说，前端传递了这个参数，再在查询中包括上这个查询条件。
- 如果没有传递参数，就不应该组装这个查询条件。

  

关于静态SQL和传递null值的问题，当你在SQL查询中直接硬编码条件时，这意味着这些条件将始终被应用于查询中，不论其值是什么。如果你的代码设计为接收参数并将它们插入到SQL查询中，但某些参数可能为null，这就需要你在编写SQL时更加小心。

如果参数值为null并且你的查询没有正确处理这种情况，可能会导致查询返回不正确的结果或者不返回任何结果。

比如：如果姓名输入了"张", 对应的SQL为:

```SQL
select *  from emp where name like '%张%' order by update_time desc;
```

如果姓名输入了"张",，性别选择了"男"，则对应的SQL为:

```SQL
select *  from emp where name like '%张%' and gender = 1 order by update_time desc;
```

**SQL语句会随着用户的输入或外部条件的变化而变化，我们称为：动态SQL。**

![[/Untitled 3 7.png|Untitled 3 7.png]]

  

# 动态SQL-if

<if>：用于判断条件是否成立。使用test属性进行条件判断，如果条件为true，则拼接SQL。

```XML
<if test="条件表达式">
   要拼接的sql语句
</if>
```

## 条件查询

示例：把SQL语句改造为动态SQL方式

- 原有的SQL语句

```XML
<select id="list" resultType="com.itheima.pojo.Emp">
        select * from emp
        where name like concat('%',#{name},'%')
              and gender = #{gender}
              and entrydate between #{begin} and #{end}
        order by update_time desc
</select>
```

- 动态SQL语句
    - `<where>`只会在子元素有内容的情况下才插入where子句，而且会自动去除子句的开头的AND或OR

```XML
<select id="list" resultType="com.itheima.pojo.Emp">
        select * from emp
        <where>
             <!-- if做为where标签的子元素 -->
             <if test="name != null">
                 and name like concat('%',#{name},'%')
             </if>
             <if test="gender != null">
                 and gender = #{gender}
             </if>
             <if test="begin != null and end != null">
                 and entrydate between #{begin} and #{end}
             </if>
        </where>
        order by update_time desc
</select>
```

测试方法：

这就是查询gender为1的所有的数据库中的记录。

```Java
@Test
public void testList(){
    //只有性别
    List<Emp> list = empMapper.list(null, (short)1, null, null);
    for(Emp emp : list){
        System.out.println(emp);
    }
}
```

  

> 执行的SQL语句：

![[/Untitled 4 5.png|Untitled 4 5.png]]

  

## 更新员工

案例：完善更新员工功能，修改为动态更新员工数据信息

- 动态更新员工信息，如果更新时传递有值，则更新；如果更新时没有传递值，则不更新
- 解决方案：动态SQL

  

修改Mapper接口：

```Java
@Mapper
public interface EmpMapper {
    // 删除@Update注解编写的SQL语句
    // update操作的SQL语句编写在Mapper映射文件中
    public void update(Emp emp);
}
```

  

修改Mapper映射文件：

使用`<set>`标签代替SQL语句中的set关键字

- `<set>`：动态的在SQL语句中插入set关键字，并会删掉额外的逗号。（用于update语句中）

```XML
<!--    update语句 因为update方法在mapper中定义返回值是void，所以不用设置resultType-->
    <update id="update">
        update emp
        <!-- 使用set标签，代替update语句中的set关键字 -->
        <set>
            <if test="username != null">
                username=#{username},
            </if>
            <if test="name != null">
                name=#{name},
            </if>
            <if test="gender != null">
                gender=#{gender},
            </if>
            <if test="image != null">
                image=#{image},
            </if>
            <if test="job != null">
                job=#{job},
            </if>
            <if test="entrydate != null">
                entrydate=#{entrydate},
            </if>
            <if test="deptId != null">
                dept_id=#{deptId},
            </if>
            <if test="updateTime != null">
                update_time=#{updateTime}
            </if>
        </set>
        where id=#{id}
    </update>
```

  

```Java
/**
     * update方法修改成XML配置文件中实现 对应的测试方法
     * */
    @Test
    void testUpdate2() {
        // 要修改的员工信息
        Emp emp = new Emp();
        emp.setId(18);
        emp.setUsername("Tom111");
        emp.setName("汤姆111");
        emp.setUpdateTime(LocalDateTime.now());

        // 调用方法，修改员工数据
        empMapper.update(emp);
    }


/*    @Test
    public void testUpdate2(){
        //要修改的员工信息
        Emp emp = new Emp();
        emp.setId(20);
        emp.setUsername("Tom222");

        //调用方法，修改员工数据
        empMapper.update(emp);
    }*/
```

  

- 再次执行测试方法，执行的SQL语句：
    
    ![[/Untitled 5 4.png|Untitled 5 4.png]]
    

  

## 小结

- `<if>`
    - 用于判断条件是否成立，如果条件为true，则拼接SQL
    - 形式：
        
        ```SQL
        <if test="name != null"> … </if>
        ```
        
- `<where>`
    - where元素只会在子元素有内容的情况下才插入where子句，而且会自动去除子句的开头的AND或OR
- `<set>`
    - 动态地在行首插入 SET 关键字，并会删掉额外的逗号。（用在update语句中）

# 动态SQL-foreach

案例：员工删除功能（既支持删除单条记录，又支持批量删除）

![[/Untitled 6 4.png|Untitled 6 4.png]]

SQL语句：

```SQL
delete from emp where id in (1,2,3);
```

Mapper接口：

```Java
@Mapper
public interface EmpMapper {
    //批量删除
    public void deleteByIds(List<Integer> ids);
}
```

XML映射文件：

- 使用<foreach>遍历deleteByIds方法中传递的参数ids集合

```XML
<foreach collection="集合名称" item="集合遍历出来的元素/项" separator="每一次遍历使用的分隔符"
         open="遍历开始前拼接的片段" close="遍历结束后拼接的片段">
</foreach>
```

```XML
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "https://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.itheima.mapper.EmpMapper">
    <!--删除操作-->
    <delete id="deleteByIds">
        delete from emp where id in
        <foreach collection="ids" item="id" separator="," open="(" close=")">
            #{id}
        </foreach>
    </delete>
</mapper>
```

  

- 代码说明
    
    ![[/Untitled 7 4.png|Untitled 7 4.png]]
    

  

- 执行的SQL语句：
    
    ![[/Untitled 8 4.png|Untitled 8 4.png]]
    

  

# 动态SQL - sql & include

问题分析：

- 在xml映射文件中配置的SQL，有时可能会存在很多**重复的片段**，此时就会存在很多**冗余的代码**

![[/Untitled 9 4.png|Untitled 9 4.png]]

![[/Untitled 10 3.png|Untitled 10 3.png]]

  

我们可以对重复的代码片段进行抽取，将其通过`<sql>`标签封装到一个SQL片段，然后再通过`<include>`标签进行引用。

- `<sql>`：定义可重用的SQL片段
- `<include>`：通过属性refid，指定包含的SQL片段

![[/Untitled 11 2.png|Untitled 11 2.png]]

  

示例来说，我想要根据id查询Emp，那么就像下面这样做

SQL片段： 抽取重复的代码

```XML
<sql id="commonSelect">
    select id, username, password, name, gender, image, job, entrydate, dept_id, create_time, update_time from emp
</sql>
```

然后通过<include> 标签在原来抽取的地方进行引用。操作如下：

```XML
<select id="getById" resultType="com.itheima.pojo.Emp">
        <include refid="commonSelect"/>
        where id = #{id}
    </select>
```

  

```Java
==>  Preparing: select id, username, password, name, gender, image, job, entrydate, dept_id, create_time, update_time from emp where id = ?
==> Parameters: 1(Integer)
<==    Columns: id, username, password, name, gender, image, job, entrydate, dept_id, create_time, update_time
<==        Row: 1, jinyong, 123456, 金庸, 1, 1.jpg, 4, 2000-01-01, 2, 2024-02-05 09:21:28, 2024-02-05 09:21:28
<==      Total: 1
Closing non transactional SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@2dba05b1]
Emp(id=1, username=jinyong, password=123456, name=金庸, gender=1, image=1.jpg, job=4, entrydate=2000-01-01, deptId=2, createTime=2024-02-05T09:21:28, updateTime=2024-02-05T09:21:28)
```

# 示例需求

## 分页查询

分页查询时使用动态SQL和静态SQL的确都涉及到传递参数，但关键区别在于SQL语句的灵活性。

在静态SQL中，即使是分页查询，SQL语句本身是固定的，例如：

```SQL
@Select("SELECT * FROM table_name LIMIT #{offset}, #{pageSize}")
```

在这个例子中，#{offset}和#{pageSize}是分页参数，它们在执行时被替换为具体的值，但是整个SQL语句在不同的查询中结构是不变的。

而动态SQL允许根据不同的条件组合不同的SQL语句，例如，当需要根据用户的不同输入（如搜索关键字、日期范围、排序方式等）来改变查询条件时，可以使用MyBatis的动态SQL特性：

```XML
<select id="selectUsers" resultType="User">
  SELECT * FROM users
  <where>
    <if test="name != null">
      AND name = #{name}
    </if>
    <if test="email != null">
      AND email = #{email}
    </if>
  </where>
  LIMIT #{offset}, #{pageSize}
</select>
```

在这个动态SQL示例中，<where>标签内的<if>标签允许在执行时根据name和email的值的存在与否动态地包含或排除条件。这样的SQL语句在结构上会随着传入参数的不同而变化。

总结来说，静态SQL适用于结构固定、变化不大的查询；而动态SQL则用于需要根据不同条件组合出不同查询语句的情况。尽管它们都是通过参数来传递查询条件，但动态SQL提供了更高的灵活性。

在实现分页时，如果仅仅是传递分页参数（如页码和页面大小），静态SQL就足够了。如果需要根据多种可能变化的条件来实现分页查询，动态SQL将会更加合适。

对于您提到的分页查询，如果您需要根据员工的name属性来过滤结果，并且这个属性是可选的（即用户可能提供也可能不提供这个搜索条件），那么使用动态SQL是合适的。

通过动态SQL，您可以构建一个SQL语句，它仅在提供了name参数时才包含对应的搜索条件。如果没有提供name，那么SQL语句不会包含与name相关的搜索条件，这样就可以得到没有过滤的完整列表。

```XML
<select id="pageQuery" resultType="com.sky.entity.Employee">
    select * from employee
    <where>
        <if test="name != null and name != ''">
            and name like concat('%',#{name},'%')
        </if>
    </where>
    order by create_time desc
</select>
```

这里使用了动态SQL的<if>标签来检查是否有有效的name参数。如果条件满足（即name参数不为空），则会包含一个额外的搜索条件来过滤员工的名称。

关于您的问题：

1. and name like concat('%',#{name},'%')中的and是用来拼接SQL语句的，确保如果有多个条件时能够正确地与其他条件结合。在这里，<where>标签会智能地插入where子句，而且只有当内部条件成立时才会包含and。如果<where>内没有任何条件成立，它不会插入无用的where关键字。
2. test="name != null and name != ''"是MyBatis的表达式语言，用于评估传入参数的值。这里的test属性定义了一个条件，只有当条件为真时，包含在<if>标签内的SQL片段才会被包括在最终执行的SQL语句中。在这个例子中，它检查name参数是否不为null且不是空字符串，如果这个条件为真，那么会将搜索条件添加到SQL语句中。

  

  

![[/Untitled 12 2.png|Untitled 12 2.png]]