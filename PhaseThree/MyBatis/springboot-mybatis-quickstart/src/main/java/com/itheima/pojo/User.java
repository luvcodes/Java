package com.itheima.pojo;

/**
 * @author ryanw
 */
public class User {
    private Integer id;
    private String name;
    private Short age;
    private Short gender;
    private String phone;

    // 省略GET, SET方法


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", phone='" + phone + '\'' +
                '}';
    }
}
