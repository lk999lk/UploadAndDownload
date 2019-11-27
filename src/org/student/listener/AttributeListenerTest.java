package org.student.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class AttributeListenerTest implements ServletRequestAttributeListener,HttpSessionAttributeListener,ServletContextAttributeListener{

	//application.setAttribute("name","zs");
	public void attributeAdded(ServletContextAttributeEvent scae) {
		String attrName = scae.getName();//返回目前正在操作的属性名
		String value = (String)scae.getServletContext().getAttribute(attrName);
		System.out.println("ServletContext[增加]属性--属性名：" + attrName+"，属性值："+value);
	}

	public void attributeRemoved(ServletContextAttributeEvent scae) {
		System.out.println("ServletContext[删除]属性--属性名：" + scae.getName());
	}

	public void attributeReplaced(ServletContextAttributeEvent scae) {
		/*
		 * application.setAttribute("name","zs");---增加Name属性
		 * application.setAttribute("name","ls");---替换Name属性
		 */
		String attrName = scae.getName();//返回目前正在操作的属性名
		String value = (String)scae.getServletContext().getAttribute(attrName);
		System.out.println("ServletContext[替换]属性--属性名：" + attrName+"，属性值："+value);
	}

	public void attributeAdded(HttpSessionBindingEvent se) {
		String attrName = se.getName();//返回目前正在操作的属性名
		String value = (String)se.getSession().getAttribute(attrName);
		System.out.println("HttpSession[增加]属性--属性名：" + attrName+"，属性值："+value);
	}

	public void attributeRemoved(HttpSessionBindingEvent se) {
		System.out.println("HttpSession[删除]属性--属性名：" + se.getName());
	}

	public void attributeReplaced(HttpSessionBindingEvent se) {
		String attrName = se.getName();//返回目前正在操作的属性名
		String value = (String)se.getSession().getAttribute(attrName);
		System.out.println("HttpSession[替换]属性--属性名：" + attrName+"，属性值："+value);
	}

	public void attributeAdded(ServletRequestAttributeEvent srae) {
		String attrName = srae.getName();//返回目前正在操作的属性名
		String value = (String)srae.getServletRequest().getAttribute(attrName);
		System.out.println("ServletRequest[增加]属性--属性名：" + attrName+"，属性值："+value);
	}

	public void attributeRemoved(ServletRequestAttributeEvent srae) {
		System.out.println("ServletRequest[删除]属性--属性名：" + srae.getName());
	}

	public void attributeReplaced(ServletRequestAttributeEvent srae) {
		String attrName = srae.getName();//返回目前正在操作的属性名
		Object object = srae.getServletRequest().getAttribute(attrName);
		System.out.println("ServletRequest[替换]属性--属性名：" + attrName+"，属性值："+object);
	}

}
