package com.itheima.dao.impl;

import com.itheima.dao.EmpDao;
import com.itheima.pojo.Emp;
import com.itheima.utils.XmlParserUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ryanw
 */
@Repository
public class EmpDaoA implements EmpDao {

    @Override
    public List<Emp> listEmp() {
        //1. 加载并解析emp.xml
        // 使用类加载器ClassLoader: 类加载器是一个负责加载类的对象，类加载器还负责定位资源
        String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
        System.out.println(file);
        List<Emp> empList = XmlParserUtils.parse(file, Emp.class);
        return empList;
    }
}
