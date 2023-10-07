# Java

## 进入Basics阶段

### 变量

### 程序控制结构

### 数组、排序和查找

### 面向对象基础

### 面向对象中级

## 进入Beginner阶段

### 面向对象高级

#### 类变量 - static关键字

#### 代码块 - 属于类中的成员，类似于方法

#### 设计模式

#### Final关键字

#### 抽象类以及抽象方法 `abstract`

#### 接口 Interface

#### 内部类

#### 枚举 Enumeration

#### 注解 Annotations

## 进入Intermediate阶段

### 异常 - Exception

### 常用类

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

##### LinkedHashSet

1. LinkedHashSet是HashSet的子类，底层是一个LinkedHashMap，底层维护了一个hash表和双向链表
2. LinkedHashSet根据元素的hashCode值来决定元素的存储位置，使用链表维护元素的次序，这使得元素看起来是以插入顺序保存的
3. LinkedHashSet**不允许添重复元素**

#### HashMap

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
