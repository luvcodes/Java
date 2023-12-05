package com.itheima;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.dao.BookDao;
import com.itheima.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookDaoTestCase {
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
    void testGetPage() {
        IPage page = new Page(1, 5);
        bookDao.selectPage(page, null);
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.getRecords());
        System.out.println(page.getPages());
    }

    @Test
    void testGetBy() {
        QueryWrapper<Book> qw = new QueryWrapper<>();
        qw.like("name", "Spring"); // select * from tbl_book where name like '%Spring%';
        bookDao.selectList(qw);
    }

    @Test
    void testGetBy2() {
        String name = "Spring";
        LambdaQueryWrapper<Book> qw = new LambdaQueryWrapper<>();
        /**
         * 这里按条件查询只演示了like，还有其他的条件可以使用
         * */
//        if (name != null) qw.like(Book::getName, "Spring"); // select * from tbl_book where name like '%Spring%';
        qw.like(name != null, Book::getName, name); // 第一个参数条件 如果true就可以走后面的参数; 如果false就不走了
        bookDao.selectList(qw);
    }
}
