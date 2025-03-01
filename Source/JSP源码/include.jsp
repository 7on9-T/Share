<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>include指令标记实例</title>
        <style type="text/css">
            p{
                color: deepskyblue;
                text-align: left;
                size: 5px;
            }
        </style>
    </head>
    <body>
        <%@include file="head.jsp"%>
        <p>&nbsp;&nbsp;include指令用于引入其他JSP页面，引入后，JSP引擎会将这些JSP页面翻译成一个servlet。因此include指令通常也被称为静态引入</p>
    </body>
</html>