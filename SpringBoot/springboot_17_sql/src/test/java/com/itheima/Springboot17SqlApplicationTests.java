package com.itheima;

import com.itheima.dao.BookDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.awt.print.Book;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@SpringBootTest
class Springboot17SqlApplicationTests {

    @Autowired
    private BookDao bookDao;

    @Test
    void getById() {
        bookDao.selectById(1);
    }

    @Autowired
    private JdbcTemplate  jdbcTemplate;

    @Test
    void testJdbcTemplate() {
        String sql = "select * from tbl_book where id = 1";
        // String sql = "select * from tbl_book"; // 另一种示例sql语句

         List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql); // 这不是标准格式
         System.out.println(maps);

//        RowMapper<Book> rm = new RowMapper<Book>() {
//            @Override
//            public Book mapRow(ResultSet resultSet, int i) throws SQLException {
//                Book temp = new Book();
//                temp.setId(resultSet.getInt("id"));
//                temp.setName(resultSet.getString("name"));
//                temp.setType(resultSet.getString("type"));
//                temp.setDescription(resultSet.getString("description"));
//                return temp;
//            }
//        };
//        List<Book> list = jdbcTemplate.query(sql, rm);
//        System.out.println(list);
    }
}
