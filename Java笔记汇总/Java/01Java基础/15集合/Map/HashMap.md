# HashMap

HashMap底层是数组 + 链表 + 红黑树

1. Map与Collection并列存在。用于保存具有映射关系的数据: Key-Value
2. Map中的key和value可以是任何引用类型的数据，会封装到HashMap$Node对象中
3. Map中的key不允许重复，原因和HashSet一样
4. 生成结果的顺序不一定是和加入顺序一致的，因为本质上就是HashSet，见Map_代码文件

Table表是一个数组，数组里面放的有链表或者是一棵树。每一个链表里面包含多个Node(HashMap Node), 而Node又实现了Map Entry接口。

[![](https://cdn.nlark.com/yuque/0/2024/png/38953059/1710805957671-5873b2d7-c020-4f35-abed-f882f27e0217.png)](https://cdn.nlark.com/yuque/0/2024/png/38953059/1710805957671-5873b2d7-c020-4f35-abed-f882f27e0217.png)

## HashMap底层机制

扩容机制与HashSet完全一样，因为HashSet底层就是HashMap。

有一个重点: HashSet是可以key相同，value不同，但是可以把新的Node添加到链表最后的，不会发生替换。

但是在HashMap中，如果key相同，value不同，就会直接发生替换，新的Value会替代旧的Value。源码中有一行e.value=value

## 解决哈希冲突

在Java中，HashMap 主要使用以下方法来解决哈希冲突：

链地址法：这是 HashMap 中使用的主要方法来解决哈希冲突。在这种方法中，每个桶（或数组槽）包含一个链表，当多个键哈希到同一个桶时，这些键值对被插入到同一个桶的链表中。如果链表过长，为了提高性能，它们可能进一步转换为红黑树。

其他提到的方法在Java的 HashMap 实现中并未使用：

- A. 开放地址法：这是解决哈希冲突的另一种方法，但Java的 HashMap 并未使用。在开放地址法中，所有的元素都存储在哈希表的数组本身中，如果一个索引已经被占用，哈希表尝试找到另一个空闲的索引来存储这个元素。
- B. 二次哈希法：这是另一种解决哈希冲突的技术，但它也不是Java HashMap 中使用的方法。二次哈希使用第二个哈希函数来决定冲突键的存储位置。
- D. 建立一个公共溢出区：这是数据库哈希表实现中可能使用的一种技术，但并不是Java HashMap 中使用的方法。

因此，对于Java中 HashMap 解决哈希冲突的方法，正确答案是 C. 链地址法。

## 总结

[![](https://cdn.nlark.com/yuque/0/2024/png/38953059/1710806198127-f4964029-0c05-44d1-84d6-b49526ca6a18.png)](https://cdn.nlark.com/yuque/0/2024/png/38953059/1710806198127-f4964029-0c05-44d1-84d6-b49526ca6a18.png)

# LinkedHashMap

[![](https://cdn.nlark.com/yuque/0/2024/png/38953059/1710821143959-4f069546-61b0-4092-be90-6733af77ff9c.png)](https://cdn.nlark.com/yuque/0/2024/png/38953059/1710821143959-4f069546-61b0-4092-be90-6733af77ff9c.png)