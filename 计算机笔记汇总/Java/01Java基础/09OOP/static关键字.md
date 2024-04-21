1. **静态变量是被对象共享的**
2. 不管static变量在哪里，共识:
    - static变量是同一个类的所有对象共享
    - static变量，在类加载的时候就生成了，所以即使没有创建对象实例也可以访问。
    - 静态变量会在该类的任何静态方法执行之前就初始化
    - 静态变量会在该类的任何对象创建之前就完成初始化
3. 类变量与实例变量(普通属性)区别: 类变量是该类的所有对象共享的，而实例变量是每个对象独享的。
4. 类方法: **口诀: 静态方法只能访问静态成员** 同时 **非静态方法可以访问静态成员和非静态成员**
5. 如果是访问成员变量，编译的话就是看父类，运行同样是看父类。如果访问的方法，编译就看父类，运行则看子类。如果是静态方法，编译和运行都是看父类。

# 静态变量及其访问

## 静态变量概念

**静态变量 == 类变量**

静态变量（也称为类变量）是属于类的，而不是属于某个特定对象的。这意味着无论创建多少个该类的对象，**静态变量只有一份拷贝，并且所有的对象都可以访问这一份拷贝**。相比之下，**非静态变量（也称为实例变量）是每个对象都有自己的一份拷贝**。

有static修饰成员变量，说明这个成员变量是属于类的，这个成员变量称为**类变量**或者**静态成员变量**。 直接用类名访问即可。因为类只有一个，所以静态成员变量在内存区域中也只存在一份。所有的对象都可以共享这个变量。

## **如何使用呢？**

- 例如现在我们需要定义传智全部的学生类，那么这些学生类的对象的学校属性应该都是“传智”，这个时候我们可以把这个属性定义成static修饰的静态成员变量。

```Java
public class Student {
    public static String schoolName = "传智播客"； // 属于类，只有一份。
    // .....
}
```

## **静态成员变量的访问**

**格式：类名.静态变量**

```Java
public static void  main(String[] args){
    System.out.println(Student.schoolName); // 传智播客
    Student.schoolName = "黑马程序员";
    System.out.println(Student.schoolName); // 黑马程序员
}
```

## **静态变量和实例变量的区别**

1. **声明**：静态变量使用`static`关键字声明，而实例变量不使用。
2. **存储**：静态变量存储在类区域，而实例变量存储在每个对象的内存中。
3. **初始化**：静态变量和静态代码块（如果有的话）在类首次加载到内存时初始化。而实例变量和普通代码块（如果有的话）在每次创建类的新对象时都会初始化。
4. **生命周期**：静态变量的生命周期与类的生命周期相同，从类加载到卸载。而实例变量的生命周期与对象的生命周期相同，从对象创建到垃圾回收。
5. **访问**：静态变量可以通过类名直接访问，也可以通过对象访问（但这通常不是推荐的做法，因为这可能会引起混淆）。实例变量只能通过对象访问。
6. **用途**：静态变量通常用于存储那些所有对象都需要共享的值，如常量或配置。实例变量用于存储与每个对象相关的值。

```Java
class MyClass {
    static int staticVariable;  // 静态变量
    int instanceVariable;      // 实例变量
}
```

# 静态方法及其访问

有static修饰成员方法，说明这个成员方法是属于类的，这个成员方法称为**类方法**或者**静态方法**。 直接用 类名访问即可。**因为类只有一个，所以静态方法在内存区域中也只存在一份**。所有的对象都可以共享这个方法。

与静态成员变量一样，静态方法也是直接通过**类名.方法名称**即可访问。

```Java
public class Student{
    public static String schoolName = "传智播客"； // 属于类，只有一份。
    // .....
    public static void study(){
    	System.out.println("我们都在黑马程序员学习");
    }
}
```

```Java
public static void  main(String[] args){
    Student.study();
}
```

在Java中，方法调用的规则如下：

1. **静态方法调用其他静态方法**:

- 静态方法可以直接调用同一个类中的其他静态方法，不需要创建类的实例。这是因为静态方法属于类本身，而不是类的任何特定对象实例。

1. **静态方法调用非静态方法**:

- 静态方法不能直接调用非静态方法。要从静态上下文（如静态方法）中调用非静态方法，你必须先创建类的实例，然后通过这个实例来调用非静态方法。这是因为非静态方法需要一个与之相关的实例来访问非静态字段和方法。

1. **非静态方法调用静态方法**:

- 非静态方法可以直接调用静态方法，即使不创建类的实例。这是因为静态方法属于类，而非静态方法已经在类的上下文中执行，所以可以直接访问类的静态成员。

举例说明：

```Java
public class MyClass {
    public static void staticMethod() {
        System.out.println("Static method called.");
    }

    public void nonStaticMethod() {
        System.out.println("Non-static method called.");
    }

    public static void anotherStaticMethod() {
        // 直接调用另一个静态方法
        staticMethod();
    }

    public static void staticMethodCallingNonStatic() {
        // 要调用非静态方法，需要创建实例
        MyClass myClass = new MyClass();
        myClass.nonStaticMethod();
    }

    public void nonStaticMethodCallingStatic() {
        // 在非静态方法中直接调用静态方法
        staticMethod();
    }
}
```

在这个例子中，`anotherStaticMethod`可以直接调用另一个静态方法`staticMethod`，而`staticMethodCallingNonStatic`需要创建`MyClass`的一个实例来调用非静态方法`nonStaticMethod`。另一方面，`nonStaticMethodCallingStatic`直接调用了静态方法`staticMethod`，展示了非静态方法可以直接访问静态成员。

# 静态变量和静态代码块的优先级

静态变量和静态代码块都属于类的静态初始化过程。它们的执行顺序取决于它们在代码中的声明顺序。

具体来说：

1. **如果静态变量在静态代码块之前声明**，那么静态变量会先于静态代码块初始化。
2. **如果静态代码块在静态变量之前声明**，那么静态代码块会先于静态变量执行。

这意味着它们的"优先级"是基于它们在源代码中的顺序，而不是它们本身的固有属性。

```Java
public class TestClass {

    static int a = 10;

    static {
        a = 20;
    }

    public static void main(String[] args) {
        System.out.println(a);  // 输出20，因为静态代码块修改了a的值
    }
}
```

在上面的例子中，虽然静态变量`a`首先被初始化为10，但随后的静态代码块将其修改为20。

再看一个例子：

```Java
public class TestClass {

    static {
        b = 30;
    }

    static int b = 40;

    public static void main(String[] args) {
        System.out.println(b);  // 输出40，因为静态变量的初始化覆盖了静态代码块的赋值
    }
}
```

在这个例子中，尽管静态代码块试图将`b`的值设置为30，但后续的静态变量初始化将其值重置为40。

因此，总结起来，静态变量和静态代码块的执行顺序是按照它们在类中的声明顺序进行的。

## 代码示例

```Java
package codeblock;

/**
 * @author ryanw
 */
public class CodeBlockDetail01 {
    public static void main(String[] args) {
        // 类被加载情况示例
        // 1. 创建对象实例时(new) 类被加载
        // AA aa = new AA();

        // 2. 创建子类对象实例，父类也会被加载，而且，父类先被加载，子类后被加载
//         AA aa2 = new AA();

        // 3. 使用类的静态成员时，会先执行静态代码块，然后再去访问到n1
         System.out.println(Cat.n1);

        /**
         * static代码块，是在类加载时执行的，而且只会执行一次
         * 普通的代码块，在创建对象实例时，会被隐式地调用，被创建一次，就会调用一次
         */
//        DD dd = new DD();
//        DD dd2 = new DD();

        // 如果只是使用类的静态成员时，普通代码块并不会执行
//        System.out.println(DD.n1);
    }
}

class DD {
    public static int n1 = 8888;
    static {
        System.out.println("DD的静态代码块1被执行...");
    }
    // 普通代码块, new对象时，被调用，而且是每创建一个对象，就调用一次
    // 可以这样简单地理解，普通代码块是构造器的补充
    {
        System.out.println("DD的普通代码块");
    }
}

class Animal {
    // 静态代码块
    static {
        System.out.println("Animal的静态代码块1被执行...");
    }
}

class Cat extends Animal{
    // 静态属性
    public static int n1 = 999;

    // 静态代码块
    static {
        System.out.println("Cat的静态代码块1被执行...");
    }
}

class BB {
    // 静态代码块
    static {
        System.out.println("BB的静态代码块1被执行...");
    }
}

class AA extends BB{
    // 静态代码块
    static {
        System.out.println("AA的静态代码块1被执行...");
    }
}
```

### 问题: 为什么`Cat.n1`一定要先执行静态代码块？

实际上，这个顺序确实是按照它们在代码中出现的顺序来初始化的。对于你的例子，虽然静态变量`n1`在静态代码块之前声明，但你观察到的行为似乎与之相反，这实际上是因为类加载和初始化过程的内部机制。

在Java中，当类被加载和链接的时候，静态变量会被初始化，静态代码块也会按照它们在类中声明的顺序执行。如果你在静态代码块之前声明了静态变量，理论上静态变量应该先被初始化。然而，从你的描述中，看起来静态代码块先于静态变量初始化执行，这实际上是符合预期的行为，让我澄清一下：

1. **类加载和初始化**：当Java类被加载时，静态变量会被初始化，静态代码块会被执行。这些操作是按照它们在类中声明的顺序进行的。
2. **执行顺序**：如果一个静态变量声明在静态代码块之前，它会在静态代码块执行之前被初始化。但是，输出操作(`System.out.println(Cat.n1);`)是在类加载和初始化完成后执行的。因此，**即使静态变量**`**n1**`**在静态代码块之前初始化**，**静态代码块的执行输出会在你通过**`**System.out.println**`**访问**`**n1**`**之前显示**。