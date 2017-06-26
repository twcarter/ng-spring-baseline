package com.vzw.bis.web.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "home", urlPatterns = {"/index.jsp", ""}, loadOnStartup = 1)
public class IndexServlet extends AbstractServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uri = request.getRequestURI();
        if( !uri.endsWith("index.jsp") ) {
            response.sendRedirect(request.getContextPath() + "/index.jsp");
            return;
        }

        try {
            response.setHeader("X-UA-Compatible", "IE=Edge");
        }
        catch(Exception ex) {
            String ctx = request.getContextPath();
            response.sendRedirect(ctx + "/error.jsp");
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/frontend/index.html");
        dispatcher.forward(request, response);

    }
}
