# 引用类型注入

`@Autowired`解决引用类型注入

`@Qualifier`指定注入的id或名称的。使用`@Qualifier`注解开始指定名称装配bean。它不能单独使用，必须配合@Autowired注解使用。

```Java
import com.itheima.dao.impl.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    @Qualifier("bookDao")
    private BookDao bookDao;
    public void save() {
        System.out.println("book service save...");
        bookDao.save();
    }
}
```

**可以不写setBookDao方法了**

自动装配**基于反射设计创建对象**并暴力反射对应属性为私有属性初始化数据，因此无需提供setter方法。

自动装配建议使用无参构造方法创建对象 (默认), 如果不提供对应构造方法，请提供唯一的构造方法。无参构造方法默认就有，如果写了有参构造方法那么无参构造方法就没了，就要自己重新写。

### 对比自动装配和setter方法注入引用类型

`@Autowired` 注解是Spring框架中用于实现依赖注入的一种方式。**它可以用于替代传统的setter方法或构造函数进行注入。**

1. 注解位置：

- `@Autowired` 可以用于字段、setter方法和构造函数上。
- Setter方法注入通常通过XML配置或Java配置类中来指定依赖关系。

1. 自动装配：

- `@Autowired` 通过类型自动装配依赖，即**Spring容器会自动寻找与目标字段或参数类型匹配的Bean**，并注入到相应的字段或参数中。
- 而通过setter方法，你通常需要手动指定依赖关系。

1. 代码简洁性：

- **使用** `**@Autowired**` **可以使代码更为简洁，不需要编写额外的setter方法**，也不需要在配置文件中指定依赖关系。
- Setter方法注入可能会使代码量稍微增加，但它提供了更明确的依赖关系配置。

1. 可维护性：

- `@Autowired` 的自动装配特性可能在某些情况下影响代码的可读性和可维护性，特别是当项目中存在多个同类型的Bean时。
- 通过setter方法注入，开发者可以更明确地控制依赖关系，从而可能提高代码的可维护性。

1. 依赖检查：

- `@Autowired` 默认要求依赖对象必须存在，如果不存在，将抛出异常。但你可以通过设置 `required` 属性为 `false` 来使其变为可选依赖。
- Setter方法注入通常不会执行这种强制性检查，除非你在配置中明确指定。

`@Autowired` 是一种更为简洁和现代的依赖注入方式，它可以替代setter方法进行依赖注入。