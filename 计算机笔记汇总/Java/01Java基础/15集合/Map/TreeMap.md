# TreeMap

[![](https://cdn.nlark.com/yuque/0/2024/png/38953059/1710822392521-5841a726-c023-49ef-932e-8e11eb8c1740.png)](https://cdn.nlark.com/yuque/0/2024/png/38953059/1710822392521-5841a726-c023-49ef-932e-8e11eb8c1740.png)

# 排序

## 默认排序

Integer Double 默认情况下都是按照升序排列的

String 按照字母再ASCII码表中对应的数字升序进行排列 abcdefg...

```Java
public class A01_TreeMapDemo1 {
    public static void main(String[] args) {
        //1.创建集合对象
        // TreeMap<Integer, String> tm = new TreeMap<>();
        TreeMap<Integer, String> tm = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //o1:当前要添加的元素
                //o2：表示已经在红黑树中存在的元素
                // 降序
                return o2 - o1;
            }
        });

        //2.添加元素
        tm.put(5, "可恰可乐");
        tm.put(4, "雷碧");
        tm.put(3, "九个核桃");
        tm.put(2, "康帅傅");
        tm.put(1, "粤利粤");

        //3.打印集合
        System.out.println(tm);
    }
}
```

## 自定义排序规则

### 实现Comparable接口

```Java
public class Student implements Comparable<Student> {
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{name = " + name + ", age = " + age + "}";
    }

    @Override
    public int compareTo(Student o) {
        // 按照学生年龄的升序排列
        // 年龄一样按照姓名的字母排列
        // 同姓名年龄视为同一个人。

        // this：表示当前要添加的元素
        // o：表示已经在红黑树中存在的元素

        // 返回值：
        // 负数：表示当前要添加的元素是小的，存左边
        // 正数：表示当前要添加的元素是大的，存右边
        // 0：表示当前要添加的元素已经存在，舍弃

        int i = this.getAge() - o.getAge();
        i = i == 0 ? this.getName().compareTo(o.getName()) : i;
        return i;
    }
}
```

### 实现Comparator比较器接口

如果第一种实现Comparable接口的方式无法满足需求，就用实现比较器的方式。

什么情况下Comparable接口无法满足需求？不想使用默认的排序规则

- Integer默认是从小到大排序，如果想要实现从大到小排序，就用Comparator接口
- String默认是用字母在ASCII码表中对应的数字进行排序，如果想要根据String的长度进行排序，就用自定义Comparator比较器来实现

```Java
    public static void main(String[] args) {
        //1.创建集合对象
        TreeMap<Integer, String> tm = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //o1:当前要添加的元素
                //o2：表示已经在红黑树中存在的元素
                // 降序
                return o2 - o1;
            }
        });

        //2.添加元素
        tm.put(5, "可恰可乐");
        tm.put(4, "雷碧");
        tm.put(3, "九个核桃");
        tm.put(2, "康帅傅");
        tm.put(1, "粤利粤");

        //3.打印集合
        System.out.println(tm);
    }
```