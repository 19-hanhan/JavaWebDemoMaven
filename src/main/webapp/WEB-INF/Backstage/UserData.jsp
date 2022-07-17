<%@ page import="hanhan.Entity.User" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: wuwenlong
  Date: 2021/10/15
  Time: 07:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <% String path = request.getContextPath(); %>
    <%--path是拿到的是web项目的根路径--%>
    <link rel="stylesheet" href="<%=path%>/css/bulma.min.css">

    <style>
        .mytitle{
            width: 600px;
            /*height: 200px;*/
            margin: 100px auto 0;
            text-align: center;
            /*background-color: #d5d5d5;*/
        }
    </style>
</head>
<body>
<div class="mytitle">
    <% ArrayList<User> lsUser = (ArrayList<User>) request.getAttribute("lsUser"); %>
    <table class="table is-fullwidth" style="border: 1px">
        <tr>
            <td>username</td>
            <td>password</td>
            <td>studentID</td>
            <td>age</td>
            <td>phoneNumber</td>
            <td>option</td>
        </tr>
        <% for (User item: lsUser) { %>
        <tr>
            <td><%=item.getUsername()%></td>
            <td><%=item.getPassword()%></td>
            <td><%=item.getStudentId()%></td>
            <td><%=item.getAge()%></td>
            <td><%=item.getPhoneNumber()%></td>
            <td>
                <div class="buttons">
                    <div class="level">
                            <a class="button is-dark" href="UpdateUserServlet?username=<%=item.getUsername()%>">Update</a>
                            <a class="button is-warning" onclick="return del()" href="DeleteUserServlet?username=<%=item.getUsername()%>">Delete</a>
                    </div>
                </div>
            </td>
        </tr>
        <% } %>
    </table>
</div>

<script type="text/javascript">
    function del(){
        if(window.confirm("你难道真的真的真的要删除我吗?")){
            return true;
        }else{
            return false;
        }
    }
</script>
</body>
</html>
