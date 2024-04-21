# 修饰类

final修饰的类，不能被继承。

格式如下：

```Java
final class 类名 {
}
```

代码:

```Java
final class Fu {
}
// class Zi extends Fu {} // 报错,不能继承final的类
```

查询API发现像 `public final class String` 、`public final class Math` 、`public final class Scanner` 等，很多我们学习过的类，都是被final修饰的，目的就是供我们使用，而不让我们所以改变其内容。

# 修饰方法

final修饰的方法，不能被重写。

代码:

```Java
class Fu2 {
	final public void show1() {
		System.out.println("Fu2 show1");
	}
	public void show2() {
		System.out.println("Fu2 show2");
	}
}

class Zi2 extends Fu2 {
//	@Override
//	public void show1() {
//		System.out.println("Zi2 show1");
//	}
	@Override
	public void show2() {
		System.out.println("Zi2 show2");
	}
}
```

# 修饰变量-局部变量

1. **局部变量——基本类型**基本类型的局部变量，**被final修饰后，只能赋值一次，不能再更改**。代码如下：

```Java
public class FinalDemo1 {
    public static void main(String[] args) {
        // 声明变量，使用final修饰
        final int a;
        // 第一次赋值
        a = 10;
        // 第二次赋值
        a = 20; // 报错,不可重新赋值

        // 声明变量，直接赋值，使用final修饰
        final int b = 10;
        // 第二次赋值
        b = 20; // 报错,不可重新赋值
    }
}
```

思考，下面两种写法，哪种可以通过编译？

写法1：

```Java
final int c = 0;
for (int i = 0; i < 10; i++) {
    c = i;
    System.out.println(c);
}
```

写法2：

```Java
for (int i = 0; i < 10; i++) {
    final int c = i;
    System.out.println(c);
}
```

根据 `final` 的定义，写法1报错！写法2，为什么通过编译呢？因为每次循环，都是一次新的变量c。

# 修饰变量-成员变量

成员变量涉及到初始化的问题，初始化方式有显式初始化和构造方法初始化，只能选择其中一个：

- 显式初始化(在定义成员变量的时候立马赋值)（常用）；

```Java
public class Student {
    final int num = 10;
}
```

- 构造方法初始化(在构造方法中赋值一次)（不常用，了解即可）。**注意：每个构造方法中都要赋值一次！**

```Java
public class Student {
    final int num = 10;
    final int num2;

    public Student() {
        this.num2 = 20;
//     this.num2 = 20;
    }

     public Student(String name) {
        this.num2 = 20;
//     this.num2 = 20;
    }
}
```

被final修饰的常量名称，一般都有书写规范，所有字母都**大写**。

1. 不希望类不能被其他类继承
2. 不希望父类的方法被子类继承
3. 当不希望类的某个属性的值被修改，可以用final修饰
4. 如果final修饰的属性是静态的，则初始化的位置只能是**定义时**, **在静态代码块**, 不能在构造器中赋值
5. 一般来说，如果一个类已经是final类了，就没有必要再将方法修饰为final
6. final不能修饰构造方法
7. final和static往往搭配使用，效率更高，不会导致类加载
8. 包装类(Integer, Double, Float, Boolean, String)是final类，不能被继承。