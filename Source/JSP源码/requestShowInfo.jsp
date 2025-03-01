<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html" charset="utf-8">
<title>使用request内置对象--requestShowInfo.jsp</title>
</head>
<body bgcolor="#ccffcc">
	<h1>
		您刚才输入的内容是：<br>
	</h1>
	<%
	Enumeration enu = request.getParameterNames();
	while (enu.hasMoreElements()) {
		String parameterName = (String) enu.nextElement();
		String parameterValue = request.getParameter(parameterName);
		out.print("参数名称：" + parameterName + "<br>");
		out.print("参数内容：" + parameterValue + "<br>");
	}
	%>
</body>
</html>