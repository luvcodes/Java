# 统一配置管理

当微服务部署的实例越来越多，达到数十、数百时，逐个修改微服务配置就会让人抓狂，而且很容易出错。我们需要一种**统一配置管理方案，可以集中管理所有实例的配置**。

Nacos一方面可以将**配置集中管理**，另一方可以在**配置变更时，及时通知微服务，实现配置的热更新**。

## 在nacos 中添加配置文件

如何在nacos中管理配置呢？

![[Pasted image 20240421082734.png]]

然后在弹出的表单中，填写配置信息：

![[Pasted image 20240421082751.png]]

> 注意：项目的核心配置，需要**热更新的配置才有放到nacos管理的必要**，不需要把所有的配置都放进来。基本不会变更的一些配置还是保存在微服务本地比较好。


## 从微服务拉取配置

微服务要拉取 nacos 中管理的配置，并且与本地的 application. Yml 配置合并，才能完成项目启动。

但如果尚未读取 application. Yml，又如何得知 nacos 地址呢？

因此**spring 引入了一种新的配置文件**：**bootstrap. Yaml 文件**，会**在 application. Yml 之前被读取**，流程如下：

一个bootstrap.yaml文件，内容如下：
```yaml
spring:  
  application:  
    name: userservice # 服务名称  
  profiles:  
        active: dev #开发环境，这里是dev   
  cloud:  
    nacos:  
      server-addr: localhost:8848 # Nacos地址  
      config:  
        file-extension: yaml # 文件后缀名
```

这里会根据spring.cloud.nacos.server-addr获取nacos地址，再根据`${spring.application.name}-${spring.profiles.active}.${spring.cloud.nacos.config.file-extension}`作为文件id，来读取配置。服务名称 + 开发环境 + 文件后缀名 就是在nacos可视化界面的DataID

本例中，就是去读取 `userservice-dev.yaml`：

![[Pasted image 20240421082928.png]]

# 配置热更新

我们最终的目的，是修改nacos中的配置后，微服务中无需重启即可让配置生效，也就是**配置热更新**。

要实现配置热更新，可以使用两种方式：

## @RefreshScope 注解

在**@Value注入的变量所在类**上添加注解 `@RefreshScope`：

![[Pasted image 20240421083250.png]]

## **@ConfigurationProperties注解**

**使用@ConfigurationProperties注解代替@Value注解。**

在user-service服务中，添加一个类，读取patterrn.dateformat属性：
```java
package cn.itcast.user.config;  
​  
import lombok.Data;  
import org.springframework.boot.context.properties.ConfigurationProperties;  
import org.springframework.stereotype.Component;  
​  
@Component  
@Data  
@ConfigurationProperties(prefix = "pattern")  
public class PatternProperties {  
    private String dateformat;  
}
```

在UserController中使用这个类代替 `@Value`：

# 配置更新

其实微服务启动时，会去nacos读取多个配置文件，例如：
- `[spring.application.name]-[spring.profiles.active].yaml`，例如：userservice-dev.yaml
- `[spring.application.name].yaml`，例如：userservice.yaml

**而`[spring.application.name].yaml`不包含环境，因此可以被多个环境共享。**而加了profile的yaml文件则不能被共享。

# 配置共享优先级

**当nacos、服务本地同时出现相同属性**时，优先级有高低之分：

![[Pasted image 20240421083841.png]]

