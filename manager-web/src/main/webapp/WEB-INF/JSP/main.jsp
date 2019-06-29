<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/13
  Time: 12:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="../js/jquery-1.8.2.js"></script>
    <script type="text/javascript">
        $(function(){
            $("#search").click(function(){
                location.href="";
            })
            $("div").click(function(){
                var $id = $(this).children("span").eq(0);
                location.href="/commodity/detailed?id="+$id.text();
            })
        })
    </script>
</head>
<body>
    <a>我的资料</a><a>我的购物车</a>
    <p><input type="text" name="searchText">
        <input type="button" name="search" id="search" value="搜索"/></p>
    <c:forEach items="${typeList}" var="type">
        <a href="/commodity/typeSearch?id=${type.id}">${type.name}</a>
    </c:forEach>
    <c:forEach items="${commodityList}" var="commodity">
        <div>
            <img src="../../commodityImages/${commodity.photo}">
            <span style="display: none">${commodity.id}</span>
            <span>${commodity.name}</span>
            <span>${commodity.price}</span>
        </div>
    </c:forEach>
    当前页数:${page.pageNumber}<c:if test="${page.pageNumber>1}"><a href="/commodity/main?pageNumber=${page.pageNumber-1}">上一页</a></c:if>
    <c:if test="${page.pageNumber<page.totalPageNumber}"><a href="/commodity/main?pageNumber=${page.pageNumber+1}">下一页</a></c:if>
</body>
</html>
