package com.itheima.dao.impl;

public class BookDaoImpl implements BookDao {
    private String database;
    private int connectionNumber;

    public BookDaoImpl(String database, int connectionNumber) {
        this.database = database;
        this.connectionNumber = connectionNumber;
    }

    @Override
    public void save() {
        System.out.println("book dao save..." + database + " " + connectionNumber);
    }
}
