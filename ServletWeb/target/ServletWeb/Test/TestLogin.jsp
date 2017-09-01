<%--
  Created by IntelliJ IDEA.
  User: CodingTest
  Date: 2017/8/2
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
${requestScope.info}<br>
<%
    String str = "Hello";
    pageContext.setAttribute("str", str);

    pageContext.setAttribute("username", "张三");
%>
java输出：<%=str%>
el:${str} / ${username}
<h2>3.5.2.与输入有关的隐含对象</h2>
<a href="el.jsp?username=li4">param测试的地址</a>
这是传参：${param.username }
<a href="el.jsp?username=li4&username=zhang3">paramValues测试的地址</a>
这是传参：${paramValues.username[0] }|${paramValues.username[1] }

</body>
</html>
