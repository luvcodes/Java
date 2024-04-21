最主要问的就是Lambda表达式、函数式接口、Stream API、方法引用

# **Lambda 表达式**

- Lambda表达式的作用: 简化函数式接口的匿名内部类的写法
- 使用前提: **必须是接口的匿名内部类**，**接口中只能有一个抽象方法**
- 好处: Lambda是一个匿名函数，我们可以把Lambda表达式理解为是一段可以传递的代码

## Lambda表达式的省略规则

- 参数类型可以省略不写。
- 如果只有一个参数，参数类型可以省略，同时()也可以省略。
- 如果Lambda表达式的方法体只有一行，大括号，分号，return可以省略不写，需要同时省略。

## **什么时候使用Lambda表达式？**

当需要对一个函数式接口实例化的时候，可以使用Lambda表达式 (它也只能是在这种情况下用)

```Java
@Test
    public void test1() {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("I love beijing");
            }
        };
        r1.run();

        System.out.println("******************");
				// 这里的Runnable r2就是一个函数式接口
        Runnable r2 = () -> System.out.println("I love peking");
        r2.run();
    }
```

# **函数式接口**

Java 8引入了函数式接口概念，这些接口只有一个抽象方法。这为Lambda表达式的使用提供了基础。

- 函数式接口是只有一个抽象方法的接口，它可以被Lambda表达式所实现。
- 当您想要定义一个函数的契约，使它可以被不同的Lambda表达式实现，可以使用函数式接口。
- Java 8提供了一些预定义的函数式接口，如Runnable、Callable、Consumer、Function等。

## **什么时候使用给定的函数式接口？**

如果我们开发中需要定义一个函数式接口，首先看看在已有的jdk提供的函数式接口是否提供了能满足需求的函数式接口。如果有，则直接调用即可，不用自己调用了。

1. **Stream API：** [https://juejin.cn/post/7220778786126741560?searchId=20230830134655BD8C8EBA4CEC8A485B62](https://juejin.cn/post/7220778786126741560?searchId=20230830134655BD8C8EBA4CEC8A485B62)
    - 什么是Stream API? Stream关注的是对数据的运算，与CPU交互。集合关注的是数据的存储，与内存交互。提供了一种新的处理集合的方式，可以以声明性的方式对数据进行操作，如过滤、映射、归约等操作。类似于sql对数据库中表的相关操作。Stream API 是 Java 8 引入的一个新特性，它提供了一种对数据集合进行高效操作的途径。Stream API 可以用来过滤、映射、聚合等。 Stream API 的核心思想是，将数据集合看作一个流，而不是一个集合。流可以被看作是数据的序列，可以根据需要进行操作。
    - Stream自己不会存储数据。Stream不会改变源对象。相反，他们会返回一个持有结果的新Stream。Stream操作是延迟执行的，这意味着他们会等到需要结果的时候才执行
    - Stream的使用流程？Stream的实例化。一系列的中间操作(过滤、映射、…)。终止操作
        
        ```Java
        List<String> list = Arrays.asList("Apple", "Banana", "Cherry", "Date", "Fig");
        
        // 使用Stream API找出长度大于5的单词并打印出来
        list.stream()
            .filter(s -> s.length() > 5)
            .forEach(System.out::println);
        ```
        
2. **默认方法和静态方法：** 接口现在可以包含默认实现的方法，这使得在不破坏现有实现的情况下，可以向接口中添加新的方法。同时，接口还可以包含静态方法。
    
    1. 默认方法的用途包括：
        - 为接口添加新方法，而无需修改现有实现类。
        - 为接口提供默认实现，以便接口实现类可以选择覆写或不覆写。
        - 为接口提供一致的行为，即使接口实现类来自不同的包。
    
    在 Java 8 之前，接口中只能定义抽象方法。从 Java 8 开始，接口中可以定义默认方法。默认方法是一种有具体实现的方法，它可以被所有实现该接口的类所共享。在Java 8中，引入了接口中的默认方法（Default Methods）的概念。这允许在接口中提供方法的默认实现，而不强制所有实现该接口的类都要实现这些方法。如果一个类实现了一个接口，但没有提供默认方法的实现，那么它将继承接口中默认方法的实现。
    
    当一个类实现一个接口，并且该接口包含一个默认方法时，这个类可以选择性地重写默认方法。这就意味着，如果你希望在实现类中使用不同的方法逻辑，你可以重写默认方法。
    
    以下是一个简单的示例，说明**如何在接口中定义默认方法以及在实现类中重写默认方法**：
    
    ```Java
    interface MyInterface {
        default void defaultMethod() {
            System.out.println("Default implementation in MyInterface");
        }
    }
    
    class MyClass implements MyInterface {
        @Override
        public void defaultMethod() {
            System.out.println("Custom implementation in MyClass");
        }
    }
    
    public class Main {
        public static void main(String[] args) {
            MyInterface obj1 = new MyClass();
            obj1.defaultMethod(); // 输出: "Custom implementation in MyClass"
    
            MyInterface obj2 = new MyInterface() {
                // 匿名类实现接口并重写默认方法
                @Override
                public void defaultMethod() {
                    System.out.println("Custom implementation in anonymous class");
                }
            };
            obj2.defaultMethod(); // 输出: "Custom implementation in anonymous class"
        }
    }
    ```
    
    在上述示例中，`MyClass` 类实现了 `MyInterface` 接口并重写了其中的默认方法。此外，我们还演示了如何使用匿名类实现接口并重写默认方法。
    
    需要注意的是，默认方法的引入是为了向已有的接口添加新功能，而不会破坏现有的实现类。这种设计允许在不破坏接口的向后兼容性的情况下向接口添加新的方法。
    
3. **新的日期和时间 API：** Java 8引入了`java.time`包，提供了全新的日期和时间处理方式，解决了旧的`java.util.Date`和`java.util.Calendar`的一些问题。
4. **方法引用：** 方法引用允许您通过方法的名称引用方法，使得代码更加简洁。它通常用于Lambda表达式中。
    - 方法引用是一种简化Lambda表达式的方式，用于直接引用已经存在的方法。
    - 当您的Lambda表达式只调用一个已有方法，并且不做其他操作时，可以考虑使用方法引用。
    - 方法引用的语法是对象::方法，或者类名::静态方法，或者类名::实例方法。
5. **Optional 类：** `java.util.Optional` 类引入了一种更好的方式来处理可能为 null 的值，可以减少空指针异常的风险。`**Optional**`类在Java 8中被引入，并且现在是Java核心库的一部分。这个类的目的是为了提供一个明确的、问题导向的替代方式来处理`**null**`，从而避免在程序中出现`**NullPointerException**`。
    - Optional 类是一个可以为null的容器对象。如果值存在则isPresent()方法会返回true，调用get()方法会返回该对象。
    - Optional 是个容器：它可以保存类型T的值，或者仅仅保存null。Optional提供很多有用的方法，这样我们就不用显式进行空值检测。
    - Optional 类的引入很好的解决空指针异常。
6. **Nashorn JavaScript 引擎：** Java 8引入了一个新的轻量级的、基于 JVM 的 JavaScript 引擎，称为 Nashorn。
7. **新的并发特性：** 引入了新的并发类，如 `CompletableFuture`，使得异步编程更加容易和灵活。
8. **重复注解：** 允许在同一位置多次使用同一注解。
9. **PermGen 被移除：** Java 8移除了永久代（PermGen）的概念，取而代之的是 Metaspace，用于存储类的元数据。

# 常见Java 8或Java 1.8问题

## **JDK 1.7 中的 HashMap**

1. **数据结构：** 在JDK 1.7中，`HashMap`使用了数组+链表的数据结构来存储键值对。数组用于存储桶（buckets），每个桶中存储一个链表，包含哈希码相同的键值对。
2. **Hash 冲突解决：** 在JDK 1.7中，当多个键具有相同的哈希码（发生哈希冲突）时，它们会被放置在同一个桶的链表中。
3. **线程不安全：** JDK 1.7中的`HashMap`是线程不安全的，如果多个线程同时修改`HashMap`，可能会导致不一致的状态或数据丢失。

## **JDK 1.8 中的 HashMap**

1. **数据结构：** 在JDK 1.8中，`HashMap`引入了“链表转红黑树”的机制，即当链表中的元素数量超过一定阈值时，链表会被转换为红黑树，以提高查找效率。
2. **Hash 冲突解决：** 在JDK 1.8中，当哈希冲突发生时，如果桶中的元素数量大于一定阈值且链表长度大于一定长度，则会将链表转换为红黑树，从而提高查找、插入和删除操作的性能。
    
    - 在 JDK 1.8 中，`HashMap`会根据一些参数来决定将链表转换为红黑树的阈值。这些参数是动态计算的，并且可以通过一些系统属性进行调整。以下是默认情况下的一些参数值：
        1. **链表长度阈值：** 默认情况下，当一个桶中的链表长度超过 8 时，`HashMap`会将该链表转换为红黑树。这是通过 `TREEIFY_THRESHOLD` 参数控制的。
        2. **红黑树长度阈值：** 如果链表被转换为红黑树，那么默认情况下，当红黑树的节点数量少于 6 时，`HashMap`会将红黑树重新转换为链表。这是通过 `UNTREEIFY_THRESHOLD` 参数控制的。
    - 上面提到的 "8" 是默认的链表长度阈值，用于确定在 `HashMap` 中何时将链表转换为红黑树。这个值在大多数情况下是适用的，但是在不同的Java版本和实现中，这个值可能会有所不同。除了默认的 "8" 外，JDK 1.8 中还有一个与此相关的参数叫做 `MIN_TREEIFY_CAPACITY`，它的默认值是 "64"。这个参数用于确保至少有足够数量的元素在 `HashMap` 中，以便在链表转换为红黑树时能够维持红黑树的平衡性能。如果元素数量不足以维持一个合理的红黑树，那么转换后的红黑树可能会比链表更加低效。
    
    在实际应用中，调整这些参数可能会影响`HashMap`在特定场景下的性能和内存占用。
    
3. **线程安全：** `HashMap`仍然是非线程安全的，但JDK 1.8引入了一些并发性能的优化，例如在没有竞争的情况下可以进行更好的并发读取。
4. **存储和遍历优化：** 在JDK 1.8中，`HashMap`进行了一些存储和遍历性能的优化，例如使用扩容机制来减少哈希冲突，以及改进的迭代器性能。