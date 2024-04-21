# Cookie

定义: Cookie 是由网站服务器发送到用户浏览器并存储在浏览器中的一小段数据。它用于记住用户的某些信息，以便在下次访问同一网站时能够读取这些信息。

特点:

- 存储在客户端（浏览器）
- 有大小和数量限制
- 可设置过期时间

[![](https://cdn.nlark.com/yuque/0/2023/png/38953059/1695953809704-92245163-2711-4826-a81a-300ffe681093.png)](https://cdn.nlark.com/yuque/0/2023/png/38953059/1695953809704-92245163-2711-4826-a81a-300ffe681093.png)

## Cookie的数据类型

Cookie 通常是一小段文本数据，它由服务器发送到用户的浏览器，并在后续请求中由浏览器返回给服务器。这些数据通常是键-值对（key-value pairs）的形式，存储为字符串。在HTTP协议中，Cookie 在HTTP头部通过`Set-Cookie`字段从服务器发送到客户端，然后通过`Cookie`字段从客户端发送回服务器。

例如，一个简单的Cookie可能看起来像这样：

```Java
Set-Cookie: sessionId=abc123; Path=/; Expires=Wed, 09 Jun 2021 10:18:14 GMT
```

这里，`sessionId=abc123`是键-值对，而`Path=/`和`Expires=Wed, 09 Jun 2021 10:18:14 GMT`是其他可选属性。

在编程语言中，如JavaScript，你通常可以通过对象或字典（键-值映射）来操作Cookie，但底层数据实际上是字符串。

总体来说，Cookie 是字符串数据类型，但在处理它们时，你通常会用到更复杂的数据结构，如对象或字典，以便更容易地操作它们。

## Cookie基本使用

1. 创建Cookie对象，设置数据
2. 发送Cookie到客户端，使用response对象的`addCookie()`方法
3. 获取客户端携带的所有Cookie，使用request对象
4. 遍历数组，获取每一个Cookie对象
5. 使用Cookie对象方法获取数据

## Cookie原理

- Cookie的是实现是基于HTTP协议的
- 响应头: set-cookie
- 请求头: cookie

## Cookie使用细节

- Cookie存活时间
- 默认情况下，Cookie存储在浏览器内存中，**浏览器关闭，内存释放，Cookie被销毁**
- `setMaxAge(int seconds)` 设置Cookie存活时间
- 正数
- 负数
- 零
- Cookie存储中文
- Cookie不能直接存储中文
- 如需要存储，则需要进行转码，URL编码

# Session

服务端会话跟踪技术: 将数据保存到服务端

因为像Cookie这样的存储在客户端的方式，数据不停地在网络中进行传输，并不是很安全的，所以要将数据存储在服务端。

[![](https://cdn.nlark.com/yuque/0/2023/png/38953059/1695953766281-57cc47ac-173b-45a2-9200-54ad3fe6f5c9.png)](https://cdn.nlark.com/yuque/0/2023/png/38953059/1695953766281-57cc47ac-173b-45a2-9200-54ad3fe6f5c9.png)

## Session基本使用

这是进行了两次请求，因为浏览器访问了两次页面，但是实际上还是在同一个Session会话中 (因为浏览器没有关闭)

1. 获取Session对象
2. Session对象功能
3. `void setAttribute(String name, Object o)` 存储数据到session域中
4. `Object getAttribute(String name)` 根据key，获取值
5. `void removeAttribute(String name)` 根据key，删除该键值对

## Session原理

Session是基于Cookie实现的

[![](https://cdn.nlark.com/yuque/0/2023/png/38953059/1695954480043-b3d3de13-a466-41a4-8ef3-4ae30124de58.png)](https://cdn.nlark.com/yuque/0/2023/png/38953059/1695954480043-b3d3de13-a466-41a4-8ef3-4ae30124de58.png)

两组请求和响应，在**同一个浏览器中 (客户端中)**，要保证两个session应该是连接到同一个session中。如何判断？通过控制台sout输出两个session，对比两个session的地址值。这样不管获取多少次，获取的都是同一个session对象。

那么如何保证两个请求访问到的session对象是同一个呢？

[![](https://cdn.nlark.com/yuque/0/2023/png/38953059/1695954912933-f7ccb5b0-204e-4130-a526-5e1c62e4c880.png)](https://cdn.nlark.com/yuque/0/2023/png/38953059/1695954912933-f7ccb5b0-204e-4130-a526-5e1c62e4c880.png)

- 会先获取一个session对象的唯一标识。那么当前servlet文件运行完成之后，tomcat要对浏览器做出响应，tomcat自动把sessionId当作一个cookie发送给浏览器，也就是**响应一**。
- 然后浏览器就会把这个set-cookie部分的sessionId = 10存储到浏览器内部，其实就是一个cookie
- 在请求 2 中，浏览器带着JSESSIONID = 10的信息，访问另一个目标servlet文件，那这个时候就会根据cookie头携带对应的数据。在第二次获取的时候，就是请求2，会读取内存中寻找，有没有一个sessionId叫做10的session对象，发现如果从 session 对象中读取该唯一标识符与请求头的sessionId相同，那么实际访问的就是同一个session对象。
- 如果两个请求中读取到的唯一标识符相同，则证明两个请求访问的是同一个 session 对象。

## Session使用细节

- Session钝化、活化
- 服务器重启后，session中的数据是否还在？在
- 钝化: 服务器正常关闭后，Tomcat会自动将session数据写入硬盘的文件中
- 活化: 再次启动服务器后，从文件中加载数据到session中
- Session销毁
- 如果进行了请求1，然后**关闭浏览器**，再做请求1，这就是**两次会话**，所以不是同一个session。所以如果想要长期地共享数据，就不能关闭浏览器。
- 默认情况下，误操作，30分钟自动销毁

```XML
<session-config>
  <session-timeout>30</session-timeout>
</session-config>
```

- `session.invalidate()` 调用session对象地invalidate()方法