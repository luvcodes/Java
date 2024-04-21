# Bean的初始配置

用于定义和配置两个bean：`bookDao`和`serviceDao`

```XML
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd"

  <bean id="bookDao" class="com.itheima.dao.impl.BookDaoImpl" />
  <bean id="serviceDao" class="com.itheima.service.impl.BookServiceImpl">
    <property name="bookDao" ref="bookDao" />
  </bean>
</beans>
```

**第一行**：定义了一个名为`bookDao`的bean。

```XML
<bean id="bookDao" class="com.itheima.dao.impl.BookDaoImpl" />
```

- `id="bookDao"`: **指定bean的唯一标识符**为`bookDao`。
- `class="com.itheima.dao.impl.BookDaoImpl"`: 指定bean的实现类。

**第二行**：定义了一个名为`serviceDao`的bean。

```XML
<bean id="serviceDao" class="com.itheima.service.impl.BookServiceImpl">
```

- `id="serviceDao"`: 指定bean的唯一标识符为`serviceDao`。
- `class="com.itheima.service.impl.BookServiceImpl"`: 指定bean的实现类

**第三行及以下**：配置`serviceDao` bean的属性。

```XML
<property name="bookDao" ref="bookDao" />
```

- `name="bookDao"`: 指定`BookServiceImpl`类中有一个属性（或成员变量）名为`bookDao`，这个属性需要被注入。
- `ref="bookDao"`: 指定将`id`为`bookDao`的bean注入到`BookServiceImpl`类的`bookDao`属性中。

总结：这段代码创建了两个bean（`bookDao`和`serviceDao`）并配置了它们的关系。`**serviceDao**`**依赖于**`**bookDao**`，**这个依赖关系是通过**`**<property>**`**标签来配置的**。

在这段配置中，``serviceDao``有一个属性（或成员变量）名为``bookDao``，这个属性被注入了一个``bookDao`` bean。这种依赖关系是通过``<property name="bookDao" ref="bookDao" />``这一行来明确指定的。这里，``ref="bookDao`"`表示``serviceDao`` bean依赖于``id``为``bookDao``的bean。

所以，``serviceDao``是依赖于``bookDao``的，而不是反过来。

# Spring容器运行的行为与顺序

当你使用Spring框架并通过XML配置文件进行依赖注入时，**Spring容器的行为**是这样的：

1. 当Spring容器启动时，它会读取XML配置文件。
2. 根据配置文件中的定义，Spring容器会实例化相应的bean。
3. 在实例化bean后，Spring容器会查找bean的配置以确定是否需要注入其他bean或属性。
4. 如果需要注入其他bean或属性，Spring容器会调用相应的setter方法（在这种情况下是`setBookDao`方法）来完成注入。

详细说明见此文档: [Spring运行行为和顺序](https://www.yuque.com/chuangshiji-poapl/epb8vm/ptq61rmn22rtct6h)

```XML
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
  <bean id="bookDao" class="com.itheima.dao.impl.BookDaoImpl" scope="prototype"/>
  <bean id="bookService" class="com.itheima.service.impl.BookServiceImpl">
    <property name="bookDao" ref="bookDao" />
  </bean>
</beans>
```

```Java
package com.itheima.service.impl;

import com.itheima.dao.BookDao;
import com.itheima.service.BookService;

public class BookServiceImpl implements BookService {
    BookDao bookDao;
    @Override
    public void save() {
        System.out.println("BookService save...");
        bookDao.save();
    }

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
        System.out.println("bookDao setter...");
    }
}
```

在你给出的例子中，`BookServiceImpl`类有一个`bookDao`属性，这个属性的值是通过setter方法`setBookDao`注入的。在XML配置文件中，你告诉Spring容器使用`bookDao` bean为`serviceDao` bean的`bookDao`属性注入值。

因此，当Spring容器创建`serviceDao` bean时，它首先实例化`BookServiceImpl`类，然后立即调用`setBookDao`方法来注入`bookDao`属性的值。这就是为什么你看到`setBookDao`方法中的输出是首先出现的原因。

简而言之，当Spring容器注入依赖时，它会调用相应的setter方法。

# Bean别名配置

### 使用name

```Java
<bean id="bookDao" name="dao" class="com.itheima.dao.impl.BookDaoImpl" />
<bean id="serviceDao" name="service service2" class="com.itheima.service.impl.BookServiceImpl">
    <property name="bookDao" ref="bookDao" />
</bean>
```

```Java
public class AppForName {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        //        BookDao bookDao = (BookDao) ctx.getBean("dao");
        //        bookDao.save();
        BookService bookService = (BookService) ctx.getBean("service");
        bookService.save();
    }
}
```

# Bean作用范围配置

**Bean的默认配置是单例模式**。单例模式的意思就是在main方法中进行创建对象的时候，直接输出两个实例对象的地址的时候，是相同的。

在这里，实际上可以定义成scope="prototype"，那么在main方法中创建实例对象，对比输出实例对象的地址的时候，就是不同的了。

[![](https://cdn.nlark.com/yuque/0/2023/png/38953059/1696242310873-cccb0438-62bf-483e-bccb-48b5a1be3f94.png)](https://cdn.nlark.com/yuque/0/2023/png/38953059/1696242310873-cccb0438-62bf-483e-bccb-48b5a1be3f94.png)

### Bean为什么默认为单例？

Spring中的Bean默认为单例是为了提高性能和降低资源消耗。

当一个Bean被声明为单例时，Spring容器在应用启动时就会创建并初始化这个Bean，然后将其保存在容器中。之后，每次请求这个Bean时，都会返回容器中已经存在的实例，而不是创建一个新的实例。这样可以避免频繁地创建和销毁对象，减少了资源消耗和提高了性能。

在大多数情况下，单例是合适且高效的，因为很多Bean的状态是相对稳定的，不会频繁变化。而且，单例模式也有助于确保应用中的各个组件共享相同的状态，避免了由于多个实例引起的状态不一致的问题。

然而，有些情况下，如果某个Bean的状态会频繁变化，或者需要特定的生命周期管理，那么可以考虑将其声明为原型（prototype）作用域，这样每次请求时都会创建一个新的实例。但要注意，原型模式可能会带来一些额外的开销，因为需要更频繁地创建和销毁对象。

### Singleton（单例）

- **作用域**: 默认的作用域。
- **生命周期**: Spring容器在启动时创建一个bean实例，并在整个应用生命周期中重用这个实例。
- **管理**: Spring容器管理bean的完整生命周期，包括初始化和销毁。
- **适用场景**: 用于无状态的服务对象，如服务层（Service）、数据访问层（DAO）等。

### Prototype（原型）

```XML
<bean id="serviceDao" name="service service2 bookEbi" class="com.itheima.service.impl.BookServiceImpl">
  <property name="bookDao" ref="bookDao" />
</bean>
<bean id="bookDao" name="dao" class="com.itheima.dao.impl.BookDaoImpl" scope="prototype"/>
```

- **作用域**: 需要明确设置为`scope="prototype"`。
- **生命周期**: 每次通过`getBean()`获取bean时，Spring都会**创建一个新的实例**。
- **管理**: Spring容器不会管理bean的完整生命周期，特别是不会调用`destroy`方法。
- **适用场景**: 用于有状态的bean，或者当你每次需要一个新实例时。

这两者的主要区别在于实例化的数量和生命周期管理。**Singleton保证一个Spring容器中只有一个实例，而Prototype每次获取都会创建一个新的实例。**

### 应用prototype

```Java
public class AppForScope {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        BookDao bookDao1 = (BookDao) ctx.getBean("dao");
        BookDao bookDao2 = (BookDao) ctx.getBean("dao");
        System.out.println(bookDao1);
        System.out.println(bookDao2);
    }
}
```

输出同样的地址值，如果定义的scope是singleton或者是不写scope; 但是如果是scope=prototype所输出的地址值就是不同的。

# 实例化Bean

### 为什么需要实例化Bean呢？

在Spring框架中，你并**不需要在Java类中显式定义构造方法来实例化bean**。**如果你没有为一个类提供构造方法，Java编译器会自动为该类生成一个默认的无参构造方法**。**当Spring容器实例化这个bean时，它会使用这个默认的无参构造方法**。

1. 在`applicationContext`文件中，你已经声明了两个beans：

- `bookDao` 的类型为 `com.itheima.dao.impl.BookDaoImpl`。
- `serviceDao` 的类型为 `com.itheima.service.impl.BookServiceImpl`。

1. 对于`serviceDao` bean，你还定义了一个属性注入，具体来说，是一个setter注入。这意味着当Spring容器实例化`serviceDao` bean后，它还会尝试调用`setBookDao`方法来注入`bookDao` bean。
2. 在`BookServiceImpl`类中，你定义了一个`setBookDao` setter方法，这个方法是用于注入`bookDao`的。当Spring容器看到`<property name="bookDao" ref="bookDao" />`这样的配置时，它知道需要调用`setBookDao`方法，并传入`bookDao` bean作为参数。

总之，即使你没有在`BookServiceImpl`或`BookDaoImpl`中显式定义任何构造方法，Spring仍然可以使用Java自动生成的默认构造方法来实例化这两个bean。实例化bean之后，Spring还会进行属性注入，如你在XML配置中所定义的。

### 构造方法

[![](https://cdn.nlark.com/yuque/0/2023/png/38953059/1696243879384-0dd0e1ab-9813-43d9-a366-9f0e06242bbd.png)](https://cdn.nlark.com/yuque/0/2023/png/38953059/1696243879384-0dd0e1ab-9813-43d9-a366-9f0e06242bbd.png)

### 静态工厂

[![](https://cdn.nlark.com/yuque/0/2023/png/38953059/1696244301178-dd3f030a-3fb3-4688-b06a-8725ab8bceb9.png)](https://cdn.nlark.com/yuque/0/2023/png/38953059/1696244301178-dd3f030a-3fb3-4688-b06a-8725ab8bceb9.png)

### 实例工厂

[![](https://cdn.nlark.com/yuque/0/2023/png/38953059/1696247292727-bfe6c03b-b922-4ca3-b822-df72c0240d75.png)](https://cdn.nlark.com/yuque/0/2023/png/38953059/1696247292727-bfe6c03b-b922-4ca3-b822-df72c0240d75.png)

### FactoryBean

[![](https://cdn.nlark.com/yuque/0/2023/png/38953059/1696246999258-b13c633e-2da7-4501-827a-dde3b4d1a4e7.png)](https://cdn.nlark.com/yuque/0/2023/png/38953059/1696246999258-b13c633e-2da7-4501-827a-dde3b4d1a4e7.png)

`FactoryBean` 是 Spring 框架中的一个接口，用于创建和管理复杂对象的工厂类。**与普通的工厂模式不同，**`**FactoryBean**` **可以被 Spring 容器所管理，可以被配置和注入到其他 Bean 中**。

`FactoryBean` 接口定义了以下方法：

1. **getObject():** 用于获取工厂所创建的对象实例。
2. **getObjectType():** 用于获取工厂创建的对象的类型。
3. **isSingleton():** 返回工厂创建的对象是否是单例的。

通过实现 `FactoryBean` 接口，开发者可以自定义对象的创建逻辑，例如在创建对象前进行一些初始化操作、根据不同的条件创建不同的对象等。`FactoryBean` 可以与 Spring 的 IoC 容器结合使用，使得这些复杂对象的创建和配置更加灵活。

以下是一个简单的示例，展示如何实现一个 `FactoryBean`：

```Java
import org.springframework.beans.factory.FactoryBean;

public class MyObjectFactory implements FactoryBean<MyObject> {

    @Override
    public MyObject getObject() throws Exception {
        // 在这里可以进行一些初始化操作
        return new MyObject();
    }

    @Override
    public Class<?> getObjectType() {
        return MyObject.class;
    }

    @Override
    public boolean isSingleton() {
        return true; // 或者返回 false，表示非单例
    }
}
```

在 Spring 配置文件中，可以这样使用：

```XML
<bean id="myObject" class="com.example.MyObjectFactory"/>
```

这样，当通过容器获取 `myObject` 这个 Bean 时，实际上会调用 `MyObjectFactory` 的 `getObject()` 方法来获取对象实例。

# Bean的生命周期

### 方法一: 配置生命周期控制方法

[![](https://cdn.nlark.com/yuque/0/2023/png/38953059/1696287120386-14ece8ed-c70b-4c13-a0a5-c8efb624fd27.png)](https://cdn.nlark.com/yuque/0/2023/png/38953059/1696287120386-14ece8ed-c70b-4c13-a0a5-c8efb624fd27.png)

### 方法二: 配置接口

[![](https://cdn.nlark.com/yuque/0/2023/png/38953059/1696287163589-dd4a7c71-e6a2-4cb9-be73-e4f447fb30f0.png)](https://cdn.nlark.com/yuque/0/2023/png/38953059/1696287163589-dd4a7c71-e6a2-4cb9-be73-e4f447fb30f0.png)

### 步骤

- 初始化容器
- 创建对象
- 执行构造方法
- 执行属性注入 (set操作)
- 执行bean初始化方法
- 使用bean
- 执行业务操作
- 关闭销毁容器
- 执行bean销毁方法

# bean销毁时机

[![](https://cdn.nlark.com/yuque/0/2023/png/38953059/1696287407868-4f0f62c4-04a7-4181-8e29-16177d84d1fa.png)](https://cdn.nlark.com/yuque/0/2023/png/38953059/1696287407868-4f0f62c4-04a7-4181-8e29-16177d84d1fa.png)