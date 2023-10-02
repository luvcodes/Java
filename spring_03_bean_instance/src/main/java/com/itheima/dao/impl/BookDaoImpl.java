package com.itheima.dao.impl;

public class BookDaoImpl implements BookDao {
    /**
     * 这里其实构造器是public还是private都是可以访问到的。这就说明内部使用的是反射
     * 但是如果给构造器定义参数，在AppForInstanceBook类中继续用原来的方法使用，是会报错的。
     * 这就说明Spring创建Bean用的是无参构造器。
     * */
    private BookDaoImpl() {
        System.out.println("book dao constructor is running...");
    }

    @Override
    public void save() {
        System.out.println("book dao save...");
    }
}
