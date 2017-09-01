<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--
  Created by IntelliJ IDEA.
  User: CodingTest
  Date: 2017/8/2
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false"%>
<html>
<head>
    <title>Title</title>
    <link href="../node_modules/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet"/>
    <script src="../node_modules/jquery/dist/jquery.min.js"></script>
    <script src="../node_modules/bootstrap/dist/js/bootstrap.min.js"></script>
    <link href="../css/cover.css"/>
    <script>

    </script>
</head>
<body>
<div class="jumbotron container" style="padding: 50px">
    <div class="row">
        <div class="col-md-6 text-left" style="padding: 20px;">
            <label><a href="/jsp/userCreate.jsp"><span class="glyphicon glyphicon-plus"/>添加用户</a></label>
        </div>
        <div class="col-md-6 text-left">
            <form class="navbar-form navbar-right" action="showdatas">
                <input type="text" class="form-control" placeholder="请输入用户名..." value="${search}" name="search">
                <button class="btn btn-success" type="submit" onclick="test()">提交</button>
                <c:set var="search" value="${search}"/>
            </form>
        </div>
    </div>
    <div>
        <table class="table table-hover">
            <tr>
                <td>ID</td>
                <td>用户名</td>
                <td>密 码</td>
                <td>邮 箱</td>
                <td>联系方式</td>
                <td>操 作</td>
            </tr>
            <c:forEach items="${datas}" var="items">
                <tr>
                    <td>${items.id}</td>
                    <td>${items.username}</td>
                    <td>${items.password}</td>
                    <td>${items.email}</td>
                    <td>${items.phone}</td>
                    <td>
                        <a href="delete?id=${items.id}"><span class="glyphicon glyphicon-remove-sign"/>删除</a>|
                        <a href="updata?id=${items.id}"><span class="glyphicon glyphicon-wrench"/>修改</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div class="text-center">
        当前第
        ${pageNumber+1}
        页
        <a href="showdatas?pageNumber=0&search=${search}">首页</a>
        <c:if test="${pageNumber>0}">
            <a href="showdatas?pageNumber=${pageNumber-1}&search=${search}">上一页</a>
        </c:if>
        <c:if test="${pageNumber<totalPages}">

            <a href="showdatas?pageNumber=${pageNumber+1}&search=${search}">下一页</a>
        </c:if>
        <a href="showdatas?pageNumber=${totalPages}&search=${search}">末页</a>
        ,共${totalPages+1}页
    </div>
</div>
</body>
</html>
