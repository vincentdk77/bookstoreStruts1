<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/31 0031
  Time: 19:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>书本详情页</title>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script>
        function addShoopingCar(obj) {
            var id = $(obj).next().val();
//            window.location.href="shoppingcar.do?type=add&id="+id;
            $.ajax({
                type: "GET",
                url: "shoppingcar.do?type=add&id="+id,
                success: function(data){
                    if(data == 'success'){
                        alert("已加入购物车！");
                    }else{
                        alert("加入失败！");
                    }
                }
            });
        }
    </script>
</head>
<body>
    <div>
        <center>
            <img src="pictures/dora/20181114_143335.jpg" width="700px" height="600px">
        </center>
    </div>
    <table align="center">
        <tr><td>书名：${myBooksDto.title}</td></tr>
        <tr><td>作者：${myBooksDto.author}</td></tr>
        <tr><td>描述：${myBooksDto.remark}</td></tr>
        <tr>
            <td>
            <input type="button" value="加入购物车" onclick="addShoopingCar(this)">
            <input type="hidden" id="id" value="${myBooksDto.id}" >
            </td>
        </tr>
        <tr><td><input type="button" value="继续逛逛" onclick="window.history.go(-1)"></td></tr>
    </table>
</body>
</html>
