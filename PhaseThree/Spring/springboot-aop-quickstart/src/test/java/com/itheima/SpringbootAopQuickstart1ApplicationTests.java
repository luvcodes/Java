package com.itheima;

import com.itheima.pojo.Dept;
import com.itheima.service.DeptService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootAopQuickstart1ApplicationTests {
    @Autowired
    private DeptService deptService;

    @Test
    public void testAopDelete(){
        deptService.delete(10);
    }

    @Test
    public void testAopList(){
        List<Dept> list = deptService.list();
        System.out.println(list);
    }

    @Test
    public void testAopGetById(){
        Dept dept = deptService.getById(1);
        System.out.println(dept);
    }

}
