<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/22 0022
  Time: 7:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>复制文件</title>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script >
        $("#byte").click(function(){
            $.ajax({
                url:"/bookstore/copy.do?id=byte",
                async:false,
                success: function(data){
                    alert(data.toString());
                }
            });
        });
        $("#character").click(function(){
            $.ajax({
                url:"/bookstore/copy.do?id=character",
                async:false , //默认是true，即为异步方式，$.Ajax执行后，会继续执行ajax后面的脚本，直到服务器端返回数据后，触发$.Ajax里的success方法，这时候执行的是两个线程。
                success: function(data){
                    alert(data.toString());
                }
            });
        });
        function submit1(){
            $.ajax({
                url:"/bookstore/copy.do?id=byte",
                async:false,
                success: function(data){
                    alert(data.toString());
                }
            });
        }
    </script>
</head>
<body>
    <div>复制文件</div>
    <div>
        <input type="button" id="byte" value="字节流" onclick="submit1()"><br/>
        <input type="button" id="character" value="字符流">
    </div>
</body>
</html>
