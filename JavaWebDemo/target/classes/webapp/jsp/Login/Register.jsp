<%--
  Created by IntelliJ IDEA.
  User: CodingTest
  Date: 2017/7/29
  Time: 22:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*,java.sql.*"%>
<html>
<head>
    <title>Title</title>
    <link href="../../node_modules/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet"/>
    <script src="../../node_modules/jquery/dist/jquery.min.js"></script>
    <script src="../../node_modules/bootstrap/dist/js/bootstrap.min.js"></script>
    <link href="../../css/register.css" rel="stylesheet"/>
</head>
<body>
<div class="container">
    <form class="form-signin" method="post" action="/register">
        <h2 class="form-signin-heading">注册界面</h2>
        <label for="inputText" class="sr-only">账号：</label>
        <input type="text" id="inputText" class="form-control" placeholder="请输入账号" name="username" required >
        <label for="inputPassword" class="sr-only">密码</label>
        <input type="password" id="inputPassword" class="form-control" placeholder="请输入密码" name="password" required>
        <label for="inputEmail" class="sr-only">邮箱：</label>
        <input type="email" id="inputEmail" class="form-control" placeholder="请输入邮箱" name="email" required >
        <label for="inputPhone" class="sr-only">手机：</label>
        <input type="text" id="inputPhone" class="form-control" placeholder="请输入手机" name="phone" required>
        <button class="btn btn-lg btn-primary btn-block" type="submit">提交</button>
    </form>
    <div class="text-center" id="showspan" style="display: none">
        <span style="color: #CC2222"><%=(String) request.getAttribute("message")%></span>
    </div>
</div>
</body>
</html>
