# `@Controller`

类注解。在SpringMVC控制器类定义上方。用来设定SpringMVC的核心控制器bean。它是一个Spring MVC注解，它标识这个类是一个控制器类。控制器类负责处理来自用户的HTTP请求，并返回响应。

# `@RequestMapping`

- 方法注解。SpringMVC控制器的**方法定义上方**。用来**设置当前控制器方法响应内容为当前返回值，无需解析**。@RequestMapping("/save") 注解告诉Spring MVC，这个方法应该处理所有发送到/save路径的请求。

  

# `@ResponseBody`

- 注解表示**此方法的返回值应直接写入HTTP响应体**。
- `@ResponseBody`注解的作**用是将Controller的方法返回的对象通过适当的转换器转换为指定的格式****之后，写入到response对象的body区**，**通常用来返回JSON数据**或者是XML数据[1]。
- 当方法上面没有写`@ResponseBody`时，底层会将方法的返回值封装为ModelAndView对象。
    - 如果返回值是字符串，直接将字符串写到客户端；
    - 如果是一个对象，会将对象转化为json串，然后写到客户端[2]。这个注解通常用于RESTful API接口的开发，可以方便地返回结构化的数据给客户端。

  

# 发送请求

见这篇notion的总结: [[请求与响应]]

## `@RequestParam`

这个注解主要是用来匹配函数传参的形参和实际的实体类中的字段值不匹配，如何解决？

通过添加注解，可以匹配上参数了

```Java
@RequestMapping("/commonParamDifferentName")
  @ResponseBody
  public String commonParamDifferentName(@RequestParam("name") String userName, int age) {
      System.out.println("普通参数传递 name ==> " + userName);
      System.out.println("普通参数传递 age ==> " + age);
      return "{'module':'common param different name'}";
  }
```

  

  

还有另一种用法:

集合参数传递的形式:

```Java
@RequestMapping("/listParam")
    @ResponseBody
    public String listParam(@RequestParam List<String> likes) {
        System.out.println("集合参数传递 ==> " + likes);
        return "{'module':'list param'}";
    }
```

基本数据类型不是必须加@RequestParam注解，但是引用数据类型必须要加

  

## `@RequestBody`注解

### 用法一

POJO参数 JSON格式: [http://localhost/listParamForJson](http://localhost/listParamForJson)

["game", "travel", "dance"] 传递数组其中包含3个字符串

```Java
@RequestMapping("/listParamForJson")
    @ResponseBody
    public String listParamForJson(@RequestBody List<String> likes) {
        System.out.println("list common(json)参数传递 list ==> " + likes);
        return "{'module':'list common for json param'}";
    }
```

  

### 用法二

还有一种用法: POJO的JSON格式 (对象传递):

- [http://localhost/pojoParamForJson](http://localhost/pojoParamForJson)

```Java
{
    "name": "itcast",
    "age": 15,
    "address": {
        "province": "beijing",
        "city": "beijing"
    }
}
```

  

```Java
@RequestMapping("/pojoParamForJson")
    @ResponseBody
    public String PojoParamForJson(@RequestBody User user) {
        System.out.println("pojo(json)参数传递 user ==> " + user);
        return "{'module':'user pojo for json param'}";
    }
```

  

### 用法三

List POJO形式 JSON格式: [http://localhost/listPojoParamForJson](http://localhost/listPojoParamForJson)

```Java
[
    {"name": "itcast", "age": 15},
    {"name": "itheima", "age": 12}
]
```

  

```Java
@RequestMapping("/listPojoParamForJson")
    @ResponseBody
    public String listPojoParamForJson(@RequestBody List<User> list) {
        System.out.println("list pojo(json)参数传递 user ==> " + list);
        return "{'module':'list user pojo for json param'}";
    }
```

  

# Restful风格

## `@RequestMapping` 家族中的注解共有以下几种:

@RequestMapping: 用于类或方法上, **用于映射 Web 请求到具体的 Controller 类/方法**。可以**指定请求方法、路径**等。

- @GetMapping: 组合了`@RequestMapping(method = RequestMethod.GET)`, 映射 HTTP GET 请求。
- @PostMapping: 组合了`@RequestMapping(method = RequestMethod.POST)`, 映射 HTTP POST 请求。
- @PutMapping: 组合了`@RequestMapping(method = RequestMethod.PUT)`, 映射 HTTP PUT 请求。
- @DeleteMapping: 组合了`@RequestMapping(method = RequestMethod.DELETE)`, 映射 HTTP DELETE 请求。
- @PatchMapping: 组合了`@RequestMapping(method = RequestMethod.PATCH)`, 映射 HTTP PATCH 请求。
- 它们**都可以注解在类和方法上**, 用来映射特定的 HTTP 请求方式到处理方法。
- 使用更具体的 HTTP 方法 mapping 注解, 可以使代码更清晰直观,推荐使用具体的方法注解来映射请求。

  

## 区分@RequestParam和@PathVariable

在 Spring MVC 中，`@PathVariable` 和 `@RequestParam` 用于从 HTTP 请求中提取数据，但它们适用于不同的情况：

在 Spring MVC 中，`@PathVariable` 和 `@RequestParam` 用于从 HTTP 请求中提取数据，但它们适用于不同的情况：

### `**@PathVariable**`

**用途**：用于获取 URL 路径中的变量。它是 RESTful URL 模式的一部分，通常用**于获取识别资源的关键字段**，如用户 ID 或项目 ID。路径变量通常用于标识特定资源。在 RESTful API 设计中，这种方法用于直接访问或操作具有特定 ID 或名称的资源。

**示例**：如果有一个 URL 路径如 `/users/{userId}`，其中 `{userId}` 是一个路径变量，可以使用 `@PathVariable` 来获取这个值。

**URL 结构**：参数是 URL 路径的直接组成部分。例如，在 `/users/123` 中，`123` 是一个路径变量，代表了特定的用户 ID。

  

**代码示例**：

```Java
	  @GetMapping("/users/{userId}")
	  public String getUser(@PathVariable String userId) {
	      // ...
	  }
```

  

**用途**：用于获取查询参数（即 URL 中 `?` 后面的参数）。它**通常用于处理非路径参数**，如分页参数、搜索查询或其他过滤条件。

**示例**：在 URL `/users?username=john` 中，`username` 是一个查询参数。

**代码示例**：

```Java
	  @GetMapping("/users")
	  public String getUserByUsername(@RequestParam String username) {
	      // ...
	  }
```

### `**@RequestParam**`

**URL 结构**：参数位于 URL 的查询字符串部分，即 `?` 后面的部分。例如，在 `/users?age=25` 中，`age=25` 是一个查询参数。

**用途**：查询参数通常用于对请求进行过滤、排序或提供其他指令，而不是直接标识资源。这适用于搜索、分页或其他类型的查询操作。

**示例**：在 Spring MVC 中，使用 `@GetMapping("/users")` 并结合 `@RequestParam` 可以获取查询参数，如 `age`。

  

### **关键区别**：

- **路径变量** 是 URL 的一部分，**直接指向特定的资源**。它们是 RESTful URL 的核心组成部分，用于访问或操作具体的资源实例。
- **查询参数** 是附加在 URL 末尾的**可选参数**，用于调整或详细说明对资源的请求，例如过滤、排序或者是详细说明请求的特定方面。
- 在实际应用中，这两种方法经常结合使用。例如，你可能会用路径变量来指定你想要操作的特定资源，同时使用查询参数来进一步说明这个操作，如 `/users/123?expand=details`。这里，`123` 是路径变量，指定了特定的用户，而 `expand=details` 是一个查询参数，指示 API 提供该用户的详细信息。
- **URL 结构**：
    - `@PathVariable` 是 URL 路径的一部分，如 `/resource/{pathVariable}`。
    - `@RequestParam` 是 URL 中的查询参数，如 `/resource?requestParam=value`。
- **用途**：
    - 使用 `@PathVariable` 时，通常是在处理 RESTful Web 服务，URL 中的路径部分用于指定资源。
    - 使用 `@RequestParam` 时，通常是在处理基于表单的数据提交或者 URL 中的过滤参数。
- **可选性**：
    - 路径变量（`@PathVariable`）通常是**必需**的，因为它们定义了访问资源的路径。
    - 查询参数（`@RequestParam`）可以是**可选**的，可以设置默认值。

  

## 如何确定什么时候用哪个注解呢？

**疑问**: 我在做开发的时候怎么确定我要请求的是一个特定资源，还是一个可选参数呢？举例来说，如果我想要查询某个用户的id，那么实际上我既可以用pathvariable这种定位的方式来查询，也可以通过指定查询参数的id值来找到他。

  

确定使用 `@PathVariable` 还是 `@RequestParam` 主要取决于 API 的设计和资源的表示方式。以下是一些指导原则帮助您作出决定：

### **资源的标识和表示**：

如果您的操作**针对的是一个具体的、单一的资源实体**，通常使用 `@PathVariable`。例如，获取、更新或删除特定用户的操作，可以将用户的 ID 作为路径的一部分：`/users/{userId}`。这里 `{userId}` 是资源的唯一标识符，表明您正在操作特定的用户资源。

### 操作的特性和过滤：

如果您的操作更多是**基于过滤条件或需要额外的操作参数**，而**不是**直接针对单一具体资源，使用 `@RequestParam` 更合适。例如，查询年龄等于某个值的所有用户，可以使用 `/users?age=25`。这里 `age` 是一个筛选条件，用于查询符合条件的用户集合，而不是单一的用户实体。

### **RESTful API 设计原则**：

在 RESTful API 设计中，URL 应该表示资源，而查询参数用于对这些资源或请求进行过滤、排序或描述。因此，如果您正在定位或操作一个特定资源，应该使用路径变量。如果是在执行更广泛的查询或提供操作的额外细节，使用查询参数。

### **明确性和直观性**：

设计 API 时，应该考虑到 URL 的明确性和直观性。路径变量通常使 URL 路径更加直观地表示对特定资源的操作。查询参数则在不改变资源路径的前提下提供了额外的灵活性。

**示例场景**：

- 获取特定用户的信息：`GET /users/{userId}` （这里 `{userId}` 是路径变量）
- 根据特定条件查询用户：`GET /users?age=25` （这里 `age` 是查询参数）

在实际开发中，有时两者可以达到类似的效果，但从 RESTful 设计原则和语义清晰性出发，选择合适的方法可以使 API 更加直观和易于理解。