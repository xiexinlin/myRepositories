<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/12
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello Maven</title>
    <script type="text/javascript" src="js/jquery-1.8.2.js"></script>
    <script type="text/javascript">
        $(function () {
            $(":button").click(function () {
                location.href="${pageContext.request.contextPath}/adminLoginView";
            })
        })
    </script>
</head>
<body>
    <div class="user_login">
        <h3>用户登录</h3>
        <div class="content">
            <form action="/user/login" method="post">
                <div>
                    <label for="username">用户名:</label>
                    <input type="text" name="username" id="username">
                </div>
                <div>
                    <label for="password">密码:</label>
                    <input type="password" name="password" id="password"><a href="${pageContext.request.contextPath}/userRegisterView"><span>注册</span></a>
                </div>
                <div>
                    <label for="validate">验证码：</label>
                    <input type="text" id="validate">
                </div>
                <div>
                    <input type="checkbox" id="keepLogin">
                    <label for="keepLogin">记住我的登录信息</label>
                </div>
                <div>
                    <input type="submit" value="用户登录">
                    <input type="button" value="管理员登录">
                </div>
            </form>
        </div>
    </div>
</body>
</html>
