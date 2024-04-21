这里我们所提到的令牌，其实它就是一个用户身份的标识，看似很高大上，很神秘，其实本质就是一个字符串。

![[/Untitled 7.png|Untitled 7.png]]

基于令牌技术来实现会话追踪。这里所提到的令牌就是用户身份的标识，其本质就是一个字符串。令牌的形式有很多，我们使用的是功能强大的 JWT令牌。

# 介绍

JWT全称：JSON Web Token （官网：[https://jwt.io/](https://jwt.io/)）

定义了一种简洁的、自包含的格式，用于在通信双方以json数据格式安全的传输信息。由于数字签名的存在，这些信息是可靠的。

- 简洁：是指jwt就是一个简单的字符串。可以在请求参数或者是请求头当中直接传递。
- 自包含：指的是jwt令牌，看似是一个随机的字符串，但是我们是可以根据自身的需求在jwt令牌中存储自定义的数据内容。如：可以直接在jwt令牌中存储用户的相关信息。

简单来讲，jwt就是将原始的json数据格式进行了安全的封装，这样就可以直接基于jwt在通信双方安全的进行信息传输了。

# JWT的组成

JWT令牌由三个部分组成，三个部分之间使用英文的点来分割

- 第一部分：Header(头）， 记录令牌类型、签名算法等。 例如：{"alg":"HS256","type":"JWT"}
- 第二部分：Payload(有效载荷），携带一些自定义信息、默认信息等。 例如：{"id":"1","username":"Tom"}
- 第三部分：Signature(签名），防止Token被篡改、确保安全性。将header、payload，并加入指定秘钥，通过指定签名算法计算而来。

签名的目的就是为了防jwt令牌被篡改，而正是因为jwt令牌最后一个部分数字签名的存在，所以整个jwt 令牌是非常安全可靠的。

一旦jwt令牌当中任何一个部分、任何一个字符被篡改了，整个令牌在校验的时候都会失败，所以它是非常安全可靠的。

![[Untitled 1.png]]

# JWT是如何将原始的JSON格式数据，转变为字符串的呢？

其实在生成JWT令牌时，会对JSON格式的数据进行一次编码：进行base64编码

Base64：是一种基于64个可打印的字符来表示二进制数据的编码方式。既然能编码，那也就意味着也能解码。

所使用的64个字符分别是A到Z、a到z、 0- 9，一个加号，一个斜杠，加起来就是64个字符。任何数据经过base64编码之后，最终就会通过这64个字符来表示。当然还有一个符号，那就是等号。等号它是一个补位的符号

需要注意的是Base64是编码方式，而不是加密方式。

![[/Untitled 2 2.png|Untitled 2 2.png]]

  

JWT令牌最典型的应用场景就是登录认证：

1. 在浏览器发起请求来执行登录操作，此时会访问登录的接口，如果登录成功之后，我们需要生成一个jwt令牌，将生成的 jwt令牌返回给前端。
2. 前端拿到jwt令牌之后，会将jwt令牌存储起来。在后续的每一次请求中都会将jwt令牌携带到服务端。
3. 服务端统一拦截请求之后，先来判断一下这次请求有没有把令牌带过来，
    1. 如果没有带过来，直接拒绝访问，
    2. 如果带过来了，还要校验一下令牌是否是有效。
        1. 如果有效，就直接放行进行请求的处理。

在JWT登录认证的场景中我们发现，整个流程当中涉及到两步操作：

1. 在登录成功之后，要生成令牌。
2. 每一次请求当中，要接收令牌并对令牌进行校验。

# JWT生成和校验

## JWT生成

```XML
        <!--JWT令牌-->
        <dependency>
            <groupId>io.jsonwebtoken</groupId>
            <artifactId>jjwt</artifactId>
            <version>0.9.1</version>
        </dependency>
```

首先我们先来实现JWT令牌的生成。要想使用JWT令牌，需要先引入JWT的依赖：

生成JWT代码实现：

```Java
@Test
public void genJwt(){
    Map<String,Object> claims = new HashMap<>();
    claims.put("id",1);
    claims.put("username","Tom");

    String jwt = Jwts.builder()
        .setClaims(claims) //自定义内容(载荷)
        .signWith(SignatureAlgorithm.HS256, "itheima") //签名算法
        .setExpiration(new Date(System.currentTimeMillis() + 24*3600*1000)) //有效期
        .compact();

    System.out.println(jwt);
}
```

运行测试方法：

```Plain
eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoidG9tIiwiaWQiOjEsImV4cCI6MTcwNjc5OTk1NH0.ka6EP0MTAQbJdDahGPKZyC4ZwCrweiwznvKfP4Vakb4
```

输出的结果就是生成的JWT令牌,，通过英文的点分割对三个部分进行分割，我们可以将生成的令牌复制一下，然后打开JWT的官网，将生成的令牌直接放在Encoded位置，此时就会自动的将令牌解析出来。

![[/Untitled 3 2.png|Untitled 3 2.png]]

  

> 第一部分解析出来，看到JSON格式的原始数据，所使用的签名算法为HS256。
> 
> 第二个部分是我们自定义的数据，之前我们自定义的数据就是id，还有一个exp代表的是我们所设置的过期时间。
> 
> 由于前两个部分是base64编码，所以是可以直接解码出来。但最后一个部分并不是base64编码，是经过签名算法计算出来的，所以最后一个部分是不会解析的。

## JWT校验

实现了JWT令牌的生成，下面我们接着使用Java代码来校验JWT令牌(解析生成的令牌)：

```Java
@Test
public void parseJwt(){
    Claims claims = Jwts.parser()
        .setSigningKey("itheima")//指定签名密钥（必须保证和生成令牌时使用相同的签名密钥）
        .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwiZXhwIjoxNjcyNzI5NzMwfQ.fHi0Ub8npbyt71UqLXDdLyipptLgxBUg_mSuGJtXtBk")
        .getBody();

    System.out.println(claims);
}
```

运行测试方法：

```JSON
{id=1, exp=1672729730}
```

> 令牌解析后，我们可以看到id和过期时间，如果在解析的过程当中没有报错，就说明解析成功了。

结论：篡改令牌中的任何一个字符，在对令牌进行解析时都会报错，所以JWT令牌是非常安全可靠的。

通过以上测试，我们在使用JWT令牌时需要注意：

- JWT校验时使用的签名秘钥，必须和生成JWT令牌时使用的秘钥是配套的。
- 如果JWT令牌解析校验时报错，则说明 JWT令牌被篡改 或 失效了，令牌非法。

## 登录下发令牌

1. 生成令牌
    - 在登录成功之后来生成一个JWT令牌，并且把这个令牌直接返回给前端
2. 校验令牌
    - 拦截前端请求，从请求中获取到令牌，对令牌进行解析校验