<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/26
  Time: 23:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>商品</title>
    <script type="text/javascript" src="../js/jquery-1.8.2.js"></script>
    <script type="text/javascript">
        $(function(){
            $("#insCommodity").click(function(){
               location.href="${pageContext.request.contextPath}/addCommodityView";
            });
            $("#updCommodity").click(function(){
                var $id = $("#commodity_id").text();
                location.href="/updCommodityView?id="+$id;
            })
        })
    </script>
</head>
<body>
    <table border="1">
        <tr>
            <th>商品编号</th>
            <th>商品图片</th>
            <th>商品名称</th>
            <th>商品类型</th>
            <th>商品价格</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${commodityList}" var="commodity">
            <tr>
                <td id="commodity_id">${commodity.id}</td>
                <td><img src="../../commodityImages/${commodity.photo}"></td>
                <td>${commodity.name}</td>
                <td>${commodity.type.name}</td>
                <td>${commodity.price}</td>
                <td><input type="button" value="修改商品" id="updCommodity"><input type="button" value="删除商品" id="delCommodity"></td>
            </tr>
        </c:forEach>
    </table>
    <tr>
        <td colspan="6" align="center">
            <input type="button" value="添加商品" id="insCommodity">
        </td>
    </tr>
</body>
</html>
