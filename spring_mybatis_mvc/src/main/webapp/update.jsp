<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改</title>
</head>
<%String tsunami = request.getContextPath();
request.setAttribute("tsunami", tsunami); %>
<body>
<form action="updatestu.do" method="post">
	<table>
		<tr>
			<td colspan="2"><h1>修改管理员信息</h1></td>
		</tr>
		<tr>
			<td>ID</td>
			<td><input type="text" name="stuId" value="${student.stuId }"></td>
		</tr>
		<tr>
			<td>姓名</td>
			<td><input type="text" name="stuName" value="${student.stuName }"></td>
		</tr>
		<tr>
			<td>年龄</td>
			<td><input type="text" name="stuAge" value="${student.stuAge }"></td>
		</tr>
		<tr>
			<td>性别</td>
			<td><input type="text" name="stuSex" value="${student.stuSex }"></td>
		</tr>
		<tr>
			<td>学号</td>
			<td><input type="text" name="stuNum"  value="${student.stuNum }"></td>
		</tr>
		<tr>
			<td>班级</td>
			<td><input type="text" name="stuClass" value="${student.stuClass }"></td>
		</tr>
		<tr>
			<td colspan="2">
				<input  type="submit" value="提交"/>
                <input  type="button" value="返回" onclick="history.go(-1)"/>
			</td>
		</tr>
	</table>
	
</form>
</body>

</html>