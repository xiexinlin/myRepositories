<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/27
  Time: 20:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>修改商品</title>
</head>
<body>
    <form action="/commodity/upd" enctype="multipart/form-data" method="post">
        <table border="1">
            <tr style="display: none">
                <td>商品编号</td>
                <td><input type="text" name="id" value="${commodity.id}"></td>
            </tr>
            <tr>
                <td>商品名称</td>
                <td><input type="text" name="name" value="${commodity.name}"></td>
            </tr>
            <tr>
                <td>商品价格</td>
                <td><input type="text" name="price" value="${commodity.price}"></td>
            </tr>
            <tr>
                <td>商品图片</td>
                <td><img src="../../commodityImages/${commodity.photo}"><input type="file" value="${commodity.photo}"></td>
            </tr>
            <tr>
                <td>商品介绍</td>
                <td><input type="text" name="introduction" value="${commodity.introduction}"></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="提交修改"></td>
            </tr>
        </table>
    </form>
</body>
</html>
