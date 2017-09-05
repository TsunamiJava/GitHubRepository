<%--
  Created by IntelliJ IDEA.
  User: CodingTest
  Date: 2017/7/29
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" import="java.util.*,java.sql.*" language="java" %>
<%@ page import="entity.User" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
    <title>Message</title>
    <link href="../../node_modules/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet"/>
    <script src="../../node_modules/jquery/dist/jquery.min.js"></script>
    <script src="../../node_modules/bootstrap/dist/js/bootstrap.min.js"></script>
    <link href="../../css/cover.css"/>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Project name</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">Home</a></li>
                <li><a href="#about">About</a></li>
                <li><a href="#contact">Contact</a></li>
                <li><a class="navbar-right" href="/loginOut"><span class="glyphicon glyphicon-user" style="color: white"><%="  "+request.getAttribute("sessionuser")%></span> 注 销</a></li>
            </ul>
        </div>
    </div>
</nav>
<%=request.getAttribute("list")%>
<div class="container" style="padding: 100px">
    <table align="center" width="450" border="1" height="180"
           bordercolor="white" bgcolor="black" cellpadding="1" cellspacing="1">
        <tr bgcolor="white">
            <td align="center" colspan="7">
                <h2>用户信息</h2>
            </td>
        </tr>
        <tr align="center" bgcolor="#e1ffc1">
            <td><b>用户名</b></td>
            <td><b>密码</b></td>
            <td><b>邮箱</b></td>
            <td><b>电话</b></td>
            <td><b>修改</b></td>
            <td><b>删除</b></td>
        </tr>
        <%
            List<User> list= (List<User>) request.getAttribute("list");
            if (list==null||list.size()<1){
                %>
        <tr>
            <td colspan="6">数据为空....</td>
        </tr>
        <%
            }else {
                for (User user: list ) {
                    %>
        <tr align="center"  bgcolor="white">
            <td><%=user.getUsername()%></td>
            <td><%=user.getPassword()%></td>
            <td><%=user.getEmail()%></td>
            <td><%=user.getPhone()%></td>
            <td >
                <form style="align:center;  background-color: gray" action="" method="post"
                      onsubmit="return check(this);">
                    <input type="hidden" name="id" value="<%%>"> <input
                        type="text" name="bookCount" size="3">
                    <input type="submit" value="修改数量">
                </form>
            </td>
            <td>
                <a href="?id=<%%>">删除</a>
            </td>


        </tr>
    <%
                }
            }
            %>
    </table>
    <h2 align="center">
        <a href="">返回添加页面</a>
    </h2>
</div>
</body>
</html>
