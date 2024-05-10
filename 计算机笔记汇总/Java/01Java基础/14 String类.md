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

## String创建过程

[https://juejin.cn/post/6988125661751672846](https://juejin.cn/post/6988125661751672846)

# String 的相关方法

在 Java 编程中，`String.valueOf()` 方法和 `toString()` 方法都用于将其他数据类型转换为字符串。选择使用哪一个方法取决于具体的情景和需求。以下是这两个方法的主要用法和适用场景的解释：

### 使用 `String.valueOf()`
`String.valueOf()` 方法是一个静态方法，可以接受几乎所有类型的参数（包括基本数据类型和对象），并将其转换成字符串。这个方法的主要优势是它永远不会抛出 `NullPointerException`。如果传递的参数是 `null`，它会返回字符串 `"null"`。

**适用场景：**
- 当你需要将一个可能为 `null` 的对象转换为字符串时，使用 `String.valueOf()` 是一个安全的选择，因为它可以避免 `NullPointerException`。
- 当你**需要将基本数据类型转换为字符串时**，也可以使用 `String.valueOf()`，如 `int`、`float`、`char` 等。

**示例：**
```java
Object obj = null;
String text = String.valueOf(obj);  // 返回 "null"
int num = 123;
String number = String.valueOf(num);  // 返回 "123"
```

### 使用 `toString()`
`toString()` 方法是 `Object` 类的一个实例方法，Java 中所有的类都继承自 `Object` 类，因此所有对象都有这个方法。通常，类会覆盖这个方法来提供更有意义的字符串表示。如果没有覆盖 `toString()` 方法，调用它会返回类的名称和对象的哈希码。

**适用场景：**
- 当你确信对象不为 `null` 时，可以使用 `toString()` 方法来获取对象的字符串表示。
- 当你需要一个特定于对象的、详细或格式化的字符串描述时（尤其是当这个类已经覆盖了 `toString()` 方法以提供详细信息时）。

**示例：**
```java
Integer myInteger = 123;
String text = myInteger.toString();  // 返回 "123"

ArrayList<Integer> list = new ArrayList<>();
list.add(1);
list.add(2);
String listString = list.toString();  // 返回 "[1, 2]"
```

**注意：** 直接调用未初始化（即 `null`）对象的 `toString()` 方法将会抛出 `NullPointerException`。
### 总结

- 使用 `String.valueOf()` 当你处理的对象可能为 `null` 或你想要一个简单的字符串表达形式时。
- 使用 `toString()` 当你知道对象不会是 `null`，并且你想要一个特定对象的详细或自定义的字符串表示时。

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
