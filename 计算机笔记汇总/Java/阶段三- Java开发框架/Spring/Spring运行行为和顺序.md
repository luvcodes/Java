Spring容器在运行时会执行多个关键步骤来初始化和管理应用程序中的bean。

1. **启动Spring容器：**

- 应用程序启动时，Spring容器会被初始化。这通常发生在`ApplicationContext`的实现类（如`ClassPathXmlApplicationContext`或`AnnotationConfigApplicationContext`）被实例化时。

1. **定位和加载Bean定义：**

- Spring容器会定位并加载应用程序中定义的所有bean。这些定义可以通过XML配置、Java配置或者注解来指定。

1. **创建Bean的实例：**

- Spring容器根据bean定义创建相应的bean实例。这可能涉及到调用构造函数、设置属性、执行初始化方法等。

1. **依赖注入：**

- 如果bean之间存在依赖关系，Spring容器会注入相应的依赖。这可以通过构造函数注入、setter方法注入或字段注入来实现。

1. **Bean的初始化方法：**

- 如果bean定义中指定了初始化方法，Spring容器会在bean创建完成后调用该方法。

1. **Bean的使用：**

- 当bean初始化完成并且所有依赖关系都被解决时，应用程序可以使用这些bean。

1. **Bean的销毁方法（可选）：**

- 如果bean定义中指定了销毁方法，Spring容器在关闭时会调用这些方法，用于释放资源或执行清理操作。

1. **关闭Spring容器：**

- 当应用程序关闭时，Spring容器可以被显式关闭。这会触发销毁阶段，其中包括调用所有bean的销毁方法。

这个过程确保了应用程序中的所有bean都得到正确地初始化、注入和管理。具体的行为可能会因为使用的`ApplicationContext`实现以及配置方式的不同而有所差异。例如，如果使用XML配置，容器会首先解析XML文件，然后实例化和初始化相应的bean。如果使用基于Java的配置，容器将扫描指定的Java配置类并相应地初始化bean。