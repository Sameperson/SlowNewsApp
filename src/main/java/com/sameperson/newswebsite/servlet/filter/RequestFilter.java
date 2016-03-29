package com.sameperson.newswebsite.servlet.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


@WebFilter("/*")
public class RequestFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletReq, ServletResponse servletResp, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletReq;

        System.out.println("Request from " + req.getRemoteAddr()
                + "; Requested path: " + req.getServletPath()
                + "; Method: " + req.getMethod());

        filterChain.doFilter(servletReq, servletResp);
    }

    @Override
    public void destroy() {

    }
}
