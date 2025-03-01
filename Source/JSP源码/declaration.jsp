<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta charset="UTF-8">
        <title>声明变量和方法</title>
    </head>
    <%!
           //声明一个整型变量
           public int count;

           //声明一个方法
           public String info(){
            return "hello";
           }
    %>
    <body>
        <%
           //将count的值输出后再加1
           out.println(count++);
        %>
        <br />
        <%
           //输出info()方法的返回值
           out.println(info());
        %>
    </body>
        
</html>
