<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/27
  Time: 10:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>商品详细信息</title>
    <script type="text/javascript" src="../js/jquery-1.8.2.js"></script>
    <script type="text/javascript">
        $(function(){
            $("#buy").click(function(){
                $("div").attr("style","display:block");
            })
            $("#close").click(function(){
                $("div").attr("style","display:none");
            })
            $("#buySure").click(function(){
                var $quantity = $("#quantity").val();
                var $id = $("#commodity_id").text();
                location.href="${pageContext.request.contextPath}/bill/buy?commodity_id="+$id+"&&quantity="+$quantity;
            })
            $("#return").click(function(){
                location.href="/commodity/main";
            })
        })
    </script>
</head>
<body>
<img src="../../commodityImages/${commodity.photo}"><br>
<span style="display: none" id="commodity_id">${commodity.id}</span>
<span>${commodity.name}</span><br>
<span>¥${commodity.price}</span><br>
<span>类型：${commodity.type.name}</span><br>
<span>介绍：${commodity.introduction}</span><br>
<span>总销量：${commodity.totalSale}</span><br>
<span>月销售：${commodity.monthSale}</span><br>
<span><input type="button" id="buy" value="购买"><input type="button" id="return" value="返回"></span>
<div style="display: none">
    购买<input type="text" name="quantity" id="quantity">件<br>
    <input type="button" id="buySure" value="下单">
    <input type="button" id="close" value="关闭">
</div>
</body>
</html>
