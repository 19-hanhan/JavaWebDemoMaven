<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<html>
<head>
    <title>Home</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <% String path = request.getContextPath(); %>
    <%--path是拿到的是web项目的根路径--%>
    <link rel="stylesheet" href="<%=path%>/css/bulma.min.css">

    <style>
        .mytitle{
            width: 600px;
            height: 200px;
            margin: 200px auto;
            text-align: center;
        }
    </style>
</head>
<body>
<div class="mytitle">
    <h1 class="title is-1">hanhan's web</h1>
    <a href="Home" class="button">Enter Home</a>
</div>
</body>
</html>