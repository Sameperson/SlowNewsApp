package com.sameperson.newswebsite.servlet.filter;

import com.sameperson.newswebsite.model.UserList;

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
        filterChain.doFilter(servletReq, servletResp);
    }

    @Override
    public void destroy() {

    }
}
