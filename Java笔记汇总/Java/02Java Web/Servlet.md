# Servlet概念解释

## 什么是 Servlet？

Servlet（服务器小程序）是 Java EE（Java Enterprise Edition）规范的一部分，用于构建基于服务器的应用。它是一个 Java 类，用于扩展应用服务器的能力，**主要用于处理来自 Web 客户端（通常是浏览器）的请求和响应**。

## 生命周期：

1. **初始化（Initialization）**：当 Servlet 首次加载到内存或启动时，`init` 方法被调用。这是一个一次性操作，用于加载资源或执行一次性设置。
2. **请求处理（Service）**：每当客户端（通常是 Web 浏览器）向 Servlet 发送请求时，`service` 方法或其相关的 `doGet`, `doPost` 等方法被调用。
3. **销毁（Destruction）**：当 Servlet 从服务器卸载或服务器停止时，`destroy` 方法被调用，用于释放资源和执行清理操作。

## 工作原理：

1. **接收请求**：当用户通过浏览器发送 HTTP 请求时，Web 服务器（如 Tomcat）将请求转发给适当的 Servlet。
2. **处理请求**：Servlet 使用 `HttpServletRequest` 对象**获取客户端发送的数据**，并执行相应的业务逻辑。
3. **生成响应**：Servlet 通过 `HttpServletResponse` 对象**生成响应**，该响应可以是 HTML、XML、JSON 等。
4. **返回响应**：最后，Web 服务器将生成的响应返回给客户端。

## 使用场景：

1. **表单处理**：例如，用户登录和注册。
2. **与数据库交互**：例如，查询、更新或删除数据。
3. **会话跟踪**：通过使用 Cookie 或 Session。
4. **响应过滤**：例如，实现身份验证和授权。
5. **多层架构**：常用于 MVC（模型-视图-控制器）架构的控制器层。

Servlet 是 Java Web 开发中的基础组件，通常与 JSP（JavaServer Pages）、JDBC（Java Database Connectivity）和其他 Java EE 组件一起使用，以构建完整的 Web 应用程序。

# Servlet快速入门

1. 创建web项目，导入Servlet依赖坐标
2. 创建: 定义一个类，实现Servlet接口，并重写接口中所有方法，并在service方法中输入一句话
3. 配置: 在类上使用@WebServlet注解，配置该Servlet的访问路径
4. 访问: 启动Tomcat，浏览器输入URL访问该Servlet

# Servlet方法介绍

- 初始化方法，在Servlet被创建时执行，只执行一次
- 提供服务方法, 每次Servlet被访问，都会调用该方法
- 销毁方法，当Servlet被销毁时，调用该方法。在内存释放或服务器关闭时雄安会Servlet
- 获取ServletConfig对象
- 获取Servlet信息

# Servlet体系结构

## HttpServlet中为什么要根据请求方式的不同，调用不同方法

GET和POST的请求方式，请求消息不一样，要分别去处理

## 如何调用？

获取请求方式，做不同的逻辑判断

## HttpServlet使用步骤

1. 继承HttpServlet
2. 重写doGet和doPost方法

## HttpServlet原理

获取请求方式，并根据不同的请求方式，调用不同的doXxx方法

  

# Servlet urlPattern配置

1. 一个Servlet，可以配置多个urlPattern
2. urlPattern配置规则
    1. 精确匹配
    2. 目录匹配。有一个情况需要注意，就是当目录匹配和精确匹配的上一级目录相同，当前访问的目录匹配所包括的范围又包含精确匹配的目录。那么这个时候就会优先访问精确匹配。例如 /user/select和/user/*
    3. 扩展名匹配
    4. 任意匹配
        1. /*的优先级高于/

  

# XML配置方式编写Servlet

比较老的方法

  

# 一般来说都会使用注解的方式来访问Servlet