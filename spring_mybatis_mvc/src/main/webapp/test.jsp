<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>显示界面</title>
</head>
<body>
	
	
	
	<table>
		<tr>
			<td>id</td>
			<td>姓名</td>
			<td>年龄</td>
			<td>性别</td>
			<td>学号</td>
			<td>班级</td>
			<td>注册时间</td>
			<td>修改时间</td>
		</tr>
		<c:forEach items="${dates}" var="item">
		<tr>
				<td>${item.stuId}</td>
				<td>${item.stuName}</td>
				<td>${item.stuAge}</td>
				<td>${item.stuSex }</td>
				<td>${item.stuNum }</td>
				<td>${item.stuClass }</td>
				<td>${item.stuCreatetime }</td>
				<td>${item.stuUpdatetime }</td>
			</tr>
		</c:forEach>
	</table>
	<div>
		当前第 ${pageNum} 页，
		<a href="pagelist.do?pageNum=1">首页</a>
		<c:if test="${pageNum>1 }">
			<a href="pagelist.do?pageNum=${pageNum-1}">上一页</a>
		</c:if>
		<c:if test="${pageNum<totalPages }">
			<a href="pagelist.do?pageNum=${pageNum+1}">下一页</a>
		</c:if>
		<a href="pagelist.do?pageNum=${totalPages}">尾页</a>，共 ${totalPages} 页
	</div>
	 
</body>
</html>