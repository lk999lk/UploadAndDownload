package org.student.listener;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class BeanListener implements HttpSessionBindingListener {
    public void valueBound(HttpSessionBindingEvent event)  { 
    	System.out.println("绑定：Bean对象（将Bean对象增加到session域中），绑定的对象:"+this
    			+",sessionId:"+event.getSession().getId());
    }

    public void valueUnbound(HttpSessionBindingEvent event)  { 
    	System.out.println("解绑bean对象（将bean对象从session域中移除），解绑的对象:"+this
    			+",sessionId:"+event.getSession().getId());
    }
	
}
