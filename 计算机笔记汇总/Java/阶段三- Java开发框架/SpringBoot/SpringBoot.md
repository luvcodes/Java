# SpringBoot快速启动

点击package的部份就会在项目下的target中产生一个jar包

[![](https://cdn.nlark.com/yuque/0/2023/png/38953059/1698443900188-34aba55d-7238-4178-b76f-afc388f27912.png)](https://cdn.nlark.com/yuque/0/2023/png/38953059/1698443900188-34aba55d-7238-4178-b76f-afc388f27912.png)

进入到jar包所在的文件夹中，终端输入指令 java -jar springboot_01_quickstart-0.0.1-SNAPSHOT.jar

# SpringBoot程序启动

## 起步依赖（Starter Dependencies）

在Spring Boot中，起步依赖是一组方便的依赖集合，可以简化你的项目配置。这些依赖通常以 `spring-boot-starter-*` 的形式出现。例如：

- `spring-boot-starter-web`：用于构建web应用，包括RESTful应用或者MVC应用。
- `spring-boot-starter-data-jpa`：用于Spring Data JPA的基础设置。
- `spring-boot-starter-security`：用于集成Spring Security。

通过添加这些起步依赖，你可以一次性添加多个相关的依赖，而不需要逐一添加和管理。

## parent

减少配置的以来冲突

## starter

主体做简化配置，但是它要用到parent里面继承过来的配置版本

## **引导类（Bootstrap Class）**

引导类是用来启动程序的，其实是初始化了一个Spring容器。Spring Boot应用程序的入口点，通常用 `@SpringBootApplication` 注解标记，并包含 `main` 方法来启动应用。这个注解实际上是一个复合注解，它包括：

- `@SpringBootConfiguration`: 标记一个类为配置类。
- `@EnableAutoConfiguration`: 自动配置Spring应用。
- `@ComponentScan`: 自动扫描和注册bean。

这样，Spring Boot可以自动配置很多项目的基础设置。

运行这个 `main` 方法，Spring Boot就会启动，并基于添加的起步依赖自动配置应用。

```Java
@SpringBootApplication
public class Springboot01Quickstart1Application {
    public static void main(String[] args) {
        SpringApplication.run(Springboot01Quickstart1Application.class, args);
    }
}
```

## **辅助功能**

- 内嵌Tomcat服务器是SpringBoot辅助功能之一
- 内嵌Tomcat工作原理是**将Tomcat服务器作为对象运行**，并将**该对象交给Spring容器管理**
- 变更内嵌服务器思想是去除现有服务器，添加全新的服务器

## **使用maven依赖管理变更起步依赖项**

```XML
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-web</artifactId>
  <exclusions>
    <exclusion>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-tomcat</artifactId>
    </exclusion>
  </exclusions>
</dependency>
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-jetty</artifactId>
</dependency>
```

这里的意思就是exclude掉tomcat服务器，使用jetty服务器。

### 区分Tomcat和Jetty

- **Tomcat** 更适合传统的、大型的企业级应用，特别是那些需要稳定性和丰富管理功能的场景。
- **Jetty** 更适合现代、轻量级的应用，尤其是在微服务架构和快速开发周期的场景中表现出色。

  

[[基础配置]]

[[整合第三方技术]]

[[SSMP整合案例]]

[[热部署]]

[[配置高级]]

[[测试]]

[[数据层解决方案]]

[[Springboot原理]]