<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 2021/9/29
  Time: 9:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <% String path = request.getContextPath(); %>
    <%--path是拿到的是web项目的根路径--%>
    <link rel="stylesheet" href="<%=path%>/css/bulma.min.css">

    <style>
        .myBox{
            width: 600px;
            height: 200px;
            margin: 200px auto;
        }
        .myButton{
            margin: 25px auto 0px;
        }
    </style>
</head>
<body>
<div class="myBox">
    <div class="box">
        <figure class="image is-128x128" style="margin: 0 auto">
            <img class="is-rounded" src="../img/buxing.jpg">
        </figure>
        <form action="../LoginServlet" method="post">
            <label for="username" class="label">Username</label>
            <input type="text" name="username" id="username" class="input is-success" placeholder="username input">
            <label for="password" class="label">Password</label>
            <input type="password" name="password" id="password" class="input is-warning" placeholder="password input">
            <label for="VerificationCode" class="label">Verification Code</label>
            <input type="text" name="verificationCode" id="verificationCode" class="input is-danger" placeholder="verification code input">
            <div class="myButton">
                <input type="checkbox" name="saved" value="autoLogin">Remember login
                <img src="../VerificationCodeServlet" alt="" style="float: right">
            </div>
            <div class="myButton">
                <button class="button is-primary is-light" type="submit" style="margin: 0 5px">submit</button>
                <button class="button is-link is-light" type="reset" style="margin: 0 5px">reset</button>
                <a href="./Register.jsp" class="block" style="float: right; margin: 10px 15px 0">Register</a>
                <a href="./Update.jsp" class="block" style="float: right; margin: 10px 15px 0">Reset Password</a>
            </div>
        </form>
    </div>
</div>
</body>
</html>
