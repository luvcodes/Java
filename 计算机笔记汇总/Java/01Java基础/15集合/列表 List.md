# ArrayList

## ArrayList和数组的区别

[https://juejin.cn/s/%E6%95%B0%E7%BB%84%20(array)%20%E5%92%8C%E5%88%97%E8%A1%A8%20(arraylist)%20%E6%9C%89%E4%BB%80%E4%B9%88%E5%8C%BA%E5%88%AB%20%E4%BB%80%E4%B9%88%E6%97%B6%E5%80%99%E5%BA%94%E8%AF%A5%E4%BD%BF%E7%94%A8%20array%20%E8%80%8C%E4%B8%8D%E6%98%AF%20arraylist](https://juejin.cn/s/%E6%95%B0%E7%BB%84%20(array)%20%E5%92%8C%E5%88%97%E8%A1%A8%20(arraylist)%20%E6%9C%89%E4%BB%80%E4%B9%88%E5%8C%BA%E5%88%AB%20%E4%BB%80%E4%B9%88%E6%97%B6%E5%80%99%E5%BA%94%E8%AF%A5%E4%BD%BF%E7%94%A8%20array%20%E8%80%8C%E4%B8%8D%E6%98%AF%20arraylist)

1. **数组是一个固定大小的数据结构**，它在内存中分配了一段连续的空间来存储元素。**数组的长度在创建后不能改变**，可以通过下标来访问和修改元素。数组在**访问元素时速度很快**，但在插入和删除元素时需要移动其他元素，所以效率较低。
2. ArrayList是Java中的一个**动态数组**，它可以**自动调整大小来适应元素的数量变化**。ArrayList使用一个数组来存储元素，当元素数量增加时，会**自动**扩展数组的大小，当元素数量减少时，会**自动**缩小数组的大小。在访问元素时，ArrayList也可以使用下标来访问和修改元素。
3. 与数组相比，ArrayList在插入和删除元素时效率更高，因为不需要移动其他元素。

## ArrayList介绍

ArrayList是Java集合框架中的一个重要类，它允许以动态数组的方式存储和操作数据。与普通数组相比，ArrayList的容量能动态增长，无需手动管理数组大小。要使用ArrayList，你需要导入java.util包并按以下方式**初始化**：

```Java
import java.util.ArrayList;
ArrayList<String> fruits = new ArrayList<>();
```

ArrayList具有一些常用的操作，如添加元素、获取元素、删除元素、判断是否为空、转换为数组、截取子列表等。此外，你还可以使用迭代器在遍历ArrayList的同时执行添加、删除等操作，而不会抛出ConcurrentModificationException异常.**ArrayList继承自AbstractList**，实现了List、RandomAccess和Cloneable接口。**它是一种有序集合**，可以**根据索引进行检索、删除或插入操作**.

## ArrayList基本用法 APIs

ArrayList的基本操作包括但不限于：

添加元素：使用 `add()` 方法向ArrayList中添加元素，例如：

```Java
ArrayList<String> list = new ArrayList<>();
list.add("apple");
```

删除元素：使用 `remove()` 方法从ArrayList中删除元素，例如：

```Java
list.remove("apple");
```

获取元素：使用 `get()` 方法获取指定位置的元素，例如：

```Java
String fruit = list.get(0);
```

判断是否包含某元素：使用 `contains()` 方法判断ArrayList是否包含特定元素，例如：

```Java
boolean hasFruit = list.contains("apple");
```

获取ArrayList大小：使用 `size()` 方法获取ArrayList的大小，例如：

```Java
int size = list.size();
```

## 遍历ArrayList

在ArrayList中，你可以使用多种方式来遍历元素，常见的包括：

### 使用for循环遍历

示例代码如下：

```Java
ArrayList<Integer> list = new ArrayList<>();
for (int i = 0; i < list.size(); i++) {
    Integer element = list.get(i);
    // 进行相应操作
}
```

### 迭代器遍历

- 迭代器遍历不依赖索引
- `hasNext`方法判断的是当前指针是否有元素
- `next`方法: 获取元素，并移动指针
- 迭代器默认指向Collection的0索引处

[![](https://cdn.nlark.com/yuque/0/2024/png/38953059/1707404060562-536ad606-134f-4d2b-bdbe-7536e9013f4f.png)](https://cdn.nlark.com/yuque/0/2024/png/38953059/1707404060562-536ad606-134f-4d2b-bdbe-7536e9013f4f.png)

1. 报错NoSuchElementException
2. 迭代器遍历完毕，指针不会复位
3. 循环中只能用一次next方法
4. 迭代器遍历时，不能用集合的方法进行增加或者删除
5. 暂时当做一个结论先行记忆，在今天我们会讲解源码详细的再来分析。
6. 如果我**实在要删除**：那么可以**用迭代器提供的remove方法进行删除**。如果我要添加，暂时没有办法。

迭代器在循环遍历结束之后，它的指针指向了最后没有元素的位置，指针不会自动复位。**如果想要进行第二次遍历，只能再次获取一个迭代器对象。**

```Java
public static void main(String[] args) {
    //1.创建集合并添加元素
    Collection<String> coll = new ArrayList<>();
    coll.add("aaa");
    coll.add("bbb");
    coll.add("ccc");
    coll.add("ddd");
    coll.add("eee");

    //2.获取迭代器对象
    //迭代器就好比是一个箭头，默认指向集合的0索引处
    Iterator<String> it = coll.iterator();
    //3.利用循环不断的去获取集合中的每一个元素
    while(it.hasNext()){
        //4.next方法的两件事情：获取元素,并移动指针
        String str = it.next();
        if("bbb".equals(str)){
            //coll.remove("bbb");
            it.remove();
        }
    }
    System.out.println(coll);
}
```

### 增强for遍历

```Java
public class A06_CollectionDemo6 {
    public static void main(String[] args) {

        //1.创建集合并添加元素
        Collection<String> coll = new ArrayList<>();
        coll.add("zhangsan");
        coll.add("lisi");
        coll.add("wangwu");

        // 2.利用增强for进行遍历
        // 注意点: s其实就是一个第三方变量，在循环的过程中依次表示集合中的每一个数据
        // 每次迭代会将集合中的一个元素的值赋给变量 s
        // 这个操作实际上只是改变了 s 这个局部变量的值，并不影响原集合 coll 中的元素。
        for (String s : coll) {
            s = "qqq";
            System.out.println(s);
        }

        // zhangsan lisi wangwu
        System.out.println(coll);
    }
}
```

在 Java 中，使用增强型 `for` 循环（也称为 for-each 循环）遍历集合时，循环变量（在这个例子中是 `s`）获取的是集合元素的一个副本，而不是直接引用集合中的元素。这意味着在循环体内对循环变量进行的修改不会反映到原始集合中的元素上。

1. `Collection<String> coll = new ArrayList<>();` 创建了一个 `ArrayList` 类型的集合 `coll`。
2. 当使用增强型 `for` 循环遍历 `coll` 集合时，每次迭代会将集合中的一个元素的值赋给变量 `s`。
3. 在循环体内，您对 `s` 赋予了新的值 `"qqq"`。这个操作实际上只是改变了 `s` 这个局部变量的值，并不影响原集合 `coll` 中的元素。
4. 因此，当您打印 `coll` 集合的内容时，它仍然显示原始的元素（"zhangsan", "lisi", "wangwu"），因为集合中的元素并没有被修改。

如果您想修改集合中的元素，您需要使用迭代器或者传统的 `for` 循环，并且通过索引或迭代器直接操作集合中的元素。例如，使用 `ListIterator` 或者通过索引访问 `ArrayList` 元素并修改它们。

### Lambda表达式遍历

```Java
Collection<String> coll = new ArrayList<>();
coll.add("zhangsan");
coll.add("lisi");
coll.add("wangwu");

//lambda表达式
coll.forEach(s -> System.out.println(s));
```

[![](https://cdn.nlark.com/yuque/0/2024/png/38953059/1707404107156-c44a05d3-3d83-472c-9252-34369a121630.png)](https://cdn.nlark.com/yuque/0/2024/png/38953059/1707404107156-c44a05d3-3d83-472c-9252-34369a121630.png)

## ArrayList的底层实现

ArrayList 是 Java 中常用的动态数组实现，它的底层是基于数组实现的。当创建一个 ArrayList 对象时，实际上是创建了一个 Object 类型的数组，**初始容量为 10**

当添加元素时，如果数组已满，**ArrayList 会自动扩容**，它会**创建一个新的数组**，并**将原数组中的元素复制到新数组**中。

[![](https://cdn.nlark.com/yuque/0/2024/png/38953059/1707404138714-80fd20f7-bb6d-40c4-af75-21cd4c1c98b9.png)](https://cdn.nlark.com/yuque/0/2024/png/38953059/1707404138714-80fd20f7-bb6d-40c4-af75-21cd4c1c98b9.png)

### ArrayList自动扩容机制

在ArrayList 的源码中，可以看到 ArrayList 内部维护了一个 Object 类型的数组 elementData，这个数组用于存储 ArrayList 中的元素。在添加元素时，ArrayList 会先判断数组是否已满，如果已满，就会调用 ensureCapacityInternal 方法进行扩容。这个方法会计算出新的容量大小，并创建一个新的数组 newElementData，然后将原数组中的元素复制到新数组中，最后将新数组赋值给 elementData。id:: 65b47328-ce5a-4731-9e72-527596d517ac

[![](https://cdn.nlark.com/yuque/0/2024/png/38953059/1707404175738-1c59bae8-3028-4075-8c3d-bf426de0d1e3.png)](https://cdn.nlark.com/yuque/0/2024/png/38953059/1707404175738-1c59bae8-3028-4075-8c3d-bf426de0d1e3.png)

在 Java 的底层，特别是在`ArrayList`类的实现中，扩容通常是通过`Arrays.copyOf()`方法来完成的。这个方法是 Java 标准库中的一部分，它在内部使用`System.arraycopy()`来实现数组元素的复制。`Arrays.copyOf()`不仅负责复制数组元素，还会创建新的数组，并确保新数组的类型与原数组相同。

### 具体到 `ArrayList` 的实现

当 `ArrayList` 的内部数组需要扩容时（例如，当添加元素而当前数组容量不足时），`ArrayList` 会计算新的容量（通常是旧容量的 1.5 倍）。然后，`ArrayList` 调用 `Arrays.copyOf()`，将旧数组的内容复制到一个新创建的、更大的数组中。这个新数组的大小就是刚才计算出的新容量。`Arrays.copyOf()` 在复制过程中确保了数据类型的一致性和系统级别的高效复制。

这种方式相比直接使用 `System.arraycopy()` 更加简洁，因为它自动处理了新数组的创建和类型匹配，同时利用了 `System.arraycopy()` 的高效率。这也是为什么 `Arrays.copyOf()` 被广泛用于 Java 标准库中，特别是在需要复制数组的时候。

## Fail-Fast机制

ArrayList的**快速失败机制（Fail-Fast机制）**指的是在多线程环境下，如果一个线程修改了ArrayList的结构（增加、删除或修改元素），那么其他线程在访问ArrayList时，如果发现modCount属性（记录ArrayList结构修改次数的属性）与自己持有的modCount属性不一致，就会抛出ConcurrentModificationException异常，从而防止多个线程同时修改ArrayList的结构，导致数据不一致的情况发生。

快速失败机制是一种保护措施，它能够及时发现并报告程序中的错误，从而避免因为错误的数据导致程序崩溃或者出现其他异常情况。在ArrayList中，快速失败机制的实现是通过modCount属性和一个迭代器的expectedModCount属性来实现的。

每当ArrayList的结构发生变化时，modCount属性就会加1，而每个迭代器的expectedModCount属性则会保存它创建时的modCount属性的值。当一个迭代器在遍历ArrayList时，如果发现expectedModCount和modCount不一致，就会抛出ConcurrentModificationException异常，从而保证了遍历的安全性。

# Vector

`Vector`是一种动态数组，能够存储任意类型对象，具有较好的可扩展性。

与数组相比，**Vector能够动态调整容量**，**可以自动扩容**，同时提供了一些常用的操作方法，例如添加元素、删除元素、修改元素、查找元素等。

**Vector的底层实现是基于Object数组的**，每次增加元素时都会检查当前容量是否足够，如果不够则会自动扩容，同时将原数组中的元素复制到新数组中。

Vector 的类型：`Vector` 是一个泛型类，可以存储任何类型的对象。如果您没有指定泛型类型，它默认存储的是 `Object` 类型的对象。当您指定了泛型类型（如 `Vector<String>`），它将只能存储该类型的对象。但在 Java 中，所有的类都隐式继承自 Object 类，所以即使您指定了具体的泛型类型，这些对象在内部仍然被视为 Object 类型。

泛型和 Object 类型：指定泛型类型（如 `Vector<Integer>`）的主要好处是类型安全。这意味着在编译时就能检查到类型错误，例如尝试将一个 `String` 添加到 `Vector<Integer>` 中将导致编译错误。泛型还免去了手动类型转换的麻烦。尽管泛型类型在内部仍然被处理为 `Object` 类型，但这个转换是自动且对开发者透明的。

Java 中的 `Vector` 是一个动态数组，它与 `ArrayList` 类似，但有几个关键区别。以下是关于 `Vector` 的一些主要特点：

1. **同步性（Synchronized）**：`Vector` 的每个方法都是同步的，这意味着它是线程安全的。这可以防止多个线程同时修改 Vector 导致的不一致问题。然而，这也意味着它在多线程环境中比非同步的集合（如 `ArrayList`）性能稍差。
2. **动态数组**：`Vector` 内部使用数组来存储元素。当元素超出当前容量时，它会自动增长。这种增长通常涉及创建一个新的更大的数组，并将旧数组的内容复制到新数组中。
3. **容量增长策略**：当 `Vector` 需要增加容量时，它会按照其容量增长率（默认为当前容量的 100%）增长。这与 `ArrayList`（通常增长 50%）不同。
4. **支持遗留方法**：`Vector` 提供了一些遗留方法，如 `addElement`、`elementAt` 和 `removeElement`，这些方法在 `ArrayList` 中没有对应的方法。
5. **性能开销**：由于 `Vector` 是同步的，因此它在单线程应用中可能比 `ArrayList` 慢。如果不需要线程安全，通常推荐使用 `ArrayList`。
6. **遍历**：可以使用 `for` 循环、迭代器（Iterator）或枚举器（Enumerator）来遍历 `Vector`。
7. **随机访问**：`Vector` 支持快速随机访问，可以通过索引直接访问元素。

示例代码：

```Java
import java.util.Vector;

public class VectorExample {
    public static void main(String[] args) {
        Vector<String> vector = new Vector<>();

        // 添加元素
        vector.add("Apple");
        vector.add("Orange");
        vector.add("Banana");

        // 遍历元素
        for (String fruit : vector) {
            System.out.println(fruit);
        }

        // 访问元素
        String item = vector.get(1); // 获取索引为 1 的元素
        System.out.println("Element at index 1: " + item);
    }
}
```

这个示例展示了如何创建一个 `Vector`，向其中添加元素，遍历元素以及通过索引访问元素。在现代 Java 应用中，除非需要与遗留代码兼容，否则通常建议使用 `ArrayList` 或其他更现代的集合类型。

## **Vector底层结构和源码分析**

- Vector底层也是一个**对象数组**，`protected Object[] elementData`
- Vector是线程同步的，即**线程安全**，Vector类的操作方法带有`synchronized`
- 在开发中需要线程同步安全时，考虑使用Vector

`elementData`是存储元素的底层数据结构，而`elementCount`表示当前已经存储的元素数量。

Vector提供了一些常用的方法，例如`add()`、`get()`、`remove()`、`set()`等。其中，add()方法用于添加元素，如果当前容量不够，则会自动扩容；`get()`方法用于获取指定位置的元素；`remove()`方法用于删除指定位置的元素；`set()`方法用于修改指定位置的元素。

为了保证线程安全性，Vector采用了`synchronized`关键字对部分方法进行同步，例如add()、`get()`、`remove()`、set()等。同时，Vector还提供了一些同步方法，例如`synchronizedAdd()`、`synchronizedGet()`、`synchronizedRemove()`、`synchronizedSet()`等，用于在多线程并发环境下进行操作。

# **ArrayList和Vector的比较**

ArrayList和Vector都是Java中的动态数组容器，它们有一些相似之处，也有一些不同之处。

## 相似之处

- 都实现了List接口，可以存储相同类型的元素并保持它们的顺序。
- 都允许元素的动态增加和删除，能够自动调整容量。

## 不同之处

- **线程安全性**：Vector是线程安全的，通过synchronized关键字实现，而ArrayList不是线程安全的。在单线程环境下，ArrayList的性能优于Vector[2]。
- **性能**：由于Vector是线程安全的，因此在多线程环境下使用时比较安全，但由于需要进行同步操作，可能导致性能下降。相比之下，ArrayList在单线程环境下的性能更好，因为不需要进行同步操作[2]。
- **扩容机制**：Vector在扩容时会将**容量增加一倍**，而ArrayList在扩容时会增加约50%的容量，这也是它们性能差异的一个原因[1]。

综上所述，如果在**单线程**环境下，并且**对性能有较高要求**时，推荐使用**ArrayList**；如果在**多线程**环境下，并且**需要线程安全**时，可以选择使用**Vector**。

## 示例代码

```Java
public class VectorArrayListCompare {
    private static final int THREAD_COUNT = 100;
    private static Vector<Integer> vector = new Vector<>();
    private static ArrayList<Integer> arrayList = new ArrayList<>();

    public static void main(String[] args) {
        ThreadGroup vectorGroup = new ThreadGroup("VectorGroup");
        ThreadGroup arrayListGroup = new ThreadGroup("ArrayListGroup");

        // 有100个arraylist线程和100个vector线程, 每次每个线程分别加100个元素
        for (int i = 0; i < THREAD_COUNT; i++) {
            new Thread(vectorGroup, () -> {
                for (int j = 0; j < 100; j++) {
                    vector.add(j);
                    // 尝试在添加后立即遍历 Vector
                    vector.forEach(v -> {});
                }
            }).start();

            new Thread(arrayListGroup, () -> {
                for (int j = 0; j < 100; j++) {
                    arrayList.add(j);
                    // 尝试在添加后立即遍历 ArrayList
                    try {
                        arrayList.forEach(a -> {});
                    } catch (ConcurrentModificationException e) {
                        System.out.println("ArrayList is not thread-safe: " + e.getMessage());
                    }
                }
            }).start();
        }

        // 等待所有线程完成
        while (vectorGroup.activeCount() > 0 || arrayListGroup.activeCount() > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Vector size: " + vector.size());
        System.out.println("ArrayList size: " + arrayList.size());
    }
}
```

# LinkedList

## **LinkedList底层结构**

1. 底层实现了双向链表和双端队列特点
2. 可以添加任意元素(元素可以重复)，包括null
3. **线程不安全**，没有实现同步

Java 中的 `LinkedList` 是一个双向链表实现的列表，它实现了 `List` 接口和 `Deque`（双端队列）接口。由于其底层是基于链表的，所以它在添加或删除元素时不需要像 `ArrayList` 那样重新调整数组的大小，这使得在列表的头部或尾部添加/删除操作更加高效。

### 主要特性

1. **双向链表**：`LinkedList` 中的每个元素都包含了前一个和后一个元素的引用，这使得元素的插入和删除非常高效。
2. **实现了 List 和 Deque 接口**：这意味着它既可以作为列表使用，也可以作为双端队列使用，提供了更多的方法和功能。
3. **元素无容量限制**：由于 `LinkedList` 在内部使用链表来存储元素，所以它的容量没有固定限制，只受限于内存大小。
4. **非同步**：`LinkedList` 是非线程安全的，如果多个线程同时访问一个 `LinkedList` 实例，并且至少有一个线程从结构上修改了列表，那么它必须在外部进行同步。
5. **高效的元素添加和删除**：在列表的头部或尾部添加或删除元素是非常快的，但在列表中间进行这些操作则比较慢，因为需要从头部或尾部遍历到相应的位置。

### 常用方法

- `add(E e)`：在列表的尾部添加一个元素。
- `addFirst(E e)` 和 `addLast(E e)`：在列表的头部或尾部添加一个元素。
- `remove()` 和 `removeFirst()`：移除并返回列表的第一个元素。
- `removeLast()`：移除并返回列表的最后一个元素。
- `getFirst()` 和 `getLast()`：获取但不移除列表的第一个或最后一个元素。
- `size()`：返回列表中的元素数。
- `clear()`：清空列表。

### 使用示例

```Java
import java.util.LinkedList;

public class LinkedListExample {
    public static void main(String[] args) {
        LinkedList<String> ll = new LinkedList<>();

        ll.add("A");
        ll.add("B");
        ll.addFirst("C");
        ll.addLast("D");
        ll.add(2, "E");

        System.out.println(ll); // 输出：[C, A, E, B, D]

        ll.remove("E");
        ll.removeFirst();
        ll.removeLast();

        System.out.println(ll); // 输出：[A, B]
    }
}
```

### 适用场景

- 当需要频繁地在列表的两端添加或删除元素时，`LinkedList` 是一个好的选择。
- 当需要实现堆栈、队列或双端队列时，`LinkedList` 提供了这些数据结构的良好支持。
- 不适合频繁地进行随机访问操作，因为每次访问都需要从头部或尾部遍历。

总之，`LinkedList` 在某些特定场景下提供了优越的性能，尤其是在列表的两端进行操作时，但在其他场景下（如随机访问）可能不如 `ArrayList` 高效。