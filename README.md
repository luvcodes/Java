# Java

## 进入Basics阶段

### 变量

- 变量:

    - 变量表示内存中的一个存储区域，不同变量类型不同，占用的空间大小不同，例如，int 4个字节，double 8个字节。
    - 变量三要素：变量名，值，数据类型

- 程序中+号的使用

    - 当左右两边都是数值型时，做加法运算
    - 当左右两边有一方为字符串，则做拼接运算

- 数据类型转换

    - AutoConvert - Java里的自动类型转换

    - ChangeChar - Java里的数据类型转换

### 运算符

### 程序控制结构

- For loop - for循环的使用
- ForceConvert - Java里的强制类型转换
- If - if语句
- Input - 接收用户输入
- TernaryOperator - 三元运算符

### 数组、排序和查找

- Array - 数组的应用
- Recursion - 递归算法
- Search - 检索算法
- Sorting - 排序算法

### 面向对象基础

- 类与对象
- 成员方法、成员方法传参机制
- Recursion - 方法递归调用
- Overload - 方法重载
- VarParameter - 形参列表
- VarScope - 作用域
- Constructor - 构造器
- This keyword - this关键字

### 面向对象中级

- Packages - 包的使用
- Modifiers - 访问修饰符
- Encapsulation - 封装
- Inheritance - 继承，`this();`和`super()`的使用是继承的重点部份。
    - `this()`的使用主要是针对class本体内的执行，
      用来指向其他的构造器。例如，在无参构造器里写`this('hello')`, 这种情况下就指向了同一个类里的有参构造器，将hello看作一个string
      传入另一个有参构造器来作为一个参数，再继续执行有参构造器函数体内的代码。
      而`super()`的使用区分开两种情况：
        1. 如果`super()`不传参，那么默认就会直接调用父类的无参构造器
        2. 如果`super()`里有参数，那么就会调用对应的父类的有参构造器，对应指的是，参数的类型、数量、顺序全都匹配。
    - 重点：`this()`和`super()`都只能在构造器内进行使用，并且必须都放置在构造器的**第一行**。因此这两个方法*
      *不可能同时存在在同一个构造器内**。
    - 详见Inheritance包，`this()`和`super()`的区别示例，见`ExtendsExercise01.php`和`ExtendsExercise02.php`这两个练习。
- Super() - super()在继承中的使用 / `Super()`和`this`
  的对比: <https://github.com/luvcodes/Java/issues/1#issue-1460958750>
- Override - 方法重写
    - 对比重载(Overload)和重写(Override): <https://github.com/luvcodes/Java/issues/1#issue-1460958750>
- Polymorphic - 多态 `属性看[README.md](README.md)编译类型，方法看运行类型`，`等号左边是编译类型，等号右边是运行类型`
    1. 一个对象的编译类型和运行类型可以不一致
    2. 编译类型在定义对象时，就确定了，不能改变
    3. 运行类型是可以变化的

#### 编译类型看 = 号的左边，运行类型看 = 号的右边

#### 向上转型与向下转型: <https://juejin.cn/post/6993341672755036173>

#### 多态的重点：动态绑定机制

- 多态数组
- 多态参数
- equals方法：
    - ==和equals的对比
        - ==是一个比较运算符
        - 既可以判断基本类型，也可以判断引用类型
            - 如果判断基本类型，判断的是值是否相等。示例：int i = 10; double d = 10.0;
            - 如果判断引用类型，判断的是地址是否相等，即判断是不是同一个对象。
    - Object类中的方法，只能判断引用类型，
- HashCode方法 - 结果是十进制
- toString方法 - 全类名（包名+类名）@ 把hashCode()方法转换成16进制
- finalize()方法
- `debug`:
    1. ####重要提示：在断点调试过程中，是运行状态，是以对象的运行类型来执行的。例如：A extends B; B b = new A(); b.xx();

## 进入Beginner阶段

### 面向对象高级

#### 类变量 - static关键字

1. **静态变量是被对象共享的**
2. 不管static变量在哪里，共识:
    - static变量是同一个类的所有对象共享
    - static变量，在类加载的时候就生成了。
3. 类变量与实例变量(普通属性)区别: 类变量是该类的所有对象共享的，而实例变量是每个对象独享的。
4. 类方法: **口诀: 静态方法只能访问静态成员** 同时 **非静态方法可以访问静态成员和非静态成员**
5. 如果是访问成员变量，编译的话就是看父类，运行同样是看父类。如果访问的方法，编译就看父类，运行则看子类。如果是静态方法，编译和运行都是看父类。

#### Main方法

- Main方法是谁调用的? JVM调用的

#### 代码块 - 属于类中的成员，类似于方法

1. 修饰符可选，要写的话，也只能写static
2. 代码块分为两类，使用static修饰的叫静态代码块

#### 设计模式

- 单例模式 - 保证了内存中全局的唯一性，避免了对象实例的重复创建
    - 饿汉式单例模式
        - 步骤:
            1. 将构造器私有化，因为私有的方法只能在本类调用
            2. 在类的内部直接创建
            3. 提供一个公共的static方法，返回gf对象
    - 懒汉式单例模式
        - 步骤
            1. 构造器私有化
            2. 定义一个static静态属性对象
            3. 提供一个public的static方法，可以返回Cat对象
            4. 懒汉式，只有当用户使用getInstance时，才返回cat对象，后面再次调用时，会返回上次创建的cat对象，从而保证了单例。
- 模版模式 - abstract的代表练习

#### Final关键字

1. 不希望类不能被其他类继承
2. 不希望父类的方法被子类继承
3. 当不希望类的某个属性的值被修改，可以用final修饰
4. 如果final修饰的属性是静态的，则初始化的位置只能是**定义时**, **在静态代码块**, 不能在构造器中赋值
5. 一般来说，如果一个类已经是final类了，就没有必要再将方法修饰为final
6. final不能修饰构造方法
7. final和static往往搭配使用，效率更高，不会导致类加载
8. 包装类(Integer, Double, Float, Boolean, String)是final类，不能被继承。

#### 抽象类 abstract

- 典型的设计模式: 模版设计模式

#### 接口 Interface

#### 内部类

- 类的五大成员: 属性、方法、构造器、代码块、内部类
- 四种内部类:
    - 定义在外部类局部位置上(比如方法内)
        1. 局部内部类 有类名
        2. **匿名内部类** 没有类名 重点！！！！
    - 定义在外部类的成员位置上(比如属性或方法上)
        1. 成员内部类 没用static修饰
        2. 静态内部类 使用static修饰
- 记住:
    1. 局部内部类定义在方法中/代码块
    2. 作用域在方法体或代码块中
    3. 本质仍然是一个类
- 成员内部类、静态内部类 是放在外部类的成员位置，本质就是一个成员。

#### 枚举 Enumeration

#### 注解 Annotations

- `@Override` 表示重写 最重要的价值就是编译器进行语法校验
- `@Deprecated` 修饰某个元素，表示该元素已经过时
- `@Suppresswarnings`

## 进入Intermediate阶段

### 异常 - Exception

1. 运行时异常: 程序运行时，发生的异常。编译器检测不出来。也就是javac.exe字节码文件转换为java.exe的过程中(
   指向在内存中加载、运行类)出现的error
2. 编译时异常: 编译时，编译器检查出的异常, 是**编译器要求必须处置的异常**。也就是Java源程序编译为javac.exe字节码文件的过程中
3. 主要介绍5种运行异常:
    1. ArrayIndexOutOfBoundsException
    2. NullPointerException
    3. ClassCastException: 当试图将对象强制转换为不是实例的子类时，抛出该异常
    4. ArithmeticException
    5. NumberFormatException: 当应用程序试图将字符串转换成一种数值类型，但该字符串不能转换为适当格式时
4. try-catch-finally捕捉异常
    - 程序员在代码中捕获发生的异常，自行处理
5. throws处理机制
    - 将发生的异常抛出，交给调用者(方法)来处理，最顶级的处理者就是JVM
6. try-catch-finally和throws二选一就可以。如果程序员，没有显示是处理异常，默认throws Exception
7. throw和throws的区分
    - throws后面带的是异常类型
    - throw后面带的是具体的异常对象

### 常用类

##### 包装类 - 针对八种基本数据类型相应的引用类型

- 单独的两个类别
    - boolean => Boolean
    - char => Character

- Number类型:
    1. byte => Byte
    2. int => integer
    3. long => Long
    4. float => Float
    5. double => Double
    6. short => Short
- 装箱和拆箱
    1. 手动装箱: int => Integer
    2. 手动拆箱: Integer => int
    3. jdk5以后，就可以自动装箱和拆箱了

##### String类

- String对象 - <https://juejin.cn/post/6988125661751672846>
- String常用方法
    - intern方法: 手动将字符串加入常量池中的方法
- StringBuffer方法
- StringBuilder
-

String、StringBuffer和StringBuilder的选择 - <https://www.runoob.com/w3cnote/java-different-of-string-stringbuffer-stringbuilder.html>

1. 如果字符串存在大量的修改操作，一般使用StringBuffer或StringBuilder
2. 如果字符串存在大量的修改操作，并在单线程的情况，使用StringBuilder
3. 如果字符串存在大量的修改操作，并在多线程的情况，使用StringBuffer
4. 如果我们字符串很少修改，被多个对象引用，使用String，比如配置信息等。

##### Math方法

##### Arrays排序

- 默认的sort方法是BubbleSort

##### 大数处理方法 - BigInteger, BigDecimal

##### System方法

##### Date()

##### Calendar()

### 集合

#### Collection接口和常用方法

- Collection实现子类可以存放多个元素，每个元素可以是Object
    - 有些Collection的实现类可以存放重复的元素，有些不可以。
    - 有些Collection的实现类，有些是有序的(List)，有些不是有序(Set)。
- Iterator迭代器
- 增强for循环

#### List接口和常用方法

- List接口时Collection接口的子接口
    - List集合类中**元素有序**(即添加顺序和取出顺序一致)、且可重复。
    - List集合中的每个元素都有其对应的顺序索引，即支持索引。

#### ArrayList底层结构和源码分析

##### ArrayList的注意事项 - <https://juejin.cn/s/%E6%95%B0%E7%BB%84%20(array)%20%E5%92%8C%E5%88%97%E8%A1%A8%20(arraylist)%20%E6%9C%89%E4%BB%80%E4%B9%88%E5%8C%BA%E5%88%AB%20%E4%BB%80%E4%B9%88%E6%97%B6%E5%80%99%E5%BA%94%E8%AF%A5%E4%BD%BF%E7%94%A8%20array%20%E8%80%8C%E4%B8%8D%E6%98%AF%20arraylist>

- permits all elements, ArrayList可以加入null，并且可以加入多个。
- ArrayList是由数组实现数据存储的
- ArrayList基本等同于Vector，除了**ArrayList是线程不安全**的。在多线程情况下，不建议使用ArrayList。
- 因为ArrayList的底层就是用数组的方式存储的，elementData其实就是现在这个ArrayList的size，minCapacity就是最小容量(
  其实也就是现在已经存进去的元素数量)。在源码的部分进行对比minCapacity和elementData.size()
  的时候其实就是在对比当前已经存进ArrayList的元素个数与整个ArrayList的大小进行比较。

#### Vector底层结构和源码分析

- Vector类的定义说明
- Vector底层也是一个**对象数组**，`protected Object[] elementData`
- Vector是线程同步的，即**线程安全**，Vector类的操作方法带有`synchronized`
- 在开发中需要线程同步安全时，考虑使用Vector

#### ArrayList和Vector的比较

#### LinkedList底层结构

1. 底层实现了双向链表和双端队列特点
2. 可以添加任意元素(元素可以重复)，包括null
3. **线程不安全**，没有实现同步

#### ArrayList和LinkedList比较

#### Set接口

1. 以Set接口的实现类 HashSet 来讲解Set 接口的方法
2. set接口的实现类的对象(Set接口对象)，不能存放重复的元素，可以添加一个null
3. set接口对象存放数据是无序(即添加的顺序和取出的顺序不一致)
4. 和List接口一样，Set接口也是Collection的子接口，因此，常用方法和Collection接口一样。

##### Set接口的遍历方式

1. 同Collection的遍历方式一样，因为Set接口是Collection接口的子接口。
    - 可以使用迭代器
    - 增强for
    - **不能使用索引**的方式来获取

##### HashSet

1. HashSet实现了Set接口
2. HashSet实际上是HashMap
3. 可以存放null值，但是只能有一个null
4. HashSet不保证元素是有序的，取决于hash后，再确定索引的结果(即，不保证存放元素的顺序和取出顺序一致)
5. 不能有重复元素

### 泛型

#### 为什么需要泛型 - <https://juejin.cn/post/7095362930983567396>

- 适用于多种数据类型执行相同的代码

### 多线程基础

### IO流

### 网络编程

### 反射
