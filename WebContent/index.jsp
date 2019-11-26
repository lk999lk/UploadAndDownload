<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="UploadServlet" method="post" enctype="multipart/form-data">
		学号：<input type="text" name="sno" /><br/>
		姓名：<input type="text" name="sname" /> <br/>
		上传照片：<input type="file" name="spicture" /><br/>
		<input type="submit" value="注册" /><br/>
	</form>
	<a href="DownloadServlet?filename=图片.png">图片下载</a>
</body>
</html>