# 数据库设计 - DML

## 增加 (insert)

insert语法：

- 向指定字段添加数据

```SQL
insert into 表名 (字段名1, 字段名2) values (值1, 值2);
```

- 全部字段添加数据

```SQL
insert into 表名 values (值1, 值2, ...);
```

- 批量添加数据（指定字段）

```SQL
insert into 表名 (字段名1, 字段名2) values (值1, 值2), (值1, 值2);
```

- 批量添加数据（全部字段）

```SQL
insert into 表名 values (值1, 值2, ...), (值1, 值2, ...);
```

案例1：向tb_emp表的username、name、gender字段插入数据

```SQL
-- 因为设计表时create_time, update_time两个字段不能为NULL，所以也做为要插入的字段
insert into tb_emp(username, name, gender, create_time, update_time)
values ('wuji', '张无忌', 1, now(), now());
```

案例2：向tb_emp表的所有字段插入数据

```SQL
insert into tb_emp(id, username, password, name, gender, image, job, entrydate, create_time, update_time)
values (null, 'zhirou', '123', '周芷若', 2, '1.jpg', 1, '2010-01-01', now(), now());
```

案例3：批量向tb_emp表的username、name、gender字段插入数据

```SQL
insert into tb_emp(username, name, gender, create_time, update_time)
values ('weifuwang', '韦一笑', 1, now(), now()),
       ('fengzi', '张三疯', 1, now(), now());
```

## 修改 (update)

update语法：

```SQL
update 表名 set 字段名1 = 值1 , 字段名2 = 值2 , .... [where 条件] ;
```

案例1：将tb_emp表中id为1的员工，姓名name字段更新为'张三'

```SQL
update tb_emp set name='张三',update_time=now() where id=1;
```

案例2：将tb_emp表的所有员工入职日期更新为'2010-01-01'

```SQL
update tb_emp set entrydate='2010-01-01',update_time=now();
```

注意事项:

1. 修改语句的条件可以有，也可以没有，如果没有条件，则会修改整张表的所有数据。
2. 在修改数据时，一般需要同时修改公共字段update_time，将其修改为当前操作时间。

## 删除delete

```SQL
delete from 表名  [where  条件] ;
```

案例1：删除tb_emp表中id为1的员工

```SQL
delete from tb_emp where id = 1;
```

案例2：删除tb_emp表中所有员工

```SQL
delete from tb_emp;
```

注意事项:

- DELETE 语句的条件可以有，也可以没有，如果没有条件，则会删除整张表的所有数据。
- DELETE 语句不能删除某一个字段的值(可以使用UPDATE，将该字段值置为NULL即可)。
- 当进行删除全部数据操作时，会提示询问是否确认删除所有数据，直接点击Execute即可。