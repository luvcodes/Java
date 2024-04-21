# Map

## Map集合的基本功能

|   |   |
|---|---|
|**方法名**|**说明**|
|V put(K key,V value)|添加元素|
|V remove(Object key)|根据键删除键值对元素|
|void clear()|移除所有的键值对元素|
|boolean containsKey(Object key)|判断集合是否包含指定的键|
|boolean containsValue(Object value)|判断集合是否包含指定的值|
|boolean isEmpty()|判断集合是否为空|
|int size()|集合的长度，也就是集合中键值对的个数|

```Java
public class A01_MapDemo1 {
    public static void main(String[] args) {
        //1.创建Map集合的对象
        Map<String, String> m = new HashMap<>();

        //2.添加元素
        //put方法的细节：
        //添加/覆盖
        //在添加数据的时候，如果键不存在，那么直接把键值对对象添加到map集合当中,方法返回null
        //在添加数据的时候，如果键是存在的，那么会把原有的键值对对象覆盖，会把被覆盖的值进行返回。
        m.put("郭靖", "黄蓉");
        m.put("韦小宝", "沐剑屏");
        m.put("尹志平", "小龙女");
        String value2 = m.put("韦小宝", "双儿");
        System.out.println(value2);

        //删除
        //黄蓉
        String result = m.remove("郭靖");
        System.out.println(result);

        //清空
        m.clear();

        //判断是否包含
        boolean keyResult = m.containsKey("郭靖");
        System.out.println(keyResult);

        boolean valueResult = m.containsValue("小龙女2");
        System.out.println(valueResult);

//        boolean result = m.isEmpty();
//        System.out.println(result);

        int size = m.size();
        System.out.println(size);


        //3.打印集合
        System.out.println(m);

    }
}
```

### Put方法

在添加数据的时候，如果键不存在，那么直接把键值对对象添加到map集合当中,方法返回null。

在添加数据的时候，如果键是存在的，那么会把原有的键值对对象覆盖，会把被覆盖的值进行返回。

### remove方法

删除键的时候，方法会返回这个被删除的键所对应的值。

# Map集合的遍历方式

|   |   |
|---|---|
|**方法名**|**说明**|
|V get(Object key)|根据键获取值|
|Set<K> keySet()|获取所有键的集合|
|Collection<V> values()|获取所有值的集合|
|Set<Map.Entry<K,V>> entrySet()|获取所有键值对对象的集合|

### 键找值

装着键的单列集合使用**增强for**的形式进行遍历。

```Java
Map<String,String> map = new HashMap<>();

map.put("尹志平","小龙女");
map.put("郭靖","穆念慈");
map.put("欧阳克","黄蓉");

Set<String> keys = map.keySet();
for (String key : keys) {
    String value = map.get(key);
    System.out.println(key + " = " + value);
}
```

**迭代器遍历**

```Java
Map<String,String> map = new HashMap<>();

map.put("尹志平","小龙女");
map.put("郭靖","穆念慈");
map.put("欧阳克","黄蓉");

Set<String> keys = map.keySet();
Iterator<String> iterator = keys.iterator();
while (iterator.hasNext()) {
    String key = iterator.next();
    String value = map.get(key);
    System.out.println("key: " + key + ", value: " + value);
}
```

**Lambda表达式遍历**

```Java
Map<String,String> map = new HashMap<>();

map.put("尹志平","小龙女");
map.put("郭靖","穆念慈");
map.put("欧阳克","黄蓉");

Set<String> keys = map.keySet();
keys.forEach(key -> {
    String value = map.get(key);
    System.out.println("key: " + key + ", value: " + value);
});
```

# HashTable

- 存放的元素是键值对: 即K-V
- HashTable的键和值都不能为null，否则会抛出NullPointerException
- 使用方法基本和HashMap一样
- HashTable是线程安全的，可以在源代码中定义的方法看到synchronized修饰符，HashMap是线程不安全的
- HashTable的首次table length是11，threshold是8，加载因子还是0.75

# HashTable和HashMap对比

HashMap 线程不安全 效率高 允许null键null值

HashTable 线程安全 效率低 不允许null键null值

[[HashMap]]

[[TreeMap]]