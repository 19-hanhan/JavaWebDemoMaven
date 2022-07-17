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
        <h1 class="title is-1" style="text-align: center">Update</h1>
        <form action="../UpdateServlet" method="post">
            <label for="username" class="label">Username</label>
            <input type="text" name="username" id="username" class="input is-success" placeholder="username input">
            <label for="oldPassword" class="label">Old Password</label>
            <input type="text" name="oldPassword" id="oldPassword" class="input is-warning" placeholder="oldPassword input">
            <label for="newPassword" class="label">New Password</label>
            <input type="text" name="newPassword" id="newPassword" class="input is-warning" placeholder="newPassword input">
            <div class="myButtonBox" style="text-align: center">
                <button class="button is-primary is-light" type="submit" style="margin: 0 50px;">submit</button>
                <button class="button is-link is-light" type="reset" style="margin: 0 50px;">reset</button>
            </div>
        </form>
    </div>
</div>
</body>
</html>