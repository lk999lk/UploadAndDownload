<%@page import="org.student.entity.Bean"%>
<%@page import="org.student.listener.BeanListener"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	//Bean bean = new Bean();
	BeanListener bean = new BeanListener();
	session.setAttribute("bean",bean);//绑定
	%>
</body>
</html>