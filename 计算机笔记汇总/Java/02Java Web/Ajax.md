异步的JS和XML

Ajax作用:

1. 与服务器进行数据交换: 通过AJAX可以给服务器发送请求，并获取服务器相应的数据
2. 使用了AJAX和服务器进行通信，就可以**使用HTML + AJAX来替换JSP页面了**
3. **异步交互**: 可以在**不重新加载整个页面**的情况下，与服务器交换数据并**更新部份网页**的技术，如: 搜索联想、用户名是否可用校验，等等...

AJAX在Java开发中是一种非常重要的技术。AJAX的全称是Asynchronous JavaScript and XML，中文意思是异步JavaScript和XML¹²⁴。 AJAX并不是一种新的编程语言，而是一种使用现有技术的新方法⁴。它主要用于创建快速动态的网页¹²。通过在后台与服务器进行少量数据交换，AJAX可以使网页实现异步更新¹²。

这意味着可以在不重新加载整个网页的情况下，对网页的某部分进行更新¹²。这样，用户的交互体验会更好，因为他们不需要等待整个页面的刷新。

AJAX的核心是XMLHttpRequest对象，它支持异步数据获取技术²。这个对象可以发送GET和POST请求²。AJAX还使用了其他的技术，如HTML或XHTML, CSS, JavaScript, DOM, XML, XSLT⁴。

总的来说，AJAX在Java开发中，尤其是在Web开发中，起着至关重要的作用。它改变了传统的Web应用模式，使得Web应用变得更加快速和动态。

# 同步和异步

[![](https://cdn.nlark.com/yuque/0/2023/png/38953059/1696038462272-ff5454bd-a929-4e97-9298-ddb5fad367b9.png)](https://cdn.nlark.com/yuque/0/2023/png/38953059/1696038462272-ff5454bd-a929-4e97-9298-ddb5fad367b9.png)

# Ajax快速入门

1. 编写AjaxServlet，并使用response输出字符串
2. 创建XMLHttpRequest对象: 用于和服务器减缓数据
3. 像服务器发送请求
4. 获取服务器响应数据