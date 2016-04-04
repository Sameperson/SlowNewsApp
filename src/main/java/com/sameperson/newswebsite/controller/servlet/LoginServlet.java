package com.sameperson.newswebsite.controller.servlet;

import com.sameperson.newswebsite.model.UserList;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserList userList = UserList.getInstance();
        String usernameFromPost = req.getParameter("username");
        if(userList.containsUser(usernameFromPost)
                && userList.findByName(usernameFromPost).getPassword()
                .equals(DigestUtils.sha512Hex(req.getParameter("password")))) {
            req.getSession().setAttribute("username", usernameFromPost);
            resp.sendRedirect("/");
        } else {
            resp.sendRedirect("/login");
        }
    }
}
