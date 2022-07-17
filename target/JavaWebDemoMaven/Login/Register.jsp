<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<html>
<head>
    <title>Register</title>
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
        <h1 class="title is-1" style="text-align: center">Register</h1>
        <form action="../RegisterServlet" method="post">
            <label for="username" class="label">Username</label>
            <input type="text" name="username" id="username" class="input is-success" placeholder="username input">
            <label for="password" class="label">Password</label>
            <input type="text" name="password" id="password" class="input is-warning" placeholder="password input">
            <label for="repeat" class="label">repeat</label>
            <input type="text" name="repeat" id="repeat" class="input is-warning" placeholder="password repeat">
            <div class="myButtonBox" style="text-align: center">
                <button class="button is-primary is-light" type="submit" style="margin: 0 50px;">submit</button>
                <button class="button is-link is-light" type="reset" style="margin: 0 50px;">reset</button>
            </div>
        </form>
    </div>
</div>
</body>
</html>