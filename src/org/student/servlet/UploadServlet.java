package org.student.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadServlet extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		//上传
		try {
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);
			if (isMultipart) {//判断前台的form是否有multipart属性,并将前台传递的sno，sname，spicture就保存到items中
				//不用缓冲区的话就用接口，用缓冲区的话就用实现类
//				FileItemFactory factory = new DiskFileItemFactory();
				DiskFileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory);
				
				//对文件的限制条件写在parseRequest之前
				//设置上传文件时用到的临时文件的大小: DiskFileItemFactory
				factory.setSizeThreshold(1024);//设置临时的缓冲文件为1k
				factory.setRepository(new File("D:\\Program Files\\JavaWeb\\apache-tomcat-8.5.47\\upoadtemp"));//设置临时文件的文件目录
				//控制上传单个文件的大小:  ServletFileUpload
				upload.setSizeMax(1024*20);//单位是 字节B
				
				
				List<FileItem> items = upload.parseRequest(request);
				//遍历items中的数据
				Iterator<FileItem> iter = items.iterator();
				while(iter.hasNext()){
					FileItem item = iter.next();
					
					//判断前台字段是普通form表单字段，还是文件字段
					//request.getParameter() ---- iter.getString()
					if(item.isFormField()){
						String itemName = item.getFieldName();
						int sno = -1;
						String sname = null;
						if("sno".equals(itemName)){//根据name属性判断item是sno,sname,spicture
							sno = Integer.parseInt(item.getString("utf-8"));
						} else if("sname".equals(itemName)) {
							sname = item.getString("utf-8");
						} else {
							System.out.println("其他字段");
						}
					} else {//spicture
						//文件上传:
						//getFieldName是获得普通表单字段的Name值
						//getName是获取文件名
						String fileName = item.getName();//a.txt  a.docx  a.png
						
						//控制上传文件的格式
						String ext = fileName.substring(fileName.indexOf(".")+1);
						if(!(ext.equals("png") || ext.equals("gif") || ext.equals("jpg")) ){
							System.out.println("图片格式有误！格式只能是png,gif,jpg");
							return;//终止
						}
						//获取文件内容并上传
						//定义文件路径：指定上传的位置（服务器路径）
						//获取服务器路径:只要修改java代码启动目录就没有了，原因：每次传class都要更新Tomcat下的目录
						//String path = request.getSession().getServletContext().getRealPath("upload");
						String path = "D:\\Program Files\\JavaWeb\\apache-tomcat-8.5.47\\upload";
						File file = new File(path,fileName);
						
						item.write(file);//上传
						
						System.out.println(fileName + "上传成功！");
						return;
					}
				}
			}
		} catch (FileUploadBase.SizeLimitExceededException e){
			//SizeLimitExceededException是FileUploadException子类异常
			System.out.println("上传文件大小超过上限！最大上传文件为20K");
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
