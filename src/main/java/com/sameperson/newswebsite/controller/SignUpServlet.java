package com.sameperson.newswebsite.controller;

import com.sameperson.newswebsite.model.User;
import com.sameperson.newswebsite.database.UserDatabase;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/sign-up")
public class SignUpServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/sign-up.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDatabase userDatabase = new UserDatabase();
        String username = req.getParameter("username");
        if(!userDatabase.containsUsername(username)) {
            userDatabase.save(new User(req.getParameter("username"), DigestUtils.sha512Hex(req.getParameter("password"))));
            req.setAttribute("username", req.getSession().getAttribute("username"));
            req.getSession().setAttribute("username", username);
            resp.sendRedirect("/");
        } else {
            resp.sendRedirect("/");
        }
    }
}
