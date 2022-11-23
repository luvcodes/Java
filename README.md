# Java
### For java learning purpose

通过`Basics，Advance`等分级来将学习Java的由易到难的过程记录下来。
既是为了给自己的Java学习经历做一个总结，也为了将此资源分享给Java的初学者。

在Basics中明确地保证定义了几个Level，以下我会依次提炼每个level的主要内容
* Level 1：
  * AutoConvert - Java里的自动类型转换
  * ChangeChar - Java里的数据类型转换
  * For loop - for循环的使用
  * ForceConvert - Java里的强制类型转换
  * If - if语句
  * Input - 接收用户输入
  * TernaryOperator - 三元运算符
* Level 2:
  * Array - 数组的应用
  * Class_Object - 类与对象
  * Recursion - 递归算法
  * Search - 检索算法
  * Sorting - 排序算法
  * Overload - 方法重载
  * VarParameter - 形参列表
  * VarScope - 作用域
  * Constructor - 构造器
  * This keyword - this关键字
* Level 3:
  * Packages - 包的使用
  * Modifiers - 访问修饰符
  * Encapsulation - 封装
  * Inheritance - 继承，`this();`和`super()`的使用是继承的重点部份。
    * `this()`的使用主要是针对class本体内的执行，
    用来指向其他的构造器。例如，在无参构造器里写`this('hello')`, 这种情况下就指向了同一个类里的有参构造器，将hello看作一个string
    传入另一个有参构造器来作为一个参数，再继续执行有参构造器函数体内的代码。
    而`super()`的使用区分开两种情况：
      * 如果`super()`不传参，那么默认就会直接调用父类的无参构造器
      * 如果`super()`里有参数，那么就会调用对应的父类的有参构造器，对应指的是，参数的类型、数量、顺序全都匹配。
    * 重点：`this()`和`super()`都只能在构造器内进行使用，并且必须都放置在构造器的**第一行**。因此这两个方法**不可能同时存在在同一个构造器内**。
    * 详见Inheritance包，`this()`和`super()`的区别示例，见`ExtendsExercise01.php`和`ExtendsExercise02.php`这两个练习。
  * Super() - super()在继承中的使用 / `Super()`和`this`的对比
  