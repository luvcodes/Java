# abstract使用格式

**abstract是抽象的意思，用于修饰方法方法和类，修饰的方法是抽象方法，修饰的类是抽象类。**

# 抽象方法

使用`abstract` 关键字修饰方法，该方法就成了抽象方法，抽象方法只包含一个方法名，而没有方法体。

定义格式：

```Java
public abstract void run()；
```

# 抽象类

如果一个类包含抽象方法，那么该类必须是抽象类。**注意：抽象类不一定有抽象方法，但是有抽象方法的类必须定义成抽象类。**

定义格式：

```Java
public abstract class Animal {
    public abstract void run()；
}
```

# 抽象类的使用

**要求**：继承抽象类的子类**必须重写父类所有的抽象方法**。否则，该子类也必须声明为抽象类。

代码举例：

```Java
// 父类,抽象类
abstract class Employee {
	private String id;
	private String name;
	private double salary;

	public Employee() {
	}

	public Employee(String id, String name, double salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	// 抽象方法
	// 抽象方法必须要放在抽象类中
	abstract public void work();
}

// 定义一个子类继承抽象类
class Manager extends Employee {
	public Manager() {
	}
	public Manager(String id, String name, double salary) {
		super(id, name, salary);
	}
	// 2.重写父类的抽象方法
	@Override
	public void work() {
		System.out.println("管理其他人");
	}
}

// 定义一个子类继承抽象类
class Cook extends Employee {
	public Cook() {
	}
	public Cook(String id, String name, double salary) {
		super(id, name, salary);
	}
	@Override
	public void work() {
		System.out.println("厨师炒菜多加点盐...");
	}
}

// 测试类
public class Demo10 {
	public static void main(String[] args) {
		// 创建抽象类,抽象类不能创建对象
		// 假设抽象类让我们创建对象,里面的抽象方法没有方法体,无法执行.所以不让我们创建对象
//		Employee e = new Employee();
//		e.work();

		// 3.创建子类
		Manager m = new Manager();
		m.work();

		Cook c = new Cook("ap002", "库克", 1);
		c.work();
	}
}
```

# 抽象类的特征

抽象类的特征总结起来可以说是 **有得有失**

**有得：抽象类得到了拥有抽象方法的能力。**

**有失：抽象类失去了创建对象的能力。**

其他成员（构造方法，实例方法，静态方法等）抽象类都是具备的。

# 抽象类的细节

1. 抽象类**不能创建对象**，如果创建，编译无法通过而报错。只能创建其非抽象子类的对象。

理解：假设创建了抽象类的对象，调用抽象的方法，而抽象方法没有具体的方法体，没有意义。

1. 抽象类中，可以有构造方法，是供子类创建对象时，初始化父类成员使用的。

理解：子类的构造方法中，有默认的super()，需要访问父类构造方法。

1. 抽象类中，不一定包含抽象方法，但是有抽象方法的类必定是抽象类。

理解：未包含抽象方法的抽象类，目的就是不想让调用者创建该类对象，通常用于某些特殊的类结构设计。

1. 抽象类的子类，必须重写抽象父类中**所有的**抽象方法，否则子类也必须定义成抽象类，编译无法通过而报错。

理解：假设不重写所有抽象方法，则类中可能包含抽象方法。那么创建对象后，调用抽象的方法，没有意义。

1. 抽象类存在的意义是为了被子类继承。

理解：抽象类中已经实现的是模板中确定的成员，抽象类不确定如何实现的定义成抽象方法，交给具体的子类去实现。

- 抽象方法就是没有实现的方法。没有实现就是指没有方法体
- **当一个类存在抽象方法时，需要将该方法所属的类定义成抽象类**。但**抽象类不一定要包含abstract方法**，也就是说抽象类可以没有abstract方法，还可以有实现的方法
- 一般来说，抽象类会被继承，由其子类来实现抽象方法。如果一个类继承了抽象类，则它必须实现抽象类的所有抽象方法，除非它自己也声明为abstract
- 抽象类不能被实例化
- abstract只能修饰类和方法，不能修饰属性和其他的

# 抽象类实现接口

实现接口的类可以是抽象类。在Java中，一个抽象类可以实现接口，并且不提供接口方法的具体实现，留给其子类去实现。

这样做的一个好处是可以为一系列相关的类提供一个共同的接口。这些子类继承抽象类后，就必须实现那些未被抽象类实现的接口方法。

```Java
public class test {
    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        myClass.method1();
        myClass.method2();
        myClass.method3(); // myclass特有方法
    }
}

interface MyInterface {
    public abstract void method1();
    public abstract void method2();
}

abstract class MyAbstractClass implements MyInterface {
    // 不实现method2
}

class MyClass extends MyAbstractClass {
    @Override
    public void method1() {
        System.out.println("method1");
    }

    @Override
    public void method2() {
        System.out.println("method2");
    }

    public void method3() {
        System.out.println("method3");
    }
}
```

```Java
interface MyInterface {
    void method1();
    void method2();
}

abstract class MyAbstractClass implements MyInterface {
    public void method1() {
        // 实现method1，但method2没有在这里实现
        System.out.println("Method1 implementation.");
    }
    // MyAbstractClass没有实现method2，因此它可以保持抽象性
}

class MyConcreteClass extends MyAbstractClass {
    public void method2() {
        // 子类实现了method2
        System.out.println("Method2 implementation.");
    }
}
```