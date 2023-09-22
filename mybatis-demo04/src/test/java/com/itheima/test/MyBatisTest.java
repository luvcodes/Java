package com.itheima.test;

import com.itheima.mapper.BrandMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisTest {
    @Test
    public void testSelectAll() throws IOException {
        // 1. 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2. 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3. 获取Mapper接口的代理对象
        BrandMapper brands = sqlSession.getMapper(BrandMapper.class);
        System.out.println(brands);

        // 4. 释放资源
        sqlSession.close();
    }
}
