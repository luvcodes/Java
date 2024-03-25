package com.itheima;

import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
        emp.setGender((short)1);
        emp.setJob((short)1);
        emp.setEntrydate(LocalDate.of(2000,1,1));
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
        emp.setGender((short)1);
        emp.setJob((short)2);
        emp.setEntrydate(LocalDate.of(2012,1,1));
        emp.setCreateTime(null);
        emp.setUpdateTime(LocalDateTime.now());
        emp.setDeptId(2);
        // 调用方法，修改员工数据
        empMapper.update(emp);
    }

    @Test
    public void testGetById(){
        Emp emp = empMapper.getById(1);
        System.out.println(emp);
    }


//    /*@Test
//    public void testGetByMultiCondition() {
//        // 定义查询参数
//        String name = "张无忌";
//        Short gender = 1; // 假设性别用1表示男性
//        LocalDate begin = LocalDate.of(2015, 1, 1);
//        LocalDate end = LocalDate.now(); // 假设查询结束日期为当前日期
//
//        // 调用Mapper接口的list方法
//        List<Emp> result = empMapper.list(name, gender, begin, end);
//
//        // 断言结果不为空
//        assert !result.isEmpty();
//
//        // 打印结果，或进行其他形式的验证
//        result.forEach(emp -> System.out.println(emp.toString()));
//    }*/
//
//    /*@Test
//    public void testList(){
//        //只有性别
//        List<Emp> list = empMapper.list(null, (short)1, null, null);
//        for(Emp emp : list){
//            System.out.println(emp);
//        }
//    }*/
//
//
//    /*@Test
//    void testList() {
//        List<Emp> empList = empMapper.list();
//        for (Emp emp : empList) {
//            System.out.println(emp);
//        }
//    }*/
//
//    /**
//     * update方法修改成XML配置文件中实现 对应的测试方法
//     * */
//    @Test
//    void testUpdate2() {
//        // 要修改的员工信息
//        Emp emp = new Emp();
//        emp.setId(18);
//        emp.setUsername("Tom111");
//        emp.setName("汤姆111");
//        emp.setUpdateTime(LocalDateTime.now());
//
//        // 调用方法，修改员工数据
//        empMapper.update(emp);
//    }
//
///*    @Test
//    public void testUpdate2(){
//        //要修改的员工信息
//        Emp emp = new Emp();
//        emp.setId(20);
//        emp.setUsername("Tom222");
//
//        //调用方法，修改员工数据
//        empMapper.update(emp);
//    }*/


}
