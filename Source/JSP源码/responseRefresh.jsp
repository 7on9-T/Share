<%@page import="java.util.Date"%>
<%@page import="org.apache.naming.java.javaURLContextFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html" ;charset="utf-8">
<title>使用response内置对象--responseRefresh。jsp</title>
</head>
<body>
	<h3>现在的时间是</h3>
	<hr>
	<%=new Date()%>
	<!-- 对属性refresh赋值，页面每1秒刷新1次 -->
	<%
	response.setHeader("refresh", "1");
	%>
	<hr>
</body>
</html>
