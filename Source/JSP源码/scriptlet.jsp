<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
    <head>
        <meta charset="UTF-8">
        <title>多个脚本段的相互访问</title>
    </head>
    <body>
        <%
            int i;
            for (i=0;i<=10;i++)
            {
        %>
        <h1>您好！张先生</h1>
        <%
            }
        %>
    </body>
</html>
