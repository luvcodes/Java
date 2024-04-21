# 状态码告知从服务器端返回的请求结果

**状态码**的职责是当客户端向服务器端发送请求时，描述返回的请求结果。借助状态码，用户可以知道服务器端是正常处理了请求，还是出现了错误。

相应类别5种:

![[/Untitled 20.png|Untitled 20.png]]

# 2XX成功

## 200 OK

表示从客户端发来的请求在服务器端被正常处理了

## 204 No Content

该状态码代表服务器接收的请求已成功处理，但在返回的响应报文中不含实体的主体部分

## 206 Partial Content

该状态码表示客户端进行了范围请求，而服务器成功执行了这部分的GET 请求。响应报文中包含由 Content-Range 指定范围的实体内容。

# 3XX重定向

## 301 Moved Permanently

当我们说一个资源或页面“移动到了另一个地址”，这可能意味着：

1. **同一网站内的变化**：例如，你可能从 `**example.com/old-page.html**` 重定向到 `**example.com/new-page.html**`。这只是网站内部的一个页面到另一个页面的移动。
2. **跨域重定向**：当然，也可能是从一个网站跳转到另一个完全不同的网站，例如从 `**example.com**` 重定向到 `**another-example.com**`。
3. **协议变化**：例如，从 HTTP 转到 HTTPS，如 `**http://example.com**` 重定向到 `**https://example.com**`。
4. **子域名变化**：例如，从 `**blog.example.com**` 重定向到 `**www.example.com/blog**`。
5. **目录结构变化**：例如，如果一个网站对其内容进行了重新组织，旧的URL目录结构可能不再适用，因此可能需要从 `**example.com/categoryA/item1**` 重定向到 `**example.com/categoryB/item1**`。

## 302 Found

临时性重定向。该状态码表示请求的资源已被分配了新的 URI，希望用户（本次）能使用新的 URI 访问。

## 303 See Other

  

## 304 Not Modified

该状态码表示客户端发送附带条件的请求 2 时，服务器端允许请求访问资源，但未满足条件的情况

  

## 307 Temporary Redirect

  

# 4XX客户端错误

  

## 400 Bad Request

  

  

## 401 Unauthorized

  

  

# 5XX服务器错误