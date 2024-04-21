# SpringMVC概述

SpringMVC是一种基于Java实现MVC模型的轻量级Web框架

## SpringMVC与Servlet区别？

SpringMVC 和 Servlet 之间的关系可以从两个角度来理解：技术层面和设计理念层面。

### 技术层面

1. **Servlet**: Servlet 是 Java EE 规范的一部分，是一种用于开发动态网站的技术。它在服务器端运行，可以接收来自客户端的请求，并生成响应。Servlet 是一个低级别的 API，直接处理 HTTP 请求和响应。
2. **Spring MVC**: Spring MVC 是基于 Spring Framework 构建的一个高级 Web 框架。它遵循 Model-View-Controller（MVC）设计模式，简化了 Web 应用的开发。**Spring MVC 使用了 Servlet 技术作为其底层基础，但提供了更高级的抽象和更多的便利功能**。

### 设计理念层面

- **Servlet** 提供了处理 HTTP 请求的基础设施，但它不强制任何特定的设计模式，使得开发者在使用时需要处理很多底层细节。
- **Spring MVC** 则提供了一个声明性的方式来定义请求映射、数据绑定、数据验证等功能。它将请求处理流程中的不同部分清晰地分离开，使得开发者可以更专注于业务逻辑，而不是底层的 HTTP 交互细节。

### 关系总结

- Spring MVC 并不是为了替代 Servlet 技术，而是基于 Servlet 构建的，提供了更为丰富和高级的功能，简化了 Web 应用的开发。
- Servlet 作为低级别的 API，仍然是 Java Web 开发的基石，而 Spring MVC 等框架则是在此基础上提供了更易用、更高效的开发模式。

在实际应用中，Spring MVC 框架会处理很多繁琐且重复的工作，使得开发者可以更加专注于业务逻辑的实现，从而提高开发效率和应用质量。

  

[[SpringMVC入门案例]]

[[bean加载]]

[[请求与响应]]

[[REST风格]]

[[SSM整合]]

[[拦截器]]

[[总结SpringMVC注解]]