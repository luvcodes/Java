this修饰的变量用于指代成员变量，其主要作用是区分局部变量和成员变量的重名问题

- 方法的形参如果与成员变量同名，不带this修饰的变量指的是形参，而不是成员变量
- 方法的形参没有与成员变量同名，不带this修饰的变量指的是成员变量

this的本质就是所在方法调用者的地址值。

# this的内存原理

## 示例一

![[/%E6%88%AA%E5%B1%8F2024-01-22_%E4%B8%8A%E5%8D%8810.23.46 2.png|%E6%88%AA%E5%B1%8F2024-01-22_%E4%B8%8A%E5%8D%8810.23.46 2.png]]

  

## 示例二

![[%E6%88%AA%E5%B1%8F2024-01-22_%E4%B8%8A%E5%8D%8810.45.48.png]]

![[%E6%88%AA%E5%B1%8F2024-01-22_%E4%B8%8A%E5%8D%8810.46.05.png]]

  

![[%E6%88%AA%E5%B1%8F2024-01-22_%E4%B8%8A%E5%8D%8810.48.46.png]]

![[%E6%88%AA%E5%B1%8F2024-01-22_%E4%B8%8A%E5%8D%8810.49.12.png]]

```Java
public class Student {
    private String name;
    private int age;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void show() {
        System.out.println(name + "," + age);
    }
}
```