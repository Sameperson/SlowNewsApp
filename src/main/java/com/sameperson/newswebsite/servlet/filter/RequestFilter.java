package com.sameperson.newswebsite.servlet.filter;

import com.sameperson.newswebsite.model.UserList;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebFilter("/*")
public class RequestFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletReq, ServletResponse servletResp, FilterChain filterChain)
            throws IOException, ServletException {

//        HttpSession session = ((HttpServletRequest)servletReq).getSession();
//
//
//
//
//        HttpServletRequest req = (HttpServletRequest) servletReq;
//        String username = (String)req.getSession().getAttribute("username");
//        UserList userList = UserList.getInstance();
//        if(userList.containsUser(username)) {
//            req.setAttribute("logged-in", true);
//            req.setAttribute("name", username);
//
//        }
//        else {
//            req.setAttribute("logged-in", false);
//
//        }
        filterChain.doFilter(servletReq, servletResp);
    }

    @Override
    public void destroy() {

    }
}
