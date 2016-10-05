package com.strtus2;


import org.springframework.web.filter.RequestContextFilter;

import javax.servlet.*;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * Created by yjh on 16/10/5.
 */
public class TestFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
       Logger logger1 = Logger.getLogger("console");
        logger1.info("before filter-----:"+Thread.currentThread().getId());
        // System.out.println("before filter-----:"+Thread.currentThread().getId());
        filterChain.doFilter(servletRequest,servletResponse);
        logger1.info("before filter-----:"+Thread.currentThread().getId());
        //System.out.println("after filter-----:"+Thread.currentThread().getId());
    }

    @Override
    public void destroy() {

    }
}
