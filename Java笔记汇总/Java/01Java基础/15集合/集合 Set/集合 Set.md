[![](https://cdn.nlark.com/yuque/0/2024/png/38953059/1710733878266-aa92857d-6c84-4e63-aaff-91691391b133.png)](https://cdn.nlark.com/yuque/0/2024/png/38953059/1710733878266-aa92857d-6c84-4e63-aaff-91691391b133.png)

# Set常用方法

[![](https://cdn.nlark.com/yuque/0/2024/png/38953059/1710733944465-c6f5652b-4797-4a1b-9e1f-8a0a6c6985f7.png)](https://cdn.nlark.com/yuque/0/2024/png/38953059/1710733944465-c6f5652b-4797-4a1b-9e1f-8a0a6c6985f7.png)

# **Set接口的遍历方式**

同Collection的遍历方式一样，因为Set接口是Collection接口的子接口。

- 可以使用迭代器
- 增强for
- Lambda表达式
- **不能使用索引**的方式来获取，也就是说不能使用普通for循环

```Java
public static void main(String[] args) {
    Set<String> s = new HashSet<>();

    s.add("张三");
    s.add("张三");
    s.add("李四");
    s.add("王五");

    // 迭代器遍历
    Iterator<String> it = s.iterator();
    while (it.hasNext()) {
        String next = it.next();
        System.out.println(next);
    }

    // 增强for循环遍历
    for (String string : s) {
        System.out.println(string);
    }

    // Lambda表达式遍历 - 匿名内部类
    s.forEach(new Consumer<String>() {
        @Override
        public void accept(String str) {
            System.out.println(str);
        }
    });

    // Lambda表达式遍历 - Lambda表达式
    s.forEach(str -> System.out.println(str));
```

[[HashSet]]

[[TreeSet]]