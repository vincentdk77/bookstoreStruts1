<%@ page import="java.util.ArrayList" %>
<%@ page import="com.vicentdk77.bookstore.bean.MyBooksDto" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/23 0023
  Time: 8:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>--%>
<html>
<head>
    <title>书本展示页</title>
</head>
<body>
    <table width='100%' border='0' cellspacing='0' cellpadding='0' class='mytable' style='table-layout: fixed'>
        <tr >
            <td>序号</td>
            <td>图片</td>
            <td>价格</td>
            <td>书名</td>
            <td>作者</td>
            <td>出版日期</td>
            <td>销量</td>
            <td>加入购物车</td>
        </tr>
        <c:forEach items="${mybooksList}" var="book" varStatus="count">
            <tr>
                <td>${count.count}</td>
                <td>图片</td>
                <td>${book.price}</td>
                <td>${book.title}</td>
                <td>${book.author}</td>
                <td>${book.publishingDate}</td>
                <td>${book.salesAmount}</td>
                <td>加入购物车</td>
            </tr>
        </c:forEach>
    </table>
    <%--<ol>--%>
        <%--<% System.err.println("123");%>--%>
        <%--<c:forEach items="${mybooksList}" var="mybooks" varStatus="count">--%>
            <%--<div>${mybooks.title}</div>--%>
            <%--<li>--%>
                <%--${mybooks.title}&nbsp;&nbsp;${mybooks.author}&nbsp;&nbsp;${mybooks.price}&nbsp;&nbsp;${mybooks.salesAmount}&nbsp;&nbsp;--%>
            <%--</li>--%>
        <%--</c:forEach>--%>

        <%--&lt;%&ndash;<li>11111</li>&ndash;%&gt;--%>
        <%--&lt;%&ndash;<li>22</li>&ndash;%&gt;--%>
        <%--&lt;%&ndash;<li>1113311</li>&ndash;%&gt;--%>
        <%--&lt;%&ndash;<li>114111</li>&ndash;%&gt;--%>
    <%--</ol>--%>
</body>
</html>
