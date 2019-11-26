package org.student.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.student.entity.Address;
import org.student.entity.Student;

public class InitServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Student student = new Student();
		student.setSno(1);
		student.setSname("张三");
		Address address = new Address();
		//address.setHomeAddress("西安");
		address.setSchoolAddress("咸阳");
		student.setAddress(address);
		
		request.setAttribute("student", student);
		request.setAttribute("my-name", "lk");
		
		String[] hobbies = new String[]{"football","pingpang","basketball"};
		request.setAttribute("hobbies", hobbies);
		
		Map<String,Object> map = new HashMap<>();
		map.put("cn", "中国");
		map.put("us", "美国");
		request.setAttribute("map", map);
		request.setAttribute("nullValue", null);
		
		request.getSession().setAttribute("sessionKey", "sessionValue");
		
		String[] names = new String[]{"aa","bb","cc"};
		request.setAttribute("names", names);
		
		Student stu1 = new Student();
		Student stu2 = new Student();
		stu1.setSno(111);
		stu1.setSname("yiyi");
		stu2.setSno(222);
		stu2.setSname("erer");
		
		List<Student> students = new ArrayList<>();
		students.add(stu1);
		students.add(stu2);
		
		request.setAttribute("students", students);
		
//		request.getRequestDispatcher("el.jsp").forward(request, response);
//		request.getRequestDispatcher("jstl1.jsp").forward(request, response);
		request.getRequestDispatcher("jstl2.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
