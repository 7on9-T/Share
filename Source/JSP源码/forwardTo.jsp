<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>带参数的forward动作标记2</title>
    </head>
    <body bgcolor="#00ffff">
        <%
           String name = request.getParameter("username");
           String pw=request.getParameter("password");
           out.println("你的用户名是："+name+"<br/>");
           out.println("你的密码是："+pw);
        %>
    </body>
</html>