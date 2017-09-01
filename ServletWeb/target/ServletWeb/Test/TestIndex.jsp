<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--
  Created by IntelliJ IDEA.
  User: CodingTest
  Date: 2017/8/2
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/testPage" method="post">
    <input type="text" class="form-control" placeholder="请输入用户名..." name="search">
    <button class="btn btn-success" type="submit">提交</button>
<table>
    <tr>
        <td>id</td>
        <td>用户名</td>
        <td>密码</td>
        <td>邮箱</td>
        <td>电话</td>
        <td></td>
    </tr>
    <c:forEach items="${PageList}" var="items">
        <tr>
            <td>${items.id}</td>
            <td>${items.username}</td>
            <td>${items.password}</td>
            <td>${items.email}</td>
            <td>${items.phone}</td>
        </tr>
    </c:forEach>
</table>
    当前第
    ${pageNumber+1}
    页
    <a href="testPage?pageNumber=0">首页</a>
    <c:if test="${pageNumber>0}">
        <a href="testPage?pageNumber=${pageNumber-1}">上一页</a>
    </c:if>
    <c:if test="${pageNumber<totalPages}">
        <a href="testPage?pageNumber=${pageNumber+1}">下一页</a>
    </c:if>
    <a href="testPage?pageNumber=${totalPages}">末页</a>
    ,共${totalPages+1}页
</form>
</body>
</html>
