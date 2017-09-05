<%--
  Created by IntelliJ IDEA.
  User: CodingTest
  Date: 2017/7/29
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
    <title>Login view</title>
    <link href="../../node_modules/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet"/>
    <script src="../../node_modules/jquery/dist/jquery.min.js"></script>
    <script src="../../node_modules/bootstrap/dist/js/bootstrap.min.js"></script>
    <link href="../../css/login.css" rel="stylesheet"/>
</head>
<body>
<div class="container">
    <form class="form-signin" method="post" action="/login">
        <h2 class="form-signin-heading">登录界面</h2>
        <label for="inputText" class="sr-only">账号：</label>
        <input type="text" id="inputText" class="form-control" placeholder="登录账号" name="username" required autofocus>
        <label for="inputPassword" class="sr-only">密码：</label>
        <input type="password" id="inputPassword" class="form-control" placeholder="密码" name="password" required>
        <button class="btn btn-lg btn-success btn-block" type="submit">登 录</button>
        <div style="padding: 10px">
            <label>
                <a href="jsp/Login/Register.jsp"><span class="glyphicon glyphicon-user"></span>申请账号</a>
            </label>
        </div>
    </form>
    <div class="text-center" id="showspan" style="display: none">
        <span style="color: #CC2222"><%=(String) request.getAttribute("message")%></span>
    </div>
</div>
</body>
</html>
