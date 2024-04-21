# 概念

TreeSet 是 Java 中 Set 接口的一个实现，它使用红黑树（一种自平衡二叉查找树）的数据结构来存储元素。以下是 TreeSet 的一些关键特点：

1. 有序性：TreeSet 中的元素按照自然排序或者根据构造时提供的 Comparator 进行排序。
2. 唯一性：和其他 Set 实现一样，TreeSet 不允许存储重复元素。
3. 性能：对于添加、删除和查找操作，TreeSet 提供了较高的性能（O(log n) 时间复杂度），但通常比基于哈希表的 Set 实现（如 HashSet）慢。
4. 范围查找：由于其基于树的特性，TreeSet 支持有效的范围查找操作，如查找小于给定元素的所有元素、获取某个范围内的元素等。
5. 非同步：TreeSet 不是线程安全的。如果在多线程环境中使用，需要外部同步。

TreeSet 适用于需要大量动态插入和删除的同时，又需要保持集合元素有序的场景。例如，在一些需要排序的集合操作中，TreeSet 是一个不错的选择。

# TreeSet集合默认的规则

- 对于数值类型: Integer, Double, 默认按照从小到大的顺序进行排序
- 对于字符，字符串类型: 按照字符在ASCII码表中的数字升序进行排序

[![](https://cdn.nlark.com/yuque/0/2024/png/38953059/1707404482917-385e52e7-d802-4304-90de-0642e2d2f906.png)](https://cdn.nlark.com/yuque/0/2024/png/38953059/1707404482917-385e52e7-d802-4304-90de-0642e2d2f906.png)

比较字符串类型的时候，先比第一位字母，再比第二位字母，以此类推，这样可以实现顺序排列。

[![](https://cdn.nlark.com/yuque/0/2024/png/38953059/1707404511546-17258348-b433-4846-ac71-38572bbfd79b.png)](https://cdn.nlark.com/yuque/0/2024/png/38953059/1707404511546-17258348-b433-4846-ac71-38572bbfd79b.png)

# TreeSet两种排序方式

[![](https://cdn.nlark.com/yuque/0/2024/png/38953059/1710765655355-c20a9603-5916-4ba3-94d9-634fa42a0e42.png)](https://cdn.nlark.com/yuque/0/2024/png/38953059/1710765655355-c20a9603-5916-4ba3-94d9-634fa42a0e42.png)

## 默认排序/自然排序

Javabean类实现Comparable接口指定比较规则, 因此需要实现`compareTo`方法

```Java
public class Student implements Comparable<Student>{
    private String name;
    private int age;
	// 定义构造器

	// 定义setter和getter

    // 定义toString方法

    @Override
    public int compareTo(Student o) {
        System.out.println("--------------");
        System.out.println("this:" + this);
        System.out.println("o:" + o);
        return this.getAge() - o.getAge();
    }
}
```

这个 compareTo 方法是通过比较两个 Student 对象的年龄来实现的。具体来说：

- 当 this.getAge() 小于 o.getAge() 时，结果为负数，表示当前 Student 对象小于传入的 Student 对象 o。
- 当 this.getAge() 大于 o.getAge() 时，结果为正数，表示当前 Student 对象大于传入的 Student 对象 o。
- 当两者年龄相等时，返回 0，表示两个 Student 对象在排序时被视为相等。

### **compareTo方法的应用**

Java中`compareTo`方法通常用于定义对象的自然排序顺序。compareTo 方法是 Comparable 接口的一部分。当一个类实现了 Comparable 接口，它必须提供 compareTo 方法的实现。这个方法用于定义该对象与另一个同类型对象的比较逻辑，以便能够在排序操作中使用。

这个特定的实现是为一个 Student 类定义的，根据学生的年龄进行排序。

### 方法签名

```Java
public int compareTo(T o)
```

- T 是实现 Comparable 接口的对象类型。
- 这个方法返回一个整数，其值有三种情况：
- 如果返回值为负数，表示当前对象小于传入的对象 o。
- 如果返回值为正数，表示当前对象大于传入的对象 o。
- 如果返回值为 0，则表示两个对象相等。

### 实现细节

在您提供的代码中：

```Java
public int compareTo(Student o) {
    return this.getAge() - o.getAge();
}
```

这个 compareTo 方法是通过比较两个 Student 对象的年龄来实现的。具体来说：

- 当 this.getAge() 小于 o.getAge() 时，结果为负数，表示当前 Student 对象小于传入的 Student 对象 o。
- 当 this.getAge() 大于 o.getAge() 时，结果为正数，表示当前 Student 对象大于传入的 Student 对象 o。
- 当两者年龄相等时，返回 0，表示两个 Student 对象在排序时被视为相等。

### 注意点

- 这种实现方式简单直观，但在**处理大数时可能会有整数溢出的风险**。例如，如果 this.getAge() 非常大而 o.getAge() 非常小，结果可能会溢出成为负数，这会导致错误的比较结果。
- 为了避免整数溢出，可以使用 Integer.compare(this.getAge(), o.getAge()) 替代直接相减的方式。
- 如果 Student 类中还有其他属性也需要参与比较，compareTo 方法可能需要更复杂的逻辑来考虑这些属性。

## 比较器排序

创建TreeSet对象的时候，传递比较器Comparator指定规则

```Java
public static void main(String[] args) {
       /*
            要求：存入四个字符串， “c”, “ab”, “df”, “qwer”
            按照长度排序，如果一样长则按照首字母排序 (默认规则)
            采取第二种排序方式：比较器排序
        */

        TreeSet<String> ts = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // 按照长度排序
                int i = o1.length() - o2.length();
                // 如果一样长则按照首字母排序
                i = i == 0 ? o1.compareTo(o2) : i;
                return i;
            }
        });

        /*TreeSet<String> ts = new TreeSet<>((o1, o2)->{
                // 按照长度排序
                int i = o1.length() - o2.length();
                //如果一样长则按照首字母排序
                i = i == 0 ? o1.compareTo(o2) : i;
                return i;
        });*/

        // 2. 添加元素
        ts.add("c");
        ts.add("ab");
        ts.add("df");
        ts.add("qwer");

        // 3. 打印集合
        System.out.println(ts);
    }
```

在这个 TreeSet 的比较器中，元素首先根据它们的长度进行排序。

如果两个字符串的长度相同，那么它们将根据字典顺序进行排序。

这是通过比较器（Comparator）自定义的排序逻辑实现的。

1. 长度比较：

- int i = o1.length() - o2.length(); 这行代码比较了两个字符串 o1 和 o2 的长度。
- 如果 o1 比 o2 短（即 o1.length() < o2.length()），则 o1.length() - o2.length() 会得到一个负数，表示 o1 应该排在 o2 之前。
- 反之，如果 o1 比 o2 长，则得到一个正数，表示 o1 应该排在 o2 之后。
- 如果两者长度相同，则结果为0，此时会进入到下一步的比较。

1. 首字母排序：

- 当 i == 0 时，即两个字符串长度相同，它们将根据按照字符在ASCII码表中的数字进行排序：i = o1.compareTo(o2);。
- compareTo 方法比较两个字符串在ASCII码表的顺序。
- 如果 o1 在字典顺序上排在 o2 之前，将返回负数；
- 如果排在 o2 之后，将返回正数；如果两者相同，则返回0。

1. 最终结果：

- 比较器最终返回 i，这个值决定了 TreeSet 中元素的排序。

这个比较器让 TreeSet 首先根据字符串的长度排序，如果长度相同，则根据字典顺序排序。这样的排序逻辑在处理需要按照长度排序但又不想丢失字典顺序的字符串集合时非常有用。

# 练习题

## 利用TreeSet存储整数

```Java
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();

        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);

        // 直接打印TreeSet
        System.out.println(set);
        System.out.println("--------------------------");

        // 迭代器
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + "\\t");
        }
        System.out.println();
        System.out.println("--------------------------");

        // 增强for循环
        for (Integer i : set) {
            System.out.print(i + "\\t");
        }
        System.out.println();
        System.out.println("--------------------------");

        // lambda表达式
        // 匿名内部类
        set.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.print(integer + "\\t");
            }
        });
        System.out.println();
        System.out.println("--------------------------");

        // lambda表达式
        set.forEach(i -> System.out.print(i));
    }
```