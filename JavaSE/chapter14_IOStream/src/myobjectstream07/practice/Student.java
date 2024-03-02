package myobjectstream07.practice;

import java.io.Serializable;

public class Student implements Serializable {
    // private static final long serialVersionUID = 1L;
    private String name;
    private String nickname;

    public Student(String name, String nickname) {
        this.name = name;
        this.nickname = nickname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    public String toString() {
        return "Student{name = " + name + ", nickname = " + nickname +"}";
    }
}
