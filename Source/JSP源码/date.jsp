<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<html>
    <head>
        <meta http-equiv="contentType" content="text/html;charset=UTF-8">
        <title>date页面</title>
    </head>
    <body>
        <%
        String name =request.getParameter("username");
        out.println("你好，"+name+"!今天的日期是：");
        Date date=new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        String string = sdf.format(date);
        out.println(string);
        %>
    </body>
</html>