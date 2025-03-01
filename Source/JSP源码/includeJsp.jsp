<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="contentType" content="text/html;charset=UTF-8">
        <title>include 动作标记</title>
    </head>
    <body>
        <h1>include 动作标记</h1>
        <hr>
        <%
        request.setCharacterEncoding("UTF-8");
        %>
        <jsp:include page="date.jsp">
            <jsp:param name="username" value="张先生"/>
        </jsp:include>
    </body>
</html>