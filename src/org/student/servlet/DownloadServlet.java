package org.student.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.codec.binary.Base64;

public class DownloadServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");//设置post的编码
		
		//获取需要下载的文件名
		String fileName = request.getParameter("filename");//href\form 表单等都是通过request去拿//fileName包含了文件的扩展名
		
		//下载文件，需要设置消息头
		response.addHeader("content-Type", "application/octet-stream");//octet-stream为二进制文件，即任意文件都可以下载
		
		//对于不同的浏览器，进行不同的处理
		//获取客户端的user-agent信息
		String agent = request.getHeader("User-Agent");
		if(agent.toLowerCase().indexOf("firefox") != -1){
			//处理火狐文件名乱码
			response.addHeader("content-Disposition", "attachment;filename==?utf-8?B?"+new String(Base64.encodeBase64(fileName.getBytes("utf-8")) ) +"?=");
		}else {
			//处理edge和谷歌文件名乱码
			response.addHeader("content-Disposition", "attachment;filename="+URLEncoder.encode(fileName,"utf-8") );
		}
		//servlet通过文件的地址将文件转换为输入流读到servlet中
		InputStream in = getServletContext().getResourceAsStream("/res/图片.png");
		
		//通过输出流将数据转为输入流传输给用户
		ServletOutputStream out = response.getOutputStream();
		byte[] bs = new byte[1024];
		int len = -1;
		while( (len=in.read(bs)) != -1){
			out.write(bs, 0, len);
		}
		out.close();
		in.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
