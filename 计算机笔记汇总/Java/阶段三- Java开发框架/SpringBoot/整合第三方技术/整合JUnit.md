不用自己设置，直接就在测试类里面有JUnit测试

- 导入测试对应的starter坐标
- 测试类使用@SpringBootTest修饰
- 使用自动装配的形式添加要测试的对象

在实际的测试类中，只要在测试类的上面设置JUnit家在的SpringBoot启动类，就可以精准地指定引导类的位置了。

[![](https://cdn.nlark.com/yuque/0/2023/png/38953059/1699768893471-e932fa89-f3a7-4715-9def-c358e285a13a.png)](https://cdn.nlark.com/yuque/0/2023/png/38953059/1699768893471-e932fa89-f3a7-4715-9def-c358e285a13a.png)

- 测试类如果存在于引导类所在包或子包中无需指定引导类
- 测试类如果不存在于引导类所在包或子包中需要通过classes属性指定引导类