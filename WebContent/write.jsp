<%@page import="org.student.listener.BeanListener2"%>
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
	BeanListener2 bean = new BeanListener2();
	bean.setNum(10);
	bean.setUser("zs");
	
	session.setAttribute("bean",bean);
	%>
</body>
</html>