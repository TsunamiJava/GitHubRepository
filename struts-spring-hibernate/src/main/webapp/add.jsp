<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>add</title>
</head>
<body>
<form action="student!addstu.action" method="post"> 
	<table>
		<tr>
			<td colspan="2"><h1>添加学生</h1></td>
		</tr>
		<tr>
			<td>姓名</td>
			<td><input type="text" name="stu_name" /></td>
		</tr>
		<tr>
			<td>年龄</td>
			<td><input type="text" name="stu_age" /></td>
		</tr>
		<tr>
			<td>性别</td>
			<td><input type="text" name="stu_sex" /></td>
		</tr>
		<tr>
			<td>学号</td>
			<td><input type="text" name="stu_num" /></td>
		</tr>
		<tr>
			<td>班级</td>
			<td><input type="text" name="stu_class" /></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" name="提交" />
				<input type="reset" name="清空" />
				<input  type="button" value="返回" onclick="history.go(-1)"/>
			</td>
		</tr>
	</table>
</form>
</body>
</html>