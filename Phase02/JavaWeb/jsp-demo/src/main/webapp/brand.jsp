<%@ page import="java.util.List" %>
<%@ page import="com.itheima.pojo.Brand" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: ryanw
  Date: 2023/9/28
  Time: 22:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
// 查询数据库
    List<Brand> brands = new ArrayList<Brand>();
    brands.add(new Brand(1, "三只松鼠", "三只松鼠", 100, "三只松鼠，好吃不上火", 1));
    brands.add(new Brand(2, "优衣库", "优衣库", 10, "优衣库，服饰人生", 0));
    brands.add(new Brand(3, "小米", "小米科技有限公司", 1000, "为发烧而生", 1));
%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<input type="button" value="New Added"><br />
<hr>
<table border="1" cellspacing="0" width="800">
    <tr align="center">
        <td>序号</td>
        <td>品牌名称</td>
        <td>企业名称</td>
        <td>排序</td>
        <td>品牌介绍</td>
        <td>状态</td>
        <td>操作</td>
    </tr>
    <%
    for (int i = 0; i < brands.size(); i++) {
        Brand brand = brands.get(i);
        %>
    <tr align="center">
        <td><%=brand.getId()%></td>
        <td><%=brand.getBrandName()%></td>
        <td><%=brand.getCompanyName()%>></td>
        <td><%=brand.getOrdered()%></td>
        <td><%=brand.getDescription()%></td>
        <%
            if (brand.getStatus() == 1) {
                // 显示启用
        %>
        <td><%="启用"%></td>
        <%
            } else {
                // 显示禁用
        %>
        <td><%="禁用"%></td>
        <%
            }
        %>
        <td><a href="#">修改</a> <a href="#">删除</a> </td>
    </tr>

    <%
    }
    %>
</table>
</body>
</html>
