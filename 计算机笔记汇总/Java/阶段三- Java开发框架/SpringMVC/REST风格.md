# REST简介

Representational State Transfer，表现形式状态转换

REST，全称为 Representational State Transfer。它利用标准化的 HTTP 方法和状态码，以及 MIME 类型（例如 XML 和 JSON）来构建网络应用。REST 通常用于构建基于网络的分布式系统。

REST 遵循以下六个原则：

1. **无状态（Stateless）**：每个请求从客户端到服务器必须包含所有的信息，服务器不会保存之前的任何请求信息。
2. **客户端-服务器（Client-Server）**：系统分为客户端和服务器两部分，各自负责不同的任务。
3. **可缓存（Cacheable）**：服务器的响应可以被明确标记为可缓存或不可缓存。
4. **分层系统（Layered System）**：可以通过层次化的方式组织系统，每一层只与相邻的层交互。
5. **按需编码（Code-On-Demand，可选）**：服务器可以将可执行代码传输给客户端，以扩展客户端功能。
6. **统一接口（Uniform Interface）**：统一的接口简化了系统架构，使得系统的各部分可以独立地演化。

RESTful 是对 REST 架构风格的实现。一个 RESTful 的服务通常会遵循 REST 原则，并通过标准的 HTTP 方法（如 GET, POST, PUT, DELETE）来实现资源的创建、读取、更新和删除（CRUD）操作。RESTful 服务通过简单、轻量和标准化的方式，使得不同系统和应用能够通过网络轻松地交互。

在构建网络应用时，采用 RESTful 架构可以帮助简化系统设计和提高可维护性。同时，由于 RESTful 架构的简洁和高效，它已成为现代网络应用和服务开发的流行选择。

## 4个动作

查询、新增、修改、删除 == get、post、put、delete

### @RequestMapping 家族中的注解共有以下几种:

@RequestMapping:用于类或方法上, **用于映射 Web 请求到具体的 Controller 类/方法**。可以**指定请求方法、路径**等。

- @GetMapping: 组合了`@RequestMapping(method = RequestMethod.GET)`,映射 HTTP GET 请求。
- @PostMapping: 组合了`@RequestMapping(method = RequestMethod.POST)`,映射 HTTP POST 请求。
- @PutMapping: 组合了`@RequestMapping(method = RequestMethod.PUT)`,映射 HTTP PUT 请求。
- @DeleteMapping: 组合了`@RequestMapping(method = RequestMethod.DELETE)`,映射 HTTP DELETE 请求。
- @PatchMapping: 组合了`@RequestMapping(method = RequestMethod.PATCH)`,映射 HTTP PATCH 请求。

它们都可以注解在类和方法上, 用来映射特定的 HTTP 请求方式到处理方法。

使用更具体的 HTTP 方法 mapping 注解, 可以使代码更清晰直观,推荐使用具体的方法注解来映射请求。

此外, @RequestMapping 注解也可以设置其他属性如 path、params、headers 等来映射请求。

# REST风格简介

[![](https://cdn.nlark.com/yuque/0/2023/png/38953059/1699319587553-2aa0911f-0e2a-4a13-84d9-28d6c6766ecf.png)](https://cdn.nlark.com/yuque/0/2023/png/38953059/1699319587553-2aa0911f-0e2a-4a13-84d9-28d6c6766ecf.png)

[![](https://cdn.nlark.com/yuque/0/2023/png/38953059/1699319684042-ae23202e-b741-4636-bf12-2a2599754564.png)](https://cdn.nlark.com/yuque/0/2023/png/38953059/1699319684042-ae23202e-b741-4636-bf12-2a2599754564.png)

# RESTful入门案例

[![](https://cdn.nlark.com/yuque/0/2023/png/38953059/1697175713661-8a0d3ccd-7a0e-4991-89ed-6b9752dc328c.png)](https://cdn.nlark.com/yuque/0/2023/png/38953059/1697175713661-8a0d3ccd-7a0e-4991-89ed-6b9752dc328c.png)

## 区分PathVariable和@RequestParam

从 URL 中获取参数（通过 `@PathVariable`）和从请求的查询参数中获取参数（通过 `@RequestParam`）是两种常用的方法，它们在 URL 结构和用途上有显著的区别：

1. **从 URL 中获取参数（使用** `**@PathVariable**`**）**：
    - **URL 结构**：参数是 URL 路径的直接组成部分。例如，在 `/users/123` 中，`123` 是一个路径变量，代表了特定的用户 ID。
    - **用途**：路径变量通常用于标识特定资源。在 RESTful API 设计中，这种方法用于直接访问或操作具有特定 ID 或名称的资源。
    - **示例**：在 Spring MVC 中，使用 `@GetMapping("/users/{userId}")` 可以获取 URL 路径中的 `userId`。
2. **从请求的查询参数中获取参数（使用** `**@RequestParam**`**）**：
    - **URL 结构**：参数位于 URL 的查询字符串部分，即 `?` 后面的部分。例如，在 `/users?age=25` 中，`age=25` 是一个查询参数。
    - **用途**：查询参数通常用于对请求进行过滤、排序或提供其他指令，而不是直接标识资源。这适用于搜索、分页或其他类型的查询操作。
    - **示例**：在 Spring MVC 中，使用 `@GetMapping("/users")` 并结合 `@RequestParam` 可以获取查询参数，如 `age`。

**关键区别**：

- **路径变量** 是 URL 的一部分，直接指向特定的资源。它们是 RESTful URL 的核心组成部分，用于访问或操作具体的资源实例。
- **查询参数** 是附加在 URL 末尾的可选参数，用于调整或详细说明对资源的请求，例如过滤、排序或者是详细说明请求的特定方面。

在实际应用中，这两种方法经常结合使用。例如，你可能会用路径变量来指定你想要操作的特定资源，同时使用查询参数来进一步说明这个操作，如 `/users/123?expand=details`。这里，`123` 是路径变量，指定了特定的用户，而 `expand=details` 是一个查询参数，指示 API 提供该用户的详细信息。

# Rest快速开发

## `@RestController`

在 Spring 框架中，创建一个用于处理Web请求的控制器（Controller）类时，我们通常会在类上使用 `@Controller` 注解。这个注解告诉Spring，该类将被用作处理入站HTTP请求的控制器。

但是，**当我们打算构建一个RESTful Web服务时**，**我们希望这些请求处理方法返回的结果直接作为HTTP响应的主体返回给客户端**，**而不是解析为视图（比如HTML页面）**。为了实现这一点，我们通常会在每个请求处理方法上添加一个 `@ResponseBody` 注解，这样Spring就知道要将方法的返回值转换为JSON或XML格式的数据，并将其直接写入HTTP响应中。

`@RestController` 注解简化了这个过程。**它是** **`@Controller`** **和** **`@ResponseBody`** **注解的组合体**，这意味着你可以**将整个控制器类标记为处理HTTP请求**，同时**默认所有的方法都会将它们的返回值作为HTTP响应的主体来处理**。

因此，当你在一个类上使用 `@RestController` 注解时，你是在告诉Spring：

- 这个类是一个控制器，用于接收和处理HTTP请求。
- 你不打算返回任何视图，而是希望返回的数据（比如对象、字符串、列表等）被自动转换为JSON或XML，并作为HTTP响应发送给客户端。

`@RestController` 是创建RESTful服务的首选方式，因为它让服务的创建变得更加简单和直接。所有的数据处理工作都在后端完成，而无需关心数据如何显示在客户端，客户端会收到一个可以直接使用的数据格式。

## 标准请求动作映射 (4种)

  

# Restful基于页面的数据案例

SpringMVC + Vue