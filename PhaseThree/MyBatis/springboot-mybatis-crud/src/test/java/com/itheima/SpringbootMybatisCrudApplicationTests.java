package com.itheima;

import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Emp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class SpringbootMybatisCrudApplicationTests {
    @Autowired
    private EmpMapper empMapper;

    @Test
    void testDelete() {
        empMapper.delete(18);
    }

    @Test
    void testInsert() {
        // 创建员工对象
        Emp emp = new Emp();
        emp.setUsername("tom3");
        emp.setName("汤姆");
        emp.setImage("1.jpg");
        emp.setGender((short) 1);
        emp.setJob((short) 1);
        emp.setEntrydate(LocalDate.of(2000, 1, 1));
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        emp.setDeptId(1);
        empMapper.insert(emp);

        // 这里能够拿到id是因为EmpMapper的Insert方法定义了Options注解，主键返回
        System.out.println("Emp current id: " + emp.getId());
    }

    @Test
    void testUpdate() {
        // 更新员工对象
        Emp emp = new Emp();
        emp.setId(19);
        emp.setUsername("songdaxia");
        emp.setPassword(null);
        emp.setName("老宋");
        emp.setImage("2.jpg");
        emp.setGender((short) 1);
        emp.setJob((short) 2);
        emp.setEntrydate(LocalDate.of(2012, 1, 1));
        emp.setCreateTime(null);
        emp.setUpdateTime(LocalDateTime.now());
        emp.setDeptId(2);
        // 调用方法，修改员工数据
        empMapper.update(emp);
    }

    @Test
    public void testGetById() {
        Emp emp = empMapper.getById(1);
        System.out.println(emp);
    }

    @Test
    void testList() {
        // List<Emp> empList = empMapper.list("张", (short) 1, LocalDate.of(2010, 1, 1),
        // LocalDate.of(2020, 1, 1));
        // List<Emp> list = empMapper.list("张", null, null, null);
        // List<Emp> list = empMapper.list("张", (short) 1, null, null);
        // List<Emp> list = empMapper.list(null, (short) 1, null, null);
        List<Emp> list = empMapper.list(null, null, null, null);

        System.out.println(list);
    }

    /**
     * update方法修改成XML配置文件中实现的对应的测试方法
     */
    @Test
    void testUpdate2() {
        // 要修改的员工信息
        Emp emp = new Emp();
        emp.setId(19);
        emp.setUsername("Tom111");
        emp.setName("汤姆111");
        emp.setUpdateTime(LocalDateTime.now());

        // 调用方法，修改员工数据
        empMapper.update2(emp);
    }

    /**
     * deleteByIds方法实现批量删除emp
     */
    @Test
    void deleteByIds() {
        // ArrayList的结构也可以当作存储ids的选项之一
        /*List<Integer> ids = new ArrayList<Integer>();
        ids.add(13);
        ids.add(14);
        ids.add(15);*/
        // 使用Array.asList方法来存储数字
        List<Integer> ids = Arrays.asList(16, 17, 19);
        empMapper.deleteByIds(ids);
    }
}
