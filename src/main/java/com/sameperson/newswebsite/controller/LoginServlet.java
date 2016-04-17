package com.sameperson.newswebsite.controller;

import com.sameperson.newswebsite.model.database.UserDatabase;
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
        String usernameFromPost = req.getParameter("username");
        if(UserDatabase.containsUsername(usernameFromPost)
                && UserDatabase.getUser(usernameFromPost).getPassword()
                .equals(DigestUtils.sha512Hex(req.getParameter("password")))) {
            req.getSession().setAttribute("username", usernameFromPost);
        }
        resp.sendRedirect("/");
    }
}
