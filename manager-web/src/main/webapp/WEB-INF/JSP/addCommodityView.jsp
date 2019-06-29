<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/26
  Time: 23:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>添加商品</title>
    <script type="text/javascript" src="../js/jquery-1.8.2.js"></script>
    <script type="text/javascript">
        $(function(){
            $(":submit").click(function(){
                if($("#name").val()!=""&&$("#price").val()!=""&&$("#type_id").val()!=""&&$("#file").val()!=""&&$("#introduction").val()!=""){

                }else {
                    alert("请填写完整的商品信息");
                    return false;
                }
            })
        })
    </script>
</head>
<body>
    <form action="/commodity/add" enctype="multipart/form-data" method="post">
        <table border="1">
            <caption>添加商品</caption>
            <col align="center"/>
            <col align="left"/>
            <tr>
                <td>商品名字</td>
                <td><input type="text" name="name" id="name"></td>
            </tr>
            <tr>
                <td>商品价格</td>
                <td><input type="text" name="price" id="price"></td>
            </tr>
            <tr>
                <td>商品类型</td>
                <td>
                    <select name="type_id" id="type_id">
                        <c:forEach items="${list}" var="type">
                            <option value="${type.id}">${type.name}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>商品照片</td>
                <td><input type="file" name="file" id="file"></td>
            </tr>
            <tr>
                <td>商品介绍</td>
                <td><input type="text" name="introduction" id="introduction"></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="添加商品"></td>
            </tr>
        </table>
    </form>
</body>
</html>
