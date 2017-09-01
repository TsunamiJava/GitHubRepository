<%--
  Created by IntelliJ IDEA.
  User: CodingTest
  Date: 2017/8/2
  Time: 17:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="../node_modules/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet"/>
    <script src="../node_modules/jquery/dist/jquery.min.js"></script>
    <script src="../node_modules/bootstrap/dist/js/bootstrap.min.js"></script>
    <link href="../css/register.css" rel="stylesheet"/>
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
        <button class="btn btn-success" type="submit">提交</button>
        <button class="btn btn-primary" type="button" onclick="history.go(-1)">返回</button>
    </form>
</div>
</body>
</html>
