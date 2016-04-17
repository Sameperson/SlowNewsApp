package com.sameperson.newswebsite.controller;

import com.sameperson.newswebsite.model.User;
import com.sameperson.newswebsite.model.database.UserDatabase;
import com.sameperson.newswebsite.model.UserList;
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
        //UserDatabase.init();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //UserList.getInstance().addUser(req.getParameter("username"), DigestUtils.sha512Hex(req.getParameter("password")));
        String username = req.getParameter("username");
        if(!UserDatabase.containsUsername(username)) {
            UserDatabase.save(new User(req.getParameter("username"), DigestUtils.sha512Hex(req.getParameter("password"))));
            req.setAttribute("username", req.getSession().getAttribute("username"));
        }
        resp.sendRedirect("/");
    }
}
