super 是 Java 中的一个关键字，主要用于从子类中访问父类的成员（属性和方法）。super 可以有多种用法，主要有以下两种：

1. **调用父类的构造器**： 当你在子类中定义了一个构造器，并且你想调用父类的某个构造器时，可以使用 super。这通常用于传递参数或确保父类的初始化逻辑得到执行。例如：

```Java
class Parent {
    Parent() {
        System.out.println("Parent Constructor");
    }
}

class Child extends Parent {
    Child() {
        super();  // 这里会调用父类的构造器
        System.out.println("Child Constructor");
    }
}

public class Test {
    public static void main(String[] args) {
        Child c = new Child();  // 输出：Parent Constructor，然后输出：Child Constructor
    }
}
```

注意：super() 必须是构造器中的第一个语句。此外，如果子类的构造器没有显式地调用父类的构造器，编译器会自动插入一个无参的 super()。

1. **引用父类的方法和属性**： 如果子类覆盖了父类的某个方法或属性，并且还想访问父类的该方法或属性，就可以使用 super 关键字。例如：

```Java
class Parent {
    int value = 100;

    void show() {
        System.out.println("Parent's show method");
    }
}

class Child extends Parent {
    int value = 200;

    void show() {
        super.show();  // 调用父类的show方法
        System.out.println("Child's show method");
        System.out.println("Parent's value: " + super.value);  // 使用super访问父类的属性
        System.out.println("Child's value: " + value);
    }
}

public class Test {
    public static void main(String[] args) {
        Child c = new Child();
        c.show();  // 输出：Parent's show method, Child's show method, Parent's value: 100, Child's value: 200
    }
}
```

总结：super 关键字为子类提供了一种方式，使其可以引用其父类的方法和属性，这在某些情况下非常有用，尤其是在覆盖父类的方法或属性时。

# 子类可以继承父类的构造函数吗？

在Java中，子类不能直接继承父类的构造函数。然而，子类可以通过使用super关键字来调用父类的构造函数。

让我们通过一些规则和例子来说明这点：

1. 如果父类有一个无参构造函数（不论是默认提供的还是明确声明的），子类默认会调用它，除非你在子类的构造函数中使用了super关键字调用父类的其他构造函数。
2. 如果父类没有无参构造函数，并且子类的构造函数没有明确地通过super调用父类的其他构造函数，那么编译器会报错。
3. 子类的构造函数（不论是否使用super）必须在其第一行调用父类的某个构造函数。

下面是一个例子，其中父类Parent有两个构造函数，子类Child通过使用super关键字调用它们：

```Java
class Parent {
    public Parent() {
        System.out.println("Parent's no-arg constructor");
    }

    public Parent(String message) {
        System.out.println("Parent's constructor with a message: " + message);
    }
}

class Child extends Parent {
    public Child() {
        // This will implicitly call the no-arg constructor of Parent.
        System.out.println("Child's no-arg constructor");
    }

    public Child(String message) {
        super(message);  // Explicitly calling the constructor of Parent with a message.
        System.out.println("Child's constructor with a message");
    }
}

public class Main {
    public static void main(String[] args) {
        Child child1 = new Child();
        Child child2 = new Child("Hello");
    }
}
```

```Plain
Parent's no-arg constructor
Child's no-arg constructor
Parent's constructor with a message: Hello
Child's constructor with a message
```

从上述例子可以看出，虽然子类Child不能"继承"父类Parent的构造函数，但它可以通过使用super关键字来调用它们。

  

# super案例图解

**父类空间优先于子类对象产生**

在每次创建子类对象时，**先初始化父类空间，再创建其子类对象本身**。目的在于子类对象中包含了其对应的父类空间，便可以包含其父类的成员，如果父类成员非private修饰，则子类可以随意使用父类成员。代码体现在子类的构造器调用时，一定先调用父类的构造方法。理解图解如下：

[![](https://cdn.nlark.com/yuque/0/2024/png/38953059/1710481905127-90f49c2f-0e0e-490d-940b-37a944f65382.png)](https://cdn.nlark.com/yuque/0/2024/png/38953059/1710481905127-90f49c2f-0e0e-490d-940b-37a944f65382.png)