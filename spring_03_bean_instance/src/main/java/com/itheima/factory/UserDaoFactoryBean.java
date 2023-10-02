package com.itheima.factory;

import com.itheima.dao.impl.UserDao;
import com.itheima.dao.impl.UserDaoImpl;
import org.springframework.beans.factory.FactoryBean;

public class UserDaoFactoryBean implements FactoryBean<UserDao> {
    // 代替原始实例工厂中创建对象的方法
    @Override
    public UserDao getObject() throws Exception {
        return new UserDaoImpl();
    }

    //
    @Override
    public Class<?> getObjectType() {
        return UserDao.class;
    }

    // 结合AppForInstanceUser的文件中判断两个Bean对象是否为单例的，下面这个方法
    // 可以通过返回值来控制是否要创建单例或是非单例的Bean
//    @Override
//    public boolean isSingleton() {
//        return false;
//    }
}
