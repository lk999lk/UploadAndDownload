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
		//ServletContext:application
		application.setAttribute("name", "zs");//增加application属性
		application.setAttribute("name", "ls");
		application.removeAttribute("name");
		
		session.setAttribute("user", "user11");
		session.setAttribute("user", "user22");
		session.removeAttribute("user");
		
		request.setAttribute("school", "lq");
		request.setAttribute("school", "lq666");
		request.removeAttribute("school");
	%>
</body>
</html>