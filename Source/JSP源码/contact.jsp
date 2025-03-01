<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>物理与电子信息学院网站</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keywords1,keywords2,keywords3">
<meta http-equiv="description" content="This is my page">
</head>
<body>
<jsp:include page="top.html"></jsp:include>
<jsp:include page="contact.html"></jsp:include>
</body>
</html>