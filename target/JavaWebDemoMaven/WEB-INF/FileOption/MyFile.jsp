<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 2021/10/7
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MyFile</title>
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
<%--    <form method="post" action="Upload" enctype="multipart/form-data">--%>
<%--        <input type="file" name="upFile">--%>
<%--        <input type="submit">--%>
<%--    </form>--%>

<div class="mytitle">
    <form method="post" action="Upload" enctype="multipart/form-data">
        <div class="file is-warning has-name">
            <label class="file-label">
                <input id="file-input" class="file-input" type="file" name="upFile">
                <span class="file-cta">
                    <span class="file-icon">
<%--                            <i class="fas fa-envelope"></i>--%>
                        <svg t="1633747896739" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="966" width="200" height="200"><path d="M192 128h320v64H192zM256 256h320v64h64v64H320v-64h-64zM192 640h128V448h320v192h128v64h-64v64h-64v64h-64v64h-64v64h-64v-64h-64l-0.02-64.02L320 832l-0.36-64.02L256 768l-0.36-64.02L192 704z" fill="#515151" p-id="967"></path></svg>
                    </span>
                    <span class="file-label">
                        Info file…
                    </span>
                </span>
            </label>
            <span id="file-name" class="file-name">
                jpg../pdf../zip..
            </span>
            <input type="submit" class="button">
        </div>
    </form>

    <% ArrayList<String> lsUser = (ArrayList<String>) request.getAttribute("filenames"); %>
    <% for (String item: lsUser) { %>
        <a href="<%="MyFile/" + item%>"> <%=item%> </a><br>
    </tr>
    <% } %>
</div>
</body>
<script>
    var test = document.getElementById('file-input');
    test.addEventListener('change', function() {
        var t_files = this.files;
        console.log(t_files);
        var str = '';
        str +=t_files[0].name + '; ' + (t_files[0].size / 1024).toFixed(2) + 'KB';
        document.getElementById('file-name').innerHTML = str;
    }, false);
</script>
</html>
