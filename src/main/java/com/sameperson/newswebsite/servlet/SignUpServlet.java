package com.sameperson.newswebsite.servlet;

import com.sameperson.newswebsite.model.UserList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/sign-up")
public class SignUpServlet extends HttpServlet {

    private volatile UserList userList;

    @Override
    public void init() throws ServletException {
        super.init();
        userList = UserList.getInstance();
        System.out.println("SingleNewsServlet initialized");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/sign-up.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        userList.addUser(req.getParameter("username"), req.getParameter("password"));
        resp.sendRedirect("/sign-up");
    }
}
