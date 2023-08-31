# Java

## 进入Basics阶段

### 变量

- 变量: 变量三要素：变量名，值，数据类型

- 数据类型转换

  - AutoConvert - Java里的自动类型转换

  - ChangeChar - Java里的数据类型转换

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
  - Java允许同一个类中，多个同名方法的存在，但要求形参列表不一致(形参类型或个数或顺序，至少有一样不同，参数名无要求)

- This keyword - this关键字

### 面向对象中级

- Modifiers - 访问修饰符

- **Encapsulation - 封装**
  
  - 在Java中，封装通过访问控制修饰符（public、private、protected和default）来实现
  - 使用封装的原则是尽量将类的成员变量声明为私有，并提供公共方法来访问和修改这些私有变量

- **Inheritance - 继承**，`this();`和`super()`的使用是继承的重点部份。
  
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
  
- **Polymorphic - 多态** `属性看编译类型，方法看运行类型`，`等号左边是编译类型，等号右边是运行类型`
  
  - 对比重载(Overload)和重写(Override):

    - 方法重载(Overload)是指在同一个类中定义多个名称相同但参数列表不同的方法。在方法重载中，方法的名称相同，但参数不同，参数的类型、数量或两者都可能不同。编译器会根据方法调用时提供的参数来决定调用哪种重载方法。方法重载发生在编译时（静态多态）

        ```java
        class MathUtils {
            int add(int a, int b) {
                return a + b;
            }
            
            double add(double a, double b) {
                return a + b;
            }
        }
        ```

    - 方法重写(Override)是指在子类中为父类（超类）中已定义的方法提供新的实现。在方法覆盖中，子类和超类中的方法名称和参数列表必须相同。当使用子类对象调用重载方法时，执行的是子类中的重载方法，而不是超类中的方法。方法重写发生在运行时（动态多态性）

        ```java
        class Animal {
            void makeSound() {
                System.out.println("Animal makes a sound");
            }
        }
        
        class Dog extends Animal {
            @Override
            void makeSound() {
                System.out.println("Dog barks");
            }
        }
        ```

    1. 一个对象的编译类型和运行类型可以不一致: 等号左边是编译类型，等号右边是运行类型
       1. 可以让父类的一个引用，指向子类的一个对象: `Animal animal = new Dog();` animal的编译类型是Animal，运行类型是Dog
    2. 编译类型在定义对象时，就确定了，不能改变
    3. 运行类型是可以变化的
    4. 编译类型看定义时 = 号的左边，运行类型看 = 号的右边

#### 向上转型与向下转型: <https://juejin.cn/post/6993341672755036173>

##### 向上转型

- 本质: 父类的引用指向子类对象
- 语法: 父类类型 引用名 = new 子类类型()
- 特点: 编译类型看左边，运行类型看右边
  - 可以调用父类中的所有成员(需遵守访问权限)
  - 不能调用子类中特有成员
  - 最终运行效果看子类的具体表现

##### 向下转型

- 语法: 子类类型 引用名 = (子类类型) 父类引用
- 只能强转父类的引用，不能强转父类的对象
- 要求父类的引用必须指向的是当前目标类型的对象
- 当向下转型后，可以调用子类类型中所有的成员

##### `InstanceOf`关键字

- 用于判断对象的类型是否为XX类型或XX类型的子类型

#### 多态的重点：动态绑定机制

- 多态数组

- 多态参数

- equals方法：
  
    ```java
    // equals方法的源码
    public boolean equals(Object obj) {
      return (this == obj);
    }
    ```

  - ==和equals的对比

    - ==是一个比较运算符
    - 既可以判断基本类型，也可以判断引用类型
      - 如果判断基本类型，判断的是值是否相等。示例：int i = 10; double d = 10.0;
      - 如果**判断引用类型**，**判断的是地址是否相等**，**即判断是不是同一个对象**。
    - equals 本质上就是 ==

  - **Object类中的方法，只能判断引用类型**

  - == 对于基本类型来说是值比较，对于引用类型来说是比较的是引用；而 equals 默认情况下是引用比较，只是很多类重写了 equals 方法，比如 String、Integer 等把它变成了值比较，所以一般情况下 equals 比较的是值是否相等。<https://juejin.cn/post/6844903790089338887>

        ```java
        class Cat {
            public Cat(String name) {
                this.name = name;
            }
            private String name;
            public String getName() {
                return name;
            }
            public void setName(String name) {
                this.name = name;
            }
        }
        Cat c1 = new Cat("王磊");
        Cat c2 = new Cat("王磊");
        System.out.println(c1.equals(c2)); // false
        ```

#### HashCode

- 两个引用，如果指向的是同一个对象，则哈希值一定是一样的
- 两个引用，如果指向的是不同对象，则哈希值是不一样的
- 哈希值主要根据地址号来的，不能完全将哈希值等价于地址

## 进入Beginner阶段

### 面向对象高级

#### 类变量 - static关键字

1. **静态变量是被对象共享的**

2. 不管static变量在哪里，共识:
    - static变量是同一个类的所有对象共享
    - static变量，在类加载的时候就生成了，所以即使没有创建对象实例也可以访问。
      - 静态变量会在该类的任何静态方法执行之前就初始化
      - 静态变量会在该类的任何对象创建之前就完成初始化

3. 类变量与实例变量(普通属性)区别: 类变量是该类的所有对象共享的，而实例变量是每个对象独享的。

4. 类方法: **口诀: 静态方法只能访问静态成员** 同时 **非静态方法可以访问静态成员和非静态成员**

5. 如果是访问成员变量，编译的话就是看父类，运行同样是看父类。如果访问的方法，编译就看父类，运行则看子类。如果是静态方法，编译和运行都是看父类。

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

#### Final关键字

1. 不希望类不能被其他类继承
2. 不希望父类的方法被子类继承
3. 当不希望类的某个属性的值被修改，可以用final修饰
4. 如果final修饰的属性是静态的，则初始化的位置只能是**定义时**, **在静态代码块**, 不能在构造器中赋值
5. 一般来说，如果一个类已经是final类了，就没有必要再将方法修饰为final
6. final不能修饰构造方法
7. final和static往往搭配使用，效率更高，不会导致类加载
8. 包装类(Integer, Double, Float, Boolean, String)是final类，不能被继承。

#### 抽象类以及抽象方法 `abstract`

- 抽象方法就是没有实现的方法。没有实现就是指没有方法体
- 当一个类存在抽象方法时，需要将该方法所属的类定义成抽象类。但抽象类不一定要包含abstract方法，也就是说抽象类可以没有abstract方法，还可以有实现的方法
- 一般来说，抽象类会被继承，由其子类来实现抽象方法。如果一个类继承了抽象类，则它必须实现抽象类的所有抽象方法，除非它自己也声明为abstract
- 抽象类不能被实例化
- abstract只能修饰类和方法，不能修饰属性和其他的

#### 接口 Interface

- 资料见: <https://www.runoob.com/java/java-interfaces.html>

- 是一个抽象类型，是抽象方法的集合。一个类通过继承接口的方式，从而来继承接口的抽象方法。接口并不是类，编写接口的方式和类很相似，但是它们属于不同的概念。类描述对象的属性和方法。接口则包含类要实现的方法。

- 接口无法被实例化，但是可以被实现。一个实现接口的类，必须实现接口内所描述的所有方法，否则就必须声明为抽象类。

- 接口与类的区别：

  - 接口不能用于实例化对象。
  - 接口没有构造方法。
  - 接口中所有的方法必须是抽象方法，Java 8 之后 接口中可以使用 default 关键字修饰的非抽象方法。
  - 接口不能包含成员变量，除了 static 和 final 变量。
  - **接口不是被类继承了，而是要被类实现**。
  - **接口支持多继承**。

- 接口特性

  - 接口中每一个方法也是隐式抽象的,接口中的方法会被隐式的指定为 **public abstract**（只能是 public abstract，其他修饰符都会报错）。

  - 接口中可以含有变量，但是接口中的变量会被隐式的指定为 **public static final** 变量（并且只能是 public，用 private 修饰会报编译错误）。

  - 接**口中的方法是不能在接口中实现的，只能由实现接口的类来实现接口中的方法**。

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
- **String类为什么用final修饰？**
- **String类型为什么不可变**

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
    - 如果table数组使用到了临界值12就会扩容到16 *2 = 32，新的临界值就是32* 0.75 = 24，依此类推。到达12的意思并不是说必须要hashSet的那一条竖列的数组到达12才扩容，而是每添加一个新的Node(元素)，源码中的size就会加1，到达12以后，就会立刻扩容; 换言之就是说，现在所有的链表上的元素到达12了以后，table length就会扩容到下一个尺寸。
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

HashMap 线程不安全 效率高 允许null键null值

HashTable 线程安全   效率低 不允许null键null值

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

解答: **因为必须保证重写后的equals方法认定相同的两个对象拥有相同的哈希值**”。同时我们顺便得出了一个结论：“**hashCode方法的重写原则就是保证equals方法认定为相同的两个对象拥有相同的哈希值**”。回答见: <https://zhuanlan.zhihu.com/p/50206657>

当我们将equals方法重写后有必要将hashCode方法也重写，这样做才能保证不违背hashCode方法中“**相同对象必须有相同哈希值**”的约定。对于任何一个对象，不论是使用继承自Object的equals方法还是重写equals方法。hashCode方法实际上必须要完成的一件事情就是，**为该equals方法认定为相同的对象返回相同的哈希值**。

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

- 当线程完成任务后，会自动退出
- 还可以通过使用变量来控制run方法退出的方式停止线程，即通知方式

#### 线程常用方法

- setPriority: 线程的优先级，优先级高的线程得到的CPU资源比较多，也就是CPU优先执行优先级高的线程对象中的任务。
- yield: 线程的礼让。让出cpu，让其他线程执行，但礼让的事件不确定，所以也不一定礼让成功。
- join: 线程的插队。插队的线程一旦插队成功，**则肯定先执行完插入的线程所有的任务**。举例说明: 两个线程t1和t2，t1先开始执行了，如果在执行的过程中调用了`t2.join()`, 那么就会开始执行t2，一定是在t2执行完以后，才继续执行t1剩余的部分。见`ThreadMethod02`
- 用户线程和守护线程
  - 用户线程: 也叫工作线程，当线程的任务执行完或通知方式结束
  - 守护线程: 一般是为工作线程服务的，当所有的用户线程结束，守护线程自动结束。
  - 常见的守护线程: 垃圾回收机制

#### 线程生命周期

#### 线程同步机制

1. 一些敏感数据不允许被多个线程同时访问，此时就使用同步访问技术，保证数据在任何同一时刻，最多有一个线程访问，以保证数据的完整性。
2. 线程同步，即当有一个线程在对内存进行操作时，其他线程都不可以对这个内存地址进行操作，直到该线程完成操作，其他线程才能对该内存地址进行操作。

- 同步具体方法: **synchronized**
  - 同步代码块
  - synchronized可以放在方法声明中，表示整个方法为同步方法

#### 锁

- 概念: 锁的本质其实就是确保在同一时刻，只有一个线程在访问共享数据，那么此时该共享数据就能得到有效的保护。
- 如何加锁？一般我们都是使用`synchronized`，记住`synchronized` 锁的就是对象头
- 说明文章: <https://juejin.cn/post/6875330340534583309>

#### 互斥锁

1. 引入对象互斥锁的概念，来保证共享数据操作的完整性
2. 每隔对象都对应于一个可称为“互斥锁”的标记，这个标记用来保证在任一时刻，只能有一个线程访问该对象。
3. 关键字`synchronized`来与对象的互斥锁联系。当某个对象用`synchronized`修饰时，表明该对象在任一时刻只能由一个线程访问。
4. 同步的局限性: 导致程序的执行效率要降低
5. 同步方法(非静态)的锁可以是this，也可以是其他对象
6. 同步方法(静态)的锁为当前类本身

- 同步方法如果没有使用static修饰，默认锁对象为this
- 如果方法使用static修饰，默认锁对象是当前类.class
- 实现的落地步骤
  - 需要先分析上锁的代码
  - 选择同步代码块或同步方法
  - 要求多个线程的锁对象为同一个即可

#### 线程的死锁

- 概念: 多个线程都占用了对方的锁资源，但不肯相让，导致了死锁。

#### 释放锁

下面的操作会释放锁

1. 当前线程的同步方法、同步代码块执行结束。
2. 当前线程在同步代码块、同步方法中遇到break、return。
3. 当前线程在同步代码块、同步方法中出现了未处理的Error或Exception，导致异常结束。
4. 当前线程在同步代码块、同步方法中执行了线程对象的wait方法，档案线程暂停。

下面的操作不会释放锁

1. 线程执行同步代码块或同步方法时，程序调用Thread.sleep()、Thread.yield()方法暂停当前线程的执行，不会释放锁
2. 线程执行同步代码块时，其他线程调用了该线程的suspend()方法将该线程挂起，该线程不会释放锁。suspend()和resume()方法不再推荐使用。

### 线程有几种状态？

| NEW           | 尚未启动的线程状态，即线程创建，还未调用start方法        |
| ------------- | -------------------------------------------------------- |
| RUNNABLE      | 就绪状态（调用start，等待调度）+正在运行                 |
| BLOCKED       | 等待监视器锁时，陷入阻塞状态                             |
| WAITING       | 等待状态的线程正在等待另一线程执行特定的操作（如notify） |
| TIMED_WAITING | 具有指定等待时间的等待状态                               |
| TERMINATED    | 线程完成执行，终止状态                                   |

### IO流

##### 创建文件

- 3种方式

##### 常见的文件操作

- 目录的操作和文件删除

##### IO流原理及流的分类

- 网络资料: <https://juejin.cn/post/7233337405377593405#heading-12>
- Java IO流原理
  - 文件读取到内存是输入流。数据输出到文件就是输出流。
    - 输入input: 读取外部数据(磁盘、光盘等存储设备的数据)到程序(内存)中。
    - 输出output: 将程序(内存)数据输出到磁盘、光盘等存储设备中。
- 流的分类
  - 按操作数据单位不同: 字节流(8 bit) 二进制文件, 字符流(按字符)
    - **字节流**
      - 字节输入流(顶级父类 InputStream)
        - `FileInputStream`是从输入流读取一个字节的数据。如果没有输入可用，此方法将阻止。如果返回-1，表示读取到了最后一位，读取完毕。
          - 读取时是一个int，输出时转成char。
            - 使用的是`read()`方法，**一个字节一个字节读取**的。返回实际读取的字节数
            - 使用`read(byte[] b)`方法，从输入流读取最多b.length字节的数据到字节数组。返回实际读取的字节数
        - `BufferInputStream`及其方法
          - 字节流**可以操作二进制文件**，**可以操作文本文件**
      - 字节输出流(顶级父类OutputStream)
        - `FileOutputStream`向目标文件中写入内容。
        - `BufferOutputStream`及其方法
          - 字节流**可以操作二进制文件**，**可以操作文本文件**
    - **字符流**
      - 字符输入流(Reader)
        - `FileReader`及其相关方法
        - `BufferedReader`及其相关方法
          - 只能操作文本文件，**不能操作二进制文件**(声音，视频，doc, pdf), 可能造成文件损坏
      - 字符输出流(Writer)
        - `FileWriter`及其相关方法
          - 一定要关闭stream，或者flush这个stream，才能真正地把数据写入到文件。
        - `BufferedWriter`及其相关方法
          - 只能操作文本文件，**不能操作二进制文件**(声音，视频，doc, pdf), 可能造成文件损坏
  - 按数据流的流向不同分为:
    - 输入流
    - 输出流
  - 按流的角色的不同分为:
    - 节点流
      - 可以从一个特定的数据源读写数据，如`FileReader`, `FileWriter`
    - 处理流/包装流
      - “连接”在已存在的流(节点流或处理流)之上, 为程序提供更为强大的读写功能，也更加灵活，如`BufferedReader`, `BufferedWriter`
      - 优势:
        - 性能的提高: 主要以增加话冲的方式来提高输入输出的效率
        - 操作的便捷

##### 节点流和处理流

- 节点流
  - 概念: 节点流可以从特定的数据源读写数据，如FileReader，FileWriter
- 处理流
  - 概念: 又名包装流，是连接在已存在的流(节点流或处理流)之上，为程序提供更为强大的读写功能，也更加灵活
- 区别与联系
  - 节点流是底层流/低级流，直接跟数据源相接
  - 处理流包装节点流，既可以消除不同结点流的实现差异，也可以提供更方便的方法来完成输入输出
  - 处理流对节点流进行包装，使用了修饰器设计模式，不会与数据源相连
- 对象流
  - 序列化和反序列化
    - 序列化: 保存数据时，保存数据的值 和 数据类型
    - 反序列化: 恢复数据时，恢复数据的值 和 数据类型
  
- 标准输入输出流
  - `System.in`标准输入
  - `System.out`标准输出
- 转换流

##### 打印流 - PrintStream

##### Properties类

### 网络编程

#### 网络的相关概念

- 查看本机IP地址指令: `ipconfig`

- 做网络编程必须要知道对方的IP地址

- IP地址分成两类
  - IPV4: 用4个字节来表示IP地址的
    - 一个字节范围0-255
  - IPV6: 用16个字节来表示IP地址的
    - 使用128位表示地址
  
- IPV4地址的组成: 网络地址 + 主机地址

- 为什么要出现IPV6? IPV4最大的问题在于网络地址资源有限，IPV6能解决网络地址资源数量的问题，而且也解决了多种接入设备连入互联网的问题。

- IPV4地址分类: 5种
  - A、B、C、D、E
  
- 域名: 将IP地址映射成域名，这里怎么映射上，HTTP协议

  - 端口号: 用于标识计算机上某个特定的网络程序
    - 形式: 整数形式
    - 常见的网络端口号:
      - tomcat:8080
      - mysql:3306
      - orcle: 1521
      - sqlserver:1433

- 网络通信协议

  - 协议(TCP/IP)

- TCP和UDP

  - TCP: 传输控制协议
    - 使用TCP协议前，须先建立TCP连接，形成传输数据通道
    - 传输前，采用“三次握手”方式，是**可靠**的
    - 传输完成后，需释放已建立的连接

  - UDP: 用户数据协议
    - 将数据、源封装成数据包，不需要建立连接
    - 每个数据包限制在64K以内，不适合传输大量数据
    - 因不建立连接，故是**不可靠**的

#### TCP的三次握手

- 通过三次握手

#### InetAddress

#### Socket (套接字)

- 字节流
  - 处理二进制数据： 如果你需要传输或接收二进制数据，例如图像、音频、视频等，字节流是更合适的选择，因为它们不会对数据进行字符编码/解码，能够直接处理原始的字节数据。
  - 通用性更强： 字节流可以处理任何类型的数据，无论是文本还是二进制数据，它们不会对数据进行任何转换，适用于处理多种数据类型。
  - 性能考虑： 对于大规模的数据传输，字节流的性能通常会比字符流更好，因为字符流需要进行字符编码和解码，而字节流直接处理原始字节数据。
- 字符流
  - 处理文本数据： 如果你主要处理的是文本数据，例如配置文件、日志等，字符流会更方便，因为它们能够处理字符编码，从而确保文本数据正确地转换成字节序列和从字节序列转换回文本数据。
  - 字符编码处理： 字符流会自动进行字符编码和解码，可以确保在不同字符集之间进行正确的转换，避免乱码问题。
  - 高层次处理： 字符流提供了更高层次的数据处理功能，如一次读取一行文本（BufferedReader.readLine()），这对于处理文本文件特别有用。

#### netstat指令

- `netstat -an`可以查看当前主机网络情况，包括端口监听情况和网络连接情况

#### UDP网络通信编程

### 反射

#### Java Reflection

1. 反射机制允许程序在执行期借助于Reflection API去的任何类的内部信息，能操作对象的属性及方法
2. 加载完类之后，在堆中就会产生一个Class类型的对象(一个类只有一个Class对象)，这个对象包含了类的完整结构信息。这个Class对象就像一面镜子，可以通过这个镜子看到类的结构，所以形象地称之为: 反射。

#### Java反射机制可以完成

1. 在运行时判断任意一个对象所属的类
2. 在运行时构造任意一个类的对象
3. 在运行时得到任意一个类所具有的成语变量和方法
4. 在运行时调用任意一个对象的成员变量和方法
5. 生成动态代理

#### 反射相关的主要类

1. Class: 代表一个类，Class对象表示某个类加载后在堆中的对象
2. Method: 代表类的方法
3. Field: 代表类的成员变量
4. Constructor: 代表类的构造方法

#### Class类

1. Class也是类，因此也继承Object类
2. Class类对象不是new出来的，是系统创建的
3. 对于某个类的Class类对象，在内存中只有一份，因为类只加载一次。Class对象只创建一次，同一个类创建的不同对象对应的Class对象是同一个。
4. 每个类的实例都会记得自己是由哪个Class实例所生成
5. 通过Class对象可以完整地得到一个类的完整结构，通过一系列API
6. Class对象是存放在堆的
7. 类的字节码二进制数据，是放在方法区的，有的地方称为类的元数据。

#### 得到Class对象的各种方式 - 六种

#### 哪些类型有Class对象

#### 类加载中的动态加载和静态加载

- 静态加载: 编译时会加载相关的类, 即使没有执行case "1"也会加载这个类
- 动态加载: 当我们运行的时候，而且执行到这段代码的时候，才会加载这个类
- 类加载时机:
  - 创建对象时(new) 静态加载
  - 当子类被加载时，父类也加载    静态加载
  - 调用类中的静态成员时    静态加载
  - 通过反射    动态加载

# MySQL

### MySQL三层结构

### SQL语句分类

- DDL: 数据定义语句
- DML: 数据操作语句
- DQL: 数据查询语句
- DCL: 数据控制语句

![image-20230816150453242](C:\Users\ryanw\AppData\Roaming\Typora\typora-user-images\image-20230816150453242.png)

### 创建数据库

### 备份数据库

### 恢复数据库

### 创建表

### 修改表

### MySQL常见数据类型(列类型)

- 数值类型
  - 整型
  - 小数类型
- 文本、二进制类型
  - char 0 - 255
  - varchar 0-65535 [0 - 2^16-1]
    - char和Varchar
      - char是一个定长
      - varchar是根据输入的长度来确定的
  - text 0 - [2^32-1]
  - longtext [0 - 2^32-1]
  - blob [0 - 2^16-1]
  - longblob [0 - 2^32-1]
- 时间日期
  - date [日期 年月日]
  - time [时间 时分秒]
  - datetime [年月日 时分秒 YYYY-MM-DD HH:MM:ss]
  - timestamp [时间戳]

### `Like`, `Between And`, `In`三个关键字的使用

```sql
-- 查询英语分数在80 - 90之间
SELECT * FROM student WHERE english BETWEEN 80 AND 90;
-- 查询数学分数为89，90，91的同学
SELECT * FROM student WHERE math IN (89,90,91);

-- For search purpose
-- brush开始的
select * from sql_store.customers where last_name like 'brush%';

-- search for lastname that have 'b' in them
-- b前后可以又任意字符数
select * from sql_store.customers where last_name like '%b%';

-- 最后一位是y
select * from sql_store.customers where last_name like '%y';


-- 这样会输出lastname是两个字符的，无所谓第一个字符是什么
-- 但是第二个字符是y
-- 如果改成5个_， 那么就是lastname是6位，最后一位是y
select * from sql_store.customers where last_name like '_y';

-- 这样会输出lastname是六个字符的
-- 第一位是b，后面跟4位，最后一位是y
select * from sql_store.customers where last_name like 'b____y';
```

### MySQL中的多表查询

- 当默认情况下，当两个表查询时，规则:
  - 从第一张表中，取出一行和第二张表的每一行进行组合，返回结果[含有两张表的所有列]
  - 一共返回的记录数 = 第一张表的行数 * 第二张表的行数
  - 这样多表查询默认处理返回的结果，称为**笛卡尔集**
  - 解决这个多表的关键就是要写出正确的过滤条件 `where` 需要程序员进行分析

### MySQL中的表连接

- 何时使用哪种连接取决于查询的具体要求：

  内连接：当您要检索两个表中都有匹配值的数据，并且您对数据的交集感兴趣时使用。
  外连接：当您想包含一个表或两个表中不匹配的行，并对探索数据之间的关系（包括可能不匹配的情况）感兴趣时使用。

- 内连接例子:

  - Let's say we have two tables: `orders` and `customers`. The `orders` table contains information about orders placed by customers, and the `customers` table contains information about the customers themselves. We'll perform an inner join to retrieve a list of orders along with the corresponding customer information for those orders.

    Here's some sample data for the two tables:

    **Table: orders**
    | order_id | customer_id | order_date | total_amount |
    | -------- | ----------- | ---------- | ------------ |
    | 1        | 101         | 2023-08-01 | 150.00       |
    | 2        | 102         | 2023-08-02 | 200.00       |
    | 3        | 103         | 2023-08-03 | 75.00        |

    **Table: customers**
    | customer_id | customer_name | email               |
    | ----------- | ------------- | ------------------- |
    | 101         | John Smith    | <john@example.com>    |
    | 102         | Jane Doe      | <jane@example.com>    |
    | 103         | Michael Brown | <michael@example.com> |

    We want to retrieve a list of orders along with the customer names and email addresses for those orders. We can achieve this using an inner join as follows:

    ```sql
    SELECT o.order_id, o.order_date, o.total_amount, c.customer_name, c.email
    FROM orders o
    INNER JOIN customers c ON o.customer_id = c.customer_id;
    ```

    The result of the query would be:

    | order_id | order_date | total_amount | customer_name | email               |
    | -------- | ---------- | ------------ | ------------- | ------------------- |
    | 1        | 2023-08-01 | 150.00       | John Smith    | <john@example.com>    |
    | 2        | 2023-08-02 | 200.00       | Jane Doe      | <jane@example.com>    |
    | 3        | 2023-08-03 | 75.00        | Michael Brown | <michael@example.com> |

    In this example, the inner join retrieves only the rows where there is a matching `customer_id` in both the `orders` and `customers` tables. It combines the order information with the corresponding customer information, giving us a result that shows the customers' names and email addresses alongside their orders.

### 检索数据

#### SELECT语句

#### 分页查询

```sql
SELECT * FROM emp
 ORDER BY empno
 LIMIT 0, 3;
-- 第2页
SELECT * FROM emp 
 ORDER BY empno 
 LIMIT 3, 3;
-- 第3页
SELECT * FROM emp 
 ORDER BY empno 
 LIMIT 6, 3;
-- 推导一个公式 
# SELECT * FROM emp
#  ORDER BY empno
#  LIMIT 每页显示记录数 * (第几页-1) , 每页显示记录数
```

#### 检索单个列

#### 检索多个列

#### 检索不同的行

- 因为使用select语句的时候很可能出现同一个属性值出现多次的情况，那么如果我们想要相同属性值的行出现一次即可，我们可以使用`DISTINCT`关键字，**如果使用DISTINCT关键字，它必须直接放在列名的前面**  
  - 不能部分使用DISTINCT DISTINCT关键字应用于所有列而不仅是前置它的列。如果给出SELECT DISTINCT vend_id, prod_price，除非指定的两个列都不同，否则所有行都将被检索出来  

#### 限制结果

为了返回第一行或前几行，可使用`LIMIT`子句。带一个值的LIMIT总是从第一行开始，给出的数为返回的行数。带两个值的LIMIT可以指定从行号为第一个值的位置开始。

```sql
SELECT prod_name FROM products LIMIT 5; -- 这样就是选择1-5行

SELECT prod_name FROM products LIMIT 5,5; -- 这样就是选择6-10行
```

**行0** 检索出来的第一行为行0而不是行1。因此， LIMIT 1, 1将检索出第二行而不是第一行。

### 排序检索数据

#### `order by`关键字

- 按多个列进行排序

  - 想要使用order by来对多个列进行排序，就会先按照其中一个列进行排序，然后针对这个列再进行第二个属性进行排序。示例说明:

    ![image-20230820124333070](C:\Users\ryanw\AppData\Roaming\Typora\typora-user-images\image-20230820124333070.png)

    ORDER BY子句的位置 在给出ORDER BY子句时，应该保证它位于FROM子句之后。如果使用LIMIT，它必须位于ORDER BY之后。使用子句的次序不对将产生错误消息。**这个子句必须是SELECT语句中的最后一条子句**。

### 分组数据

#### 使用GROUP BY关键字

- GROUP BY替代WHERE的原因: WHERE不能完成任务，因为**WHERE过滤指定的是行而不是分组**
- 不使用WHERE使用什么呢？MySQL为此目的提供了另外的子 句，那就是HAVING子句。HAVING非常类似于WHERE。事实上，目前为止所 学过的所有类型的WHERE子句都可以用HAVING来替代。唯一的差别是 WHERE过滤行，而HAVING过滤分组

#### SELECT子句及其顺序

![image-20230824115657581](C:\Users\ryanw\AppData\Roaming\Typora\typora-user-images\image-20230824115657581.png)

![image-20230824115709540](C:\Users\ryanw\AppData\Roaming\Typora\typora-user-images\image-20230824115709540.png)

### MySQL中的表外连接

### MySQL中的外键使用

- 外键约束要定义在从表中，主表则必须具有**主键约束**或是**unique约束**。当定义外键约束后，要求外键列数据必须在主表的主键列存在或是为null
  - 外键指向的表的字段，要求是primary key或者是unique
  - 表的类型必须是innodb，这样才能支持外键
  - 外键字段的类型要和主键字段的类型一致(长度可以不同)
  - 外键字段的值，必须在主键字段中出现过，或者为null[**前提是外键字段允许为null，也就是说FK没有定义NOT NULL**]
  - 一旦建立主外键关系，数据不能随意删除了。

### MySQL中的自增长

- `auto_increment`的使用细节
  - 一般来说自增长和primary key一起使用
  - 自增长也可以单独使用[但是需要配合一个unique]
  - 自增长修饰的字段为整数型的
  - 自增长默认从1开始，也可以通过命令修改
  - 如果你添加数据时，给自增长字段指定的有值，则以指定的值为准，**如果指定了自增长，一般来说，就按照自增长的规则来添加数据**

### MySQL中的索引

#### 索引的原理

- 没有索引为什么查询会慢？因为它是全表扫描
- 使用索引为什么查询会快？形成一个索引的数据结构，比如二叉树
- 索引的代价:
  - 磁盘占用
  - 对update、delete、insert语句的效率影响
- 索引的类型
  - 主键索引：主键自动地为主索引
  - 唯一索引(unique)
  - 普通索引(index)
  - 全文索引(fulltext)
- 哪些列上适合使用索引？
  - 较频繁地作为查询条件字段应该创建索引
  - 唯一性太差的字段不适合单独创建索引，即使频繁作为查询条件
  - 更新非常频繁的字段不适合创建索引
  - 不会出现在where子句中的字段不该创建索引

### MySQL事务

- 回退事务: 在介绍回退事务前，先介绍一下保存点(savepoint)。保存点是事务中的点，用于取消部份事务，当结束事务时(commit)，会自动地删除该事务所定义的所有保存点。当执行回退事务时，通过指定保存点可以回退到指定的点。
- 提交事务: 使用commit语句可以提交事务。

#### MySQL事务隔离级别

- 脏读: 一个事务读取另一个事务**未提交**的修改(update, insert, delete)时，产生幻读
- 不可重复读: **修改**和**删除**已**提交**的事务, 每次返回不同的数据集
- 幻读: 其他**提交**事务的**插入**(添加)操作, 每次返回不同的数据集

![image-20230815164721670](C:\Users\ryanw\AppData\Roaming\Typora\typora-user-images\image-20230815164721670.png)

- 不应该出现这样情况的原因是因为，想要在第二个连接到数据库的时候，看到数据库中的数据就是我看到那一个瞬间的数据，而不能够受到其他连接到数据库所修改产生的影响。比如我在10点01分访问数据库，我看到的应该是10点01分之前在数据库中保存的数据的情况，不能是有其他另一个数据库的连接，在10点02分修改了数据库中的数据，导致我看到的数据也变成了修改过后的数据。

#### MySQL事务ACID

- 原子性(Atomicity):
- 一致性(Consistency):
- 隔离性(Isolation):
- 持久性(Durability):

### MySQL表类型和存储引擎

- 如何选择表的存储引擎
  - 如果应用不需要事务，处理的指示基本的CRUD操作，那么MyISAM是不二选择，速度快
  - 如果需要支持事务，选择InnoDB
  - Memory存储引擎就是将数据存储在内存中，由于没有磁盘IO的等待，速度极快，但由于是内存存储引擎，所做的任何修改在服务器重启后都将小时

### MySQL视图(view)

- 基本概念
  - 视图是根据基表来创建的，视图是虚拟的表
  - 视图也有列，数据来自基表
  - 通过视图可以修改基表的数据
  - 基表的改变也会影响到视图的数据
- 使用视图的原因是因为想让基表上的某些数据看不到(隐藏)，使用视图来映射一个表出来，显示的都是可以看到的数据。

### MySQL管理

### MySQL中的存储过程

### MySQL中的游标

- MySQL检索操作返回一组称为结果集的行。这组返回的行都是与SQL语句相匹配的行（零行或多行）。使用简单的SELECT语句，例如，没有办法得到第一行、下一行或前10行，也不存在每次一行地处理所有行的简单方法（相对于成批地处理它们）
- 有时，需要在检索出来的行中前进或后退一行或多行。这就是使用游标的原因。
- **MySQL游标只能用于存储过程**（和函数）

### MySQL的额外知识点

#### SELECT语句的相关额外知识点

- 在使用简单的select语句的时候，检索出来的结果并不是完全随机的。如果不使用`order by`进行排序，数据一般将以它在底层表中出现的顺序显示。可以是数据最初添加到表中的顺序。但是，如果数据后来进行过更新或删除，则此顺序将会受到MySQL重用回收存储空间的影响。  
- 关系数据库设计理论认为，如果不明确规定排序顺序，则不应该假定检索出的数据的顺序有意义。

- `WITH ROLLUP`关键字与`GROUP BY`关键字的使用

以下是一个名为employee_tbl的表的示例，包含id、name、date和signin等列：

| **id** | **name** | **date**   | **signin** |
| :----- | :------- | :--------- | :--------- |
| 1      | Alice    | 2023-08-01 | 2          |
| 2      | Alice    | 2023-08-02 | 3          |
| 3      | Bob      | 2023-08-01 | 1          |
| 4      | Bob      | 2023-08-02 | 4          |
| 5      | Bob      | 2023-08-03 | 2          |

如果我们想要按照名字分组，并统计每个人有多少条记录，可以使用以下SQL语句：

```sql
SELECT name, COUNT(*) FROM employee_tbl GROUP BY name;
```

输出结果如下：

| **name** | **COUNT(\*)** |
| :------- | :------------ |
| Alice    | 2             |
| Bob      | 3             |

如果想要在分组统计数据的基础上再进行相同的统计（SUM、AVG、COUNT等），可以使用WITH ROLLUP。例如，我们将以上的数据表按名字进行分组，再统计每个人登录的次数：

```sql
SELECT name, SUM(signin) as signin_count FROM employee_tbl GROUP BY name WITH ROLLUP;
```

输出结果如下：

| **name** | **signin_count** |
| :------- | :--------------- |
| Alice    | 5                |
| Bob      | 7                |
| NULL     | 12               |

其中记录NULL表示所有人的登录次数。如果名字为空，我们可以使用总数代替：

```sql
SELECT coalesce(name, '总数'), SUM(signin) as signin_count FROM employee_tbl GROUP BY name WITH ROLLUP;
```

输出结果如下：

| **coalesce(name, ‘总数’)** | **signin_count** |
| :------------------------- | :--------------- |
| Alice                      | 5                |
| Bob                        | 7                |
| 总数                       | 12               |

**所以相当于使用了WITH ROLLUP关键字以后，多了一行NULL的行吗？**

是的，使用WITH ROLLUP关键字后，查询结果将包含分组统计数据以及小计和总计。其中记录NULL表示所有人的登录次数。如果名字为空，我们使用总数代替。如果您不使用WITH ROLLUP，那么查询结果将只包含分组统计数据，而不会生成小计和总计。

#### 子查询、内部联结、自联结、自然联结、外部联结

- 自联结和子查询: 用自联结而不用子查询, 自联结更快
- 标准的联结返回所有数据，甚至相同的列多次出现。 **自然联结**排除多次出现，使每个列只返回一次。
- 联结包含了那些在相关表中没有关联行的行。这种类型的联结称为**外部联结**。
  - **与内部联结关联两个表中的行不同**的是，外部联结还包括没有关联行的行。  
  - 在使用OUTER JOIN语法时，必须使用RIGHT或LEFT关键字指定包括其所有行的表（ RIGHT指出的是OUTER JOIN右边的表，而LEFT指出的是OUTER JOIN左边的表）  

##### 区分概念

当涉及到多表查询和数据连接时，不同的操作可以用于检索、过滤和组合数据。以下是子查询、内部联结、自联结、自然联结和外部联结的区别：

1. **子查询（Subquery）：**
   子查询是**一个查询嵌套在另一个查询内部的查询语句**。它可以返回一个结果集，然后该结果集可以用于主查询中的条件。子查询用于检索数据，可以在 SELECT、WHERE、FROM 和 HAVING 子句中使用。

   ```sql
   SELECT column1, column2
   FROM table1
   WHERE column1 IN (SELECT column1 FROM table2);
   ```

2. **内部联结（Inner Join）：**
   内部联结是通过**比较两个或多个表的列之间的值**来合并数据的方式。它**只返回匹配的行**，即只返回在连接列上有匹配值的行。

   ```sql
   SELECT orders.order_id, customers.customer_name
   FROM orders
   INNER JOIN customers ON orders.customer_id = customers.customer_id;
   ```

3. **自联结（Self Join）：**
   自联结是将**同一个表与其自身进行联结**。它**在表中的不同行之间创建连接**，类似于将表复制一遍，然后在其中一个表中查询另一个表中的数据。

   ```sql
   SELECT e1.employee_name, e2.manager_name
   FROM employees e1
   INNER JOIN employees e2 ON e1.manager_id = e2.employee_id;
   ```

4. **自然联结（Natural Join）：**
   自然联结是基于列名的联结，它自动根据表之间的相同列名进行联结。它会**返回所有列名相同且具有相同值的行。**

   ```sql
   SELECT customers.customer_id, orders.order_id, orders.order_date
   FROM customers
   NATURAL JOIN orders;
   ```

5. **外部联结（Outer Join）：**
   外部联结通过比较两个或多个表的列之间的值来合并数据，**与内部联结不同的是，外部联结可以包括未匹配的行**。有**三种类型**的外部联结：左外部联结、右外部联结和全外部联结。

   - 左外部联结（Left Outer Join）：

   ```sql
   SELECT customers.customer_name, orders.order_id
   FROM customers
   LEFT OUTER JOIN orders ON customers.customer_id = orders.customer_id;
   ```

   - 右外部联结（Right Outer Join）：

   ```sql
   SELECT orders.order_id, order_items.product_id
   FROM orders
   RIGHT OUTER JOIN order_items ON orders.order_id = order_items.order_id;
   ```

   - 全外部联结（Full Outer Join）通常需要用到 `UNION`：

   ```sql
   SELECT customers.customer_id, orders.order_id
   FROM customers
   LEFT OUTER JOIN orders ON customers.customer_id = orders.customer_id
   UNION
   SELECT customers.customer_id, orders.order_id
   FROM orders
   LEFT OUTER JOIN customers ON customers.customer_id = orders.customer_id
   WHERE customers.customer_id IS NULL;
   ```

总结：

- **子查询** 用于嵌套在其他查询内部，提供一个子集的数据作为条件。
- **内部联结** 用于合并具有匹配值的行。
- **自联结** 是将一个表自身与另一个别名表进行联结，用于查询表中的不同行之间的关系。
- **自然联结** 根据列名自动进行联结，返回具有相同值的所有列。
- **外部联结** 可以包括未匹配的行，有左、右和全三种类型。

# JDBC

### JDBC基础

### Statement

- Statement [存在SQL注入]
- PreparedStatement [预处理]
  - 好处:
    - 不再使用 '+' 拼接sql语句，减少语法错误
    - 有效地解决了sql注入问题
    - 大大减少了编译次数，效率较高
- CallableStatement [存储过程]

- 为什么我们更多地使用PreparedStatement而不是Statement呢? 因为Statement存在SQL注入

### JDBC APIs

### 批处理

1. 当需要成批插入或者更新记录时，可以采用Java的批量更新机制，**这一机制允许多条语句一次性提交给数据库批量处理**
2. JDBC连接MySQL时，如果要使用批处理功能，请再url中加参数?rewriteBatchedStatements=true
3. 批处理往往和PreparedStatement一起搭配使用，可以既

### 数据库连接池

- 传统获取Connection问题:
  - 连接使用DriverManager来获取，每次向数据库连接的时候都要将Connection加载道内存中，再验证IP地址，用户名，密码。需要数据库连接的时候，就向数据库要求一个，这样占用很多系统资源。
  - 为了解决传统开发中的数据库连接问题，可以采用数据库连接池技术
- 数据库连接池种类
  - C3P0
  - Druid
    - 解释为什么Druid形式的JDBC不需要在使用后断开连接的原因：
      - 连接复用：Druid连接池会在应用程序启动时初始化一组数据库连接，这些连接可以被重复利用，而不是每次都重新创建连接。这样可以减少数据库服务器上的连接开销，提高性能。当应用程序使用完一个连接后，并不会立即关闭它，而是将其放回连接池，以供其他部分的代码重用。
      - 连接状态维护：Druid连接池会在连接使用完成后，通过将连接还给连接池，自动将连接的状态重置为初始状态。这意味着连接的各种状态（如事务、会话状态等）不会被保留到下一次使用，从而避免了潜在的问题。
      - 减少连接开销：建立和断开连接是一项相对昂贵的操作，需要与数据库进行网络通信等。Druid连接池通过复用连接，避免了频繁的连接开关操作，从而降低了连接的维护成本。
      - 连接池管理：Druid连接池会对连接进行管理，包括连接的空闲时间、最大连接数、最小连接数等参数的配置。这可以帮助应用程序根据需求来动态地管理连接的数量，以达到最佳的性能和资源利用率。
      - 总之，Druid连接池的设计理念在于通过连接的复用和自动管理，减少数据库连接的创建和关闭开销，从而提高应用程序的性能和可靠性。这也是为什么使用Druid形式的JDBC连接时，不需要手动断开连接，而是由连接池来管理连接的生命周期。

### DAO和增删改查通用方法

- 虽然Druids简化了JDBC开发，但还有不足:
  - SQL语句固定，通用性不好，为了更方便增删改查

# Java 8的新特性

1. **Lambda 表达式：** 
2. **函数式接口：**
3. **Stream API：** 
4. **默认方法和静态方法：**
5. **新的日期和时间 API：**
6. **方法引用：** 
7. **Optional 类：**
8. **Nashorn JavaScript 引擎：**
9. **新的并发特性：**
10. **重复注解：**
11. **PermGen 被移除：**
