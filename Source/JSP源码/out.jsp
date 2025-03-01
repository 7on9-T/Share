<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>使用out内置对象--out.jsp</title>
</head>
<body>
	<h2>out内置对象</h2>
	<%
	out.println("学习使用out内置对象；<br>");
	int Buffer = out.getBufferSize();
	int Available = out.getRemaining();
	%>
	输出缓冲区的大小：<%=Buffer%><br> 缓冲区剩余空间的大小：<%=Available%><br>
</body>
</html>