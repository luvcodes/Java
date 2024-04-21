# HTTP-请求数据格式

### 请求数据分为3部份

1. 请求行: 请求数据的第一行。其中GET表示请求方式，/表示请求资源路径，HTTP/1.1表示协议版本
2. 请求头: 第二行开始，格式为key: value形式
3. 请求体: POST请求的最后一部分，存放请求参数

```Java
GET/HTTP/1.1
Host:www.google.com
Connection: keep-alive
...
```

```Java
POST/HTTP/1.1
Host: www.google.com
Connection:keep-alive
...

username=superbaby&password=123456
```

### GET请求和POST请求区别

1. GET请求参数在请求行中，没有请求体。POST请求参数在请求体中。
2. GET请求参数大小有限制，POST没有

  

# HTTP - 响应数据格式

## 响应数据

1. 响应行:
2. 响应头:
3. 响应体: