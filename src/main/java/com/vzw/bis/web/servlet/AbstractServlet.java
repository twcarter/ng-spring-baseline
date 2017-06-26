package com.vzw.bis.web.servlet;



import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public abstract class AbstractServlet extends HttpServlet {

    protected AutowireCapableBeanFactory context;

    @Override
    public void init() throws ServletException {
        super.init();

        ApplicationContext applicationContext = (ApplicationContext)getServletContext().getAttribute("applicationContext");
        context = applicationContext.getAutowireCapableBeanFactory();

        context.autowireBean(this);
    }
}