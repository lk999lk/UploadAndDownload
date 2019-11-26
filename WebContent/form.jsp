<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="el.jsp">
		用户名：<input name="uname" type="text"/><br/>
		兴趣：<br/>
		足球：<input name="hobbies" value="football" type="checkbox"/><br/>
		篮球：<input name="hobbies" value="basketball" type="checkbox"/><br/>
		乒乓球：<input name="hobbies" value="pingpang" type="checkbox"/><br/>
		<input type="submit" value="注册"/>
	</form>
</body>
</html>