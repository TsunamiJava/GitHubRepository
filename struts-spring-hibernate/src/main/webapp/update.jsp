<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改</title>
</head>
<body>
<form action="student!updatestu.action" method="post">
	<table>
		<tr>
			<td colspan="2"><h1>修改管理员信息</h1></td>
		</tr>
		<tr>
			<td>ID</td>
			<td><input type="text" name="stu_id" value="${student.stu_id }"></td>
		</tr>
		<tr>
			<td>姓名</td>
			<td><input type="text" name="stu_name" value="${student.stu_name }"></td>
		</tr>
		<tr>
			<td>年龄</td>
			<td><input type="text" name="stu_age" value="${student.stu_age }"></td>
		</tr>
		<tr>
			<td>性别</td>
			<td><input type="text" name="stu_sex" value="${student.stu_sex }"></td>
		</tr>
		<tr>
			<td>学号</td>
			<td><input type="text" name="stu_num"  value="${student.stu_num }"></td>
		</tr>
		<tr>
			<td>班级</td>
			<td><input type="text" name="stu_class" value="${student.stu_class }"></td>
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