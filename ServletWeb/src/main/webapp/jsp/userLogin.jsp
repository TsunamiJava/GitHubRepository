<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %><%--
  Created by IntelliJ IDEA.
  User: CodingTest
  Date: 2017/8/2
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UserLogin</title>
    <link href="../node_modules/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet"/>
    <script src="../node_modules/jquery/dist/jquery.min.js"></script>
    <script src="../node_modules/bootstrap/dist/js/bootstrap.min.js"></script>
    <link href="../css/login.css" rel="stylesheet"/>
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
                <a href="/jsp/userRegister.jsp"><span class="glyphicon glyphicon-user"></span>申请账号</a>
            </label>
        </div>
    </form>
    <div class="container col-lg-12 text-center">
        <%
            List<String> info = (List<String>) request.getAttribute("info") ;
            if(info != null){   // 有信息返回
                Iterator<String> iter = info.iterator() ;
                while(iter.hasNext()){
        %>
        <span style="color: #b92c28"><%=iter.next()%></span>
        <%
                }
            }
        %>
    </div>
</div>
</body>
</html>
