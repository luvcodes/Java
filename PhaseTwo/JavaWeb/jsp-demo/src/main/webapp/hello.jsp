<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>JSP, Hello World</h1>
<%
    System.out.println("Hello, jsp!");
    int i = 3;
%>

<%="hello"%>
<%=i%>

<%!
void show() {
    String name = "zhangsan";
}
%>
</body>
</html>