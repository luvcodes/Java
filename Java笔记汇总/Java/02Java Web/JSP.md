# 概念

Java Server Pages，Java服务端页面

一种动态的网页技术，其中既可以定义HTML、CSS、JS等静态内容，还可以定义Java代码的动态和内容

JSP = HTML + Java

# 作用

简化开发，避免了再Servlet中直接输出HTML标签

# JSP快速入门

1. 导入JSP坐标
2. 创建JSP文件
3. 编写HTML标签和Java代码

# JSP原理

**JSP本质上就是一个Servlet**

JSP在被访问时，由JSP容器(Tomcat)将其转换为Java文件 (Servlet)，在由JSP容器(Tomcat)将其编译，最终提供服务的其实就是这个字节码文件。

# JSP脚本

```Java
<%
    System.out.println("Hello, jsp!");
    int i = 3;
%>

<%="hello"%>
<%=i%>

<%!
void show() {
    String name = "zhangsan";
}
%>
```

# JSP缺点

- 书写麻烦
- 阅读麻烦
- 复杂度搞: 运行需要依赖于各种环境
- 占内存和磁盘: JSP会自动生成.java和.class文件占磁盘，运行的是.class文件占内存

# EL表达式

# Expression Language

用于简化JSP页面内的Java代码

主要功能: 获取数据

语法: `${expression`

JavaWeb中的四大域对象

1. page
2. request
3. session
4. application

el表达式获取数据，会依次从这4个域中寻找，知道找到为止

# JSTL标签

JSP标准标签库，使用标签取代JSP页面上的Java代码

# MVC模式和三层架构

[![](https://cdn.nlark.com/yuque/0/2023/png/38953059/1695944307193-4dac133b-97f5-4866-bafd-a9dfeb77dfdd.png)](https://cdn.nlark.com/yuque/0/2023/png/38953059/1695944307193-4dac133b-97f5-4866-bafd-a9dfeb77dfdd.png)