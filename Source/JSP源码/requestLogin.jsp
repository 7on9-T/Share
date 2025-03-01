<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html" charset="utf-8">
<title>使用request内置对象--requestLogin.jsp</title>
</head>
<body bgcolor="#ffc7c7">
	<form name="form1" method="post" action="requestShowInfo.jsp">
		<p align="center">
			用户名：<input type="text" name="username">
		</p>
		<p align="center">
			密 码：<input type="password" name="password">
		</p>
		<p align="center">
			<input type="submit" name="submit" value="OK"> <input
				type="reset" name="Reset" id="Reset" value="Cancel">
		</p>
	</form>
</body>
</html>