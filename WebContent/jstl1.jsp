<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@	taglib	uri="http://java.sun.com/jsp/jstl/core"  prefix="c"   %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--
		request.setAttribute("name","zhangsan");
	--%>
	<c:set var="name" value="zhangsan" scope="request"/>
	${requestScope.name}<br/><br/>
	
	======= 给对象的属性赋值 ========<br/>
	${requestScope.student.sname}<br/>
	<c:set target="${requestScope.student }" property="sname" value="zxs" />
	${requestScope.student.sname}<br/><br/>
	
	======== 给map对象的属性赋值 ========<br/>
	${requestScope.map.cn}<br/>
	<c:set target="${requestScope.map}" property="cn" value="China" />
	${requestScope.map.cn}<br/><br/>
	
	========= 给不存在的变量赋值 =======<br/>
	<c:set var="xxx" value="y" scope="request" />
	${requestScope.xxx }<br/><br/><br/>
	
	========= c:out ==========<br/>
	传统EL：${requestScope.student }<br/>
	c:out方式： <c:out value="${requestScope.student }" /><br/>
	c:out显示不存在的数据： <c:out value="${requestScope.stu}" default="张三-23"/><br/><br/>
	
	<a href="https://www.baidu.com">百度</a><br/>
	true:<c:out value='<a href="https://www.baidu.com">百度</a>'  escapeXml="true" /><br/>
	false：<c:out value='<a href="https://www.baidu.com">百度</a>' escapeXml="false" />
	<br/><br/>
	
	<c:set var="a" value="b" scope="request"/><br/>
	显示：${a }
	<c:remove var="a" scope="request"/><br/>
	删除后再显示：${a }
	
	
</body>
</html>