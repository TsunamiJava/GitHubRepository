<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
isELIgnored="false"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>add</title>
</head>
<%String tsunami = request.getContextPath();
request.setAttribute("tsunami", tsunami); %>
<body>
<form action="addstu.do" method="post"> 
	<table>
		<tr>
			<td colspan="2"><h1>添加学生</h1></td>
		</tr>
		<tr>
			<td>姓名</td>
			<td><input type="text" name="stuName" /></td>
		</tr>
		<tr>
			<td>年龄</td>
			<td><input type="text" name="stuAge" /></td>
		</tr>
		<tr>
			<td>性别</td>
			<td><input type="text" name="stuSex" /></td>
		</tr>
		<tr>
			<td>学号</td>
			<td><input type="text" name="stuNum" /></td>
		</tr>
		<tr>
			<td>班级</td>
			<td><input type="text" name="stuClass" /></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" name="提交" />
				<input type="reset" name="清空" />
			</td>
		</tr>
	</table>
</form>
</body>
</html>