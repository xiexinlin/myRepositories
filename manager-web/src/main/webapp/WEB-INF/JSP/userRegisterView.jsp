<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/16
  Time: 9:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册界面</title>
    <script type="text/javascript" src="../js/jquery-1.8.2.js"></script>
    <script type="text/javascript">
        $(function(){
            var flag1 = true;
            var flag2 = true;
            var flag3 = true;
            var flag4 = true;
            var flag5 = true;
            var flag6 = true;

            $("#username").blur(function(){
               var username = $(this).val();
               if(username!=""&&username!=null){
                   $("#usernameScan").html("√");
                   $("#usernameScan").attr("style","color:green");

               }else{ flag1=true;
                   $("#usernameScan").html("x");
                   $("#usernameScan").attr("style","color:red");
                   flag1=false;
               }
            });
            $("#password").blur(function(){
               var password = $(this).val();
               if(password.match(/^\w{6,12}$/)){
                   $("#passwordScan").html("√");
                   $("#passwordScan").attr("style","color:green");
                   flag2=true;
               }else{
                   $("#passwordScan").html("x");
                   $("#passwordScan").attr("style","color:red");
                   flag2=false;
               }
            });
            $("#passwordSure").blur(function(){
                var password = $("#password").val();
                var passwordSure = $("#passwordSure").val();
                if(password==passwordSure){
                    $("#passwordSureScan").html("√");
                    $("#passwordSureScan").attr("style","color:green");
                    flag3=true;
                }else{
                    $("#passwordSureScan").html("x");
                    $("#passwordSureScan").attr("style","color:red");
                    flag3=false;
                }
            });
            $("#age").blur(function(){
                var age = $(this).val();
                if(age!=""&&username!=null){
                    $("#ageScan").html("√");
                    $("#ageScan").attr("style","color:green");
                    flag4=true;
                }else{
                    $("#ageScan").html("x");
                    $("#ageScan").attr("style","color:red");
                    flag4=false;
                }
            });
            $("#tel").blur(function(){
                var tel = $(this).val();
                if(tel.match(/^\d{11}$/)){
                    $("#telScan").html("√");
                    $("#telScan").attr("style","color:green");
                    flag5=true;
                }else{
                    $("#telScan").html("x");
                    $("#telScan").attr("style","color:red");
                    flag5=false;
                }
            });
            $(":submit").click(function(){
                if(flag1&&flag2&&flag3&&flag4&&flag5&&$(":file").val()!=""){

                }else{
                    alert("请填写完整信息");
                    return false;
                }
            });
        })
    </script>
</head>
<body>
    <form action="/user/register" enctype="multipart/form-data" method="post">
        <table>
            <tr>
                <td>用户名:</td>
                <td><input type="text" name="username" id="username"><scan id="usernameScan"></scan></td>
            </tr>
            <tr>
                <td>密码:</td>
                <td><input type="password" name="password" id="password"><scan id="passwordScan"></scan></td>
            </tr>
            <tr>
                <td>确认密码:</td>
                <td><input type="password" name="passwordSure" id="passwordSure"><scan id="passwordSureScan"></scan></td>
            </tr>
            <tr>
                <td>年龄:</td>
                <td><input type="text" name="age" id="age"><scan id="ageScan"></scan></td>
            </tr>
            <tr>
                <td>电话号码:</td>
                <td><input type="text" name="tel" id="tel"><scan id="telScan"></scan></td>
            </tr>
            <tr>
                <td>头像：</td>
                <td><input type="file" name="file"></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="提交注册">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
