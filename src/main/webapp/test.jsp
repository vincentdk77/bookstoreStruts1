<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/18 0018
  Time: 23:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <%--<script language="javascript" type="text/javascript" src="jquery-1.4.2.min.js"></script>--%>
    <script language="javascript" type="text/javascript">

        $(function () {
            //alert($("div[id='a']").length);
//            alert($("#sum").find("div[name='a']").length);
//            alert($("input[name='d']").length);
            $("div[name='a']").each(function () {
//                alert($(this).find("input[name='d']").lenth)
                var str = $(this).find("input[name='d']");
                alert(str.length);
//                alert($(this).find("input[id='d']").eq(0) instanceof jQuery);
//                alert($(this).attr("value"));
            });
        });

//        $("#CarprpLcomponentDtoItems").find("tr").each(function(){
//            var obj = $(this).find("input[name='prpLcomponentCompName']");
//            obj.parent().find("a").remove();
//            obj.parent().find("p").remove();
//            obj.parent().append("<a href='/newclaim/DAA/certify/DAAComponentImgView.jsp?pageEditType=&editType=&directType=&businessNo="+registNo+"&compName="+obj.val()+"&lossItemCode="+lossItemCode+"' target='_blank'>"+obj.val()+"</a>");
//            obj.hide();
//        });
    </script>
</head>
<body>
<form>

    <table>
        <div id="a" name="a">
            <tr id="tr1">
                <td>
                    <input id="d" name="d" type="button" value="t"/>
                    <input id="e" name="d" type="button" value="t"/>
                </td>
            </tr>
            <tr id="tr2">
                <td>
                    <input id="d" name="d" type="button" value="t"/>
                    <input id="e" name="d" type="button" value="t"/>
                </td>
            </tr>
        </div>
        <div id="b" name="a">
            <tr>
                <td>
                    <input id="f" name="d" type="button" value="d"/>
                </td>
            </tr>
        </div>
        <div id="c" name="a">
            <tr>
                <td>
                    <input id="g" name="d" type="button" value="d"/>
                    <input id="h" name="d" type="button" value="d"/>
                    <input id="i" name="d" type="button" value="d"/>
                </td>
            </tr>
        </div>
    </table>
</form>
</body>
</html>
