<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>显示界面</title>
</head>
<body>
	<form action="student!list.action" method="post">
		<input placeholder="请输入用户名..." value="${search}" name="search"/>
		<button type="submit">提交</button>
	</form>
	<table border="2">
		<tr>
			<td colspan="9"><a href="add.jsp">添加管理员</a></td>
		</tr>
		<tr>
			<td>id</td>
			<td>姓名</td>
			<td>年龄</td>
			<td>性别</td>
			<td>学号</td>
			<td>班级</td>
			<td>注册时间</td>
			<td>修改时间</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${list}" var="item">
		<tr>
				<td>${item.stuId}</td>
				<td>${item.stuName}</td>
				<td>${item.stuAge}</td>
				<td>${item.stuSex }</td>
				<td>${item.stuNum }</td>
				<td>${item.stuClass }</td>
				<td>${item.stuCreatetime }</td>
				<td>${item.stuUpdatetime }</td>
				<td>
					<a href="student!deletestu.action?ids=${item.stuId }">删除</a>
					<a href="student!selectbyid.action?ids=${item.stuId }">修改</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	 
	<div>
		当前第 ${pageNum} 页，
		<a href="student!list.action?pageNum=1&search=${search}">首页</a>
		<c:if test="${pageNum>1 }">
			<a href="student!list.action?pageNum=${pageNum-1}&search=${search}">上一页</a>
		</c:if>
		<c:if test="${pageNum<totalPages }">
			<a href="student!list.action?pageNum=${pageNum+1}&search=${search}">下一页</a>
		</c:if>
		<a href="student!list.action?pageNum=${totalPages}&search=${search}">尾页</a>，共 ${totalPages} 页
	</div>
</body>
</html>