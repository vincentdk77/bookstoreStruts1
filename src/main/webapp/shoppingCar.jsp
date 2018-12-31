<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/31 0031
  Time: 20:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>购物车</title>
</head>
<body>
    <table align="center">
        <tr align="center">
            <td>序号</td>
            <td>书名</td>
            <td>作者</td>
            <td>数量</td>
        </tr>
        <c:forEach items="${shoppingCarList}" var="book" varStatus="count">
            <tr align="center">
                <td>${count.count}</td>
                <td>${book.title}</td>
                <td>${book.author}</td>
                <td>${book.count}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
