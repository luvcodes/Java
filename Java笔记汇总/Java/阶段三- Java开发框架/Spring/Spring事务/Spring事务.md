# 概念

事务是一组操作的集合，它是一个不可分割的工作单位。事务会把所有的操作作为一个整体，一起向数据库提交或者是撤销操作请求。所以这组操作要么同时成功，要么同时失败。

# 事务的操作

事务的操作主要有三步：

1. 开启事务（一组操作开始前，开启事务）：start transaction / begin;
2. 提交事务（这组操作全部成功后，提交事务）：commit;
3. 回滚事务（中间任何一个操作出现异常，回滚事务）：rollback;

# 案例引入Spring的事务

```Java
@Slf4j
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;

    @Autowired
    private EmpMapper empMapper;

    //根据部门id，删除部门信息及部门下的所有员工
    @Override
    public void delete(Integer id){
        //根据部门id删除部门信息
        deptMapper.deleteById(id);

        //模拟：异常发生
        int i = 1/0;

        //删除部门下的所有员工信息
        empMapper.deleteByDeptId(id);
    }
}
```

其中的`int i = 1/0`模拟了一个运行时异常。出现这样的情况再刷新数据库后发现:

**删除了2号部门**

![[/Untitled 23.png|Untitled 23.png]]

  

**2号部门下的员工数据没有删除**

![[/Untitled 1 9.png|Untitled 1 9.png]]

  

以上程序出现的问题：即使程序运行抛出了异常，部门依然删除了，但是部门下的员工却没有删除，造成了数据的不一致。

## 原因

- 先执行根据id删除部门的操作，这步执行完毕，数据库表 dept 中的数据就已经删除了。
- 执行 1/0 操作，抛出异常
- 抛出异常之前，下面所有的代码都不会执行了，根据部门ID删除该部门下的员工，这个操作也不会执行 。

这就引出了Spring中的@Transactional注解来解决这个问题

  

# Transactional注解

@Transactional作用：就是在当前这个方法执行开始之前来开启事务，方法执行完毕之后提交事务。如果在这个方法执行的过程当中出现了异常，就会进行事务的回滚操作。

@Transactional注解：我们一般会在业务层当中来控制事务，因为在业务层当中，一个业务功能可能会包含多个数据访问的操作。在业务层来控制事务，我们就可以将多个数据访问操作控制在一个事务范围内。

```Java
    @Override
    @Transactional  //当前方法添加了事务管理
    public void delete(Integer id){
        //根据部门id删除部门信息
        deptMapper.deleteById(id);

        //模拟：异常发生
        int i = 1/0;

        //删除部门下的所有员工信息
        empMapper.deleteByDeptId(id);
    }
```

## 两个常见属性

![[/Untitled 2 9.png|Untitled 2 9.png]]

  

### rollbackFor

以上业务功能delete()方法在运行时，会引发除0的算数运算异常(运行时异常)，出现异常之后，由于我们在方法上加了@Transactional注解进行事务管理，所以发生异常会执行rollback回滚操作，从而保证事务操作前后数据是一致的。

下面我们在做一个测试，我们修改业务功能代码，在模拟异常的位置上直接抛出Exception异常（编译时异常）

```Java
@Transactional
public void delete(Integer id) throws Exception {
        //根据部门id删除部门信息
        deptMapper.deleteById(id);

        //模拟：异常发生
        if(true){
            throw new Exception("出现异常了~~~");
        }

        //删除部门下的所有员工信息
        empMapper.deleteByDeptId(id);
}
```

> 说明：在service中向上抛出一个Exception编译时异常之后，由于是controller调用service，所以在controller中要有异常处理代码，此时我们选择在controller中继续把异常向上抛。
> 
> ```Java
> @DeleteMapping("/depts/{id}")
> public Result delete(@PathVariable Integer id) throws Exception {
>   //日志记录
>   log.info("根据id删除部门");
>   //调用service层功能
>   deptService.delete(id);
>   //响应
>   return Result.success();
> }
> ```

发生了Exception异常，但事务依然提交了

![[/Untitled 3 6.png|Untitled 3 6.png]]

  

通过以上测试可以得出一个结论：默认情况下，只有出现RuntimeException(运行时异常)才会回滚事务。

假如我们想让所有的异常都回滚，需要来配置@Transactional注解当中的rollbackFor属性，通过rollbackFor这个属性可以指定出现何种异常类型回滚事务。

```Java
@Transactional(rollbackFor=Exception.class)
```

这样就可以达成出现所有异常都会滚的需求了。

### propagation

这个属性是用来配置事务的传播行为的。

什么是事务的传播行为呢？

- 就是当一个事务方法被另一个事务方法调用时，这个事务方法应该如何进行事务控制。

例如：两个事务方法，一个A方法，一个B方法。在这两个方法上都添加了@Transactional注解，就代表这两个方法都具有事务，而在A方法当中又去调用了B方法。

  

![[/Untitled 4 4.png|Untitled 4 4.png]]

  

所谓事务的传播行为，指的就是在A方法运行的时候，首先会开启一个事务，在A方法当中又调用了B方法， B方法自身也具有事务，那么B方法在运行的时候，到底是加入到A方法的事务当中来，还是B方法在运行的时候新建一个事务？这个就涉及到了事务的传播行为。

我们要想控制事务的传播行为，在@Transactional注解的后面指定一个属性propagation，通过 propagation 属性来指定传播行为。

### 常见的事务传播行为

|   |   |
|---|---|
|属性值|含义|
|REQUIR​ED|【默认值】需要事务，有则加入，无则创建新事务|
|REQUIRES_NEW|需要新事务，无论有无，总是创建新事务|
|SUPPORTS|支持事务，有则加入，无则在无事务状态中运行|
|NOT_SUPPORTED|不支持事务，在无事务状态下运行,如果当前存在已有事务,则挂起当前事务|
|MANDATORY|必须有事务，否则抛异常|
|NEVER​​|必须没事务，否则抛异常|
|…||

  

> 我们只需要关注以下两个就可以了：
> 
> 1. REQUIRED（默认值）大部分情况下都是用该传播行为即可。
> 2. REQUIRES_NEW 当我们不希望事务之间相互影响时，可以使用该传播行为。比如：下订单前需要记录日志，不论订单保存成功与否，都需要保证日志记录能够记录成功。

# Spring事务角色

## 事务管理员

发起事务方，在Spring中通常指代业务层开启事务的方法

## 事务协调员

加入事务方，在Spring中通常指代数据层方法，也可以是业务层方法