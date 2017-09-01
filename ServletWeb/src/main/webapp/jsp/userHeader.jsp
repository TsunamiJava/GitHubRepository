<%--
  Created by IntelliJ IDEA.
  User: CodingTest
  Date: 2017/8/4
  Time: 18:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="../node_modules/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet"/>
    <script src="../node_modules/jquery/dist/jquery.min.js"></script>
    <script src="../node_modules/bootstrap/dist/js/bootstrap.min.js"></script>
    <link href="../css/cover.css"/>
</head>
<body>
<div class="container">
    <nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">Tsunami</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="#">首頁</a></li>
                    <li><a href="#">設置</a></li>
                    <li><a href="#">幫助</a></li>
                    <li>
                        <a class="navbar-right" href="/outlogin">
                    <span class="glyphicon glyphicon-user" style="color: white">
                        ${sessionScope.username}
                    </span> 注 销
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</div>
</body>
</html>
