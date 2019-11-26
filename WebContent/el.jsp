<%@page import="org.student.entity.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%--
	//Jsp中使用Java代码的弊端：类型转换、需要处理null、代码参杂
		Student student = (Student)request.getAttribute("student");
		out.print(student+"</br>");
		out.print(student.getSno()+"</br>");
		out.print(student.getSname()+"</br>");
		out.print(student.getAddress().getHomeAddress()+"</br>");
		out.print(student.getAddress().getSchoolAddress()+"</br>");
	--%>
	============== EL 点操作符  使用方便===============</br>
	${requestScope.student}</br>
	${requestScope.student.sno}</br>
	${requestScope.student.sname}</br>
	${requestScope.student.address.schoolAddress}</br>
	<!-- 如果是null,不显示 -->
	${requestScope.student.address.homeAddress}</br>
	
	============== EL 中括号操作符  功能强大===============</br>
	<!-- 单双引号都可以 -->
	${requestScope.student["address"]["schoolAddress"]}</br></br>
	----- 特殊字符  -  -----</br>
	点操作符：${requestScope.my-name}</br>
	[""]操作符：${requestScope["my-name"]}</br>
	
	----- 获取变量值  不加引号  -------<br>
	//String name = "student";
	${requestScope[name]}</br></br>
	
	----- 访问数组 --------------</br>
	${paramValues .hobbies[0]}</br>
	${paramValues .hobbies[1]}</br>
	${requestScope.hobbies[2]}</br></br>
	
	---------- Map ---------</br>
	${requestScope.map.cn}</br>
	${requestScope.map["us"]}</br></br>
	
	--------- 运算 --------</br>
	${3>2}、${3 gt 2}</br></br>
	
	--------- empty --------</br>
	${empty requestScope["my-name"]}</br>
	不存在的值：${empty requestScope["hello"]}</br>
	null值：${empty requestScope["nullValue"]}	</br>
	
	--------- session -------</br>
	${sessionScope.sessionKey }</br>
	--- EL域对象：pageScope、requestScope、sessionScope、applicationScope ---</br>
	${sessionKey }</br></br>
	
	---- 参数对象 ---- </br>
	${param.uname }、
	${paramValues.hobbies[0]}
	${paramValues.hobbies[1]}
	${paramValues.hobbies[2]}</br></br>
	
	---- JSP隐式对象 -----</br>
	---- 可以使用此方法级联获取方法</br>
	${pageContext.session}</br>
	${pageContext.response}</br>
	${pageContext.request.serverPort}</br>
	
	
</body>
</html>