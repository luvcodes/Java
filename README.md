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

##### ArrayList的注意事项

ArrayList和Array有什么区别: <https://juejin.cn/s/%E6%95%B0%E7%BB%84%20(array)%20%E5%92%8C%E5%88%97%E8%A1%A8%20(arraylist)%20%E6%9C%89%E4%BB%80%E4%B9%88%E5%8C%BA%E5%88%AB%20%E4%BB%80%E4%B9%88%E6%97%B6%E5%80%99%E5%BA%94%E8%AF%A5%E4%BD%BF%E7%94%A8%20array%20%E8%80%8C%E4%B8%8D%E6%98%AF%20arraylist>

- permits all elements, ArrayList可以加入null，并且可以加入多个。
- ArrayList是由数组实现数据存储的
- ArrayList基本等同于Vector，除了**ArrayList是线程不安全**的。在多线程情况下，不建议使用ArrayList。
- 因为ArrayList的底层就是用数组的方式存储的，elementData其实就是现在这个ArrayList的size，minCapacity就是最小容量(其实也就是现在已经存进去的元素数量)。在源码的部分进行对比minCapacity 和elementData.size() 的时候其实就是在对比当前已经存进ArrayList的元素个数与整个ArrayList的大小进行比较。

#### Vector底层结构和源码分析

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

1. HashSet实际上是HashMap
2. 可以存放null值，但是只能有一个null
3. HashSet不保证元素是有序的，取决于hashCode，再确定索引的结果(即，不保证存放元素的顺序和取出顺序一致)
4. **不能有重复元素**

##### HashSet底层逻辑 - 重中之重

1. 添加一个元素时，先得到hash值 -> 会转成 -> 索引值。第一次添加时，table数组扩容到16，临界值(threshold)是16 * 加载因子(loadFactor)是0.75 = 12
2. 找到存储数据表table，看这个索引位置是否已经存放的有元素。
    - 如果没有，直接加入
    - 如果有，调用equals比较, 这个equals方法可以程序员控制(可以重写)，有可能是比较value，也就是V，也有可能不是。
        - 如果相同，就放弃添加
        - 如果不相同，则**添加到最后**。在HashSet中是可以添加到最后的，见`HashSetExercise_7.java`文件的示例，但是在HashMap中，如果key相同，value不同，只能是新的value替换重复的那一个key的Node的旧value。这里和HashMap出现分歧的原因是，HashSet本身是通过有一个PRESENT的java build-in值来代替value，而使用key来代表实际的用户传入值，那么相当于在进行链表比较的时候，传入的这个值可以是一个string，也可以是一个对象，但是**重点在于都当作一个整体的key值来进行比较**
    - 如果table数组使用到了临界值12就会扩容到16 * 2 = 32，新的临界值就是32 * 0.75 = 24，依此类推。到达12的意思并不是说必须要hashSet的那一条竖列的数组到达12才扩容，而是每添加一个新的Node(元素)，源码中的size就会加1，到达12以后，就会立刻扩容; 换言之就是说，现在所有的链表上的元素到达12了以后，table length就会扩容到下一个尺寸。
3. 在Java8中，如果一条链表的元素个数超过TREEIFY_THRESHOLD(默认是8)，并且table的大小 >= MIN_TREEIFY_CAPACITY(默认64)，就会进行树化(红黑树)。两个条件都需要满足，才会进行树化，就是把这个链表树化，这个64的意思指的是，table的length超过了64。

##### LinkedHashSet

1. LinkedHashSet是HashSet的子类，底层是一个LinkedHashMap，底层维护了一个hash表和双向链表
2. LinkedHashSet根据元素的hashCode值来决定元素的存储位置，使用链表维护元素的次序，这使得元素看起来是以插入顺序保存的
3. LinkedHashSet**不允许添重复元素**

#### HashMap

- HashMap底层是数组 + 链表 + 红黑树

1. Map与Collection并列存在。用于保存具有映射关系的数据: Key-Value
2. Map中的key和value可以是任何引用类型的数据，会封装到HashMap$Node对象中
3. Map中的key不允许重复，原因和HashSet一样
4. 生成结果的顺序不一定是和加入顺序一致的，因为本质上就是HashSet，见Map_代码文件

- Table表是一个数组，数组里面放的有链表或者是一棵树。每一个链表里面包含多个Node(HashMap$Node)，而Node又实现了Map$Entry接口。

##### HashMap底层机制

扩容机制与HashSet完全一样，因为HashSet底层就是HashMap。有一个重点: HashSet是可以key相同，value不同，但是可以把新的Node添加到链表最后的，不会发生替换。但是在HashMap中，如果key相同，value不同，就会直接发生替换，新的Value会替代旧的Value。源码中有一行`e.value=value`

#### HashTable

- 存放的元素是键值对: 即K-V
- HashTable的键和值都不能为null，否则会抛出NullPointerException
- 使用方法基本和HashMap一样
- HashTable是线程安全的，可以在源代码中定义的方法看到`synchronized`修饰符，HashMap是线程不安全的

- HashTable的首次table length是11，threshold是8，加载因子还是0.75

#### HashTable和HashMap对比

HashMap	线程不安全	效率高	允许null键null值

HashTable	线程安全	  效率低	不允许null键null值

#### Properties

- Properties类**继承自HashTable类**并且实现了Map接口，也是使用一种键值对的形式来保存数据。
- 使用特点和HashTable类似

#### 总结: 开发中如何选择集合实现类

1. 判断存储的类型 (一组对象[单列]或一组键值对[多列])
2. 一组对象[单列]: Collection 接口
   1. 允许重复: List
      1. 增删多: LinkedList - 底层双向链表
      2. 改查多: ArrayList - 底层Object类型的可变数组
   2. 不允许重复: Set
      1. 无序: HashSet - 底层HashMap 即数组 + 链表 + 红黑树
      2. 排序: TreeSet
      3. 插入和取出顺序一致: LinkedHashSet - 底层LinkedHashMap 维护数组 + 双向链表
3. 一组键值对[双列]: Map
   1. 键无序: HashMap - 底层哈希表 数组 + 链表 + 红黑树
   2. 键排序: TreeMap
   3. 键插入和取出顺序一致: LinkedHashMap
   4. 读取文件: Properties

#### TreeSet

- TreeSet底层是TreeMap

#### TreeMap

#### Collections工具类

#### 为什么重写了equals方法一定要重写HashCode方法？

解答: **因为必须保证重写后的equals方法认定相同的两个对象拥有相同的哈希值**”。同时我们顺便得出了一个结论：“**hashCode方法的重写原则就是保证equals方法认定为相同的两个对象拥有相同的哈希值**”。回答见: https://zhuanlan.zhihu.com/p/50206657

当我们将equals方法重写后有必要将hashCode方法也重写，这样做才能保证不违背hashCode方法中“**相同对象必须有相同哈希值**”的约定。equals方法与hashCode方法**根本就是配套使用的**。对于任何一个对象，不论是使用继承自Object的equals方法还是重写equals方法。hashCode方法实际上必须要完成的一件事情就是，**为该equals方法认定为相同的对象返回相同的哈希值**。

1. 相同的对象必然导致相同的哈希值。
2. 不同的哈希值必然是由不同对象导致的。

哈希函数/散列函数的概念: **哈希函数（散列函数）能够将任意长度的输入值转变成固定长度的值输出，该值称为散列值，输出值通常为字母与数字组合**

- **为什么要保证它们的哈希值相等呢？“hashCode方法返回的哈希值在语言中扮演了一个什么角色？**
  - 这里可以根据HashMap的源码来说明。

- Equals的原理是什么？为什么需要重写equals方法呢？
  - Object类中的equals方法区分两个对象的做法是比较地址值，即使用“==”。而我们如若根据业务需求改写了equals方法的实现，那么也应当同时改写hashCode方法的实现。否则hashCode方法依然返回的是依据Object类中的依据地址值得到的integer哈希值。继承自Object的equals方法不能满足业务需求的情形，就比如我在文中说的，String除了对比地址值之外，还将每个对应字符相等的两个String对象也认定为“equals”。

### 泛型

- 为什么需要泛型 - <https://juejin.cn/post/7095362930983567396>

- 适用于多种数据类型执行相同的代码



### Java事件处理机制

1. 事件源: 产生事件的对象，比如按钮、窗口等
2. 事件: 
3. 事件类型: 
4. 事件监听器接口: 
   1. 当事件源产生一个事件，可以传递给事件监听者处理
   2. 事件监听者实际上就是一个类，该类实现了某个事件监听器接口
   3. 事件监听器接口有多种，不同的事件监听器接口可以监听不同的事件，一个类可以实现多个监听接口

### 多线程基础

#### 相关概念

1. 程序(Program)
2. 进程
   1. 进程是指运行中的程序。进程是程序的一次执行过程，或是正在运行的一个程序。是动态过程: 有它自身的产生、存在和消亡的过程。
3. 线程
   1. 线程由进程创建的，是进程的一个实体
   2. 一个进程可以拥有多个线程
4. 单线程: 同一个时刻，只允许执行一个线程
5. 多线程: 同一个时刻，可以允许多个线程，比如: 一个qq进程，可以同时打开多个聊天窗口，一个迅雷进程，可以同时下载多个文件。
6. 并发: 同一个时刻，多个任务交替执行。简单的说，单核CPU实现的多任务就是并发。
7. 并行: 同一个时刻，多个任务同时执行。多核CPU可以实现并行。

#### 线程的基本使用

1. 主线程结束了，并不代表其他线程也结束了，也不代表进程就结束了。

##### 创建线程的两种方式

1. 继承Thread类，重写run方法
   1. start方法是核心，start方法调用start0方法，start0(才是真正实现多线程的方法，而不是run方法)是由JVM调用的，该线程并不一定会立马执行，只是将线程变成了可运行状态，具体什么时候执行，取决于CPU，由CPU统一调用
2. 实现Runnable接口，重写run方法
   1. 因为java是单继承的，所以在某行且况下一个类可能已经继承了某个父类，这时再用继承Thread类方法来创建线程显然不可能了。另外一种方式创建线程，就是通过实现Runnable接口来创建线程。
   1. 底层使用了代理模式(设计模式)

#### 继承Thread和实现Runnable接口的区别

1. 从java的设计来看，本质上没有区别。
2. 实现Runnable接口方式更加适合多个线程共享一个资源的情况，并且避免了单继承的限制。

#### 线程终止

#### 线程常用方法

- setPriority: 线程的优先级，优先级高的线程得到的CPU资源比较多，也就是CPU优先执行优先级高的线程对象中的任务。
- yield: 线程的礼让。让出cpu，让其他线程执行，但礼让的事件不确定，所以也不一定礼让成功。
- join: 线程的插队。插队的线程一旦插队成功，**则肯定先执行完插入的线程所有的任务**。举例说明: 两个线程t1和t2，t1先开始执行了，如果在执行的过程中调用了`t2.join()`, 那么就会开始执行t2，一定是在t2执行完以后，才继续执行t1剩余的部分。见`ThreadMethod02`

#### 线程生命周期



### IO流

### 网络编程

### 反射
