package com.itheima.dao.impl;

public class BookDaoImpl implements BookDao {
    private String database;
    private int connectionNumber;

    public void setDatabase(String database) {
        this.database = database;
    }

    public void setConnectionNumber(int connectionNumber) {
        this.connectionNumber = connectionNumber;
    }

    @Override
    public void save() {
        System.out.println("book dao save..." + database + " " + connectionNumber);
    }
}
