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
<%
//    ArrayList<MyBooksDto> list=  (ArrayList<MyBooksDto>)request.getAttribute("mybooksList");
//    for(MyBooksDto books :list){
//        System.err.println(books.getTitle());
//    }
%>
    <ol>
        <% System.err.println("123");%>
        <c:forEach items="${mybooksList}" var="mybooks" varStatus="count">
            <div>${mybooks.title}</div>
            <li>
                ${mybooks.title}&nbsp;&nbsp;${mybooks.author}&nbsp;&nbsp;${mybooks.price}&nbsp;&nbsp;${mybooks.salesAmount}&nbsp;&nbsp;
            </li>
        </c:forEach>

        <%--<li>11111</li>--%>
        <%--<li>22</li>--%>
        <%--<li>1113311</li>--%>
        <%--<li>114111</li>--%>
    </ol>
</body>
</html>
