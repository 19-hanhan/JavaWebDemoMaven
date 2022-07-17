<%@ page import="hanhan.Entity.User" %>
<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 2021/10/16
  Time: 20:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<html>
<head>
    <title>Update</title>
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
        .myButtonBox{
            margin: 25px auto 0px;
        }
    </style>

</head>
<body>
<div class="myBox">
    <div class="box">
        <% User ur = (User)request.getAttribute("updateUser"); %>
        <h1 class="title is-1" style="text-align: center">Update</h1>
        <form action="UpdateUserServlet2" method="post">
            <label for="username" class="label">username</label>
            <input type="text" name="username" id="username" class="input is-success" value="<%=ur.getUsername()%>" readonly="readonly">
            <label for="password" class="label">password</label>
            <input type="text" name="password" id="password" class="input is-warning" value="<%=ur.getPassword()%>">
            <label for="studentId" class="label">studentID</label>
            <input type="text" name="studentId" id="studentId" class="input is-active" value="<%=ur.getStudentId()%>">
            <label for="age" class="label">age</label>
            <input type="text" name="age" id="age" class="input is-danger" value="<%=ur.getAge()%>">
            <label for="phoneNumber" class="label">phoneNumber</label>
            <input type="text" name="phoneNumber" id="phoneNumber" class="input is-white" value="<%=ur.getPhoneNumber()%>">
            <div class="myButtonBox" style="text-align: center">
                <button class="button is-primary is-light" type="submit" style="margin: 0 50px;">submit</button>
                <button class="button is-link is-light" type="reset" style="margin: 0 50px;">reset</button>
            </div>
        </form>
    </div>
</div>
</body>
</html>
