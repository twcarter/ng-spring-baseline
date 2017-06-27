package com.vzw.bis.web.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebFilter( urlPatterns = { "/rest/*" } )
public class SampleFilter extends HttpFilter {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void httpFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        logger.debug("{}.httpFilter", getClass().getName());
        chain.doFilter(request, response);
    }

}
