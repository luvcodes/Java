# String类的特点

- 字符串不可变，它们的值在创建后不能被更改
- 虽然 String 的值是不可变的，但是它们可以被共享
- **字符串效果上相当于字符数组( char[] )，但是底层原理是字节数组( byte[] )**

# String类的构造方法

## 创建字符串对象的两种方式

[![](https://cdn.nlark.com/yuque/0/2024/png/38953059/1707403556716-992c907e-730f-4ed7-8131-cd435d2e0c4b.png)](https://cdn.nlark.com/yuque/0/2024/png/38953059/1707403556716-992c907e-730f-4ed7-8131-cd435d2e0c4b.png)

```Java
public class StringDemo1 {
    public static void main(String[] args) {
        //1.使用直接赋值的方式获取一个字符串对象
        String s1 = "abc";
        System.out.println(s1);

        //2.使用new的方式来获取一个字符串对象
        String s2 = new String();
        System.out.println("@" + s2 + "!");

        String s3 = new String("abc");
        System.out.println(s3);

        // 3. 传递一个字符数组，根据字符数组的内容再创建一个新的字符串对象
        char[] chs = {'a', 'b', 'c', 'd'};
        String s4 = new String(chs);
        System.out.println(s4);

        // 4. 传递一个字节数组，根据字节数组的内容 ASCII码转换 再创建一个新的字符串对象
        byte[] bytes = {97, 98, 99, 100};
        String s5 = new String(bytes);
        System.out.println(s5);
    }
}
```

### 内存模型

### 直接赋值

**字符串常量池**（String Pool）是Java的一个特殊区域，用于**存储由字面量创建的字符串**。

```Java
String str = "hello";
```

这个字符串字面量 "hello" 会被存储在字符串常量池中。如果**后续有相同的字面量**，Java会**重用字符串常量池**中的这个字符串，而**不是创建一个新的**。

以`""`方式给出的字符串，只要字符序列相同(顺序和大小写)，无论在程序代码中出现几次，JVM 都只会建立一个 String 对象，并在字符串池中维护。

### new String()

[![](https://cdn.nlark.com/yuque/0/2024/png/38953059/1707781620592-e3fa4ae0-5aa6-4db2-899a-0b7ff7d32232.png)](https://cdn.nlark.com/yuque/0/2024/png/38953059/1707781620592-e3fa4ae0-5aa6-4db2-899a-0b7ff7d32232.png)

通过 `new String()` 显式创建的字符串对象总是在堆内存中创建一个新的对象，每一次 new 都会申请一个内存空间，即使内容相同的字符串已经存在于字符串常量池中, 但是地址值不同。

但是，当你通过某些方法创建新的字符串，如：

```Java
String newStr = str.toUpperCase();
```

这时，`newStr`**指向的 "HELLO" 字符串通常会在堆内存中创建**，**而不是字符串常量池**。

### intern()

如果你希望确保字符串对象引用常量池中的版本，可以使用 `intern()` 方法。

- 此方法会检查字符串是否存在于常量池中，如果存在，它返回常量池中的字符串引用；
- 如果不存在，它会将字符串添加到常量池，并返回这个新添加的字符串引用。

示例代码:

```Java
public class StringInternExample {
    public static void main(String[] args) {
        // 创建两个相同内容但不同引用的字符串
        String s1 = new String("Hello");
        String s2 = "Hello";

        // 检查s1和s2是否是同一个引用
        System.out.println("Before intern()");
        System.out.println("s1 == s2: " + (s1 == s2));  // 应输出 false

        // 使用intern方法，尝试优化s1的存储
        s1 = s1.intern();

        // 再次检查s1和s2是否是同一个引用
        System.out.println("After intern()");
        System.out.println("s1 == s2: " + (s1 == s2));  // 应输出 true
    }
}
```

总的来说，由**字面量创建的字符串通常存储在字符串常量池**中，而**通过某些操作或方法创建的新字符串通常存储在堆内存**中。

## Java中String创建过程

[https://juejin.cn/post/6988125661751672846](https://juejin.cn/post/6988125661751672846)

# 字符串的比较

## **String的==比较**

[![](https://cdn.nlark.com/yuque/0/2024/png/38953059/1707403781763-6a8879fe-2775-4db7-8801-74d4e397f4ad.png)](https://cdn.nlark.com/yuque/0/2024/png/38953059/1707403781763-6a8879fe-2775-4db7-8801-74d4e397f4ad.png)

[![](https://cdn.nlark.com/yuque/0/2024/png/38953059/1707403786996-331e6d1a-380a-4211-86a2-266d07f526d5.png)](https://cdn.nlark.com/yuque/0/2024/png/38953059/1707403786996-331e6d1a-380a-4211-86a2-266d07f526d5.png)

# 遍历字符串

```Java
public class Test2 {
    public static void main(String[] args) {
        //两个方法：
        //charAt()：会根据索引获取对应的字符
        //length(): 会返回字符串的长度

        //1.键盘录入一个字符串
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入字符串");
        String str = sc.next();
        System.out.println(str);

        //2.遍历
        for (int i = 0; i < str.length(); i++) {
            //i 依次表示字符串的每一个索引
            //索引的范围：0 ~  长度-1

            //根据索引获取字符串里面的每一个字符
            //ctrl + alt + V 自动生成左边的接受变量
            char c = str.charAt(i);
            System.out.println(c);
        }
    }
}
```

# StringBuilder

StringBuilder 是 Java 中的一个可变字符序列。与不可变的 String 类不同，**StringBuilder 允许更改、添加或删除字符**，而**不会像 String 操作那样每次都生成一个新的对象**。这使得 StringBuilder 在处理大量的字符串操作时更加高效，特别是在进行字符串拼接的时候。

## 关键特性

- 可变性：可以在**不创建新对象的情况下修改字符串**。
- 性能：比使用 String 进行多次串联操作更高效。
- 非线程安全：与 StringBuffer 相比，StringBuilder 不是线程安全的，但在单线程环境下性能更好。

## 常用方法

[![](https://cdn.nlark.com/yuque/0/2024/png/38953059/1707403829733-3637a799-b708-44d6-8ed2-3fb44c8b63b0.png)](https://cdn.nlark.com/yuque/0/2024/png/38953059/1707403829733-3637a799-b708-44d6-8ed2-3fb44c8b63b0.png)

1. 构造方法：

- StringBuilder()：构造一个无字符的字符串构建器。
- StringBuilder(int capacity)：构造一个指定初始容量的字符串构建器。
- StringBuilder(String str)：构造一个初始化为指定字符串内容的字符串构建器。

1. 添加和插入：

- append(...)：将参数添加到序列的末尾。这个方法有多个重载形式，可以接受不同类型的数据（如 int, long, String, char 等）。
- insert(int offset, ...)：在指定位置插入参数。这个方法也有多个重载形式，允许插入不同类型的数据。

1. 删除和替换：

- delete(int start, int end)：删除序列中从 start 到 end 位置之间的内容。
- deleteCharAt(int index)：删除指定位置的字符。
- replace(int start, int end, String str)：使用给定的字符串替换序列中从 start 到 end 位置之间的内容。

1. 反转和长度：

- reverse()：将此字符序列用其反转形式取代。
- length()：返回当前长度（字符数）。
- setLength(int newLength)：设置字符序列的长度。

1. 其他功能：

- toString()：将字符序列转换为 String。
- charAt(int index)：返回指定位置的字符。
- substring(int start, int end)：返回一个新的 String，它包含此序列中从 start 到 end 位置的字符。

### 使用示例

```Java
StringBuilder sb = new StringBuilder("Hello");
sb.append(" World"); // 现在字符串为 "Hello World"
sb.insert(6, "Java "); // 现在字符串为 "Hello Java World"
sb.delete(6, 11); // 删除 "Java "，现在字符串为 "Hello World"
sb.replace(6, 11, "Earth"); // 替换 "World" 为 "Earth"，现在字符串为 "Hello Earth"
sb.reverse(); // 字符串反转，现在字符串为 "htraE olleH"
String result = sb.toString(); // 转换为String
```

这些是 StringBuilder最常用的方法和基本用法。使用 StringBuilder可以显著提高在循环或频繁操作中字符串拼接的效率。

# String、StringBuffer 和 StringBuilder 区别？

**StringBuilder 和 StringBuffer 都是 Java 中用于处理字符串的类**，它们**提供了在字符串上执行修改操作的方法**，如添加、删除和替换字符。但它们之间存在一些关键的差异：

1. StringBuilder：

- **不是线程安全的**：这意味着在多线程环境中，多个线程可以同时修改一个StringBuilder对象，可能导致数据不一致。StringBuilder在修改字符串时，会尽量复用已有的字符数组，避免重新分配内存，因此性能较好。
- 由于其非线程安全性，**性能**通常比StringBuffer**更好**，因为它不需要进行同步操作。
- 在单线程环境中，**如果不需要线程安全，通常建议使用StringBuilder**。

1. StringBuffer：

- 是**线程安全**的：StringBuffer内部的方法大多数都是同步的，这意味着在多线程环境中，只有一个线程可以在特定时间内修改StringBuffer对象，因此性能较差。
- 由于其线程安全性，**性能**可能比StringBuilder稍**差**，因为它需要进行同步操作。
- 如果需要在多线程环境中操作字符串，建议使用StringBuffer。
- StringBuffer使用构造器创建初始是开创一块size为16的char类型的数组

```Java
// 构造器的使用:
// 1. 创建一个 大小为16的 char[], 用于存放字符内容
StringBuffer stringBuffer = new StringBuffer();

// 2. 通过构造器指定 char[] 大小
StringBuffer stringBuffer1 = new StringBuffer(100);

// 3. 通过给一个String 创建 StringBuffer, char[] 大小就是str.length() + 16
StringBuffer stringBuffer2 = new StringBuffer("hello");
```

1. String:

- 在**修改字符串时，会创建一个新的String对象**，并**将原来的对象引用指向新的对象**。因此，String的性能最佳，但在修改字符串时会产生额外的开销，造成资源浪费。

## 为什么需要它们？

在Java中，String对象是不可变的，这意味着一旦创建了一个String对象，就不能更改它。如果需要频繁地修改字符串，例如在循环中添加、删除或替换字符，使用String可能会导致性能问题，因为每次修改都会创建一个新的String对象。而StringBuilder和StringBuffer提供了一种可变的方式来处理字符串，使得字符串的修改更加高效。

如果需要多线程访问字符串，则应使用StringBuffer；

如果不需要多线程访问字符串，但需要频繁修改字符串，则应使用StringBuilder；

如果不需要频繁修改字符串，则应使用String。

总体来说，如果不需要线程安全，StringBuilder 通常是更好的选择，因为它提供了与 StringBuffer 相似的 API，但由于没有同步机制，所以更快。如果需要线程安全，StringBuffer 是更好的选择。

# StringJoiner

String直接创建效率低，StringBuilder代码复杂。引出StringJoiner。

- StringJoiner跟StringBuilder一样，也可以看成是一个容器，创建之后里面的内容是可变的。
- 作用：提高字符串的操作效率，而且代码编写特别简洁，但是目前市场上很少有人用。
- JDK8出现的

基本使用：

```Java
//1.创建一个对象，并指定中间的间隔符号
StringJoiner sj = new StringJoiner("---");
//2.添加元素
sj.add("aaa").add("bbb").add("ccc");
//3.打印结果
System.out.println(sj);//aaa---bbb---ccc
```

```Java
//1.创建对象
StringJoiner sj = new StringJoiner(", ","[","]");
//2.添加元素
sj.add("aaa").add("bbb").add("ccc");
int len = sj.length();
System.out.println(len);//15
//3.打印
System.out.println(sj);//[aaa, bbb, ccc]
String str = sj.toString();
System.out.println(str);//[aaa, bbb, ccc]
```

## 对比StringJoiner和StringBuilder

**功能**

- **StringBuilder** 主要用于**修改**现有字符串。它提供了一系列方法来追加、插入和删除字符或子字符串。**StringBuilder 是可变的**，这意味着它的内容可以被修改。
- **StringJoiner** 主要用于**连接**多个字符串。它提供了一个 `add()` 方法来添加字符串，并允许指定分隔符和前缀/后缀。**StringJoiner 是不可变的**，这意味着一旦创建就不能修改其内容。

**性能**

- **StringBuilder** 通常比 StringJoiner 更快，因为它避免了创建新的字符串对象。在循环中拼接字符串时，这尤其重要。
- **StringJoiner** 在需要在字符串之间插入分隔符或前缀/后缀的情况下更有效。

**线程安全性**

- **StringBuilder** 是非线程安全的，这意味着多个线程不能同时修改同一个 StringBuilder 对象。如果需要在多线程环境中使用 StringBuilder，则必须使用同步机制。
- **StringJoiner** 是线程安全的，这意味着多个线程可以安全地同时使用同一个 StringJoiner 对象。

**其他**

- **StringBuilder** 可以用于更复杂的字符串操作，例如反转字符串或替换子字符串。
- **StringJoiner** 更易于使用，因为它具有更简单的 API。

**总结**

|   |   |   |
|---|---|---|
|**特性**|**StringBuilder**|**StringJoiner**|
|主要用途|修改现有字符串|连接多个字符串|
|性能|通常更快|在需要分隔符/前缀/后缀时更有效|
|线程安全性|非线程安全|线程安全|
|其他|可用于更复杂的字符串操作|更易于使用|

## **选择哪一个？**

在大多数情况下，**StringBuilder** 是拼接字符串的更好选择。它更快、更灵活，并且可以用于更复杂的字符串操作。但是，如果需要在字符串之间插入分隔符或前缀/后缀，或者需要在多线程环境中使用，则 **StringJoiner** 可能是更好的选择。

- **使用 StringBuilder** 用于以下情况：
    - 需要修改现有字符串
    - 在循环中拼接字符串
    - 需要执行更复杂的字符串操作
- **使用 StringJoiner** 用于以下情况：
    - 需要连接多个字符串
    - 需要在字符串之间插入分隔符或前缀/后缀
    - 需要在多线程环境中使用字符串拼接

# 字符串原理

## 字符串拼接的底层原理

### 不涉及多个变量

[![](https://cdn.nlark.com/yuque/0/2024/png/38953059/1707403631915-406b1ce0-04b3-44c9-9cea-f0b6ab9a1150.png)](https://cdn.nlark.com/yuque/0/2024/png/38953059/1707403631915-406b1ce0-04b3-44c9-9cea-f0b6ab9a1150.png)

### **涉及多个变量**

涉及多个变量的时候，就需要创建 StringBuilder 对象来拼接字符串，然后再调用 StringBuilder 的 toString 方法。

[![](https://cdn.nlark.com/yuque/0/2024/png/38953059/1707403651480-7ba76187-1fc5-4b04-9301-3312a3aeac6a.png)](https://cdn.nlark.com/yuque/0/2024/png/38953059/1707403651480-7ba76187-1fc5-4b04-9301-3312a3aeac6a.png)

[![](https://cdn.nlark.com/yuque/0/2024/png/38953059/1707403661891-4680cf12-17fe-4b8d-b433-eb1e389a4d87.png)](https://cdn.nlark.com/yuque/0/2024/png/38953059/1707403661891-4680cf12-17fe-4b8d-b433-eb1e389a4d87.png)

### **JDK8字符串拼接的底层原理**

[![](https://cdn.nlark.com/yuque/0/2024/png/38953059/1707403682771-8d4ede51-439f-4f33-92f6-7534c620fe35.png)](https://cdn.nlark.com/yuque/0/2024/png/38953059/1707403682771-8d4ede51-439f-4f33-92f6-7534c620fe35.png)

[![](https://cdn.nlark.com/yuque/0/2024/png/38953059/1707403694121-1902eabf-60ab-4b89-a0ae-1f9069c24722.png)](https://cdn.nlark.com/yuque/0/2024/png/38953059/1707403694121-1902eabf-60ab-4b89-a0ae-1f9069c24722.png)

## **总结**

[![](https://cdn.nlark.com/yuque/0/2024/png/38953059/1707403729021-b5a32bab-05b7-4f59-8765-ee97a6c34028.png)](https://cdn.nlark.com/yuque/0/2024/png/38953059/1707403729021-b5a32bab-05b7-4f59-8765-ee97a6c34028.png)

# **练习题1**

[![](https://cdn.nlark.com/yuque/0/2024/png/38953059/1707403746954-a6ed54a5-a6ee-4331-9b7d-e7b6533efb64.png)](https://cdn.nlark.com/yuque/0/2024/png/38953059/1707403746954-a6ed54a5-a6ee-4331-9b7d-e7b6533efb64.png)

[![](https://cdn.nlark.com/yuque/0/2024/png/38953059/1707781257309-ca9cc46e-5d14-4073-9c59-fe4d347983bf.png)](https://cdn.nlark.com/yuque/0/2024/png/38953059/1707781257309-ca9cc46e-5d14-4073-9c59-fe4d347983bf.png)

# 练习题2

```Java
String s1 = "coder";
String s2 = "coder";
String s3 = "coder" + s2;
String s4 = "coder" + "coder";
String s5 = s1 + s2;
System.out.println(s3 == s4);
System.out.println(s3 == s5);
System.out.println(s4 == "codercoder");
```

在Java中，字符串的处理方式，特别是在字符串字面量、字符串内部化（interning）和字符串连接方面，可能有些难以理解。让我们分析一下你提供的代码片段：

1. `String s1 = "coder";` 和 `String s2 = "coder";` - 这里，`s1` 和 `s2` 都引用了字符串池中的同一个字符串字面量 "coder"。
2. `String s3 = "coder" + s2;` - 在这种情况下，`s3` 通过连接一个字符串字面量和一个字符串引用（`s2`）来创建。这是在运行时发生的，因此 `s3` 不是引用字符串池中的字符串，而是一个新的字符串对象。
3. `String s4 = "coder" + "coder";` - 这里，`s4` 是通过连接两个字符串字面量创建的。Java编译器将其优化为单个字符串字面量 "codercoder"，并将其内部化到字符串池中。
4. `String s5 = s1 + s2;` - 类似于 `s3`，`s5` 是通过连接两个字符串引用在运行时创建的，结果是一个新的字符串对象。

现在，让我们来看看 `println` 语句：

- `System.out.println(s3 == s4);` - 这比较了 `s3` 和 `s4` 的引用。由于 `s3` 是在运行时创建的字符串，而 `s4` 是编译时的字面量，它们引用了不同的对象。输出将是 `false`。
- `System.out.println(s3 == s5);` - `s3` 和 `s5` 都是通过连接字符串在运行时创建的。然而，它们是分别创建的不同对象，所以这个比较也将是 `false`。
- `System.out.println(s4 == "codercoder");` - 这里，`s4` 和 `"codercoder"` 都引用了字符串池中的同一个内部化字符串。所以，这个比较将是 `true`。

总结一下，你的代码的输出将是：

```Java
false
false
true
```

# 字面量创建和new String创建字符串

[![](https://cdn.nlark.com/yuque/0/2023/png/38953059/1703251122438-e50b70cc-fc2d-44e1-92c3-12ffd27f83b9.png)](https://cdn.nlark.com/yuque/0/2023/png/38953059/1703251122438-e50b70cc-fc2d-44e1-92c3-12ffd27f83b9.png)

在字符串常量池中，独立于它们是如何被引用的，相同内容的字符串只会有一个实例。这就是**字符串常量池的目的**：它确保了**所有相同的字符串字面量都指向池中的同一个对象实例**，以**减少内存占用和提高性能**。

1. **栈内存中的** `**str**` **变量指向** `**"hello"**`:

- 当您使用字面量方式创建字符串，如 `String str = "hello";`，`str` 将直接指向字符串常量池中的 `"hello"`。

1. **堆内存上的** `**new String("hello")**` **对象**:

- 当您使用 `new String("hello")` 创建一个新的 `String` 对象，这个对象在堆上，并且内部包含一个指向字符串常量池中 `"hello"` 的引用。

在这两种情况下，字符串常量池中的 `"hello"` 是同一个对象。无论是 `str` 变量还是通过 `new` 关键字创建的 `String` 对象，它们都引用了字符串常量池中相同的 `"hello"` 字符串实例。

总结来说，**字符串常量池中的一个特定字符串（如 "hello"）只存在一个唯一的实例**，无论它被多少个变量或对象引用。这就是为什么字符串常量池可以有效地减少重复字符串的内存占用，并在字符串处理中提供性能优势。您的理解基本正确，但需要一点澄清。让我们逐步分解这两种情况：

### 当字符串常量池中不存在 "hello"

1. **栈内存**: `str` 变量存在于栈内存中。
2. **堆内存**: 使用 `new String("hello")` 在堆上创建一个新的 `String` 对象。
3. **字符串常量池**: 字符串字面量 `"hello"` 被存储在字符串常量池中，如果它之前不存在的话。
4. **引用关系**:

- `str` 变量在栈上引用了堆上的 `String` 对象。
- 堆上的 `String` 对象包含了指向字符串常量池中 `"hello"` 的引用。

### 当字符串常量池中已存在 "hello"

1. **栈内存**: `str` 变量依然存在于栈内存中。
2. **堆内存**: 使用 `new String("hello")` 仍然会在堆上创建一个新的 `String` 对象，即使 `"hello"` 已经存在于字符串常量池中。
3. **字符串常量池**: `"hello"` 已经存在，不会重复创建。
4. **引用关系**:

- `str` 变量在栈上引用了堆上的 `String` 对象。
- 堆上的 `String` 对象依然包含了指向字符串常量池中 `"hello"` 的引用。

总结：

- **不管字符串常量池中是否已存在** `"hello"` 字符串，使用 `new String("hello")` **都会在堆上创建一个新的** `String` 对象，并且这个新对象会引用字符串常量池中的 `"hello"` 字符串（如果它不存在，首先会在常量池中创建）。
- `str` 变量（在栈上）总是指向堆上的这个新创建的 `String` 对象，而不是直接指向字符串常量池中的 `"hello"` 字符串。

因此，在这种情况下，即使字符串常量池中已经有了 `"hello"` 字符串，`new String("hello")` 仍然会在堆上创建一个新的 `String` 对象，并且栈上的 `str` 变量会引用这个新创建的对象。