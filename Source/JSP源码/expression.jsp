<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>表达式实例1</title>
    </head>
    <%!
       String url = "expressionHref.jsp";
    %>
    <body>
        <a href="<%=url%>">单击跳转</a>
        <form action="<%=url%>">
            <input type="submit" value="单击跳转"/>
        </form> 
    </body>
</html>