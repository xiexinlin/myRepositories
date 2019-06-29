<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/26
  Time: 21:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员登录</title>
    <script type="text/javascript" src="../js/jquery-1.8.2.js"></script>
    <script type="text/javascript">
        $(function () {
            $(":button").click(function () {
                location.href="${pageContext.request.contextPath}/adminRegisterView";
            })
        })
    </script>
</head>
<body>
    <form action="/admin/login" method="post">
        <p>用户名:<input type="text" name="adminname"></p>
        <p>密码:<input type="password" name="password"></p>
        <p><input type="submit" value="管理员登录">
            <input type="button" value="管理员注册"></p>
    </form>
</body>
</html>
