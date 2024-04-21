# 数据层开发

## 导入MyBatisPlus与Druid 对应的 starter 坐标

[![](https://cdn.nlark.com/yuque/0/2023/png/38953059/1701740205341-a21575a4-fe16-4454-b24b-56ee655ea892.png)](https://cdn.nlark.com/yuque/0/2023/png/38953059/1701740205341-a21575a4-fe16-4454-b24b-56ee655ea892.png)

## 配置数据源与 MyBatis Plus对应的基础配置

id 生成策略本来默认是雪花算法，现在使用数据库自增策略

[![](https://cdn.nlark.com/yuque/0/2023/png/38953059/1701740271332-5aca61ce-56fa-4e0b-bb1b-da8fbb248bda.png)](https://cdn.nlark.com/yuque/0/2023/png/38953059/1701740271332-5aca61ce-56fa-4e0b-bb1b-da8fbb248bda.png)

## 继承 BaseMapper 并指定泛型

[![](https://cdn.nlark.com/yuque/0/2023/png/38953059/1701740312664-1a7de7ba-1310-4c15-b738-1c4785ad3f98.png)](https://cdn.nlark.com/yuque/0/2023/png/38953059/1701740312664-1a7de7ba-1310-4c15-b738-1c4785ad3f98.png)

## 制作测试类测试结果

```Java
package com.itheima;

import com.itheima.dao.BookDao;
import com.itheima.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot10SsmpApplicationTests {
    @Autowired
    private BookDao bookDao;

    @Test
    void testGetById() {
        System.out.println(bookDao.selectById(1));
    }

    @Test
    void testSave() {
        Book book = new Book();
        book.setType("测试数据123");
        book.setName("测试数据123");
        book.setDescription("description");
        bookDao.insert(book);
    }

    @Test
    void testUpdate() {
        Book book = new Book();
        book.setId(7);
        book.setType("测试数据456");
        book.setName("测试数据456");
        book.setDescription("description");
        bookDao.updateById(book);
    }

    @Test
    void testDelete() {
        bookDao.deleteById(7);
    }

    @Test
    void testGetAll() {
        System.out.println(bookDao.selectList(null));
    }

    @Test
    void testGetPage() {}

    @Test
    void testGetBy() {}
}
```

## 分页功能

分页操作需要设定分页对象 IPage

[![](https://cdn.nlark.com/yuque/0/2023/png/38953059/1701745975177-3451990c-c0a2-45e0-a021-d6f5f52e5486.png)](https://cdn.nlark.com/yuque/0/2023/png/38953059/1701745975177-3451990c-c0a2-45e0-a021-d6f5f52e5486.png)

IPage 对象中封装了分页操作中的所有数据

[![](https://cdn.nlark.com/yuque/0/2023/png/38953059/1701746015486-a053a3b9-7f05-40aa-9754-06d01cf7e68c.png)](https://cdn.nlark.com/yuque/0/2023/png/38953059/1701746015486-a053a3b9-7f05-40aa-9754-06d01cf7e68c.png)

分页操作是在 MyBatisPlus 的常规操作基础上增强得到，内部是**动态地拼写 SQL 语句**，因此需要增强对应的功能，使用 MyBatisPlus 拦截器实现。其实拼写的就是 select语句后面的 Limit 语句。

[![](https://cdn.nlark.com/yuque/0/2023/png/38953059/1701746205614-2927a4fa-663e-43e4-a898-b05ef9feb58e.png)](https://cdn.nlark.com/yuque/0/2023/png/38953059/1701746205614-2927a4fa-663e-43e4-a898-b05ef9feb58e.png)

## 条件查寻功能

使用 QueryWrapper 对象封装查询条件，推荐使用 LambdaQueryWrapper 对象，所有查询操作封装成方法调用

[![](https://cdn.nlark.com/yuque/0/2023/png/38953059/1701750314118-855f0618-0854-4f2b-92f1-c71497e0abf8.png)](https://cdn.nlark.com/yuque/0/2023/png/38953059/1701750314118-855f0618-0854-4f2b-92f1-c71497e0abf8.png)

动态拼写查询条件

[![](https://cdn.nlark.com/yuque/0/2023/png/38953059/1701750438194-999ea1a7-1a1f-43e9-ac9c-1039c66e4dc0.png)](https://cdn.nlark.com/yuque/0/2023/png/38953059/1701750438194-999ea1a7-1a1f-43e9-ac9c-1039c66e4dc0.png)

# 业务层开发

## 实现类定义

```Java
package com.itheima.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.dao.BookDao;
import com.itheima.domain.Book;
import com.itheima.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    @Override
    public Boolean save(Book book) {
        return bookDao.insert(book) > 0;
    }

    @Override
    public Boolean update(Book book) {
        return bookDao.updateById(book) > 0;
    }

    @Override
    public Boolean delete(Integer id) {
        return bookDao.deleteById(id) > 0;
    }

    @Override
    public Book getById(Integer id) {
        return bookDao.selectById(id);
    }

    @Override
    public List<Book> getAll() {
        return bookDao.selectList(null);
    }

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize) {
        IPage<Book> page = new Page(currentPage, pageSize);
        bookDao.selectPage(page, null);
        return page;
    }
}
```

## 测试类定义

```Java
package com.itheima;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.itheima.domain.Book;
import com.itheima.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookServiceTestCase {
    @Autowired
    private BookService bookService;

    @Test
    void testGetById() {
        System.out.println(bookService.getById(4));
    }

    @Test
    void testSave() {
        Book book = new Book();
        book.setType("测试数据456");
        book.setName("测试数据456");
        book.setDescription("description");
        bookService.save(book);
    }

    @Test
    void testUpdate() {
        Book book = new Book();
        book.setId(7);
        book.setType("测试数据456");
        book.setName("测试数据456");
        book.setDescription("description");
        bookService.update(book);
    }

    @Test
    void testDelete() {
        bookService.delete(7);
    }

    @Test
    void testGetAll() {
        System.out.println(bookService.getAll());
    }

    @Test
    void testGetPage() {
        IPage<Book> page = bookService.getPage(2, 5);
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.getRecords());
        System.out.println(page.getPages());
    }
}
```

# 业务层开发 - 快速开发

## 接口定义

[![](https://cdn.nlark.com/yuque/0/2023/png/38953059/1701757708546-e9688519-1361-493c-af4f-977236a1dd17.png)](https://cdn.nlark.com/yuque/0/2023/png/38953059/1701757708546-e9688519-1361-493c-af4f-977236a1dd17.png)

## 实现类定义

[![](https://cdn.nlark.com/yuque/0/2023/png/38953059/1701757740232-85c46bd7-e0ca-45fb-9132-874e971b4053.png)](https://cdn.nlark.com/yuque/0/2023/png/38953059/1701757740232-85c46bd7-e0ca-45fb-9132-874e971b4053.png)

# 表现层开发

## 基于Restful制作表现层接口

- 新增: POST
- 删除: DELETE
- 修改: PUT
- 查询: GET

## 接收参数

- 实体数据: @RequestBody
- 路径变量: @PathVariable

## 表现层消息一致性处理

设计表现层返回结果的模型类，用于后端与前端进行数据格式统一，也称为前后端数据协议。就是为了统一表现层的数据格式。

```C++
package com.itheima.controller.utils;

import lombok.Data;

@Data
public class R {
    private Boolean flag;
    private Object data;

    public R() {
    }

    public R(Boolean flag) {
        this.flag = flag;
    }

    public R(Boolean flag, Object data) {
        this.flag = flag;
        this.data = data;
    }
}
```

## 前后端协议联调